package de.rest.begoodtoday;


import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import org.springframework.http.HttpStatus;

import java.net.MalformedURLException;
import static org.assertj.core.api.Assertions.assertThat;


public class CucumberStepDef extends CucumberHelperMethods {


    @When("^the Rest-Resource (.*) is called$")
    public void call_rest_endpoint(String resource) throws MalformedURLException {
        buildCallUrl(resource);
    }

    @Then("^the expected answer is (.*)$")
    public void check_httpStatus(HttpStatus httpStatus) throws MalformedURLException {
        doGETRestCall();
        assertThat(map.get("status")).isEqualTo(httpStatus);
    };


}


