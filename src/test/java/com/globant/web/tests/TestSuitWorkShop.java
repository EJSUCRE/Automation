package com.globant.web.tests;

import com.globant.web.pages.WorkShopPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuitWorkShop extends BaseTestWorkShop {
    private WorkShopPage workShopPage;

    @Test(description = "Example Youtube play", priority = 1)
    public void PlayVideoYouTube() throws InterruptedException {

        //YouTube Play
        WorkShopPage workShopPage = getWorkShopPage();
        workShopPage.switchToiFrameYoutube();
        workShopPage.playVideoYoutube();
        Thread.sleep(10000);
        Assert.assertTrue(workShopPage.youTubeVideoValidation(), "The YouTube Video was not played");
    }

    @Test(description = "Example Vimeo play", priority = 2)
    public void PlayVideoVimeo() throws InterruptedException {
        //Vimeo Play
        WorkShopPage workShopPage = getWorkShopPage();
        workShopPage.switchToiFrameVimeo();
        workShopPage.playVideoVimeo();
        Thread.sleep(10000);
        Assert.assertTrue(workShopPage.vimeoVideoValidation(), "The YouTube Video was not played");
    }

}
