package stepdefinitions;

import base.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.NotificationPage;

public class NotificationSteps {

    NotificationPage notificationPage = new NotificationPage(BaseTest.driver);

    @When("the user clicks on the \"Show Notification\" button")
    public void theUserClicksOnTheButton() {
        notificationPage.clickShowNotificationButton();
    }

    @When("the user opens the Notification Bar")
    public void displayNotificationBar() {
        notificationPage.displayNotificationBar();
    }

    @When("the user clicks on the notification")
    public void theUserClicksOnTheNotification() {
        notificationPage.theUserClicksOnTheNotification();
    }

    @Then("the notification detail should open")
    public void theNotificationDetailShouldOpen() {
        notificationPage.theNotificationDetailShouldOpen();
    }

    @Then("the text in the notification detail should match the notification in the Notification Bar")
    public void notificationDetailShouldMatchNotificationBar() {
        notificationPage.notificationDetailShouldMatchNotificationBar();
    }
}
