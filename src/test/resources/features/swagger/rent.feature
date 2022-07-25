@swagger
Feature: Rent


  @post-rent @positive @login-1
  Scenario: Rent room successfully
    When user send POST rent request with body "rent-room-success.json"
    Then response status code should be 200
    And response body should be equal with jsonSchema "success-rent-room.json"

  @post-rent @negative @login-1
  Scenario: Rent room with id as string
    When user send POST rent request with body "rent-room-id-string.json"
    Then response status code should be 400
    And response body should be equal with jsonSchema "unsuccessfull-rent-room.json"

  @post-rent @negative @login-1
  Scenario: Rent room with id as special character
    When user send POST rent request with body "rent-room-id-special-char.json"
    Then response status code should be 400
    And response body should be equal with jsonSchema "unsuccessfull-rent-room.json"

  @post-rent @negative @login-1
  Scenario: Rent room with id not exist
    When user send POST rent request with body "rent-room-id-not-exist.json"
    Then response status code should be 400
    And response body should be equal with jsonSchema "unsuccessfull-rent-room.json"

  @post-rent @negative @login-1
  Scenario: Rent room multiple times in same date
    When user send POST rent request with body "rent-room-multiple-times.json"
    Then response status code should be 405
    And response body should be equal with jsonSchema "unsuccessfull-rent-room.json"

  @post-rent @negative @login-2
  Scenario: Rent room that has been booked by someone
    When user send POST rent request with body "rent-room-has-booked.json"
    Then response status code should be 405
    And response body should be equal with jsonSchema "unsuccessfull-rent-room.json"

  @post-rent @negative
  Scenario: Rent room without login 
    When user send POST rent request with body "rent-room-success.json"
    Then response status code should be 400
    And response body should be equal with jsonSchema "rent-room-no-login.json"