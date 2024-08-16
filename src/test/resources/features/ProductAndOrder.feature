Feature: This feature to validate everything related to product and order

  @UserStory7
  Scenario Outline: Validate search result for a searched keyword
    When user enter "<SearchKeyWord>" on search bar and click search
    Then validate search result contains "<SearchKeyWord>" for all products
    Examples:
      | SearchKeyWord |
      | TV            |
      | Card          |
      | Keyboard      |
      | Xbox          |
      | LED           |
      | LG            |
      | Sony          |

  @UserStory8
    Scenario: Add product in cart and delete
      Given user click on "Sign in" link
      Then validate user is in sign in page
      When user enter "mohammad2536@gmail.com" on "Email" field
      When user enter "Password@123" on "Password" field
      When user click on "Login" button
      Then user should be able to see account link
      When user enter "TV" on search bar and click search
      Then validate search result contains "TV" for all products
      When user click on first item in search result
      When user click on "Add to Cart" button
      When user click on cart link
      Then verify 1 item in the cart list
      When user delete all items in cart
      Then validate shopping cart is empty






