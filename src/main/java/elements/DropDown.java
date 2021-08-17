package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDown {
    WebDriver driver;
    String label;

    private static final String COMMON_DROPDOWN = "//*[contains(text(),'%s')]/ancestor::div[contains(@class,";
    private static final String DROPDOWN_XPATH = COMMON_DROPDOWN + "'uiInputSelect')]//a";
    private static final String SELECT_OPTION_XPATH = "//*[contains(@class,'select-options')]/descendant::a[contains(text(),'%s')]";
    private static final String TIME_DROPDOWN_XPATH = COMMON_DROPDOWN + "'dateTime')]//input";
    private static final String SELECT_TIME_DROPDOWN_XPATH = "//*[contains(@class, 'uiInputTimePicker')]//li[contains(@id, '%s')]";

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void select(String option) {
        driver.findElement(By.xpath(String.format(DROPDOWN_XPATH, label))).click();
        driver.findElement(By.xpath(String.format(SELECT_OPTION_XPATH, option))).click();
    }

    public void selectTimeDropDown(String option) {
        driver.findElement(By.xpath(String.format(TIME_DROPDOWN_XPATH, label))).click();
        driver.findElement(By.xpath(String.format(SELECT_TIME_DROPDOWN_XPATH, option))).click();
    }
}