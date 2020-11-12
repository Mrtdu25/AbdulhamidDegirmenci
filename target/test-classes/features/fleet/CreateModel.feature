Feature: As user, I want to be able to add new models

  @add_model
  Scenario:  Add some model
    Given user is on the login page
    And user logs in as a "store manager"
    And user navigates to "Fleet" and "Vehicles Model"
    And user clicks on create model button
    When user adds new model information
      |Car model    |Q8  |
      |Car make     |Audi|
    And user clicks on save and close button
    Then user should see new model on the list
      |Car model    |Q8  |
      |Car make     |Audi|


  @add_model_scenario_outline
  Scenario Outline: Add some <car make> and <car model>
    Given user is on the login page
    And user logs in as a "store manager"
    And user navigates to "Fleet" and "Vehicles Model"
    And user clicks on create model button
    When user adds new model information
      |Car model    |<car model>|
      |Car make     |<car make> |
    And user clicks on save and close button
    Then user should see new model on the list
      |Car model    |<car model>|
      |Car make     |<car make> |

    Examples: model and make data
      | car model   | car make   |
      | Touareg     | Volkswagen |
      | 750li       | Bmw        |
      | 540I        | Bmw        |