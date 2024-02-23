package com.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AutomatePostRequestBDDStyle1 {

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
    public void validate_status_code() throws JsonProcessingException {

        HashMap<String, Object> mainObject=new HashMap<>();

        HashMap<String, String> nestedObject=new HashMap<>();
        nestedObject.put("name","Public WorkspaceNon34587349");
        nestedObject.put("type","Public");
        nestedObject.put("description","This is a public workspace.");

       // File file=new File("C:\\Users\\SATHEESH VUSIKELA\\IdeaProjects\\api\\src\\main\\resources\\CreateWorkSpacePayload.json");

        ObjectMapper objectMapper=new ObjectMapper();
        String mainObjectStr=objectMapper.writeValueAsString(nestedObject);
        given().
                body(mainObjectStr).
                when().post("/workspaces").
                then().
                log().all().
                assertThat().
                body("workspace.name",equalTo("Public Workspace945645"));

    }
}
