package com.degirmenci.step_definition;

import com.degirmenci.pages.CalenderEventPage;
import com.degirmenci.utils.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import java.util.Map;

public class CreateCalenderEventsStepsDefinition {

    CalenderEventPage calenderEventPage=new CalenderEventPage();

    @Given("user clicks on create calendar event button")
    public void user_clicks_on_create_calendar_event_button() {
        BrowserUtils.wait(4);
      calenderEventPage.clickOnCreateCalenderEvent();
        BrowserUtils.wait(4);

    }


    @When("user adds new calendar event information")
    public void user_adds_new_calendar_event_information(Map<String,String> dataTable) {
        String title = dataTable.get("Title");
        String description = dataTable.get("Description");
        calenderEventPage.enterDescription(description);
        BrowserUtils.wait(2);
        calenderEventPage.enterTitle(title);
    }


    @Then("user verifies that new calendar event is displayed:")
    public void user_verifies_that_new_calendar_event_is_displayed(Map<String,String> dataTable) {

        String title = dataTable.get("Title");
        String description = dataTable.get("Description");

        Assert.assertEquals(title, calenderEventPage.getDataFromGeneralInfo("Title"));
        Assert.assertEquals(description, calenderEventPage.getDataFromGeneralInfo("Description"));
    }

    //TC1
    @When("Hover on three dots for {string} calendar event")
    public void hover_on_three_dots_for_calendar_event(String string) {

        calenderEventPage.hoverOnTheThreeDots(string);


    }



    @Then("{string}, {string} and {string} options should be available")
    public void and_options_should_be_available(String view, String edit, String delete) { BrowserUtils.wait(1);
        calenderEventPage.optionsDisp(view,edit,delete);
    }


    //TC2
    @When("Click on Grid Options button")
    public void click_on_grid_options_button() {
       calenderEventPage.clickOnGridOptions();

       BrowserUtils.wait(2);
    }


    @When("Deselect all options except Title")
    public void deselect_all_options_except_title() {
      calenderEventPage.deselectAllOptionExceptTitle();
      BrowserUtils.wait(2);

    }
    @Then("Verify that Title column still displayed")
    public void verify_that_title_column_still_displayed() {

        calenderEventPage.titleIsDisplayed();

    }

    //TC3
    @When("Expand Save And Close menu")
    public void expand_save_and_close_menu() {

        calenderEventPage.clickOnSaveAndCloseDropdown();

    }


    @Then("Verify that {string}, {string} and {string} options are available")
    public void verify_that_and_options_are_available(String string1, String string2, String string3) {

        calenderEventPage.verifyThatSaveAndCloseDropdownOptionsAvailable(string1);
        calenderEventPage.verifyThatSaveAndCloseDropdownOptionsAvailable(string2);
        calenderEventPage.verifyThatSaveAndCloseDropdownOptionsAvailable(string3);


    }


    //TC4

    @Then("Verify that “All Calendar Events” page subtitle is displayed")
    public void verify_that_all_calendar_events_page_subtitle_is_displayed() {

        calenderEventPage.allCalenderEventsSubtitleGetText();

    }

     //TC5
    @Then("Verify that difference between end and start time is exactly {int} hour")
    public void verify_that_difference_between_end_and_start_time_is_exactly_hour(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



    //TC6

    @When("Select {string} as a start time")
    public void select_as_a_start_time(String string) {

        calenderEventPage.selectStartTime(string);
        BrowserUtils.wait(3);

    }


    @Then("Verify that end time is equals to {string}")
    public void verify_that_end_time_is_equals_to(String string) {

        String actual = calenderEventPage.endTimeSubtitleGetText(string);

        Assert.assertEquals(string,actual);
    }


    //TC7

    @When("Select {string} checkbox")
    public void select_checkbox(String string) {

    calenderEventPage.clickOnAllDayEventCheckBox(string);

    BrowserUtils.wait(3);

    }


    @Then("Verify that {string} checkbox is selected")
    public void verify_that_checkbox_is_selected(String string) {

      calenderEventPage.checkboxIsSelected(string);

    }
    @Then("Verify that start and end time input boxes are not displayed")
    public void verify_that_start_and_end_time_input_boxes_are_not_displayed() {

        calenderEventPage.verifyThatStartAndEndTimeBoxAreNotDisplayed();

    }
    @Then("Verify that start and end date input boxes are displayed")
    public void verify_that_start_and_end_date_input_boxes_are_displayed() {

          calenderEventPage.verifyThatStartAndEndDateBoxAreDisplayed();
    }

    //TC8   calenderEventPage.clickOnRepeatCheckBox();

    @Then("Verify that {string} is selected by default.")
    public void verify_that_is_selected_by_default(String string) {

        calenderEventPage.verifyTheSelectedOption(string);
    }


    //TC9

    @Then("Verify that {string} radio button is selected")
    public void verify_that_radio_button_is_selected(String string) {

        calenderEventPage.repeatEveryRadioButtonIsSelected(string);


    }

    @Then("Verify that {string} radio button is selected as an “Ends” option.")
    public void verify_that_radio_button_is_selected_as_an_ends_option(String string) {

        calenderEventPage.repeatEveryRadioButtonIsSelected(string);
    }

    @Then("Verify that following message as a summary is displayed: {string}")
    public void verify_that_following_message_as_a_summary_is_displayed(String string) {


       calenderEventPage.summaryMessageGetText(string);


    }

    //TC10

    @When("Select After  as an “Ends” option and enter {string}")
    public void select_after_as_an_ends_option_and_enter(String string) {

     calenderEventPage.clickAfterCheckBoxAndInput10(string);

     BrowserUtils.wait(2);


    }

    //TC11









}
