Feature: As user i want to be able to login under different role
#this is a comment
  #this is a comment

  Background: common steps
    Given user is on the login page

  Scenario: Login as a sales manager
    When user logs in
    Then user should see dashboard page

  @parametrized_test
  Scenario: Parametrized login
    When user logs in as a "driver"
    Then user should see Quick Launch page

  @parametrized_test2
  Scenario: Parametrized login
    When user logs in second time as a "store manager"
    Then user should see dashboard page

  @s_o @with_two_columns
  Scenario Outline: Parametrized login as <role>
    When user logs in as a "<role>"
    Then user should see "<page_title>" page
    Examples:
      | role          | page_title      |
      | sales manager | Dashboard       |
      | store manager | Dashboard       |
      | driver        | Quick Launchpad |


  @negative_scenario_outline
  Scenario Outline: Invalid Login <username> and<password>
    When user logs in with "<username>" username and "<password>" password
    Then user verifies that "<message>" message is displayed
    Examples:
      | username | password | message                        |
      | wrong    | bad      | Invalid user name or password. |
      | murat    | bad      | Invalid user name or password. |
      | murat1   | bad1     | Invalid user name or password. |
      | murat2   | bad2     | Invalid user name or password. |
      | murat3   | bad3     | Invalid user name or password. |



