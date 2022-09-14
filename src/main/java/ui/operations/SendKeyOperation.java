package ui.operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.utilities.DriverManager;

public class SendKeyOperation {
    private String logMessage = "";
    private final WebDriver webDriver;

    public SendKeyOperation() {

        DriverManager driverManager = new DriverManager();
        webDriver = driverManager.getDriver();
    }

    public void sendKey(String text, By by) {

        WebElement element = webDriver.findElement(by);
        element.sendKeys(text);
        logMessage = String.format(" Sent '%s' to '%s' ", text, element);
        System.out.println(logMessage);
    }
}
