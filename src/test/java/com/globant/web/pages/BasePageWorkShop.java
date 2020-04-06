package com.globant.web.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageWorkShop {
    private WebDriver driver;
    private WebDriverWait wait;
    public Logger log = Logger.getLogger(BasePageWorkShop.class);

    /**
     * Constructor.
     *
     * @param pDriver : WebDriver
     */
    public BasePageWorkShop(WebDriver pDriver) {
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
     * SwitchTo iFrame element
     *
     * @param iFrame : WebElement
     */
    public void switchToiFrame(WebElement iFrame) {
        waitElementVisibility(iFrame);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        //This will scroll the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", iFrame);
        getDriver().switchTo().frame(iFrame);
    }

}
