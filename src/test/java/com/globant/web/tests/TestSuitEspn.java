package com.globant.web.tests;

import com.globant.web.data.DataEspn;
import com.globant.web.pages.EspnPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestSuitEspn extends BaseTestEspn {
    List<String> emails = new ArrayList<String>();

    @Test(description = "User Sing Up", dataProviderClass = DataEspn.class, dataProvider = "users", priority = 1)
    public void singUpTest(String firstName2, String lastName2, String email2, String newPassword2) {
        emails.add(email2);
        EspnPage espnPage = getEspnPage();
        espnPage.sigUpAction(firstName2, lastName2, email2, newPassword2);
        Assert.assertTrue(espnPage.successCreateAccoutMsgDisplayed(), "The account was not created");
    }

    @Parameters({"email", "password"})
    @Test(description = "User Log In", priority = 2)
    public void logInTest(String email2, String newPassword2) throws InterruptedException {
        EspnPage espnPage = getEspnPage();
        espnPage.logInAction(email2, newPassword2);
        Assert.assertEquals(espnPage.getText(), "Sign In", "The user is not Log In");
    }


    @Test(description = "User Log In", dataProviderClass = DataEspn.class, dataProvider = "users", dependsOnMethods = {"singUpTest"}, priority = 3)
    public void cancelAccountTest(String firstName2, String lastName2, String email2, String newPassword2) throws InterruptedException {
        EspnPage espnPage = getEspnPage();
        espnPage.deleteAccountAction(emails.get(0), newPassword2);
        Assert.assertTrue(espnPage.deleteAccountMsgDisplayed(), "The account was not deleted");
    }
}
