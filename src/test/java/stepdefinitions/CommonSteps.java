package stepdefinitions;

import base.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import pages.CommonPage;

public class CommonSteps {

    CommonPage commonPage = new CommonPage(BaseTest.driver);

    @Given("the user navigates to the following menu")
    public void theUserNavigatesToMenu(DataTable menuTable) {
        commonPage.navigateToMenu(menuTable);
    }
}
