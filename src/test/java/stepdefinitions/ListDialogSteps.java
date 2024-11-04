package stepdefinitions;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DialogPage;

public class ListDialogSteps {

    DialogPage dialogPage = new DialogPage(BaseTest.driver);


    @When("the user taps on the {string} option")
    public void theUserTapsOnTheOption(String option) {
        dialogPage.theUserTapsOnTheOption(option);
    }

    @Given("the user selects an element from the list dialog")
    public void theUserSelectsAnElementFromTheListDialog() {
        dialogPage.theUserSelectsAnElementFromTheListDialog();
    }

    @Then("the alert message displays the correct order and name of the selected element")
    public void verifyAlertDisplaysCorrectSelection() {
        dialogPage.verifyAlertDisplaysCorrectSelection();
    }
}
