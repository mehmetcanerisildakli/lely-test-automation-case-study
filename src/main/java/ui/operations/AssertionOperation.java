package ui.operations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.utilities.DriverManager;

import java.util.List;

public class AssertionOperation {

    private String logMessage = "";
    private final WebDriver webDriver;

    public AssertionOperation() {

        DriverManager driverManager = new DriverManager();
        webDriver = driverManager.getDriver();
    }

    public void assertIsPresent(By by) {

        List<WebElement> elements = webDriver.findElements(by);
        Assert.assertFalse(elements.isEmpty());
        logMessage = String.format("Checked that '%s' is present", by);
        System.out.println(logMessage);
    }

    public void containsText(By by, String expectedText) {

        List<WebElement> elements = webDriver.findElements(by);
        logMessage = String.format("'%s' contain the value", elements);
        for (WebElement element : elements) {
            if (!element.getText().toLowerCase().contains(expectedText.toLowerCase())) {
                logMessage = String.format("'%s' does not contain '%s'", elements, element);
                System.out.println(logMessage);
                Assert.fail();
            }
        }
        System.out.println(logMessage);
    }

    public void checkEquals(String expectedValue, String actualValue) {

        if (!expectedValue.equals(actualValue)) {
            logMessage = String.format("'%s' and '%s' are not equal!", expectedValue, actualValue);
            System.out.println(logMessage);
            Assert.fail();
        }
        logMessage = String.format("'%s' and '%s' have been checked", expectedValue, actualValue);
        System.out.println(logMessage);
    }

}
