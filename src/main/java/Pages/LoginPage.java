package Pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final String URL = "https://filial-z.lightning.force.com";
    private static final By LOGIN_BUTTON = By.id("Login");
    private static final By ERROR_TEXT = By.id("error");

    @FindBy(xpath = "//*[@class = 'photoContainer forceSocialPhoto']")
    WebElement iconImage;

    @FindBy(id = "error")
    WebElement errorText;

    public LoginPage loginPage() {
        log.info("Open login page");
        driver.get(URL);
        return this;
    }

    @Step("The user is logged into the account")
    public void loginAndGoToHomePage(String username, String password) {
        log.info(String.format("Fill in username: %s in Login field", username));
        driver.findElement(By.id("username")).sendKeys(username);
        log.info(String.format("Fill in password: %s in password field", password));
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        new HomePage(driver);
    }

    public void waitForOpenHomePage(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public LoginPage waitForHomePageLoaded() {
        waitForOpenHomePage(iconImage, 50);
        return this;
    }

    public void waitForErrorText(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public LoginPage waitForErrorTextMessage() {
        waitForErrorText(errorText, 50);
        return this;
    }

    public String getErrorText() {
        return driver.findElement(ERROR_TEXT).getText();
    }
}