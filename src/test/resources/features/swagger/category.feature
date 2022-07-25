@swagger
Feature: Categories

  @get-categories @positive
  Scenario: Successfully get all categories room
    When user send GET request categories
    Then response status code should be 200
    And response body should be equal with jsonSchema "success-get-categories.json"

  @get-categories @positive
  Scenario: Successfully get categories by id
    When user send GET request categories by id with 1
    Then response status code should be 200
    And response body should be equal with jsonSchema "success-get-categories-by-id.json"

  @get-categories @negative
  Scenario: Get categories with id as string
    When user send GET request categories by id with "satu"
    Then response status code should be 400
    And response body should be equal with jsonSchema "unsuccessfully-get-categories.json"

  @get-categories @negative
  Scenario: Get categories with id as special character
    When user send GET request categories by id with "##$@@@"
    Then response status code should be 400
    And response body should be equal with jsonSchema "unsuccessfully-get-categories.json"

  @get-categories @negative
  Scenario: Get categories with id not exist
    When user send GET request categories by id with 10
    Then response status code should be 400
    And response body should be equal with jsonSchema "unsuccessfully-get-categories.json"
