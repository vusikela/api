package com.rest;

import io.restassured.config.LogConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Test {

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

        //....Below one for Matchers assert
         // assertThat(res.path("workspaces[0].name"),equalTo("Team Workspace"));


          //.... Testng
        //Assert.assertEquals(res.path("workspaces[0].name"),"Team Workspace");

//        JsonPath jsonPath=new JsonPath(res.asString());
//        System.out.println("response = " + jsonPath.getString("workspaces[0].name"));

    }

    @org.testng.annotations.Test
    public void validate_response_body_hamcrest_learnings() {
          given().
                      baseUri("https://api.postman.com").
                      header("X-Api-Key", "PMAK-65a7715e2b6cb27e117fcb78-6837169a4ef67485f1c8bdbe530427a674").
                when().
                      get("/workspaces").
                then().
                      log().all().
                      assertThat().
                      statusCode(200).
                       // ....... contains() -> Check all elements are in a collection and in a strict order
                     // body("workspaces.name",contains("Team Workspace","Automation API Learning"));

               //.... Order is not same then it will fail automatically
                      //body("workspaces.name",contains("Automation API Learning","Team Workspace"));

               // .... containsInAnyOrder() -> Check all elements are in a collection and in any order
              //body("workspaces.name",containsInAnyOrder("Automation API Learning","Team Workspace"));

               //....empty() -> Check if collection is empty
               // body("workspaces.name",containsInAnyOrder("Automation API Learning","Team Workspace"),"workspaces.name",empty());

                       //.....not(empty()) -> Check if the Array is not empty
                              // body("workspaces.name",containsInAnyOrder("Automation API Learning","Team Workspace"),"workspaces.name",is(not(empty())));

                       //.....not(emptyArray()) -> Check if the Array is not empty
                              // body("workspaces.name",containsInAnyOrder("Automation API Learning","Team Workspace"),"workspaces.name",is(not(emptyArray())));


                 //.....hasSize() -> Check size of a collection
             // body("workspaces.name",containsInAnyOrder("Automation API Learning","Team Workspace"),"workspaces.name",is(not(emptyArray())),"workspaces.name",hasSize(2));


           //.....everyItem(startsWith()) -> Check if every item in a collection starts with specified string
          //                   hasKey() -> Map -> Check if Map has the specified key [value is not checked]
//        hasValue() -> Map -> Check if Map has at least one key matching specified value
//        hasEntry() -> Maps -> Check if Map has the specified key value pair
        body("workspaces.name",containsInAnyOrder("Automation API Workspace","Team Workspace"),
                   "workspaces.name",is(not(emptyArray())),
                  // "workspaces.name",everyItem(startsWith("My")),
                   "workspaces[0]",hasKey("id"),
                   "workspaces[0]",hasValue("cb9b7cb4-a02c-4a1f-809f-36f9635f38b2"),
                    "workspaces[0]",hasEntry("id","cb9b7cb4-a02c-4a1f-809f-36f9635f38b2"),
                    "workspaces[0]",not(equalTo((Collections.EMPTY_LIST))),
                 "workspaces[0].name",allOf(startsWith("Team"),containsString("Workspace"))
        );

    }
    @org.testng.annotations.Test
    public void request_response_logging() {
        Set<String> headers = new HashSet<String>();

        HashMap<String, String> headers1=new HashMap<String, String>();

        headers1.put("test","tst");



        headers.add("X-Api-Key");
        headers.add("Accept");
        given().
                baseUri("https://api.postman.com").
                   header("X-Api-Key", "PMAK-65a7715e2b6cb27e117fcb78-6837169a4ef67485f1c8bdbe530427a674").
               //f config(config.logConfig(LogConfig.logConfig().blacklistedHeaders(headers))).
                  log().all().
                when().
                    get("/workspaces").
                then().
                    log().all().
                    assertThat().
                    statusCode(200)

                ;

    }

    }

