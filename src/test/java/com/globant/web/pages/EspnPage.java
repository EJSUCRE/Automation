package com.globant.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EspnPage extends BasePageEspn {

    @FindBy(css = "iframe[id=\"google_ads_iframe_/21783347309/espn.com/frontpage/index_3\"]")
    private WebElement bannerAds;

    @FindBy(css = "div[class=\"ad-banner-wrapper\"]")
    private WebElement bannerAds2;

    @FindBy(css = "article[id=\"sideLogin-left-rail\"]")
    private WebElement sigInLeft;

    @FindBy(id = "global-user-trigger")
    private WebElement userTrigger;

    @FindBy(css = "a[tref=\"/members/v3_1/login\"]")
    private List<WebElement> loginButton;

    @FindBy(css = "iframe[id=\"disneyid-iframe\"]")
    private WebElement iframe;

    @FindBy(linkText = "Sign Up")
    private WebElement singUpButtton;

    @FindBy(name = "firstName")
    private WebElement firstName;

    @FindBy(name = "lastName")
    private WebElement lastName;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "newPassword")
    private WebElement newPassword;

    @FindBy(css = "section>div>button[type=\"submit\"]")
    private WebElement secSingUpButton;

    @FindBy(css = "div.global-user:nth-child(2) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(5) > a")
    private WebElement modifyAccountButton;

    @FindBy(css = ".user > div > div.global-user-container > ul.account-management > li:nth-child(9) > a")
    private WebElement logOutButtton;

    @FindBy(css = "span>input[type=\"email\"]")
    private WebElement emailLogIn;

    @FindBy(css = "span>input[type=\"password\"]")
    private WebElement passwordLogIn;

    @FindBy(css = "div.btn-group.touch-print-btn-group-wrapper > button")
    private WebElement secLogInButton;

    @FindBy(xpath = "//*[@id=\"cancel-account\"]")
    private WebElement cancelAccout;

    @FindBy(css = "button[ng-click=\"vm.confirm()\"]")
    //@FindBy(css = "button[ng-click=\"vm.cancel()\"]")
    private WebElement confirmationButton;

    @FindBy(css = "div.global-user:nth-child(2) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > span")
    private WebElement nameAfterLogin;

    @FindBy(css = "div[class=\"success-check\"]")
    private WebElement singUoMsgSuccess;

    @FindBy(css = "h2[did-translate=\"deactivate.successful.messages.header\"]")
    private WebElement deleteMsg;

    /**
     * Constructor.
     *
     * @param pDriver : WebDriver
     */
    public EspnPage(WebDriver pDriver, String url) {
        super(pDriver);
        pDriver.manage().window().maximize();
        pDriver.get(url);
    }

    /**
     * singUpAction.
     *
     * @param firstName2 : String
     * @param lastName2 : String
     * @param email2 : String
     * @param newPassword2 : String
     */
    public void sigUpAction(String firstName2, String lastName2, String email2, String newPassword2) {
        waitElementVisibility(sigInLeft);
        waitElementVisibility(bannerAds);
        waitElementVisibility(userTrigger);
        clickAction(userTrigger);
        waitElementVisibility(loginButton.get(0));
        clickAction(loginButton.get(0));
        waitElementVisibility(iframe);
        getDriver().switchTo().frame(iframe);
        waitElementVisibility(singUpButtton);
        clickAction(singUpButtton);
        waitElementVisibility(firstName);
        clickAction(firstName);
        typeText(firstName, firstName2);
        clickAction(lastName);
        typeText(lastName, lastName2);
        clickAction(email);
        typeText(email, email2);
        clickAction(newPassword);
        typeText(newPassword, newPassword2);
        waitElementVisibility(secSingUpButton);
        clickAction(secSingUpButton);
    }

    /**
     * logInAction.
     *
     * @param email2 : String
     * @param newPassword2 : String
     */
    public void logInAction(String email2, String newPassword2) {
        waitElementVisibility(sigInLeft);
        waitElementVisibility(bannerAds);
        waitElementVisibility(userTrigger);
        clickAction(userTrigger);
        waitElementVisibility(loginButton.get(0));
        clickAction(loginButton.get(0));
        waitElementVisibility(iframe);
        getDriver().switchTo().frame(iframe);
        waitElementVisibility(emailLogIn);
        clickAction(emailLogIn);
        typeText(emailLogIn, email2);
        clickAction(passwordLogIn);
        typeText(passwordLogIn, newPassword2);
        clickAction(secLogInButton);
    }

    /**
     * deleteAccountAction.
     *
     * @param email2 : String
     * @param newPassword2 : String
     */
    public void deleteAccountAction(String email2, String newPassword2) throws InterruptedException {
        waitElementVisibility(sigInLeft);
        waitElementVisibility(bannerAds);
        waitElementVisibility(userTrigger);
        clickAction(userTrigger);
        waitElementVisibility(loginButton.get(0));
        clickAction(loginButton.get(0));
        waitElementVisibility(iframe);
        getDriver().switchTo().frame(iframe);
        waitElementVisibility(emailLogIn);
        clickAction(emailLogIn);
        typeText(emailLogIn, email2);
        clickAction(passwordLogIn);
        typeText(passwordLogIn, newPassword2);
        clickAction(secLogInButton);
        Thread.sleep(5000);
        //implicitWaitTime(5);
        getDriver().switchTo().defaultContent();
        waitElementVisibility(userTrigger);
        clickAction(userTrigger);
        waitElementClick(modifyAccountButton);
        clickAction(modifyAccountButton);
        waitElementVisibility(iframe);
        getDriver().switchTo().frame(iframe);
        Thread.sleep(2000);
        //implicitWaitTime(2);
        scrollDown(cancelAccout);
        waitElementClick(cancelAccout);
        clickAction(cancelAccout);
        waitElementVisibility(confirmationButton);
        clickAction(confirmationButton);
    }

    /**
     * logOut.
     *
     */
    public void logOut() {
        getDriver().switchTo().defaultContent();
        waitElementVisibility(userTrigger);
        clickAction(userTrigger);
        waitElementVisibility(logOutButtton);
        clickAction(logOutButtton);
    }

    /**
     * getText.
     *
     */
    public String getText() throws InterruptedException {

        Thread.sleep(5000);
        //implicitWaitTime(5);
        getDriver().switchTo().defaultContent();
        waitElementRefresh(userTrigger);
        clickAction(userTrigger);
        String info = userTrigger.getText();
        return info;
    }

    /**
     * deleteAccountMsgDisplayed.
     *
     */
    public boolean deleteAccountMsgDisplayed() {
        waitElementRefresh(deleteMsg);
        Boolean flag = deleteMsg.isDisplayed();
        return flag;
    }

    /**
     * successCreateAccoutMsgDisplayed.
     *
     */
    public boolean successCreateAccoutMsgDisplayed() {
        waitElementRefresh(singUoMsgSuccess);
        Boolean flag = singUoMsgSuccess.isDisplayed();
        return flag;
    }
}
