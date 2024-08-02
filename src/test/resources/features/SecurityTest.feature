Feature: Security tests scenarios

  Scenario: validate sign in functionality with valid credential
    When user click on sign in link
    Then validate user is in sign in page
    When user enter "mohammad2536@gmail.com" and "Password@123" and click on login
    Then user should be able to see account link

    #Task First implement this below scenarios and then Apply Scenario Outline

    Scenario: Validate sign in with invalid username valid password
      When user click on sign in link
      Then validate user is in sign in page
      When user enter "invalid@gmail.com" and "Password@123" and click on login
      Then user should see error "wrong username or password"

  Scenario: Validate sign in with invalid username valid password
    When user click on sign in link
    Then validate user is in sign in page
    When user enter "mohammad2536@gmail.com" and "WrongUserName" and click on login
    Then user should see error "wrong username or password"