package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test(description = "Registration / logging in Sales Force")
    @Description("Enter username / password -> press enter")
    public void loginPageTest() {
        loginPage
                .loginPage()
                .loginAndGoToHomePage("shumans-lqjm@force.com", "LJ77M9JKnszpzP@T");
        loginPage
                .waitForHomePageLoaded();
        Assert.assertTrue(driver.getTitle().contains("Home | Salesforce"));
    }

    @Test(description = "Registration / logging in Sales Force")
    @Description("Enter username / wrong password -> press enter")
    public void loginPageTestWithWrongPasswordTest() {
        loginPage
                .loginPage()
                .loginAndGoToHomePage("shumans-lqjm@force.com", "LJ77M9JKnszpzP@T1");
        loginPage
                .waitForErrorTextMessage();
        Assert.assertEquals(loginPage.getErrorText(), "Please check your username and password. If you still can't log in, contact your Salesforce administrator.");
    }
}