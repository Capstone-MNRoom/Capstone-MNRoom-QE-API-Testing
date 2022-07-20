@swagger
Feature: users


  @get-users @positive @login
    Scenario: Get all user
    When user send GET users request
    Then response status code should be 200
    And response body should be equal with jsonSchema "get-all-user.json"