
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;



public class GET_request {

//given() set cookies, add auth, add param, set headers, info ...
//when() get, post, put, delete...
    //get()
//then() validate status code, extract response, headers, cookies ...
    //statusCode()

    @Test
    public void getUserRequest(){
        given()
        .when()
                .get("https://jsonplaceholder.typicode.com/comments?postId=1&id=1")
        .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .assertThat().body("email", hasItem("Eliseo@gardner.biz"))
                .header("Content-Type", "application/json; charset=utf-8")
                .log().all();

    }

    @Test
    public void getSingleUser(){
given()
        .when()
        .get("https://reqres.in/api/users/3")
        .then()
        .statusCode(200)
        .statusLine("HTTP/1.1 200 OK")
        .header("Content-Type", "application/json; charset=utf-8")
        .header("Content-Encoding", "gzip" )
        .log().all();


    }

}



