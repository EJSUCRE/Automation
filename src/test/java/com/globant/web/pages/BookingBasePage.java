package com.globant.web.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Parent of the other classes of pages.
 *
 * @author juan.montes
 */
public class BookingBasePage {

    private WebDriver driver;
    private WebDriverWait wait;
    public Logger log = Logger.getLogger(BookingBasePage.class);

    /**
     * Constructor.
     *
     * @param pDriver : WebDriver
     */
    public BookingBasePage(WebDriver pDriver) {
        PageFactory.initElements(pDriver, this);
        wait = new WebDriverWait(pDriver, 30);
        driver = pDriver;
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
    protected WebDriver getDriver() {
        return driver;
    }

    /**
     * Close the web driver.
     */
    public void dispose() {
        if (driver != null) {
            driver.quit();
        }
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
     * Wait element to be Clickable.
     *
     * @param element : WebElement
     */
    public void waitElementClick(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Click element
     *
     * @param element : WebElement
     */
    public void clickElement(WebElement element) {
        element.click();
    }

    /**
     * Type Text element
     *
     * @param element : WebElement
     * @param text    : String
     */
    public void typeText(WebElement element, String text) {
        element.sendKeys(text);
    }

    /**
     * get Text element
     *
     * @param element : WebElement
     */
    public String getText(WebElement element) {
        return element.getText();
    }

    /**
     * Click by text Element
     *
     * @param element : String
     */
    public void clickByTextElement(String element) {
        WebElement element1 = getDriver().findElement(By.cssSelector(element));
        element1.click();
    }

    /**
     * Dropdown Chilf Age
     *
     * @param element : Webelement
     */
    public void dropDownElement(String element, String age) {
        Select ageDropdown = new Select(getDriver().findElement(By.cssSelector(element)));
        ageDropdown.selectByValue(age);
    }

    /**
     * Dropdown by Element
     *
     * @param element : Webelement
     */
    public void dropDownByElement(WebElement element, String value) {
        Select valueDropdown = new Select(element);
        valueDropdown.selectByValue(value);
    }

    /**
     * ScrollDown Element
     *
     * @param element : Webelement
     */
    public void scrollDown(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);

    }

    /**
     * isDiplay Element
     *
     * @param element : Webelement
     */
    public boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

}