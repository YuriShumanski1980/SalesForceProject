package elements;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextArea {

    WebDriver driver;
    String label;

    private static final String TEXTAREA_XPATH = "//*[contains(text(),'%s')]/ancestor::div[contains(@class,'uiInput')]/textarea";

    public TextArea(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    @Step("Filling in text information in the fields describing the terms of the transaction, place of delivery, etc.")
    public void writeTextDescription(String text) {
        driver.findElement(By.xpath(String.format(TEXTAREA_XPATH, label))).sendKeys(text);
    }
}