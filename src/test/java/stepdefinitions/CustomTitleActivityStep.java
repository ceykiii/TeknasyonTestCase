package stepdefinitions;

import base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CustomTitleActivityPage;

public class CustomTitleActivityStep {

    CustomTitleActivityPage customTitleActivityPage = new CustomTitleActivityPage(BaseTest.driver);

    @Then("the default textBox and navigationBar texts should be displayed correctly")
    public void verifyDefaultTextBoxAndNavBar() {
        customTitleActivityPage.verifyDefaultTextBoxAndNavBar();
    }

    @When("the user updates the left textBox to {string}")
    public void theUserUpdatesTheLeftTextBoxTo(String text) {
        customTitleActivityPage.theUserUpdatesTheLeftTextBoxTo(text);
    }

    @And("the user updates the right textBox to {string}")
    public void theUserUpdatesTheRightTextBoxTo(String text) {
        customTitleActivityPage.theUserUpdatesTheRightTextBoxTo(text);
    }

    @Then("the left and right textBox fields and navigationBar should display the updated texts")
    public void verifyUpdatedTextsInTextBoxesAndNavBar() {
        customTitleActivityPage.verifyUpdatedTextsInTextBoxesAndNavBar();
    }
}
