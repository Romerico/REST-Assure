import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;


public class POST_request {

    public static HashMap map = new HashMap();
    @BeforeClass
    public void postUser()
    {

        map.put("name", "Roman");
        map.put("job", "QA Engineer");
    }

    @Test
    public void passUser(){

        given()
                .contentType("application/json")
                .body(map)
        .when()
                .post("https://reqres.in/api/users")

        .then()
                .statusCode(201);





    }
}
