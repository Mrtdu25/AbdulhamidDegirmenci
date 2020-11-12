@contacts_options
Feature: As user, I want to be able to create calendar events

  Background: common steps
    Given user is on the login page
    And user logs in as a "store manager"
    And user navigates to "Sales" and "Opportunities"

 @new_opportunity
  Scenario:  creating new opportunity
   When user clicks on "Create Opportunity" button
   And for "Opportunity name" , give "F150"
   And for "Probability (%)" , give 20
   And for "Budget amount" , give 35000 USD
   And for "Close revenue" , give 28000 USD
   And clicks on choose account
   And selects "Test Account"
   Then message "You do not have permission to perform this action." should be displayed


  @new_opportunity#tc2
  Scenario:  creating new opportunity tc2
    When user clicks on "Create Opportunity" button
    And for "Budget amount" , give 40000 USD
    And user clicks on save and close button
    Then for "Opportunity name" message "This value should not be blank." should displayed


  @new_opportunity#tc3
  Scenario:  creating new opportunity tc3
    When user clicks on "Create Opportunity" button
    When user adds new opportunity budget range
      |Budget amount     |35000|
     # |Close revenue     |28000|
    And user clicks on save and close button
    Then for option message required should displayed
      |Opportunity name    |This value should not be blank.|
     # |Opportunity name    |This value should not be blank.|

  @new_opportunity#tc3_outline
  Scenario Outline: creating new opportunity tc3 outline
    When user clicks on "Create Opportunity" button
    When user adds new opportunity budget range
      |<option>|  <money>|
    And user clicks on save and close button
    Then for option message required should displayed
      |Opportunity name    |This value should not be blank.|


    Examples:
      |option            |money|
      |Budget amount     |35000|
      |Close revenue     |28000|

