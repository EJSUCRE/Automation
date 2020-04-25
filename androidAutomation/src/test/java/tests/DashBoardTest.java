package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.context.annotation.Description;

import screens.DashBoardScreen;
import screens.LoginScreen;
import util.tests.BaseMobileTest;

public class LoginAppTest extends BaseMobileTest {

    /**
     * Verify something.
     */
	/*@Description(value = "test of something ID:0001")
	@Test()
	public void testOfSomething() {
		log.info("testOfSomething");
		DashBoardScreen dashBoard = loadDashBoardScreen();
		LoginScreen login = dashBoard.goToLoginScreen();
		login.fillInLoginData("ender.sucre@globant.com", "Test123*");
		Assert.assertTrue(login.isDisplayed(),"The User is no Log In");
	}
    @Description(value = "Test of Log In faile ID:0002")
    @Test()
    public void testLogInFail() {
        log.info("testLogInFail");
        DashBoardScreen dashBoard = loadDashBoardScreen();
        LoginScreen login = dashBoard.goToLoginScreen();
        login.fillInLoginFailData("bad_email@globant.com", "Test123*");
        Assert.assertEquals(login.getTextFromFailMessageLogIn(), "The email and/or password do not match. Please try again.", "The bad log in message was not found");
    }

    @Description(value = "Test Map Category ID:0003")
    @Test()
    public void testMapCategories() {
        log.info("testMapCategories");
        DashBoardScreen dashBoard = loadDashBoardScreen();
        dashBoard.goToMapTab();
        Assert.assertTrue(dashBoard.getDisplayResponse(),"The Hotel Category was not found in the List");
    }

    @Description(value = "Test Map Privacy & Legacy ID:0004")
    @Test()
    public void testMapPrivacyAndLegacy() {
        log.info("testMapPrivacyAndLegacy");
        DashBoardScreen dashBoard = loadDashBoardScreen();
        dashBoard.goToMoreOption();
        Assert.assertTrue(dashBoard.getDisplayMyProfile(),"My Profile option was not found");
        Assert.assertTrue(dashBoard.getDisplayProperty(),"Property Rules option was not found");
        Assert.assertTrue(dashBoard.getDisplayLinkToAccount(),"Link to Account option was not found");
        Assert.assertTrue(dashBoard.getDisplayHelp(),"Help option was not found");
        Assert.assertTrue(dashBoard.getDisplayPrivacy(),"Privacy & Legal option was not found");
        dashBoard.goToPrivacyAndLegacyTab();
        Assert.assertTrue(dashBoard.getDisplayPrivacySubOption(),"Privacy & Legal Sub-Option were not found as expected");
    }*/

    @Description(value = "Test Add Plans ID:0005")
    @Test()
    public void testAddPlans() {
        log.info("testAddPlans");
        DashBoardScreen dashBoard = loadDashBoardScreen();
        dashBoard.goToAddPlans();
        Assert.assertTrue(dashBoard.getDisplayReserveDining(),"Reserve Dining was not found");
}
}
