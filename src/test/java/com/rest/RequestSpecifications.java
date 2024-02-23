package com.rest;


import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RequestSpecifications {
    RequestSpecification requestSpecification;

    @BeforeClass
    public void beforeClass(){
        requestSpecification= given().
                baseUri("https://api.postman.com").
                header("X-Api-Key", "PMAK-65a7715e2b6cb27e117fcb78-6837169a4ef67485f1c8bdbe530427a674").
                log().all();

    }

    @org.testng.annotations.Test
    public void validate_status_code() {
              Response response=requestSpecification.get("/workspaces").then().log().all().extract().response();
              assertThat(response.statusCode(),is(equalTo(200)));
    }

    @org.testng.annotations.Test
    public void validate_response_code() {
        Response response=requestSpecification.get("/workspaces").then().log().all().extract().response();
        assertThat(response.path("workspaces[0].name"),equalTo("Team Workspace"));

    }
}
