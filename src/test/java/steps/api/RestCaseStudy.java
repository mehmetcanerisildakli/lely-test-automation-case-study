package steps.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import restapi.ReadData;
import restapi.methods.RestMethod;

public class RestCaseStudy {

    @Given("Send GET request to list all users")
    public void SendGETRequestToListAllUsers() {
        RestMethod.listUserId();
    }

    @Then("Check all users with proper digits")
    public void checkAllUsersHaveProperDigits() {
        RestMethod.checkUserDigit();
    }

    @And("^Send POST request to add a (.*) with expected code (.*)$")
    public void sendPOSTRequestToAddANewUser(String user, int expectedStatusCode) {
        RestMethod.postUser(ReadData.getTestData(user), expectedStatusCode);
    }

    @Then("^Check new (.*) is created correctly$")
    public void checkNewUserIsCreatedCorrectly(String user) {
        RestMethod.checkCreatedUser(ReadData.getTestData(user));
    }

    @Then("^Check the response (.*)$")
    public void checkTheResponse(String expectedMessage) {
        RestMethod.checkResponseBody(expectedMessage);
    }
}
