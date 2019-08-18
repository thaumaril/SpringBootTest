package com.example.helloworld;


import com.sun.tools.corba.se.idl.toJavaPortable.Helper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import jdk.internal.org.objectweb.asm.Type;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import sun.security.ssl.Debug;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.*;


class IsItFriday {
    static String isItFriday(String today) {
        return "Friday".equals(today) ? "TGIF" : "Nope";
    }
}

class HelperMethods {

    public static String StreamReader(HttpURLConnection conn) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line + "\n");
        }
        br.close();
        System.out.println(sb.toString());
        return sb.toString();
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
    }

    @Then("I suspect status {int}")
    public void check_httpStatus(Integer int1) throws java.io.IOException {
        assertEquals((long)int1, (long)conn.getResponseCode());
        //conn.disconnect();
    };

    @Then("I suspect JSON")
    public void check_JSON() throws java.io.IOException, JSONException {
        String expectedJson =  "{\"mood\":\".*\",\"dateTime\":\".*\"}";
        String actualJSON = HelperMethods.StreamReader(conn);
        JSONAssert.assertEquals(expectedJson ,actualJSON, true);


    }

}


