package steps.ui;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import ui.utilities.DriverManager;

public class BaseStep {

    private WebDriver webDriver;
    private final DriverManager driver;
    final String baseURL = "https://www.lely.com/";

    public BaseStep() {
        driver = new DriverManager();
    }

    @Before
    public void StartTest(Scenario scenario) {

        if (!(scenario.getUri().toString().contains("restapi"))) {
            driver.setUpDriver();
            webDriver = driver.getDriver();
        }
    }

    @Given("Go to address (.*)$")
    public void goToAddress(String endpoint) {
        webDriver.get(baseURL + endpoint);
    }

    @After
    public void closeDriver() {
        driver.tearDown();
    }
}
