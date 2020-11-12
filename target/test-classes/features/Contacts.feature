@contacts_options
Feature: As user, I want to be able to create calendar events

  Background: common steps
    Given user is on the login page
    And user logs in as a "store manager"
    And user navigates to "Customers" and "Contacts"


  @new_contact
  Scenario: creating new contact
    When user clicks on "Create Contact" button
    And for "First name" enter "Milica"
    And for "Last name" enter "Jovanovic"
    And for phone number enter "625-225-883"
    And for email enter "milica.jovanovic@gmail.com"
    And user clicks on save and close button
    Then new contact should be "Milica Jovanovic"
    And email "milica.jovanovic@gmail.com" , phone "625-225-883" should be displayed

  @new_contact2
  Scenario: creating new contact 2
    When user clicks on "Create Contact" button
    When user adds new contacts information
        |First name   |Milica          |
        |Last name    |Jovanovic       |
    And for phone number enter "625-225-883"
    And for email enter "milica.jovanovic@gmail.com"
    And user clicks on save and close button
    Then new contact should be "Milica Jovanovic"
    And email "milica.jovanovic@gmail.com" , phone "625-225-883" should be displayed


  @new_contact_out1
  Scenario Outline: creating new contacts
    When user clicks on "Create Contact" button
    When user adds new contacts information
      |First name   | <First name>    |
      |Last name    | <Last name>     |
    And for phone number enter "<Phone number>"
    And for email enter "<email>"
    And user clicks on save and close button
    Then new contact should be "<full name>"
    And email "<email>" , phone "<Phone number>" should be displayed

    Examples: persons info
      | First name    | Last name       | Phone number   |  email                       | full name         |
      | Milica        | Jovanovic       | 623-225-883    |  milica.jovanovic@gmail.com  | Milica Jovanovic  |
      | Dragana       | Ivanovic        | 602-512-963    |  dragana.ivanovic@gmail.com  | Dragana Ivanovic  |
      | Marko         | Stefanovic      | 480-225-883    |  marko.stefanovic@gmail.com  | Marko Stefanovic  |

  @new_contact_out2
  Scenario Outline: creating new contacts2
      When user clicks on "Create Contact" button
      When user adds new contacts information
        |First name   | <First name>    |
        |Last name    | <Last name>     |
      And user adds new contacts information
        |Job Title    | <Job Title>     |
        |LinkedIn     | <LinkedIn>      |
      And user clicks on save and close button
      Then new contact should be "<full name>"
      And  "Job Title" for "<Job Title>" , should be displayed
      And  "LinkedIn" , social media should be displayed

      Examples: persons info
        | First name    | Last name       | Job Title      |  LinkedIn            | full name         |
        | Milica        | Jovanovic       | manager        |  milica#jo           | Milica Jovanovic  |
        | Dragana       | Ivanovic        | team lead      |  gaga#Iva            | Dragana Ivanovic  |
        | Marko         | Stefanovic      | developer      |  marko#st            | Marko Stefanovic  |












