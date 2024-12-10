package ed_wantuil.java_docker_sample;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

class BookTest extends BaseTest {

    @Test
    void createBookTest(){
        String jsonPayload = """
                {
                    "title": "The Tales of Beedle the Bard",
                    "author": "Beedle the Bard",
                    "genre": "Wizarding Fairy Tales",
                    "isbn": "978-1408898673",
                    "status": "Available"
                }
                """;

       given()
               .header("Content-Type", "application/json")
               .body(jsonPayload)
               .when()
               .post("/books")
               .then()
               .statusCode(200)
               .body("id", notNullValue())
               .body("title", equalTo("The Tales of Beedle the Bard"))
               .body("author", equalTo("Beedle the Bard"))
               .body("genre", equalTo("Wizarding Fairy Tales"))
               .body("isbn", equalTo("978-1408898673"))
               .body("status", equalTo("Available"));
    }
}
