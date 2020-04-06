package com.globant.web.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WorkShopPage extends BasePageWorkShop {

    @FindBy(css = "iframe")
    private List<WebElement> iFrames;

    @FindBy(css = "button.ytp-large-play-button.ytp-button")
    private WebElement playButtonYoutube;

    @FindBy(css = "button.play.rounded-box")
    private WebElement PlayButtonVimeo;

    @FindBy(css = ".ytp-ad-overlay-image")
    private WebElement youTubeValidation;

    @FindBy(css = "button[class=\"play rounded-box state-playing\"]")
    private WebElement vimeoValidation;


    /**
     * Constructor.
     *
     * @param driver : WebDriver
     */
    public WorkShopPage(WebDriver driver, String url) {
        super(driver);
        driver.manage().window().maximize();
        driver.get(url);
    }

    public void switchToiFrameYoutube() throws InterruptedException {

        switchToiFrame(iFrames.get(0));
        Thread.sleep(1000);
    }

    public void switchToiFrameVimeo() throws InterruptedException {
        switchToiFrame(iFrames.get(1));
        Thread.sleep(1000);
    }

    public void playVideoYoutube() throws InterruptedException {
        clickAction(playButtonYoutube);
        Thread.sleep(10000);
    }

    public void playVideoVimeo() throws InterruptedException {
        clickAction(PlayButtonVimeo);
        Thread.sleep(10000);
    }

    public Boolean youTubeVideoValidation(){
        Boolean played = youTubeValidation.isDisplayed();
        return  played;
    }

    public Boolean vimeoVideoValidation(){
        Boolean played = vimeoValidation.isDisplayed();
        return  played;
    }

}
