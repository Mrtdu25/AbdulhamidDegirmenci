package com.vytrack.step_definitions;

import com.vytrack.pages.calendar.CalendarEventsPage;
import com.vytrack.pages.calendar.CreateCalendarEventPage;
import com.vytrack.pages.calendar.Repeat;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CalendarEventsRepeatOptionsSteps {
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
    CreateCalendarEventPage createCalendarEventPage = new CreateCalendarEventPage();
    Repeat repeat = new Repeat();






    @Then("Verify that {string} is selected by default")
    public void verify_that_is_selected_by_default(String string) {

        Assert.assertEquals("Wrong option selected",string,repeat.selectedRepeatsOption());
    }

    @Then("Daily Weekly Monthly Yearly options are available")
    public void daily_weekly_monthly_yearly_options_are_available() {
        repeat.selectOptions();
    }

    @Then("that {string} radio button is selected as an {string} option")
    public void that_radio_button_is_selected_as_an_option(String string, String string2) {
       Assert.assertTrue(repeat.neverChkBtnIsSelected());
    }


    @Given("Select After {int} occurrences as an {string} option.")
    public void select_after_occurrences_as_an_option(Integer int1, String string) {
        repeat.setOccurrences(int1);
    }

    @Given("Select {string} as an {string} option.")
    public void select_as_an_option(String string, String string2) {
        repeat.setByDate(string);
    }

    @Given("Select {string} options as a {string} option")
    public void select_options_as_a_option(String option, String dropdown) {
        repeat.selectingRepeatingOptions(option, dropdown);
    }



    @Then("following message for default as a summary is displayed: {string}")
    public void following_message_for_default_as_a_summary_is_displayed(String string) {
        Assert.assertEquals(string,repeat.summaryMessageIs());
    }



}
