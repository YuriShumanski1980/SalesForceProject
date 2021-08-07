package Pages;

import elements.DropDown;
import elements.Input;
import elements.SaveButton;
import elements.TextArea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class NewAccountModalPage extends BasePage {

    public NewAccountModalPage(WebDriver driver) {
        super(driver);
    }

    private static final String URL_NEW_ACCOUNT = "https://filial-z.lightning.force.com/lightning/o/Account/new";
    private static final String COMMON_ELEMENT = "//*[@id='brandBand_2']";
    private static final String ACCOUNT_NAME = COMMON_ELEMENT + "//descendant::div[contains(@class, 'sfaOutputNameWithHierarchyIcon')]//descendant::span[contains(.,'%s')]";
    private static final String ACCOUNT_PHONE = COMMON_ELEMENT + "//descendant::a[contains(.,'%s')]";
    private static final String ACCOUNT_ADDRESS = COMMON_ELEMENT + "//slot/lightning-formatted-address/a/div[contains(.,'%s')]";
    private static final String ACCOUNT_ADDRESS2 = COMMON_ELEMENT + "//slot/lightning-formatted-address/a/div[contains(.,'%s')]";
    private static final String ACCOUNT_STATE = COMMON_ELEMENT + "//slot/lightning-formatted-address/a/div[contains(.,'%s')]";
    private static final String ACCOUNT_WEBSITE = COMMON_ELEMENT + "//descendant::a[contains(.,'%s')]";

    @FindBy(xpath = "//*[contains(text(),'Additional Information')]")
    WebElement additionalInformation;


    @Step("Open accounts page")
    public NewAccountModalPage openNewAccountPage() {
        log.info("Open new account modal page");
        driver.get(URL_NEW_ACCOUNT);
        return this;
    }

    @Step("Fill in the information on the account page.")
    public NewAccountModalPage createInformationIntoAccountNewPage
            (String accountName, String website, String option, String description, String phoneNumber,
             String option2, String numberOfEmployees, String billingStreet, String shippingStreet,
             String billingCity, String billingState, String shippingCity, String shippingState,
             String billingZip, String billingCountry, String shippingZip, String shippingCountry) {
        log.info(String.format("Fill in the information to create a new account: %s in Account Name", accountName));
        new Input(driver, "Account Name").writeText(accountName);
        log.info(String.format("Fill in the information to create a new account: %s in Type", option));
        new DropDown(driver, "Type").select(option);
        log.info(String.format("Fill in the information to create a new account: %s in Website", website));
        new Input(driver, "Website").writeText(website);
        log.info(String.format("Fill in the information to create a new account: %s in Description", description));
        new TextArea(driver, "Description").writeTextDescription(description);
        log.info(String.format("Fill in the information to create a new account: %s in Phone", phoneNumber));
        new Input(driver, "Phone").writeText(phoneNumber);
        log.info(String.format("Fill in the information to create a new account: %s in Industry", option2));
        new DropDown(driver, "Industry").select(option2);
        log.info(String.format("Fill in the information to create a new account: %s in Employees", numberOfEmployees));
        new Input(driver, "Employees").writeText(numberOfEmployees);
        log.info(String.format("Fill in the information to create a new account: %s in Billing Street", billingStreet));
        new TextArea(driver, "Billing Street").writeTextDescription(billingStreet);
        log.info(String.format("Fill in the information to create a new account: %s in Shipping Street", shippingStreet));
        new TextArea(driver, "Shipping Street").writeTextDescription(shippingStreet);
        log.info(String.format("Fill in the information to create a new account: %s in Billing City", billingCity));
        new Input(driver, "Billing City").writeText(billingCity);
        log.info(String.format("Fill in the information to create a new account: %s in Billing State", billingState));
        new Input(driver, "Billing State").writeText(billingState);
        log.info(String.format("Fill in the information to create a new account: %s in Shipping City", shippingCity));
        new Input(driver, "Shipping City").writeText(shippingCity);
        log.info(String.format("Fill in the information to create a new account: %s in Shipping State", shippingState));
        new Input(driver, "Shipping State").writeText(shippingState);
        log.info(String.format("Fill in the information to create a new account: %s in Billing Zip", billingZip));
        new Input(driver, "Billing Zip").writeText(billingZip);
        log.info(String.format("Fill in the information to create a new account: %s in Billing Country", billingCountry));
        new Input(driver, "Billing Country").writeText(billingCountry);
        log.info(String.format("Fill in the information to create a new account: %s in Shipping Zip", shippingZip));
        new Input(driver, "Shipping Zip").writeText(shippingZip);
        log.info(String.format("Fill in the information to create a new account: %s in Shipping Country", shippingCountry));
        new Input(driver, "Shipping Country").writeText(shippingCountry);
        return this;
    }

    @Step("Save account")
    public NewAccountModalPage clickSaveButton() {
        log.info("Жмякнули кнопку сохранить аккаунт");
        new SaveButton(driver).clickSaveButton();
        return this;
    }

    public void waitForElementOnNewModalPage(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public NewAccountModalPage waitForPageLoaded() {
        waitForElementOnNewModalPage(additionalInformation, 20);
        return this;
    }

    public String getNewAccountName(String accountName) {
        return driver.findElement(By.xpath(String.format(ACCOUNT_NAME, accountName))).getText();
    }

    public String getNewAccountPhone(String phone) {
        return driver.findElement(By.xpath(String.format(ACCOUNT_PHONE, phone))).getText();
    }

    public String getNewAccountAddress(String address) {
        return driver.findElement(By.xpath(String.format(ACCOUNT_ADDRESS, address))).getText();
    }

    public String getNewAccountAddress2(String address2) {
        return driver.findElement(By.xpath(String.format(ACCOUNT_ADDRESS2, address2))).getText();
    }

    public String getNewAccountState(String state) {
        return driver.findElement(By.xpath(String.format(ACCOUNT_STATE, state))).getText();
    }

    public String getNewAccountWebsite(String website) {
        return driver.findElement(By.xpath(String.format(ACCOUNT_WEBSITE, website))).getText();
    }
}