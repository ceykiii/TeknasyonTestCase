package stepdefinitions;

import base.BaseTest;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hook {

    private static final String TARGET_TAG = "@ReinstallApp";

    @Before
    public void setUp(Scenario scenario) {

        if (scenario.getSourceTagNames().contains(TARGET_TAG)) {
            BaseTest.reinstallApp();
        }else{
            BaseTest.initializeDriver();
        }
    }

    @After
    public void tearDown() {
        BaseTest.quitDriver(); // Driver'ı kapat
    }
}
