package com.vytrack.step_definitions;

import com.vytrack.pages.opportunity.Opportunity;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class CreateOpportunitySteps {
    Opportunity opportunity = new Opportunity();


    @When("for {string} , give {string}")
    public void for_give(String string, String string2) {
        opportunity.enterInfo(string,string2);
    }

    @When("for {string} , give {int}")
    public void for_give(String string, Integer int1) {
        opportunity.enterInfo(string,int1);
    }

    @When("for {string} , give {int} USD")
    public void for_give_usd(String string, Integer int1) {
        opportunity.enterMoney(string,int1);
    }

    @When("clicks on choose account")
    public void clicks_on_choose_account() {
        opportunity.clickOnAccountBtn();
    }

    @Then("for {string} message {string} should displayed")
    public void for_message_should_displayed(String string, String string2) {
        opportunity.requiredFieldMessage(string,string2);
    }

    @When("user adds new opportunity budget range")
    public void user_adds_new_opportunity_budget_range(Map<String,Double> info) {
        info.forEach((k,v) -> {opportunity.enterMoney(k,v);});

        }


    @Then("for option message required should displayed")
    public void for_option_message_required_should_displayed(Map<String,String> info) {
        info.forEach((k,v) -> { opportunity.requiredFieldMessage(k,v);});
    }

}
