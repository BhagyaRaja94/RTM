Feature: WatchList Screen in Tank Master

  Scenario: Verify user is able to remove tanks from watchlist
    Given user has launched Tank Master application in the browser
    When user enters valid email and password on the Login page
    Then verify "Demo" user is logged in successfully with user name displayed on the page
    And verify user is able to see all tanks tab selected in over view screen

    When user adds tank with name "TK-101" to watch list
    Then verify user is able to see tank with name "TK-101" in watch list

    When user navigates to User Overview page
    And user adds tank with name "TK-102" to watch list
    Then verify user is able to see tank with name "TK-102" in watch list

    When user removes tank with name "TK-101" from watch list
    Then verify user is not able to see tank with name "TK-101" in watch list

    



