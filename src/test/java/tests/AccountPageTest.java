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
                .login(
                        System.getProperty("username", PropertyReader.getProperty("username")),
                        System.getProperty("password", PropertyReader.getProperty("password")));
        accountPage
                .openAccountListPage()
                .clickDropDownForAccountName("TestAccount-SalesForce")
                .clickDeleteAccount();
        newDeleteAccountModalPage
                .clickDeleteAccountOnModalPage();
        Assert.assertEquals(accountPage.isElementPresent("TestAccount-SalesForce"), false);
    }
}