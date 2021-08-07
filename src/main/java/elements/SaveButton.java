package elements;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SaveButton {

    WebDriver driver;

    private static final String SAVE_BUTTON_XPATH = "//*[contains(@class,'button-container-inner slds-float_right')]/descendant::span[text() ='Save']";

    public SaveButton(WebDriver driver) {
        this.driver = driver;

    }

    @Step("Save new account")
    public void clickSaveButton() {
        driver.findElement(By.xpath(SAVE_BUTTON_XPATH)).click();
    }
}