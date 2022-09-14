package ui.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    static WebDriver webDriver;

    public void setUpDriver() {

        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    public void tearDown() {

        if (webDriver != null) {
            webDriver.quit();
        }
    }

    public WebDriver getDriver() {
        return webDriver;
    }
}
