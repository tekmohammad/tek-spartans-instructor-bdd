@Regression
Feature: Create new account functionality

#  Steps that is common between Scenarios of specific feature.
#  Background steps will execute at beginning of each scenario
  Background: Setup create account scenarios
    Given user click on "Sign in" link
    Then validate user is in sign in page
    Given user click on "Create New Account" link

  @UsingMap
  Scenario: Using a Map as Data Table
    When user enter new account info
      | name     | Mohammad     |
      | email    | random       |
      | password | Password@123 |
    When user click on "Sign Up" button
    Then validate user is in account page
    Then validate email address in account page match

    @UsingList
  Scenario: Using List as Data Table
    When user enter new account info using list Data
      | Mohammad     |
      | random       |
      | Password@123 |
    When user click on "Sign Up" button
    Then validate user is in account page
    Then validate email address in account page match