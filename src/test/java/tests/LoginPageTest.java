package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class LoginPageTest extends BaseTest {

    @Test(priority = 1, description = "Registration / logging in Sales Force")
    @Description("Enter username / password -> press enter")
    public void loginPageTest() {
        loginPage
                .loginPage()
                .login(
                        System.getProperty("username", PropertyReader.getProperty("username")),
                        System.getProperty("password", PropertyReader.getProperty("password")));
        loginPage
                .waitForHomePageLoaded();
        Assert.assertEquals(loginPage.getTitle(), "Home | Salesforce");
    }

    @Test(priority = 2)
    public void loginPageTestCheckLogoNameTest() {
        loginPage
                .loginPage()
                .login(
                        System.getProperty("username", PropertyReader.getProperty("username")),
                        System.getProperty("password", PropertyReader.getProperty("password")));
        loginPage
                .waitForHomePageLoaded()
                .clickLogoName();
        Assert.assertEquals(loginPage.getLogoName("Yura"), "Yura SHUMANAS");
    }

    @Test(priority = 3, description = "Registration / logging in Sales Force")
    @Description("Enter username / wrong password -> press enter")
    public void loginPageTestWithWrongPasswordTest() {
        loginPage
                .loginPage()
                .login(
                        System.getProperty("username1", PropertyReader.getProperty("username1")),
                        System.getProperty("password1", PropertyReader.getProperty("password1")));
        loginPage
                .waitForErrorTextMessage();
        Assert.assertEquals(loginPage.getErrorText(), "Please check your username and password. If you still can't log in, contact your Salesforce administrator.");
    }
}