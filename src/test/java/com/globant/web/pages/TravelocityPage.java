package com.globant.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TravelocityPage extends BasePageTravelocity {

    @FindBy(id = "tab-flight-tab-hp")
    private WebElement flightOption;

    @FindBy(id = "flight-origin-hp-flight")
    private WebElement originCity;

    @FindBy(id = "flight-destination-hp-flight")
    private WebElement destinationCity;

    @FindBy(id = "header-logo")
    private WebElement logo;

    @FindBy(id = "flight-departing-hp-flight")
    private WebElement departureDate;

    @FindBy(id = "flight-returning-hp-flight")
    private WebElement returningDate;

    @FindBy(id = "flight-adults-hp-flight")
    private WebElement adultDrop;

    @FindBy(id = "flight-children-hp-flight")
    private WebElement childDrop;

    @FindBy(id = "flight-age-select-1-label-hp-flight")
    private WebElement childValidation;


    /**
     * Constructor.
     *
     * @param driver : WebDriver
     */
    public TravelocityPage(WebDriver driver, String url) {
        super(driver);
        driver.manage().window().maximize();
        driver.get(url);
    }

    public void searchFlight() throws InterruptedException {
        // Explicit Wait for load the page
        waitElementVisibility(logo);

        //Select the FLight Option
        clickAction(flightOption);

        //Select The Departure and Destination Flights
        clickAction(originCity);
        typeText(originCity, "LAS");
        Thread.sleep(1000);
        pressTab(originCity);
        clickAction(destinationCity);
        typeText(destinationCity, "LAX");
        Thread.sleep(1000);
        pressTab(destinationCity);

        //Select Departure Date
        SimpleDateFormat dtf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar today = Calendar.getInstance();
        today.setTime(new Date());
        today.add(Calendar.DAY_OF_MONTH, 4);
        String departureDateText = dtf.format(today.getTime());
        clickAction(departureDate);
        typeText(departureDate, departureDateText);

        //Select Return Date
        clearText(returningDate);
        SimpleDateFormat dtf2 = new SimpleDateFormat("MM/dd/yyyy");
        Calendar today2 = Calendar.getInstance();
        today.setTime(new Date());
        today.add(Calendar.DAY_OF_MONTH, 10);
        String returnDateText = dtf.format(today.getTime());
        clickAction(returningDate);
        typeText(returningDate, returnDateText);

        //Select the Adults number
        clickAction(adultDrop);
        selectByIndex(adultDrop, 3);

        //Select the Children's number
        clickAction(childDrop);
        selectByValue(childDrop, "5");
        isDisplayed();
    }

    public boolean isDisplayed() {
        Boolean displayed = childValidation.isDisplayed();
        return displayed;

    }

}
