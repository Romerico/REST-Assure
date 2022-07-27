import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PUT_request {

    public static HashMap map = new HashMap();
    @BeforeClass
    public void updateForUser()
    {

        map.put("name", "Roman");
        map.put("salary", "140000");
        map.put("age", "30");

    }


    @Test
    public void updateUser(){
        given()
            .contentType("application/json")
            .body(map)
                .when()
                .put("https://dummy.restapiexample.com/api/v1/update/7416")
                .then()
                .statusCode(200)
                .body("message", equalTo("Successfully! Record has been updated."))
                .log().all();


    }
}
