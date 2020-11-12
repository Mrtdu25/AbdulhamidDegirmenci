package com.vytrack.step_definitions;

import com.vytrack.pages.BaseP;
import com.vytrack.pages.LoginPage;
import com.vytrack.utils.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CommonStepsDefinitions {
    BaseP basePage = new LoginPage();

    @Given("user navigates to {string} and {string}")
    public void user_navigates_to_and(String string, String string2) {
        BrowserUtils.wait(10);
        basePage.navigateTo(string, string2);
        BrowserUtils.wait(10);
    }

    @When("user clicks on save and close button")

    public void user_clicks_on_save_and_close_button() {
        BrowserUtils.wait(3);
        basePage.clickSaveAndClose();
        BrowserUtils.wait(3);
    }
}
