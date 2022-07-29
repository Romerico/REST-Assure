import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GET_another {



      @Test
      public void getBooks() {
          given()
                  .when()
                  .get("https://restful-booker.herokuapp.com/booking\n")
                  .then()
                  .log()
                  .all()
                  .statusCode(200);
      }

         @Test
                 public void getSpecificOne(){
          String response = given()
                      .when()
                      .get("https://restful-booker.herokuapp.com/booking/5457")
                      .then()
                      .extract().response().asString();
              System.out.println(response);

          }

          @Test
            public void checkIfItsTheOne(){
          given()
                  .when()
                  .get("https://restful-booker.herokuapp.com/booking/5457")
                  .then()
                  .assertThat().body("firstname", equalTo("Roman"));

          }

      }


