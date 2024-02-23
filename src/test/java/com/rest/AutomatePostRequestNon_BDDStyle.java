package com.rest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AutomatePostRequestNon_BDDStyle {

    @BeforeClass
    public void beforeClass(){
        RequestSpecBuilder requestSpecBuilder=new RequestSpecBuilder().
                setBaseUri("https://api.postman.com").addHeader("X-Api-Key", "PMAK-65a7715e2b6cb27e117fcb78-6837169a4ef67485f1c8bdbe530427a674").
                setContentType(ContentType.JSON).
                log(LogDetail.ALL);
        RestAssured.requestSpecification=requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder=new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
                log(LogDetail.ALL);

        RestAssured.responseSpecification=responseSpecBuilder.build();
    }

    @org.testng.annotations.Test
    public void validate_status_code() {

        String payload="{\n" +
                "    \"workspace\": {\n" +
                "        \"name\": \"Public WorkspaceNonBDD\",\n" +
                "        \"type\": \"public\",\n" +
                "        \"description\": \"This is a public workspace.\"\n" +
                "    }\n" +
                "}";

        Response response=with().
                body(payload).
                post("/workspaces");
                assertThat(response.<String>path("workspace.name"),equalTo("Public WorkspaceNonBDD"));




    }
}
