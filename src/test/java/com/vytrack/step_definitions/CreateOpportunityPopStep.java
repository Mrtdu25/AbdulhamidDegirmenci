package com.vytrack.step_definitions;

import com.vytrack.pages.opportunity.AccountWindow;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CreateOpportunityPopStep {
    AccountWindow accountWindow = new AccountWindow();


    @When("selects {string}")
    public void selects(String string) {
        accountWindow.selectAccount(string);
    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String string) {
        Assert.assertTrue(accountWindow.isMessageDisplayed(string));
    }
}
