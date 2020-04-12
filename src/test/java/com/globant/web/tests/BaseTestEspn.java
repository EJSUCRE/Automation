package com.globant.web.tests;

import com.globant.web.driver.Driver;
import com.globant.web.pages.EspnPage;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;

public class BaseTestEspn {

    Driver driver;
    private EspnPage espnPage;
    public Logger log = Logger.getLogger(BaseTestEspn.class);

    @BeforeTest(alwaysRun = true)
    @Parameters({"browser", "url"})
    public void beforeTest(String browser, String url) {
        driver = new Driver(browser);
        espnPage = new EspnPage(driver.getDriver(), url);
    }

    public EspnPage getEspnPage() {
        return espnPage;
    }

    @AfterMethod()
    public void afterMethod(Method flag) throws InterruptedException {
        if (flag.getName().equals("singUpTest")) {
            Thread.sleep(5000);
            espnPage.logOut();
        } else if (flag.getName().equals("logInTest")) {
            Thread.sleep(5000);
            espnPage.logOut();
        }
    }

    @AfterTest()
    public void afterTest() throws InterruptedException {
        driver.getDriver().quit();
    }

}
