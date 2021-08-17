package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteButton {

    WebDriver driver;

    private static final String DELETE_BUTTON_XPATH = "//*[contains(@class, 'forceModalActionContainer')]//span[contains(., 'Delete')]";

    public DeleteButton(WebDriver driver) {
        this.driver = driver;
    }

    public void clickDeleteButton() {
        driver.findElement(By.xpath(DELETE_BUTTON_XPATH)).click();
    }
}