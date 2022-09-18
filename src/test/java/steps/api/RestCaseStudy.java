package steps.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import restapi.ReadData;
import restapi.methods.RestMethod;

public class RestCaseStudy {

    RestMethod restMethod = new RestMethod();
    ReadData readData = new ReadData();

    @Given("Send GET request to list all users")
    public void SendGETRequestToListAllUsers() {
        restMethod.listUserId();
    }

    @Then("Check all users with proper digits")
    public void checkAllUsersHaveProperDigits() {
        restMethod.checkUserDigit();
    }

    @And("^Send POST request to add a (.*) with expected code (.*)$")
    public void sendPOSTRequestToAddANewUser(String user, int expectedStatusCode) {
        restMethod.postUser(readData.getTestData(user), expectedStatusCode);
    }

    @Then("^Check new (.*) is created correctly$")
    public void checkNewUserIsCreatedCorrectly(String user) {
        restMethod.checkCreatedUser(readData.getTestData(user));
    }

    @Then("^Check the response (.*)$")
    public void checkTheResponse(String expectedMessage) {
        restMethod.checkResponseBody(expectedMessage);
    }
}
