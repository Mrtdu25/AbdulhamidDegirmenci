Feature: As a user I want to choose different options

  @accounts_launchpad
  Scenario: selecting option from Quick Launchpad
    Given user is on Dashboard page
    When user clicks on "suitcase" icon
    Then "All Accounts" page should open



  @quick_launchpad
  Scenario Outline: Choosing options from Quick Launchpad

    Given user is on Dashboard page
    When user clicks on "<icons>" icon
    Then "<pages>" page should open

    Examples: icons and pages

      | icons    |     pages          |
      | suitcase | All Accounts       |
      | group    | All Contacts       |
      | usd      | Open Opportunities |


  @quick_launchpad_icons
  Scenario: Quick launchpad icons
    Given user is on Dashboard page
    Then user should see "suitcase" icon


  @quick_launchpad_all_icons
  Scenario Outline:  Quick launchpad all icons
    Given user is on Dashboard page
    Then user should see "<icons>" icon

    Examples:

      | icons    |
      | suitcase |
      | group    |
      | usd      |