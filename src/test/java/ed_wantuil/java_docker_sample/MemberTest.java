package ed_wantuil.java_docker_sample;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

class MemberTest extends BaseTest {

    @Test
    void createBookTest(){
        String jsonPayload = """
                {
                  "name": "Hermione Granger",
                  "address": "Hampstead Garden Suburb, London, UK",
                  "phone": "+44-20-7946-0958",
                  "email": "hermione.granger@hogwarts.wiz"
                }
                """;

       given()
               .header("Content-Type", "application/json")
               .body(jsonPayload)
               .when()
               .post("/members")
               .then()
               .statusCode(200)
               .body("id", notNullValue())
               .body("name", equalTo("Hermione Granger"))
               .body("address", equalTo("Hampstead Garden Suburb, London, UK"))
               .body("phone", equalTo("+44-20-7946-0958"))
               .body("email", equalTo("hermione.granger@hogwarts.wiz"));
    }
}
