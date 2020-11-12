package com.vytrack.step_definitions;

import com.vytrack.pages.calendar.RepeatsWeekly;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class RepeatsWeeklySteps {
    RepeatsWeekly repeatsWeekly = new RepeatsWeekly();

    @Given("Select {string} and {string} options as a Repeat On options")
    public void select_and_options_as_a_repeat_on_options(String day1, String day2) {
        repeatsWeekly.selectingDays(day1,day2);
    }
    @Then("Verify that {string} options are selected")
    public void verify_that_options_are_selected(String string) {
        Assert.assertTrue("options are not selected",repeatsWeekly.areOptionsSelected(string));
    }

}
