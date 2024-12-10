package ed_wantuil.java_docker_sample;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

class LoanTest extends BaseTest {

    @Test
    void createBookTest(){
        String jsonPayload = """
                {
                   "bookId": "e9973d38-8a48-47f5-a560-fac4e094fd94",
                   "memberId": "092233f9-20f5-4543-ba96-d92594d918d3",
                   "loanDate": "2024-12-08T14:30:00",
                   "dueDate": "2025-01-08T14:30:00",
                   "status": "On Loan"
                }
                """;

       given()
               .header("Content-Type", "application/json")
               .body(jsonPayload)
               .when()
               .post("/loans")
               .then()
               .statusCode(200)
               .body("id", notNullValue())
               .body("book.id", equalTo("e9973d38-8a48-47f5-a560-fac4e094fd94"))
               .body("book.title", equalTo("The Tales of Beedle the Bard"))
               .body("book.author", equalTo("Beedle the Bard"))
               .body("book.genre", equalTo("Wizarding Fairy Tales"))
               .body("book.isbn", equalTo("978-1408898673"))
               .body("book.status", equalTo("Available"))
               .body("member.id", equalTo("092233f9-20f5-4543-ba96-d92594d918d3"))
               .body("member.name", equalTo("Hermione Granger"))
               .body("member.address", equalTo("Hampstead Garden Suburb, London, UK"))
               .body("member.phone", equalTo("+44-20-7946-0958"))
               .body("member.email", equalTo("hermione.granger@hogwarts.wiz"))
               .body("loanDate", equalTo("2024-12-08T14:30:00"))
               .body("dueDate", equalTo("2025-01-08T14:30:00"))
               .body("status", equalTo("On Loan"));
    }
}
