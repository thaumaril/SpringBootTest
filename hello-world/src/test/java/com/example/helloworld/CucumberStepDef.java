package com.example.helloworld;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.*;


class IsItFriday {
    static String isItFriday(String today) {
        return "Friday".equals(today) ? "TGIF" : "Nope";
    }
}


public class CucumberStepDef {
    private String today;
    private String actualAnswer;
    private URL url;
    private HttpURLConnection conn;

    @Given("^today is \"([^\"]*)\"$")
    public void today_is(String today) {
        this.today = today;
    }

    @When("^I ask whether it's Friday yet$")
    public void i_ask_whether_it_s_Friday_yet() {
        this.actualAnswer = IsItFriday.isItFriday(today);
    }

    @Then("^I should be told \"([^\"]*)\"$")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }


    @When("I call the REST-Endpoint {string}")
    public void call_rest_endpoint(String endpoint) throws java.io.IOException {
        url = new URL(endpoint);
        conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
    };

    @Then("I suspect status {int}")
    public void check_httpStatus(Integer int1) throws java.io.IOException{
        assertEquals((long)int1, (long)conn.getResponseCode());
        conn.disconnect();
    };
}


