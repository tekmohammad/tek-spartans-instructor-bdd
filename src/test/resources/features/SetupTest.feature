Feature: This feature to setup framework

  Scenario: Validate top left corner logo
    # Given Open browser and navigate to retail app
    Then validate top left corner is TEKSCHOOL
    # Then Close the browser

  Scenario: Validate Logo and Sign in button
    Then validate top left corner is TEKSCHOOL
    Then Validate Sign in button is Enabled