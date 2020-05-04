package com.globant.web.tests;

import com.globant.web.driver.Driver;
import com.globant.web.pages.BookingPage;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

/**
 * Parent of the other classes of test.
 *
 * @author juan.montes
 */
public class BookingBaseTest {

    Driver driver;

    private BookingPage Home;
    public Logger log = Logger.getLogger(BookingBaseTest.class);


    @BeforeTest(alwaysRun = true)
    @Parameters({"browser", "url"})
    public void beforeTest(String browser, String url) {
        driver = new Driver(browser);
        driver.getDriver().manage().window().maximize();
        Home = new BookingPage(driver.getDriver(), url);
    }

	@AfterTest(alwaysRun=true)
	public void afterTest() {
		Home.dispose();
	}

    /**
     * Get the home page.
     *
     * @return HomePage
     */
    public BookingPage getHomePage() {
        return Home;
    }

}
