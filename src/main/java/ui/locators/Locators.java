package ui.locators;

import org.openqa.selenium.By;

import java.util.HashMap;

public class Locators {

    private static HashMap<String, By> PageLocators;

    public static HashMap<String, By> getPageLocators() {

        if (PageLocators == null)
            PageLocators = new HashMap<String, By>();

        if (PageLocators.size() <= 0)
            initPageLocators();

        return PageLocators;
    }

    private static void addId(String key, By value) {
        PageLocators.put(key, value);
    }

    private static void initPageLocators() {

        /*Lely-WebSite-Needed-Locators*/
        addId("acceptCookies",By.xpath("//*[@id='cookienotice-button-accept']"));
        addId("mainPageSearchButton",By.xpath("//*[@data-do=\"trigger-search\"]"));
        addId("searchFormActive",By.xpath("//form[@class='global-search-container menu-item search-active']"));
        addId("searchBox",By.xpath("//input[@id='global-search']"));
        addId("searchButton",By.xpath("//button[contains(.,'Search')]"));
        addId("searchResultTexts",By.xpath("//div/section/ul/li/a/section/p"));
        addId("dropDownList",By.xpath("//select[@id='id_q']"));
        addId("techDocHeader",By.xpath("//*[@id=\"items-list\"]//a[2]/h3"));
        addId("viewFirstDocButton",By.xpath("//li[1]//section[1]//footer[1]//p[2]//a[1]"));
        addId("firstDownloadButton",By.xpath("(//a[@class=\"button button-secondary icon-pdf\"])[1]"));
        addId("typeDropDownList",By.xpath("//span[@id='select2-id_machine_type-container']"));
        addId("dropDown",By.id("select2-id_q-container"));
    }
}
