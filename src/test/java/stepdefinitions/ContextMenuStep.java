package stepdefinitions;

import base.BaseTest;
import io.cucumber.java.en.Then;
import pages.ContextMenuPage;

public class ContextMenuStep {

    ContextMenuPage contextMenu = new ContextMenuPage(BaseTest.driver);

    @Then("the user long presses the \"long press\" me button")
    public void theUserLongPressesTheButton() {
        contextMenu.theUserLongPressesTheButton();
    }

    @Then("the \"Menu A\" and \"Menu B\" options should be visible")
    public void theAndOptionsShouldBeVisible() {
        contextMenu.theAndOptionsShouldBeVisible();
    }
}
