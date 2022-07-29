import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ChainingPOST_GET {

    @Test
    public void psotSmthToMockServer(){
       int id = given().header("Content-type", ContentType.JSON)
                .header("Accept", ContentType.JSON)
                .body("{\n" +
                        "    \"firstname\": \"Roman\",\n" +
                        "    \"lastname\": \"Smith\",\n" +
                        "    \"totalprice\": 111,\n" +
                        "    \"depositpaid\": true,\n" +
                        "    \"bookingdates\": {\n" +
                        "        \"checkin\": \"2018-01-01\",\n" +
                        "        \"checkout\": \"2019-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\": \" strong relax\"\n" +
                        "}")
                .when().post("https://restful-booker.herokuapp.com/booking/")
                .then()
                .extract().body().jsonPath().get("bookingid");


       given().when()
                       .get("https://restful-booker.herokuapp.com/booking/" + id + "")
                               .then().log().all()
                       .assertThat().body("firstname", equalTo("Roman"));

    }
}
