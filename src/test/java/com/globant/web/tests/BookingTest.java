package com.globant.web.tests;

import com.globant.web.pages.BookingPage;
import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookingTest extends BookingBaseTest {
    @Description("Examen FinalPage")
    @Test()
    public void testCase() throws InterruptedException {
        log.info(getHomePage());
        BookingPage bookingPage = getHomePage();
        bookingPage.searchBooking("Bogotá, Colombia");
        Assert.assertTrue(bookingPage.bookingOptionValidationName(), "The Hotel's name was not found");
        Assert.assertTrue(bookingPage.bookingOptionValidationScore(), "The Hotel's Score was not found");
        Assert.assertTrue(bookingPage.bookingOptionValidationPrice(), "The Hotel's Price was not found");
        bookingPage.chooseHotelAndGetInfo();
        bookingPage.switchNewTab();
        bookingPage.getHotelInformationSecondTab();
        Assert.assertTrue(bookingPage.hotelNamesValidator(),"The name between the hotel in page 1 and page 2 are different");
        Assert.assertTrue(bookingPage.hotelScoresValidator(),"The score between the hotel in page 1 and page 2 are different");
        Assert.assertTrue(bookingPage.hotelPricesValidator(),"The price between the hotel in page 1 and page 2 are different");
        Assert.assertTrue(bookingPage.checkInValidator(),"The Check In date was not found");
        Assert.assertTrue(bookingPage.checkOutValidator(),"The Check Out date was not found");
        Assert.assertTrue(bookingPage.mountPersonValidator(),"The amount of person between the hotel in page 1 and page 2 are different");
        bookingPage.reserveOption();
        bookingPage.fillTheInformation("Perez","perez@hotmail.com","3023583654");
        Assert.assertEquals(bookingPage.getNameForm(),"Perez","The user is not correct");
        Assert.assertEquals(bookingPage.getEmailForm(),"perez@hotmail.com","The email user is not correct");
        Assert.assertTrue(bookingPage.lastCheckInValidator(),"The Check In information was not found");
        Assert.assertTrue(bookingPage.lastCheckOutValidator(),"The Check Out information was not found");
        Assert.assertTrue(bookingPage.lastCheckPersonsValidator(),"The Amount of person information was not found");
    }
}
