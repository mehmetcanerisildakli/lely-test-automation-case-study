package ui.operations;

import org.openqa.selenium.WebDriver;
import ui.utilities.DriverManager;

public class WaitOperation {
    private String logMessage = "";
    private final WebDriver webDriver;

    public WaitOperation() {

        DriverManager driverManager = new DriverManager();
        webDriver = driverManager.getDriver();
    }

    public void wait(int second) {

        try {
            Thread.sleep(second);
        } catch (Exception e) {
        }
        logMessage = String.format(" Waited %s second(s)", second);
        System.out.println(logMessage);
    }
}
