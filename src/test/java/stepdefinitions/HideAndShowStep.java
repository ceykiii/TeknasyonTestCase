package stepdefinitions;

import base.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HideAndShowPage;

public class HideAndShowStep {

    HideAndShowPage hideAndShowPage = new HideAndShowPage(BaseTest.driver);

    @Then("the user should see two Hide buttons and two text boxes on the screen")
    public void verifyTwoHideButtonsAndTwoTextBoxesAreVisible() {
        hideAndShowPage.verifyTwoHideButtonsAndTwoTextBoxes();
    }

    @When("the user clicks on the second Hide button")
    public void clickSecondHideButton() {
        hideAndShowPage.clickSecondHideButton();
    }

    @Then("the second text box should be hidden and the button text should be {string}")
    public void verifySecondTextBoxIsHiddenAndButtonText(String expectedStatus) {
        hideAndShowPage.verifySecondTextBoxHiddenAndButtonStatus(expectedStatus);
    }

    @When("the user clicks on the Show button")
    public void clickSecondShowButton() {
        hideAndShowPage.clickSecondShowButton();
    }

    @Then("the second text box should reappear and the button text should be {string}")
    public void verifySecondTextBoxIsVisibleAndButtonText(String expectedStatus) {
        hideAndShowPage.verifySecondTextBoxVisibleAndButtonStatus(expectedStatus);
    }
}
