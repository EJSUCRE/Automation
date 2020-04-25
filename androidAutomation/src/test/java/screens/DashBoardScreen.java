package screens;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import util.screens.BaseScreen;

import java.util.List;

/**
 * DashBoard screen.
 *
 * @author Hans.Marquez
 */
public class DashBoardScreen extends BaseScreen {

    /**
     * Constructor method.
     *
     * @author Hans.Marquez
     * <p>
     * : AndroidDriver
     */
    public DashBoardScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    // AndroidElements
    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "UiSelector().resourceIdMatches(\".*button1.*\")")
    @AndroidFindBy(uiAutomator = "UiSelector().resourceIdMatches(\".*button1.*\").textContains(\"OK\")")
    @AndroidFindBy(uiAutomator = "UiSelector().resourceIdMatches(\".*permission.*allow.*button.*\")")
    private AndroidElement alertsPopUps;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*tmpsubacts_root\").childSelector(new UiSelector().textContains(\"Sign In\"))")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*tmpsubacts_primary\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionContains(\"Sign In, button\")")
    private AndroidElement signInButton;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/tmpsubacts_root\").childSelector(new UiSelector().textContains(\"Sign In\"))")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/tmpsubacts_primary\")")
    private AndroidElement userTextBox;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/tmpsubacts_root\").childSelector(new UiSelector().textContains(\"Sign In\"))")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/tmpsubacts_primary\")")
    private AndroidElement passwordTextBox;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(id = "tab_icon")
    private List<AndroidElement> dashBoardMenu;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(id = "categoryTitle")
    private AndroidElement categoryTitle;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionContains(\"Hotels\")")
    private AndroidElement hotelCategory;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionContains(\"More Option\")")
    private AndroidElement moreOptionButton;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionContains(\"My Profile\")")
    private AndroidElement myProfileOption;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionContains(\"Property Rules\")")
    private AndroidElement propertyRules;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionContains(\"Link to Account\")")
    private AndroidElement linktoAccount;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionContains(\"Help\")")
    private AndroidElement helpOption;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Privacy & Legal\")")
    private AndroidElement privacyAndLegal;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(id = "txt_element")
    private List<AndroidElement> privacyAndLegalSubOption;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(id = "tab_animated_icon")
    private AndroidElement addPlanButton;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Reserve Dining\")")
    private AndroidElement reserveDining;




    /**
     * @author Hans.Marquez
     * @description: Handle with random PopUps available in DashBoard Screen.
     */
    public LoginScreen goToLoginScreen() {
        click(signInButton);
        return new LoginScreen(driver);
    }


    /**
     * Alert control.
     */
    @Override
    public void alertControl() {
        int retries = 0;
        while (retries < 3) {
            if (alertsPopUps.isDisplayed() == true) {
                click(alertsPopUps, 3);
                retries++;
            }
        }
    }


    /**
     * Go to Map and Categories
     */
    public void goToMapTab() {
        click(dashBoardMenu.get(1));
        click(categoryTitle);
    }

    /**
     * Get Display Response
     */
    public Boolean getDisplayResponse() {
        return isDisplayed(hotelCategory);
    }

    /**
     * Go to More Option and Privacy and Legacy
     */
    public void goToMoreOption() {
        click(moreOptionButton);
        scrollDown(10);
    }

    /**
            * Go to Add Plans
     */
    public void goToAddPlans() {
        click(addPlanButton);
    }

    /**
     * Go to More Option and Privacy and Legacy
     */
    public void goToPrivacyAndLegacyTab() {
        click(privacyAndLegal);
    }

    /**
     * Get Display Response
     */
    public Boolean getDisplayMyProfile() {
        return isDisplayed(myProfileOption);
    }

    /**
     * Get Display Response
     */
    public Boolean getDisplayProperty() {
        return isDisplayed(propertyRules);
    }

    /**
     * Get Display Response
     */
    public Boolean getDisplayLinkToAccount() {
        return isDisplayed(linktoAccount);
    }

    /**
     * Get Display Response
     */
    public Boolean getDisplayHelp() {
        return isDisplayed(helpOption);
    }

    /**
     * Get Display Response
     */
    public Boolean getDisplayPrivacy() {
        return isDisplayed(privacyAndLegal);
    }

    /**
     * Get Display Response
     */
    public Boolean getDisplayPrivacySubOption() {
        boolean flag;
        flag = isDisplayed(privacyAndLegalSubOption.get(0));
        if (flag==true){
            flag = isDisplayed(privacyAndLegalSubOption.get(1));

            if ((flag==true)){
                flag = isDisplayed(privacyAndLegalSubOption.get(2));

                if ((flag==true)){
                    flag = isDisplayed(privacyAndLegalSubOption.get(3));

                    if ((flag==true)){
                        flag = isDisplayed(privacyAndLegalSubOption.get(4));

                        if ((flag==true)){
                            flag = isDisplayed(privacyAndLegalSubOption.get(5));
                        }
                    }
                }
            }
        }
        return flag;
    }

    /**
     * Get Display Response
     */
    public Boolean getDisplayReserveDining(){
        return isDisplayed(reserveDining);
    }



}
