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
	@Description(value = "test of something ID:0001")
	@Test()
	public void testOfSomething() {
		log.info("testOfSomething");
		DashBoardScreen dashBoard = loadDashBoardScreen();
		LoginScreen login = dashBoard.goToLoginScreen();
		login.fillInLoginData("ender.sucre@globant.com", "Test123*");
		Assert.assertTrue(login.isDisplayed(),"The User is no Log In");
	}

}
