package com.globant.web.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePageEspn {
    private WebDriver driver;
    private WebDriverWait wait;
    Logger log = Logger.getLogger(BasePageTravelocity.class);

    /**
     * Constructor.
     *
     * @param pDriver : WebDriver
     */
    public BasePageEspn(WebDriver pDriver) {
        PageFactory.initElements(pDriver, this);
        driver = pDriver;
        wait = new WebDriverWait(pDriver, 20);
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
     * Get the web driver wait.
     *
     * @return WebDriverWait
     */
    public WebDriverWait getWait() {
        return wait;
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
     * Wait element to be click.
     *
     * @param element : WebElement
     */
    public void waitElementClick(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Refresh.
     *
     * @param element : WebElement
     */
    public void waitElementRefresh(WebElement element) {
        getWait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
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
     * scrollDown element
     *
     * @param element : WebElement
     */
    public void scrollDown(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        //This will scroll the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", element);
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    /**
     * implicit wait element
     *
     * @param element : WebElement
     */
    public void implicitWaitTime(int seconds){
        getDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }
}
