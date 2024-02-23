package com.rest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class AutomatePostRequestBDDStyle {

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

//        String payload="{\n" +
//                "    \"workspace\": {\n" +
//                "        \"name\": \"Public Workspace8\",\n" +
//                "        \"type\": \"public\",\n" +
//                "        \"description\": \"This is a public workspace.\"\n" +
//                "    }\n" +
//                "}";
        File file=new File("C:\\Users\\SATHEESH VUSIKELA\\IdeaProjects\\api\\src\\main\\resources\\CreateWorkSpacePayload.json");
        given().
                body(file).
                when().post("/workspaces").
                then().
                log().all().
                assertThat().
                body("workspace.name",equalTo("Public Workspace9"));

    }
}
