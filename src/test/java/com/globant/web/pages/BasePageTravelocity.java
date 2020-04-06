package com.globant.web.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePageTravelocity {
    private WebDriver driver;
    private WebDriverWait wait;
    Logger log = Logger.getLogger(BasePageTravelocity.class);

    /**
     * Constructor.
     *
     * @param pDriver : WebDriver
     */
    public BasePageTravelocity(WebDriver pDriver) {
        PageFactory.initElements(pDriver, this);
        driver = pDriver;
        wait = new WebDriverWait(pDriver, 20);
    }

    /**
     * Get the web driver wait.
     *
     * @return WebDriverWait
     */
    public WebDriverWait getWait() {
        return wait;
    }

    /**
     * Get the  web driver.
     *
     * @return WebDriver
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Wait element to be visible.
     *
     * @param element : WebElement
     */
    public void waitElementVisibility(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Click element
     *
     * @param element : WebElement
     */
    public void clickAction(WebElement element) {
        element.click();
    }

    /**
     * SendKeys element
     *
     * @param element : WebElement
     */
    public void typeText(WebElement element, String text) {
        element.sendKeys(text);
    }

    /**
     * getText element
     *
     * @param element : WebElement
     */
    public String getText(WebElement element) {
        return element.getText();
    }

    /**
     * Press Tab element
     *
     * @param element : WebElement
     */
    public void pressTab(WebElement element) {
        element.sendKeys(Keys.TAB);
    }

    /**
     * Clear element
     *
     * @param element : WebElement
     */
    public void clearText(WebElement element) {
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
    }

    /**
     * Select element by Index
     *
     * @param element : WebElement
     * @param index : int
     */
    public void selectByIndex(WebElement element, int index) {
        Select adultN = new Select(element);
        adultN.selectByIndex(index);
    }

    /**
     * Select element by Value
     *
     * @param element : WebElement
     * @param value : String
     */
    public void selectByValue(WebElement element, String value) {
        Select adultN = new Select(element);
        adultN.selectByValue(value);
    }


}
