package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final By LOGIN_BUTTON = By.id("Login");
    private static final By ERROR_TEXT = By.id("error");
    private static final By LOGO_NAME = By.xpath("//*[contains(@class,'profile-card-name')]/descendant::a[contains(text(),'%s')]");

    @FindBy(xpath = "//*[@class = 'photoContainer forceSocialPhoto']")
    WebElement iconImage;

    @FindBy(id = "error")
    WebElement errorText;

    public LoginPage loginPage() {
        log.info("Open login page");
        driver.get(LOGIN_URL_PAGE);
        return this;
    }

    @Step("The user is logged into the account")
    public void login(String username, String password) {
        log.info(String.format("Fill in username: %s in Login field", username));
        driver.findElement(By.id("username")).sendKeys(username);
        log.info(String.format("Fill in password: %s in password field", password));
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        new HomePage(driver);
    }

    public LoginPage waitForHomePageLoaded() {
        waitForPageOpened(iconImage, 50);
        return this;
    }

    public LoginPage waitForErrorTextMessage() {
        waitForPageOpened(errorText, 50);
        return this;
    }

    public String getErrorText() {
        return driver.findElement(ERROR_TEXT).getText();
    }

    public String getTitle(){
        return driver.getTitle();
    }
//TODO add check logo name
//    public String getLogoName(String logoName){
//        return driver.findElement(By.xpath(String.format(logoName, LOGO_NAME))).getText();
//        return driver.findElement(By.xpath(String.format(String.valueOf(LOGO_NAME), logoName))).getText();
//    }
}