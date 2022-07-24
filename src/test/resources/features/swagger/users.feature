@swagger
Feature: Users


  #  -----------GET USERS------------
  @get-users @positive @login-3
  Scenario: Success GET all users
    When user send GET request users
    Then response status code should be 200
    And response body should be equal with jsonSchema "get-all-users.json"

  @get-users @positive @login-3
  Scenario: Success GET user profile
    When user send GET request user profile
    Then response status code should be 200
    And response body should be equal with jsonSchema "get-users-profile.json"


  #  -----------UPDATE USERS------------

  @put-update-user @positive @login-3
  Scenario: PUT update user without image profile
    When user send PUT update request with "username" is "yasin", "password" is "yasin123", "address" is "Jl.Merpati no.14"
    Then response status code should be 200
    And response body should be equal with jsonSchema "success-update-user.json"

  @put-update-user @positive @login-4
  Scenario: Success PUT update user with image profile
    When user send PUT update request with "image" is "user-image-2.png", "username" is "muhnuryasin", "password" is "yasin123456", "address" is "Jl.Merpati no.13"
    Then response status code should be 200
    And response body should be equal with jsonSchema "success-update-user.json"

  @put-update-user @positive @login-3
  Scenario: PUT update user username only
    When user send PUT update request username only with "username" is "yasin"
    Then response status code should be 200
    And response body should be equal with jsonSchema "success-update-user.json"
  
  @put-update-user @positive @login-3
  Scenario: PUT update user image only
    When user send PUT update request image only with "image" is "user-image-3.png"
    Then response status code should be 200
    And response body should be equal with jsonSchema "success-update-user.json"

  @put-update-user @positive @login-3
  Scenario: PUT update user password only
    When user send PUT update request password only with "password" is "yasin123"
    Then response status code should be 200
    And response body should be equal with jsonSchema "success-update-user.json"

  @put-update-user @positive @login-4
  Scenario: PUT update user image and username only
    When user send PUT update request image and username only with "image" is "user-image-2.png", "username" is "muhnuryasin"
    Then response status code should be 200
    And response body should be equal with jsonSchema "success-update-user.json"

  @put-update-user @positive @login-4
  Scenario: PUT update user username and password only
    When user send PUT update request username and password only with "username" is "yasin", "password" is "yasin123456"
    Then response status code should be 200
    And response body should be equal with jsonSchema "success-update-user.json"

  @put-update-user @positive @login-3
  Scenario: PUT update user image and password only
    When user send PUT update request image and password only with "image" is "user-image-3.png", "password" is "yasin123"
    Then response status code should be 200
    And response body should be equal with jsonSchema "success-update-user.json"

  @put-update-user @negative @login-4
  Scenario: PUT update username with less than minimum allowed character
    When user send PUT update request username with "username" is "ya"
    Then response status code should be 400
    And response body should be equal with jsonSchema "update-username-invalid.json"

  @put-update-user @negative @login-4
  Scenario: PUT update username with not alphabet
    When user send PUT update request username with "username" is "111$$$$"
    Then response status code should be 400
    And response body should be equal with jsonSchema "update-username-invalid.json"

  @put-update-user @negative @login-4
  Scenario: PUT update password with less than minimum allowed character
    When user send PUT update request password with "password" is "test1"
    Then response status code should be 400
    And response body should be equal with jsonSchema "update-password-invalid.json"


  #  -----------DELETE USERS------------

  @delete-user @positive @login-4
  Scenario: Success DEL delete user
    When user send DEL request to delete user
    Then response status code should be 200
    And response body should be equal with jsonSchema "success-delete-user.json"









