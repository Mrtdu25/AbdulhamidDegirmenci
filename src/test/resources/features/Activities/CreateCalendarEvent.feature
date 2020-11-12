@calendar_events
Feature: As user, I want to be able to create calendar events

  Background: common steps
    Given user is on the login page
    And user logs in as a "store manager"
    And user navigates to "Activities" and "Calendar Events"

@create_calendar_event
  Scenario: Create calendar event with default time

    And user clicks on create calendar event button
    When user adds new calendar event information
      | Title       | B20 Graduation Party                        |
      | Description | All B20 friends are invited for this party! |
    And user clicks on save and close button
    Then user verifies that new calendar event is displayed:
      | Title       | B20 Graduation Party                        |
      | Description | All B20 friends are invited for this party! |


@three_dots_hover
  Scenario: Verify hover options

    When user hover on three dots ... for "fsd"
    Then "View", "Edit" and "Delete" options should be available

@deselecting_options
  Scenario: deselecting options

    When Click on "Grid Options" button
    And Deselect all options except "End"
    Then "End" column still displayed

@savings_options
  Scenario: savings options
    And user clicks on create calendar event button
    And Expand "Save And Close" menu
    Then Verify that "Save And Close", "Save And New" and "Save" options are available

@canceling_create_new_event
  Scenario: canceling creation of new event
  And user clicks on create calendar event button
  When user click on "Cancel" button
  Then "All Calendar Events" subtitle is displayed

@event_last_time
  Scenario: Event should last one hour exactly
  And user clicks on create calendar event button
  Then difference between end and start time is exactly 1 hour

@start_end_time
  Scenario: Event should end after one hour
  And user clicks on create calendar event button
  When user selects "8:00 PM" as a start time
  Then End time is equals to "9:00 PM"

@all_day_event
  Scenario: When all day checkbox is selected time disappears
  And user clicks on create calendar event button
  And Select "All-Day Event" checkbox
  Then Verify that "All-Day Event" checkbox is selected
  And time input boxes are not displayed
  And date input boxes are displayed


@repeat_options
  Scenario: repeat options
  And user clicks on create calendar event button
  And Select "Repeat" checkbox
  Then Verify that "Repeat" checkbox is selected
  Then Verify that "Daily" is selected by default
  And Daily Weekly Monthly Yearly options are available

@default_options
  Scenario: default options
  And user clicks on create calendar event button
  And Select "Repeat" checkbox
  Then Verify that "Repeat" checkbox is selected
  And that "Never" radio button is selected as an "Ends" option
  And following message for default as a summary is displayed: "Summary: Daily every 1 day"

@ends_after
  Scenario: ends after
  And user clicks on create calendar event button
  And Select "Repeat" checkbox
  And Select After 10 occurrences as an "Ends" option.
  Then following message as a summary is displayed: "Summary: Daily every 1 day, end after 10 occurrences"

@ends_by_date @smoke
  Scenario: ends by date
  And user clicks on create calendar event button
  And Select "Repeat" checkbox
  And Select "By Nov 18, 2021" as an "Ends" option.
  Then following message as a summary is displayed: "Summary: Daily every 1 day, end by Nov 18, 2021"

@verifying_days_repeating
  Scenario: verify days repeating
  And user clicks on create calendar event button
  And Select "Repeat" checkbox
  And Select "Weekly" options as a "Repeat" option
  And Select "Monday" and "Friday" options as a Repeat On options
  Then Verify that "Monday and Friday" options are selected
  Then following message for default as a summary is displayed: "Summary: Weekly every 1 week on Monday, Friday"



