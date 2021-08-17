package pages;

import elements.DeleteButton;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AccountPage extends BasePage {

    private String accountName;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    private static final String DROPDOWN_DELETE_ACCOUNT_XPATH = "//*[contains(.,'%s')]/ancestor::tr//span[contains(@class, 'slds-icon_container')]";
    private static final By DELETE_BUTTON_XPATH = By.xpath("//*[@class = 'branding-actions actionMenu']//a[@title = 'Delete']");
    private static final String ACCOUNT_NAME_ON_ACCOUNT_PAGE = "//*[contains(@class, 'forceInlineEditCell')]//descendant::a[contains(.,'%s')]";

    @Step("Open account list page")
    public AccountPage openAccountListPage() {
        log.info("Open new account modal page" + ACCOUNT_PAGE);
        super.openPage(ACCOUNT_PAGE);
        return this;
    }

    @Step("Click dropdown")
    public AccountPage clickDropDown(String accountName) {
        log.info("Select account & click dropdown");
        driver.findElement(By.xpath(String.format(DROPDOWN_DELETE_ACCOUNT_XPATH, accountName))).click();
        return this;
    }

    @Step("Click delete on dropdown")
    public AccountPage clickDeleteAccount() {
        log.info("Delete account");
        driver.findElement(DELETE_BUTTON_XPATH).click();
        return this;
    }

    @Step("Confirm account delete on modal page")
    public AccountPage clickDeleteAccountOnModalPage() {
        log.info("Confirm account delete on modal page");
        new DeleteButton(driver).clickDeleteButton();
        return this;
    }

    public boolean elementIsNotPresent(String accountName){
        this.accountName = accountName;
        return driver.findElements(By.xpath(ACCOUNT_NAME_ON_ACCOUNT_PAGE)).isEmpty();
    }
}