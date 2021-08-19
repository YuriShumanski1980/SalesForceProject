package elements;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button {

    WebDriver driver;

    private static final String DELETE_BUTTON_XPATH = "//*[contains(@class, 'forceModalActionContainer')]//span[contains(., 'Delete')]";
    private static final String SAVE_BUTTON_XPATH = "//*[contains(@class,'button-container-inner')]/descendant::span[text() ='Save']";

    public Button(WebDriver driver) {
        this.driver = driver;
    }

    public void clickDeleteButton() {
        driver.findElement(By.xpath(DELETE_BUTTON_XPATH)).click();
    }

    @Step("Save new account")
    public void clickSaveButton() {
        driver.findElement(By.xpath(SAVE_BUTTON_XPATH)).click();
    }
}