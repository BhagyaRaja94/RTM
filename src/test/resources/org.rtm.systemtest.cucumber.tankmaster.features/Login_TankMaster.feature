Feature: Login functionality check in Tank Master

  Scenario: Verify User with valid credentials can login to the Tank Master portal
    Given user has launched Tank Master application in the browser
    When user enters valid email and password on the Login page
    Then verify "Demo" user is logged in successfully with user name displayed on the page

  Scenario Outline: Verify that invalid Users can not login to the Tank Master portal
    Given user has launched Tank Master application in the browser
    When user enters email "<email>" and password "<password>" on the Login page
    Then verify user is not logged in and error message is displayed
    Examples:
      | email                | password |
      | xxxx@example.com     | Pass123! |





