package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input {

    WebDriver driver;
    String label;

    private static final String COMMON_FOR_TASK_XPATH = "//*[contains(text(),'%s')]/ancestor::div[contains(@class,";
    private static final String INPUT_XPATH = COMMON_FOR_TASK_XPATH + "'uiInput')]//input";
    private static final String INPUT_FOR_TASK_XPATH = COMMON_FOR_TASK_XPATH + "'slds-form-element__control')]//input";
    private static final String INPUT_FOR_TASK_DATE_XPATH = COMMON_FOR_TASK_XPATH + "'dateTime')]//input";

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void writeText(String text) {
        driver.findElement(By.xpath(String.format(INPUT_XPATH, label))).sendKeys(text);
    }

    public void writeTaskText(String text) {
        driver.findElement(By.xpath(String.format(INPUT_FOR_TASK_XPATH, label))).sendKeys(text);
    }

    public void clickReminderSet() {
        driver.findElement(By.xpath(String.format(INPUT_FOR_TASK_XPATH, label))).click();
    }

    public void chooseDateSendDay(String text) {
        driver.findElement(By.xpath(String.format(INPUT_FOR_TASK_DATE_XPATH, label))).clear();
        driver.findElement(By.xpath(String.format(INPUT_FOR_TASK_DATE_XPATH, label))).sendKeys(text);
    }
}