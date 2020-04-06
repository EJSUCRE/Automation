package com.globant.web.tests;

import com.globant.web.pages.TravelocityPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuitTravelocity extends BaseTestTravelocity {
    private TravelocityPage travelocityPage;

    @Test(description = "Travelocity Flight Search")
    public void travelocityTestFlightSearch() throws InterruptedException {
        TravelocityPage travelocityPage = getWTravelocityPage();
        travelocityPage.searchFlight();
        Assert.assertTrue(travelocityPage.isDisplayed(),"WebElement for choose children's age was not found");
    }
}
