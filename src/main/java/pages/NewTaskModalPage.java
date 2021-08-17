package pages;

import elements.DropDown;
import elements.Input;
import elements.SaveButton;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class NewTaskModalPage extends BasePage {

    public NewTaskModalPage(WebDriver driver) {
        super(driver);
    }

    private static final String TASK_SUBJECT = "//*[@class ='row row-main column']//descendant::span[contains(., '%s')]";
    private static final String TASK_DUE_DATE = "//*[contains(@class, 'slds-col slds-grid')]//span[contains(@class, 'slds-grow')][contains(., '%s')]";
    private static final String TASK_REMINDER_SET = "//*[@class = 'slds-form-element__control slds-grid itemBody']//span[contains(., '%s')]";

    @FindBy(xpath = "//*[contains(text(),'Additional Information')]")
    WebElement taskAdditionalInformation;

    @Step
    public NewTaskModalPage openNewTaskPage() {
        log.info("Open new task modal page" + NEW_TASK_MODAL_PAGE);
        super.openPage(NEW_TASK_MODAL_PAGE);
        return this;
    }

    @Step("Create task without Reminder Set - Date & Time")
    public NewTaskModalPage createInformationIntoTaskNewPage(String subject, String relatedTo, String dueDate) {
        log.info("Select the subject of the task");
        new Input(driver, "Subject").writeTaskText(subject);
        log.info("Select which account the task refers to");
        new Input(driver, "Related To").writeTaskText(relatedTo);
        log.info("Specify due date");
        new Input(driver, "Due Date").writeTaskText(dueDate);
        log.info("Remove the ability to specify the date and time of the reminder - remove the checkbox");
        new Input(driver, "Reminder Set").clickReminderSet();
        return this;
    }

    @Step("Create task with Reminder Set - Date & Time")
    public NewTaskModalPage createNewTaskWithDateAndTime(String subject, String relatedTo, String dueDate, String date,
                                                         String timeId, String status, String priority) {
        log.info("Select the subject of the task");
        new Input(driver, "Subject").writeTaskText(subject);
        log.info("Select which account the task refers to");
        new Input(driver, "Related To").writeTaskText(relatedTo);
        log.info("Specify due date");
        new Input(driver, "Due Date").writeTaskText(dueDate);
        log.info("Specify Reminder Date");
        new Input(driver, "Date").chooseDateSendDay(date);
        log.info("Specify Reminder Time");
        new DropDown(driver, "Time").selectTimeDropDown(timeId);
        log.info("Specify status");
        new DropDown(driver, "Status").select(status);
        log.info("Specify priority");
        new DropDown(driver, "Priority").select(priority);
        return this;
    }

    @Step("Save account")
    public NewTaskModalPage clickSaveNewTaskButton() {
        log.info("Clicked save new task button");
        new SaveButton(driver).clickSaveButton();
        return this;
    }

    public NewTaskModalPage waitForTaskModalPageLoaded() {
        waitForPageOpened(taskAdditionalInformation, 50);
        return this;
    }

    public String getTaskSubject (String subject) {
        return driver.findElement(By.xpath(String.format(TASK_SUBJECT, subject))).getText();
    }
    public String getTaskDueDate (String dueDate) {
        return driver.findElement(By.xpath(String.format(TASK_DUE_DATE, dueDate))).getText();
    }

    public String getTaskReminderSet (String date) {
        return driver.findElement(By.xpath(String.format(TASK_REMINDER_SET, date))).getText();
    }
}