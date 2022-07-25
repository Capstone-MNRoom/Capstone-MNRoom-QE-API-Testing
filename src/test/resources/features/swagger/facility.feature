@swagger
Feature: Facility

#  -----------GET ALL FACILITY------------
  @get-all-facility @positive
  Scenario: Successfully get all facility
    When I send GET request all facility
    Then response status code should be 200
    And response body should be equal with jsonSchema "success-get-all-facility.json"

  @get-all-facility @positive
  Scenario: Get all facility by valid id
    When I send GET request id facility by set params
    Then response status code should be 200
    And response body should be equal with jsonSchema "success-get-facility by id.json"

  @get-all-facility @negative
  Scenario: Get all facility by id as negative num
    When I send GET request id facility as negative num
    Then response status code should be 400
    And response body should be equal with jsonSchema "unsuccess-get-facility invalid id.json"

  @get-all-facility @negative
  Scenario: Get all facility by id as alphanumeric
    When I send GET request id facility as alphanumeric
    Then response status code should be 400
    And response body should be equal with jsonSchema "unsuccess-get-facility invalid id.json"

  @get-all-facility @negative
  Scenario: Get all facility by id doesn't exist
    When I send GET request id facility doesn't exist
    Then response status code should be 400
    And response body should be equal with jsonSchema "unsuccess-get-facility invalid id.json"

  @get-all-facility @negative
  Scenario: Get all facility by id special char
    When I send GET request id facility as special char
    Then response status code should be 400
    And response body should be equal with jsonSchema "unsuccess-get-facility invalid id.json"

#  -----------GET ROOM FACILITY------------
  @get-room-facility @positive @login-1
  Scenario: Successfully get room facility
    When I send GET request room facility with id room 86
    Then response status code should be 200
    And response body should be equal with jsonSchema "success-get-room-facility.json"

  @get-room-facility @negative @login-1
  Scenario: Get room facility with id room as negatif number
    When I send GET request room facility with id room -85
    Then response status code should be 400
    And response body should be equal with jsonSchema "unsuccess-get-room-facility.json"

  @get-room-facility @negative @login-1
  Scenario: Get room facility with id room as alphanumeric
    When I send GET request room facility with id room "delapanlima"
    Then response status code should be 400
    And response body should be equal with jsonSchema "unsuccess-get-room-facility.json"

  @get-room-facility @negative @login-1
  Scenario: Get room facility with id room doesn't exist
    When I send GET request room facility with id room 1001
    Then response status code should be 400
    And response body should be equal with jsonSchema "unsuccess-get-room-facility.json"

  @get-room-facility @negative @login-1
  Scenario: Get room facility with id as special char
    When I send GET request room facility with id room "@#$"
    Then response status code should be 400
    And response body should be equal with jsonSchema "unsuccess-get-room-facility.json"
    