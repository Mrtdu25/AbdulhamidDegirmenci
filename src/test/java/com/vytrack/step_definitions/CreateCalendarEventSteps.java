package com.vytrack.step_definitions;

import com.vytrack.pages.calendar.CalendarEventsPage;
import com.vytrack.pages.calendar.CreateCalendarEventPage;
import com.vytrack.utils.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class CreateCalendarEventSteps {
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
    CreateCalendarEventPage createCalendarEventPage = new CreateCalendarEventPage();



    @Given("user clicks on create calendar event button")
    public void user_clicks_on_create_calendar_event_button() {

        calendarEventsPage.clickOnCreateCalendarEvent();

    }


    @When("user adds new calendar event information")
    public void user_adds_new_calendar_event_information(Map<String,String> data) {
        String title = data.get("Title");
        String description = data.get("Description");
        calendarEventsPage.enterTitleText(title);
        calendarEventsPage.enterDescriptionText(description);

    }
    @Then("user verifies that new calendar event is displayed:")
    public void user_verifies_that_new_calendar_event_is_displayed(Map<String,String> data) {

        String title = data.get("Title");
        String description = data.get("Description");

        Assert.assertEquals(title,calendarEventsPage.getInfo("Title"));
        Assert.assertEquals(description,calendarEventsPage.getInfo("Description"));


    }

    @When("user hover on three dots ... for {string}")
    public void user_hover_on_three_dots_for(String string) {
        calendarEventsPage.hoverOverDots(string);
    }



    @Then("{string}, {string} and {string} options should be available")
    public void and_options_should_be_available(String view, String edit, String delete) { BrowserUtils.wait(1);
        calendarEventsPage.optionsDisp(view,edit,delete);

    }

    @When("Click on {string} button")
    public void click_on_button(String string) {
        calendarEventsPage.clickOnSettings();
        BrowserUtils.wait(2);
    }

    @When("Deselect all options except {string}")
    public void deselect_all_options_except(String string) {
        calendarEventsPage.deselectingOptions(string);
    }

    @Then("{string} column still displayed")
    public void column_still_displayed(String string) {
        calendarEventsPage.checkIfOptionIsSelected(string);
    }

    @When("Expand {string} menu")
    public void expand_menu(String string) {
        calendarEventsPage.clickOnSaveAndCloseOptionsBtn();
    }


    @Then("Verify that {string}, {string} and {string} options are available")
    public void verify_that_and_options_are_available(String string, String string2, String string3) {
        calendarEventsPage.saveAndCloseOptionsAvailable(string,string2,string3);
    }
    @When("user click on {string} button")
    public void user_click_on_button(String string) {
        calendarEventsPage.clickCancelBtn();
    }


    @Then("{string} subtitle is displayed")
    public void subtitle_is_displayed(String string) {
        calendarEventsPage.createCalendarEventBtnIsDisplayed();
        Assert.assertEquals(string,calendarEventsPage.getPageSubTitleText());
    }

    @Then("difference between end and start time is exactly {int} hour")
    public void difference_between_end_and_start_time_is_exactly_hour(Integer int1) {
        createCalendarEventPage.meetingLastingTime(int1);
    }

    @When("user selects {string} as a start time")
    public void user_selects_as_a_start_time(String string) {
        createCalendarEventPage.selectingStartTime(string);
    }


    @Then("End time is equals to {string}")
    public void end_time_is_equals_to(String string) {
        createCalendarEventPage.endingTime(string);
    }
    @Given("Select {string} checkbox")
    public void select_checkbox(String string) {
        createCalendarEventPage.selectChkBox(string);
    }
    @Then("Verify that {string} checkbox is selected")
    public void verify_that_checkbox_is_selected(String string) {

        createCalendarEventPage.isChkBoxSelected(string);
    }

    @Then("time input boxes are not displayed")
    public void time_input_boxes_are_not_displayed() {
       Assert.assertTrue("time boxes are displayed",
               !createCalendarEventPage.areStartTimeAndEndTimeBoxesDisplayed());
    }

    @Then("date input boxes are displayed")
    public void date_input_boxes_are_displayed() {
        Assert.assertTrue(createCalendarEventPage.areStartAndEndDateBoxesDisplayed());
    }




}
