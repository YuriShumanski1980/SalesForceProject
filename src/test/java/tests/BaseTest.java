package tests;

import lombok.extern.log4j.Log4j2;
import pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
@Log4j2
public class BaseTest {
    WebDriver driver;
    BasePage basePage;
    LoginPage loginPage;
    HomePage homePage;
    NewAccountModalPage newAccountModalPage;
    AccountPage accountPage;
    NewTaskModalPage newTaskModalPage;
    DeleteAccountModalPage newDeleteAccountModalPage;

    @BeforeMethod
    @Step("Open browser,maximize window")
    public void initTest(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        newAccountModalPage = new NewAccountModalPage(driver);
        accountPage = new AccountPage(driver);
        newTaskModalPage = new NewTaskModalPage(driver);
        newDeleteAccountModalPage = new DeleteAccountModalPage(driver);
        String variable = "driver";
        log.debug("Setting driver into context with variable name " + variable);
        context.setAttribute(variable, driver);
    }

    @AfterMethod
    @Step("Close browser")
    public void endTest() {
        driver.quit();
    }
}