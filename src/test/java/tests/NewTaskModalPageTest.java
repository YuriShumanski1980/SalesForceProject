package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class NewTaskModalPageTest extends BaseTest {

    @Test
    @Description("Create task WITHOUT Reminder Set - Date & Time")
    public void newTaskModalPageTest () {
        loginPage
                .loginPage()
                .login(
                        System.getProperty("username", PropertyReader.getProperty("username")),
                        System.getProperty("password", PropertyReader.getProperty("password")));
        newTaskModalPage
                .openNewTaskPage()
                .waitForTaskModalPageLoaded()
                .createInformationIntoTaskNewPage("Send Letter", "Privet trabla", "9/22/2021")
                .clickSaveNewTaskButton();
        Assert.assertEquals(newTaskModalPage.getTaskSubject ("Send"), "Send Letter");
    }

    @Test
    @Description("Create task WITH Reminder Set - Date & Time")
    public void newTaskModalPageTestReminderSet () {
        loginPage
                .loginPage()
                .login(
                        System.getProperty("username", PropertyReader.getProperty("username")),
                        System.getProperty("password", PropertyReader.getProperty("password")));
        newTaskModalPage
                .openNewTaskPage()
                .waitForTaskModalPageLoaded()
                .createNewTaskWithDateAndTime("Send Letter", "Privet trabla", "9/25/2021",
                        "9/30/2021", "1230", "In Progress", "Low")
                .clickSaveNewTaskButton();
        Assert.assertEquals(newTaskModalPage.getTaskSubject ("Send"), "Send Letter");
        Assert.assertEquals(newTaskModalPage.getTaskDueDate("2021"), "9/25/2021");
        Assert.assertEquals(newTaskModalPage.getTaskReminderSet("Sep"), "Sep 30, 2021 at 12:30 pm");
    }
}