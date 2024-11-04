package stepdefinitions;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ScrollPage;

public class ScrollStpes {

    ScrollPage scrollPage = new ScrollPage(BaseTest.driver);

    @Given("the user scrolls to {string} menu")
    public void theUserScrollsToMenu(String tabName) {
        scrollPage.scrollToAndClickMenu(tabName);
    }

    @When("the user clicks on the last tab")
    public void theUserClicksOnTheLastTab() {
        scrollPage.scrollToLastTabAndClick();
    }

    @Then("the opened tab information should belong to {string}")
    public void theOpenedTabInformationShouldBelongTo(String lastTabName) {
        scrollPage.theOpenedTabInformationShouldBelongTo(lastTabName);
    }
}