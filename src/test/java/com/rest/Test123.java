package com.rest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Test123 {

    @org.testng.annotations.Test
    public void validate_status_code() {
        given().
                baseUri("https://api.postman.com").
                      header("X-Api-Key", "PMAK-65a7715e2b6cb27e117fcb78-6837169a4ef67485f1c8bdbe530427a674").
                when().
                     get("/workspaces").
                then().
                    log().all().
                    assertThat().
                //testing
                    statusCode(200);

    }

    @org.testng.annotations.Test
    public void validate_response_code() {
        given().
                baseUri("https://api.postman.com").
                     header("X-Api-Key", "PMAK-65a7715e2b6cb27e117fcb78-6837169a4ef67485f1c8bdbe530427a674").
                when().
                    get("/workspaces").
                then().
                     log().all().
                     assertThat().
                     statusCode(200).
                     body("workspaces.name", hasItems("Team Workspace", "Automation API Learning"),
                        "workspaces.type", hasItems("team", "team"),
                        "workspaces[0].name", equalTo("Team Workspace"),
                        "workspaces[0].name", is(equalTo("Team Workspace")),
                        "workspaces.size()", equalTo(2),
                        "workspaces.name", hasItem("Team Workspace"));

    }

    @org.testng.annotations.Test
    public void extract_response() {
        Response res = given().
                baseUri("https://api.postman.com").
                     header("X-Api-Key", "PMAK-65a7715e2b6cb27e117fcb78-6837169a4ef67485f1c8bdbe530427a674").
                when().
                     get("/workspaces").
                then().
                    log().all().
                    assertThat().
                    statusCode(200).
                    extract().response();
        System.out.println("respose = " + res.asString());

    }

    @org.testng.annotations.Test
    public void extract_single_value_from_response() {
        Response res = given().
                   baseUri("https://api.postman.com").
                  header("X-Api-Key", "PMAK-65a7715e2b6cb27e117fcb78-6837169a4ef67485f1c8bdbe530427a674").
                when().
                    get("/workspaces").
                then().
                   log().all().
                   assertThat().
                   statusCode(200).
                   extract().response();

        // ....Printing single values in different ways
        System.out.println("response = " + res.path("workspaces[0].name"));

        JsonPath jsonPath=new JsonPath(res.asString());
        System.out.println("response = " + jsonPath.getString("workspaces[0].name"));

    }
}
