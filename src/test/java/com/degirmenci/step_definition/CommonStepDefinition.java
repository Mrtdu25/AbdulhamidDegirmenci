package com.degirmenci.step_definition;

import com.degirmenci.pages.BasePage;
import com.degirmenci.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CommonStepDefinition {
    BasePage basePage = new LoginPage();

    @Given("user navigates to {string} and {string}")
    public void user_navigates_to_and(String string, String string2) {
        basePage.navigateTo(string, string2);
    }

    @When("user clicks on save and close button")
    public void user_clicks_on_save_and_close_button() {
        basePage.clickSaveAndClose();
    }

    @When("Click on “Cancel” button")
    public void click_on_cancel_button() {

        basePage.clickOnCancel();

    }


}
