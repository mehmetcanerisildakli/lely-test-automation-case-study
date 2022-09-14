package ui.operations;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.utilities.DriverManager;


public class ScrollOperation {
    private String logMessage = "";
    private final WebDriver webDriver;
    private final WaitOperation waitOperation;

    public ScrollOperation() {

        DriverManager driverManager = new DriverManager();
        webDriver = driverManager.getDriver();
        waitOperation = new WaitOperation();
    }

    public void scrollToElement(By by) {

        WebElement element = webDriver.findElement(by);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
        logMessage = String.format(" Scrolled to '%s' ", element);
        System.out.println(logMessage);

    }
}
