package com.example.helloworld;


import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.http.HttpStatus;

import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.*;

public class CucumberStepDef extends CucumberHelperMethods {


    @When("^the Rest-Resource (.*) is called$")
    public void call_rest_endpoint(String resource) throws java.io.IOException {
        doRestCall(resource);
    }

    @Then("^the expected answer is (.*)$")
    public void check_httpStatus(HttpStatus httpStatus) throws java.io.IOException {

        AssertHttpStatusCodeIsAsExpected(httpStatus);
    };


}


