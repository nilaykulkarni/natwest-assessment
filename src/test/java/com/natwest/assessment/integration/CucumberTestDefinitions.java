package com.natwest.assessment.integration;

import com.natwest.assessment.model.InputRequest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

/*
Step definitions for PrimeNumberFeature.feature
 */
@CucumberContextConfiguration
@SpringBootTest
public class CucumberTestDefinitions {

    Response primeNumbersResponse;

    int errorStatusCode = 400;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://localhost:8080";
    }

    @When("^the client calls /prime$")
    public void the_client_issues_prime() throws Throwable{
        InputRequest inputRequest = new InputRequest();
        inputRequest.setInput(10);
        primeNumbersResponse = given()
                .header("Content-type", "application/json")
                .and()
                .body(inputRequest)
                .when()
                .post("/prime")
                .then()
                .extract().response();
    }

    @Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        Assertions.assertEquals(primeNumbersResponse.statusCode(), 200);
    }

    @And("^the client receives prime numbers$")
    public void the_client_receives_server_version_body() throws Throwable {
        List<Integer> primeNumbers = Arrays.asList(2 , 3, 5, 7);
        Assertions.assertEquals(primeNumbersResponse.body().as(ArrayList.class), primeNumbers);
    }

    @When("^the client calls /prime with invalid input$")
    public void the_client_issues_prime_with_invalid_input() throws Throwable{
        InputRequest inputRequest = new InputRequest();
        inputRequest.setInput(new Integer("invalid"));
        errorStatusCode = given()
                .header("Content-type", "application/json")
                .and()
                .body(inputRequest)
                .when()
                .post("/prime")
                .then()
                .extract().statusCode();
    }

    @Then("^the client receives error code of (\\d+)$")
    public void the_client_receives_error_code_of(int statusCode) throws Throwable {
        Assertions.assertEquals(errorStatusCode, 400);
    }

}
