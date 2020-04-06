package com.globant.web.tests;

import com.globant.web.driver.Driver;
import com.globant.web.pages.BasePageWorkShop;
import com.globant.web.pages.WorkShopPage;
import org.apache.log4j.Logger;
import org.testng.annotations.*;

public class BaseTestWorkShop {
    Driver driver;

    private WorkShopPage workShopPage;
    public Logger log = Logger.getLogger(BasePageWorkShop.class);

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser", "url"})
    public void beforeTest(String browser, String url) {
        driver = new Driver(browser);
        workShopPage = new WorkShopPage(driver.getDriver(), url);
    }

    public WorkShopPage getWorkShopPage() {
        return workShopPage;
    }

   @AfterMethod
    public void closeWindows() throws InterruptedException {
        Thread.sleep(10000);
        driver.getDriver().quit();
    }
}
