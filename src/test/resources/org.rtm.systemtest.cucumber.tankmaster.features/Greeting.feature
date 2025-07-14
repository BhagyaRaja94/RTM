Feature: Dummy feature to test API
//   This feature is used to test the API endpoint for greeting functionality.
  Scenario: Get a greeting for a specific name
    When I call GET "/api/greet?name=Alice"
    Then the response status should be 500


    



