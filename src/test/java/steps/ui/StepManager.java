package steps.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.locators.Locators;
import ui.operations.*;
import ui.utilities.DriverManager;

public class StepManager {
    private final ClickOperation clickOperation;
    private final ScrollOperation scrollOperation;
    private final SendKeyOperation sendKeyOperation;
    private final AssertionOperation assertionOperation;
    private final MainOperation mainOperation;


    public StepManager() {

        clickOperation = new ClickOperation();
        scrollOperation = new ScrollOperation();
        sendKeyOperation = new SendKeyOperation();
        assertionOperation = new AssertionOperation();
        mainOperation = new MainOperation();
    }

    @And("^Click (.*)$")
    public void clickElement(String key) {

        By locator = Locators.getPageLocators().get(key);
        clickOperation.click(locator);
    }

    @Then("^Check whether (.*) is opened$")
    public void checkWhetherSearchBoxIsOpened(String key) {

        By locator = Locators.getPageLocators().get(key);
        assertionOperation.assertIsPresent(locator);
    }

    @And("^Enter (.*) into (.*)")
    public void enterTextIntoSearchBox(String text, String key) {

        By locator = Locators.getPageLocators().get(key);
        sendKeyOperation.sendKey(text, locator);
    }

    @And("^Select (.*) from (.*)")
    public void selectFromDropDownList(String text, String key) {

        By locator = Locators.getPageLocators().get(key);
        clickOperation.selectFromDropDownList(locator, text);
    }

    @Then("^Check (.*) have (.*)$")
    public void checkSearchResultTextsHaveText(String key, String text) {

        By locator = Locators.getPageLocators().get(key);
        assertionOperation.containsText(locator, text);
    }

    @Then("^Check (.*) is present$")
    public void checkElementIsPresent(String key) {

        By locator = Locators.getPageLocators().get(key);
        assertionOperation.assertIsPresent(locator);
    }

    @And("Switch the tab")
    public void switchTheTab() {

        mainOperation.switchToTab();
    }

    @And("^Get attribute (.*) from (.*)$")
    public void getDocumentLink(String attribute, String key) {

        By locator = Locators.getPageLocators().get(key);
        mainOperation.getAttribute(locator, attribute);
    }

    @Then("Check file is opened in the new tab")
    public void checkFileIsOpenedInTheNewTab() {

        assertionOperation.checkEquals(mainOperation.getTagText(), mainOperation.getTheUrl());
    }

    @Then("Check the file is downloaded")
    public void checkTheFileIsDownloaded() {

        mainOperation.checkFile(mainOperation.getTagText());
    }

    @And("^Scroll to (.*)$")
    public void scrollTo(String key) {

        By locator = Locators.getPageLocators().get(key);
        scrollOperation.scrollToElement(locator);
    }
}
