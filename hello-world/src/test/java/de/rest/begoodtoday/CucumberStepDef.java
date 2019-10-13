package de.rest.begoodtoday;


import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import de.rest.begoodtoday.model.Mood;
import de.rest.begoodtoday.repository.MoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.net.MalformedURLException;
import static org.assertj.core.api.Assertions.assertThat;


public class CucumberStepDef extends CucumberHelperMethods {

    @Autowired
    MoodRepository moodRepository;


    @When("^the Rest-Resource (.*) is called$")
    public void call_rest_endpoint(String resource) {
        buildCallUrl(resource);
    }

    @Then("^the expected answer is (.*)$")
    public void check_httpStatus(HttpStatus httpStatus) {
        doGETRestCall();
        assertThat(map.get("status")).isEqualTo(httpStatus);
    }

    @Then("^the amount of Moods in the Database is (.*)$")
    public void theAmountOfMoodsInTheDatabaseIs(int expectedAmount){
        assertThat(moodRepository.count()).isEqualTo(expectedAmount);
    }


}


