import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class DELETE_request {
@Test
    public void deleteUser(){

    Response response =
        given()
        .when()
        .delete("https://dummy.restapiexample.com/api/v1/delete/9698")
        .then()
        .statusCode(200)
                .extract().response();

    String responseAsString = response.asString();
    Assert.assertEquals(responseAsString.contains("Successfully! Record has been deleted"), true);

    }

}
