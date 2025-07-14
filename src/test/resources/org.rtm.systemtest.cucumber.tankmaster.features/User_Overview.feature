Feature: User Overview Screen in Tank Master

  Scenario: Verify user is able to see all tanks tab selected in overview screen
    Given user has launched Tank Master application in the browser
    When user enters valid email and password on the Login page
    Then verify "Demo" user is logged in successfully with user name displayed on the page
    And verify user is able to see all tanks tab selected in over view screen

  Scenario: Verify user is able to add tank to watchlist from overview screen
    Given user has launched Tank Master application in the browser
    When user enters valid email and password on the Login page
    Then verify "Demo" user is logged in successfully with user name displayed on the page
    And verify user is able to see all tanks tab selected in over view screen

    When user adds tank with name "TK-101" to watch list
    Then verify user is able to see tank with name "TK-101" in watch list


    



