@Calender_Events
Feature: Calendar Events

  Background:common steps
    Given user is on the login page
    When user logs in as a "store manager"
    And user navigates to "Activities" and "Calendar Events"

  @calendar_events
  Scenario: Create calendar event with default time
    And user clicks on create calendar event button
    When user adds new calendar event information
      | Title       | B20 Graduation Party                        |
      | Description | All B20 friends are invited for this party! |
    And user clicks on save and close button
    Then user verifies that new calendar event is displayed:
      | Title       | B20 Graduation Party                        |
      | Description | All B20 friends are invited for this party! |


  @TC1
  Scenario: Verify that "view", "edit" and "delete" options are available
    And Hover on three dots for "Hello" calendar event
    Then Verify that "View", "Edit" and "Delete" options are available

  @TC2
  Scenario: Verify that “Title” column still displayed
    And Click on Grid Options button
    And Deselect all options except Title
    Then Verify that Title column still displayed

  @TC3
  Scenario: Verify that “Save And Close”, “Save And New” and “Save” options are available
    And user clicks on create calendar event button
    And Expand Save And Close menu
    Then Verify that "Save and Close", "Save and New" and "Save" options are available

  @TC4
  Scenario:Verify that “All Calendar Events” page subtitle is displayed
    And user clicks on create calendar event button
    And Click on “Cancel” button
    Then Verify that “All Calendar Events” page subtitle is displayed

  @TC5
  Scenario: Verify that difference between end and start time is exactly 1 hour
    And user clicks on create calendar event button
    Then Verify that difference between end and start time is exactly 1 hour

    #last part not working
  @TC6
  Scenario: Verify that end time is equals to "10:00 PM"
    And user clicks on create calendar event button
    And Select "9:00 PM" as a start time
    Then Verify that end time is equals to "10:00 PM"


  @TC7
  Scenario: Verify that start and end date input boxes are displayed
    And user clicks on create calendar event button
    And Select "All-day event" checkbox
    Then Verify that "All-day event" checkbox is selected
    Then Verify that start and end time input boxes are not displayed
    Then Verify that start and end date input boxes are displayed

  @TC8
  Scenario: Verify that "Daily" is selected by default.
    And user clicks on create calendar event button
    And Select "Repeat" checkbox
    Then Verify that "Repeat" checkbox is selected
    Then Verify that "Daily" is selected by default.


  @TC9
  Scenario: Verify that following message as a summary is displayed: “Summary: Daily every 1 day”
    And user clicks on create calendar event button
    And Select "Repeat" checkbox
    Then Verify that "Repeat" checkbox is selected
    Then Verify that "Repeat Every" radio button is selected
    Then Verify that "Never" radio button is selected as an “Ends” option.
    Then Verify that following message as a summary is displayed: "Daily every 1 day"

  @TC10
  Scenario: Verify that following message as a summary is displayed: “Summary: Daily every 1 day, endafter 10 occurrences”
    And user clicks on create calendar event button
    And Select "Repeat" checkbox
    And Select After  as an “Ends” option and enter "10"
    Then Verify that following message as a summary is displayed: "Daily every 1 day, end after 10 occurrences"

  @TC11
  Scenario: Verify that following message as a summary is displayed: “Summary: Daily every 1 day, end by Nov 18, 2021”
    And user clicks on create calendar event button
    And Select "Repeat" checkbox
    And Select "By Nov 18, 2021" as an “Ends” option.
    Then Verify that following message as a summary is displayed: "Daily every 1 day, end by Nov 18, 2021"

  @TC12
  Scenario: Verify that following message as a summary is displayed: “Summary: Weekly every 1 week onMonday, Friday”
    And user clicks on create calendar event button
    And Select "Repeat" checkbox
    And Select "Weekly" options as a “Repeat” option
    And Select “Monday and Friday” options as a “Repeat On” options
    Then Verify that “Monday and Friday” options are selected
    Then Verify that following message as a summary is displayed: "Summary: Weekly every 1 week onMonday, Friday"
      | Description | All B20 friends are invited for this party! |