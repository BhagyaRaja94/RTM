package org.rtm.systemtest.cucumber.tankmaster.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

public class GreetingStepDefs {

    @Autowired
    private WebTestClient webTestClient;
    private WebTestClient.ResponseSpec responseSpec;

    @When("I call GET {string}")
    public void i_call_get(String uri) {
        responseSpec = webTestClient.get().uri(uri).exchange();
    }

    @Then("the response status should be {int}")
    public void the_response_status_should_be(int status) {
        responseSpec.expectStatus().isEqualTo(status);
    }

    @Then("the response body should be {string}")
    public void the_response_body_should_be(String body) {
        responseSpec.expectBody(String.class).isEqualTo(body);
    }
}