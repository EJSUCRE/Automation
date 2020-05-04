package com.globant.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.*;

public class BookingPage extends BookingBasePage {

    /**
     * Attributes to save information for validation process
     *
     *
     */
    private String nameHotel;
    private String scoreHotel;
    private String priceHotel;
    private String newNameHotel;
    private String newScoreHotel;
    private String newPriceHotel;


    /**
     * Elements Locator.
     *
     *
     */
    @FindBy(css = "span[class=\"xpb__link selected\"]")
    private WebElement sleepButton;

    @FindBy(id = "ss")
    private WebElement destinationTexBox;

    @FindBy(css = "div:nth-child(2) > div > div > div > div > span")
    private WebElement calendar;

    @FindBy(css = "div.bui-calendar__wrapper:nth-child(1) > div:nth-child(1)")
    private WebElement month;

    @FindBy(css = "div.bui-calendar__control:nth-child(2) > svg:nth-child(1)")
    private WebElement nextMontButton;

    @FindBy(id = "xp__guests__toggle")
    private WebElement chooseAmountOfPerson;

    @FindBy(css = "span[class=\"bui-stepper__display\"]")
    private List<WebElement> amountOfPerson;

    @FindBy(css = "button[aria-label=\"Aumenta el número de Adultos\"]")
    private WebElement plusAdultButton;

    @FindBy(css = "button[aria-label=\"Aumenta el número de Niños\"]")
    private WebElement plusChildButton;

    @FindBy(css = "select[aria-label=\"Edad del niño 1\"]")
    private WebElement chooseChildAge;

    @FindBy(css = ".sb-searchbox__button")
    private WebElement searchButton;

    @FindBy(css = "#filter_class > div:nth-child(2) > a:nth-child(4) > label:nth-child(1) > div:nth-child(2) > span:nth-child(1)")
    private WebElement fiveStarSort;

    @FindBy(css = ".sr_header > h1:nth-child(1)")
    private WebElement headMsg;

    @FindBy(css = ".sr-hotel__name ")
    private List<WebElement> hotelListName;

    @FindBy(css = "div[class=\"bui-review-score__badge\"]")
    private List<WebElement> scoreListHotel;

    @FindBy(css = "div[class=\"bui-price-display__value prco-inline-block-maker-helper\"]")
    private List<WebElement> pricesListHotel;

    @FindBy(css = "#hp_hotel_name")
    private WebElement newNameHotelTab2;

    @FindBy(css = "div[class=\"bui-review-score__badge\"]")
    private List<WebElement> newScoreTab2;

    @FindBy(css = "div[class=\"bui-price-display__value prco-inline-block-maker-helper\"]")
    private List<WebElement> newPriceTab2;

    @FindBy(css = "div[class=\"bui-price-display__label \"]")
    private List<WebElement> textAmountPersonValidator;

    @FindBy(css = "div[data-placeholder=\"Fecha de entrada\"]")
    private WebElement checkInDateTab2;

    @FindBy(css = "div[data-placeholder=\"Fecha de salida\"]")
    private WebElement checkOutDateTab2;

    @FindBy(css = "#hp_book_now_button")
    private List<WebElement> reserveButtonOne;

    @FindBy(css = "select[class=\"hprt-nos-select\"]")
    private List<WebElement> dropDewnRooms;

    @FindBy(css = "div[class=\"hprt-reservation-cta\"]")
    private WebElement reserveButtonTwo;

    @FindBy(css = "button[title=\"Cerrar\"]")
    private WebElement closePopUp;

    @FindBy(id="lastname")
    private WebElement lastName;

    @FindBy(id="email")
    private WebElement email;

    @FindBy(id="email_confirm")
    private WebElement emailConfirm;

    @FindBy(css = ".submit_holder_button ")
    private WebElement continueButton;

    @FindBy(id="phone")
    private WebElement phoneTextBox;

    @FindBy(id="cc_type")
    private  WebElement ccType;

    @FindBy(id="cc_number")
    private  WebElement tdcNumberBox;

    @FindBy(id="cc_cvc")
    private  WebElement ccCvcBox;

    @FindBy(css = "div[class=\"book-form-field-value\"]")
    private List<WebElement> userInfotmation;

    @FindBy(css = "div[class=\"bp_sidebar_content_block__li_content\"]")
    private  List<WebElement> reserveInformation;



    /**
     * Constructor.
     *
     * @param pDriver : WebDriver
     * @param url     : String
     */
    public BookingPage(WebDriver pDriver, String url) {
        super(pDriver);
        pDriver.get(url);
    }

    /**
     * SearchBooking.
     *
     * @param city : String
     */
    public void searchBooking(String city) throws InterruptedException {
        waitElementVisibility(sleepButton);
        clickElement(sleepButton);
        waitElementVisibility(destinationTexBox);
        clickElement(destinationTexBox);
        typeText(destinationTexBox, city);
        waitElementVisibility(calendar);
        clickElement(calendar);
        chooseDate();
        clickElement(chooseAmountOfPerson);
        chooseAmountOfAdult();
        chooseAmountOfChild();
        chooseAgeChild();
        clickElement(searchButton);
        waitElementVisibility(fiveStarSort);
        scrollDown(fiveStarSort);
        waitElementClick(fiveStarSort);
        clickElement(fiveStarSort);
        Thread.sleep(5000);
    }

    /**
     * Choose Date.
     */
    public void chooseDate() {
        SimpleDateFormat dtf = new SimpleDateFormat("MMMMM yyyy");
        SimpleDateFormat dtf2 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dtf3 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar today = Calendar.getInstance();
        today.setTime(new Date());
        today.add(Calendar.DAY_OF_MONTH, 29);

        String checkInMonth = dtf.format(today.getTime());
        String checkInDay = dtf2.format(today.getTime());
        today.add(Calendar.DAY_OF_MONTH, 14);
        String checkOutDay = dtf3.format(today.getTime());
        String flag = getText(month);

        if (flag.equalsIgnoreCase(checkInMonth)) {
            clickByTextElement("td[data-date=\"" + checkInDay + "\"]");
            clickByTextElement("td[data-date=\"" + checkOutDay + "\"]");
        } else {
            clickElement(nextMontButton);
            chooseDate();
        }
    }

    /**
     * Choose amount of adults to teh reservation.
     *
     *
     */
    public void chooseAmountOfAdult() {
        if (getText(amountOfPerson.get(0)).equals("3")) {
        } else {
            clickElement(plusAdultButton);
            chooseAmountOfAdult();
        }
    }

    /**
     * Choose amount of child to teh reservation.
     *
     *
     */
    public void chooseAmountOfChild() {
        if (getText(amountOfPerson.get(1)).equals("1")) {
        } else {
            clickElement(plusChildButton);
            chooseAmountOfChild();
        }
    }

    /**
     * Choose age for the child
     *
     *
     */
    public void chooseAgeChild() {
        dropDownElement(".sb-group__children__field > select", "9");
    }

    /**
     * Validate the hotel name is displayed
     *
     *
     */
    public boolean bookingOptionValidationName() {
        return isDisplayed(hotelListName.get(1));
    }

    /**
     * Validate the hotel score is displayed
     *
     *
     */
    public boolean bookingOptionValidationScore() {
        return isDisplayed(scoreListHotel.get(1));
    }

    /**
     * Validate the hotel price is displayed
     *
     *
     */
    public boolean bookingOptionValidationPrice() {
        return isDisplayed(pricesListHotel.get(1));
    }

    /**
     * Select the hotel and get the infotmation Name, Score and Price
     *
     *
     */
    public void chooseHotelAndGetInfo() {
        nameHotel = "Hotel "+getText(hotelListName.get(1));
        scoreHotel = getText(scoreListHotel.get(1));
        priceHotel = getText(pricesListHotel.get(1));
        log.info(nameHotel + " " + scoreHotel + " " + priceHotel);
        waitElementClick(hotelListName.get(1));
        clickElement(hotelListName.get(1));
    }

    /**
     * Switch the driver to the new browser tab
     *
     *
     */
    public void switchNewTab() throws InterruptedException {
        String currentHandle = getDriver().getWindowHandle();
        Set<String> handles = getDriver().getWindowHandles();
        for (String actual : handles) {

            if (!actual.equalsIgnoreCase(currentHandle)) {
                getDriver().switchTo().window(actual);
            }
        }

    }

    /**
     * Get the hotel's information in the new tab opened Name, Score and Price
     *
     *
     */
    public void getHotelInformationSecondTab() {

        waitElementVisibility(newNameHotelTab2);
        newNameHotel = getText(newNameHotelTab2);

        waitElementVisibility(newScoreTab2.get(0));
        newScoreHotel = getText(newScoreTab2.get(0));

        waitElementVisibility(newPriceTab2.get(0));
        newPriceHotel = getText(newPriceTab2.get(0));

        log.info(newNameHotel+" "+newScoreHotel+" "+newPriceHotel);
    }

    /**
     * Validate the Hotel's name between the first and second page
     *
     *
     */
    public boolean hotelNamesValidator(){

        if (nameHotel.equals(newNameHotel)){
            return true;
        }else {
            return false;
        }
    }

    /**
     * Validate the Hotel's score between the first and second page
     *
     *
     */
    public boolean hotelScoresValidator(){

        if (scoreHotel.equals(newScoreHotel)){
            return true;
        }else {
            return false;
        }
    }

    /**
     * Validate the Hotel's price between the first and second page
     *
     *
     */
    public boolean hotelPricesValidator(){

        if (priceHotel.equals(newPriceHotel)){
            return true;
        }else {
            return false;
        }
    }

    /**
     * Validate that the CheckIn date is displayed
     *
     */
    public boolean checkInValidator(){
        if(isDisplayed(checkInDateTab2)==true){
            return true;
        }else {
            return false;
        }
    }

    /**
     * Validate that the CheckOut date is displayed
     *
     */
    public boolean checkOutValidator(){
        if(isDisplayed(checkOutDateTab2)==true){
            return true;
        }else {
            return false;
        }
    }

    /**
     * Validate that the Amount of person in correct
     *
     */
    public boolean mountPersonValidator(){
        if (getText(textAmountPersonValidator.get(0)).equals("14 noches, 3 adultos, 1 niño")){
            return true;
        }else {
            return false;
        }
    }

    /**
     * Reservation Action
     *
     */
    public void reserveOption(){
        clickElement(reserveButtonOne.get(1));
        dropDownByElement(dropDewnRooms.get(0),"1");
        waitElementClick(reserveButtonTwo);
        clickElement(reserveButtonTwo);
        waitElementClick(closePopUp);
        clickElement(closePopUp);
    }

    /**
     * Fill Reservation Information
     *
     * @param name : String
     * @param emailText : String
     * @param phoneNumber : String
     */
    public void fillTheInformation(String name, String emailText,String phoneNumber){
        waitElementVisibility(lastName);
        typeText(lastName,name);
        typeText(email,emailText);
        typeText(emailConfirm,emailText);
        scrollDown(continueButton);
        clickElement(continueButton);
        waitElementClick(closePopUp);
        clickElement(closePopUp);
        waitElementVisibility(phoneTextBox);
        typeText(phoneTextBox,phoneNumber);
        dropDownByElement(ccType,"Visa");
        typeText(tdcNumberBox,"4594186367022176");
        typeText(ccCvcBox,"007");
    }

    /**
     * Reservation name Validation
     *
     */
    public String getNameForm(){
    return getText(userInfotmation.get(0));
    }

    /**
     * Reservation email Validation
     *
     */
    public String getEmailForm(){
        return getText(userInfotmation.get(1));
    }

    /**
     * Reservation CheckIn date Validation
     *
     */
    public Boolean lastCheckInValidator(){
        return isDisplayed(reserveInformation.get(0));
    }

    /**
     * Reservation CheckOut date Validation
     *
     */
    public Boolean lastCheckOutValidator(){
        return isDisplayed(reserveInformation.get(1));
    }

    /**
     * Reservation amount of persons Validation
     *
     */
    public Boolean lastCheckPersonsValidator(){
        return isDisplayed(reserveInformation.get(3));
    }

}
