package com.globant.web.tests;

import com.globant.web.driver.Driver;
import com.globant.web.pages.BasePageTravelocity;
import com.globant.web.pages.TravelocityPage;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class BaseTestTravelocity {
    Driver driver;
    private TravelocityPage travelocityPage;
    public Logger log = Logger.getLogger(BasePageTravelocity.class);

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser", "url"})
    public void beforeTest(String browser, String url) {
        driver = new Driver(browser);
        travelocityPage = new TravelocityPage(driver.getDriver(), url);
    }

    public TravelocityPage getWTravelocityPage() {
        return travelocityPage;
    }

    @AfterMethod
    public void closeWindows() throws InterruptedException {
        Thread.sleep(3000);
        driver.getDriver().quit();
    }
}
