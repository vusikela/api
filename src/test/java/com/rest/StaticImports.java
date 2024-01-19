package com.rest;




import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class StaticImports {


    @org.testng.annotations.Test
    public void test() {
        given().
                basePath("").
                header("","").
                when().
                     get("").
                             then().
                             statusCode(200).
                             body("name",is(equalTo("Satheesh")),"email",is(equalTo("")));
    }
}
