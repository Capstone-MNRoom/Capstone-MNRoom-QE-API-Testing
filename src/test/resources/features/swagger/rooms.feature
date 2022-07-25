@swagger
Feature: rooms

#  -----------GET ALL ROOMS------------
  @get-rooms @positive
  Scenario: Get all rooms successfully
    When I send GET request rooms
    Then response status code should be 200
    And response body should be equal with jsonSchema "success-get-all-rooms.json"

  @get-rooms @positive
  Scenario: Get all rooms by idcategory
#    idcategory masih belum sesuai
    When I send GET request with set query params
    Then response status code should be 200
    And response body should be equal with jsonSchema "success-get-all-rooms-by idcategory.json"

  @get-rooms @negative
  Scenario: Get all rooms by idcategory as alphanumeric
    When I send GET request with set idcategory as alphanumeric
    Then response status code should be 400
    And response body should be equal with jsonSchema "unsuccess-get-all-rooms-invalid idcategory.json"

  @get-rooms @negative
  Scenario: Get all rooms by idcategory as negative number
    When I send GET request with set idcategory as negative number
    Then response status code should be 400
    And response body should be equal with jsonSchema "unsuccess-get-all-rooms-invalid idcategory.json"

  @get-rooms @negative
  Scenario: Get all rooms by idcategory that doesn't exist
    When I send GET request with set query params that doesnt exist
    Then response status code should be 400
    And response body should be equal with jsonSchema "unsuccess-get-all-rooms-invalid idcategory.json"

#  ---------INSERT ROOM-------------
  @post-rooms @positive @login-1
  Scenario: Insert room successfully
    When I send POST request with body "success-insert-room.json"
    Then response status code should be 200
    And response body should be equal with jsonSchema "success-insert-room.json"

#  --------GET ROOM BY ID-----------
  @get-room-by-id @positive
  Scenario: Successfully get room by id
    When I send GET request by id room 88
    Then response status code should be 200
    And response body should be equal with jsonSchema "success-get-room-by-id.json"

  @get-room-by-id @negative
  Scenario: Get room by id as negative number
    When I send GET request by id room -88
    Then response status code should be 400
    And response body should be equal with jsonSchema "unsuccessfull-get-room-invalid id.json"

  @get-room-by-id @negative
  Scenario: Get room by id as alphanumeric
    When I send GET request by id room "delapan"
    Then response status code should be 400
    And response body should be equal with jsonSchema "unsuccessfull-get-room-invalid id.json"

  @get-room-by-id @negative
  Scenario: Get room by id that doesn't exist
    When I send GET request by id room 1001
    Then response status code should be 400
    And response body should be equal with jsonSchema "unsuccessfull-get-room-invalid id.json"

#  --------UPDATE ROOM BY ID-----------
  @update-room-by-id @positive @login-1
  Scenario: Successfully update image room by id
    When I send PUT request by id room 86 with body "workspace.png"
    Then response status code should be 200
    And response body should be equal with jsonSchema "success-update-room.json"

  @update-room-by-id @negative @login-2
  Scenario: Update image room by different account
    When I send PUT request by id room 86 with image "workspace.png"
    Then response status code should be 401
    And response body should be equal with jsonSchema "unsuccessfull-update-room.json"

  @update-room-by-id @negative @login-1
  Scenario: Update room by id as negative number
    When I send PUT request by id room -86 with body "workspace.png"
    Then response status code should be 401
    And response body should be equal with jsonSchema "unsuccessfull-update-room.json"

  @update-room-by-id @negative @login-1
  Scenario: Update room by id as alphanumeric
    When I send PUT request by id room "enam" with body "workspace.png"
    Then response status code should be 400
    And response body should be equal with jsonSchema "unsuccessfull-update-room.json"

  @update-room-by-id @negative @login-1
  Scenario: Update room by id that doesn't exist
    When I send PUT request by id room 1001 with body "workspace.png"
    Then response status code should be 401
    And response body should be equal with jsonSchema "unsuccessfull-update-room.json"

#  --------DELETE ROOM BY ID-----------
  @delete-room-by-id @positive @login-1
  Scenario: Successfully delete room by id
    When I send DELETE request by id 85
    Then response status code should be 200
    And response body should be equal with jsonSchema "success-delete-room.json"

  @delete-room-by-id @negative @login-1
  Scenario: Delete room by id as negative number
    When I send DELETE request by id -84
    Then response status code should be 400
    And response body should be equal with jsonSchema "unsuccessfull-delete-room.json"

  @delete-room-by-id @negative @login-1
  Scenario: Delete room by id as alphanumeric
    When I send DELETE request by id "empat"
    Then response status code should be 400
    And response body should be equal with jsonSchema "unsuccessfull-delete-room.json"

  @delete-room-by-id @negative @login-1
  Scenario: Delete room by id that doesn't exist
    When I send DELETE request by id 1001
    Then response status code should be 400
    And response body should be equal with jsonSchema "unsuccessfull-delete-room.json"

 #  --------GET ROOM BY USER CREATE-----------
  @get-rooms @positive @login-1
  Scenario: Get all rooms by user create
    When I send GET request rooms
    Then response status code should be 200
    And response body should be equal with jsonSchema "success-get-rooms-by user.json"