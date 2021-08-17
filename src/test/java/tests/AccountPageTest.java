package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class AccountPageTest extends BaseTest {

    @Test
    @Description("Delete account")
    public void deleteAccountTest() {
        loginPage
                .loginPage()
                .login(System.getenv().getOrDefault("username", PropertyReader.getProperty("username")),
                        System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        accountPage
                .openAccountListPage()
                .clickDropDown("TestAccount-SalesForce")
                .clickDeleteAccount()
                .clickDeleteAccountOnModalPage();
        Assert.assertEquals(accountPage.elementIsNotPresent("TestAccount-SalesForce"), true);
    }
}