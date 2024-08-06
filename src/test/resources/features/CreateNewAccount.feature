Feature: Create new account functionality


  Scenario: create valid account with random email
    Given user click on "Sign in" link
    Then validate user is in sign in page
    Given user click on "Create New Account" link
    When user enter "Mohammad" and "random"  and "Password@123"
    When user click on "Sign Up" button
    Then validate user is in account page
    Then validate email address in account page match