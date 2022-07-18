@swagger
Feature:Swagger API


  @post-login @positive
  Scenario: Login successfully
    When user send POST login request with body "success-login.json"
    Then response status code should be 200
    And response body should be equal with jsonSchema "successfull-login.json"

  @post-login @negative
  Scenario: Login with invalid email
    When user send POST login request with body "login-with-invalid-email.json"
    Then response status code should be 400
    And response body should be equal with jsonSchema "unsuccessfull-login.json"

  @post-login @negative
  Scenario: Login with invalid password
    When user send POST login request with body "login-with-invalid-password.json"
    Then response status code should be 400
    And response body should be equal with jsonSchema "unsuccessfull-login.json"

  @post-login @negative
  Scenario: Login with email only
    When user send POST login request with body "login-with-email-only.json"
    Then response status code should be 400
    And response body should be equal with jsonSchema "unsuccessfull-login.json"

  @post-login @negative
  Scenario: Login with password only
    When user send POST login request with body "login-with-password-only.json"
    Then response status code should be 400
    And response body should be equal with jsonSchema "unsuccessfull-login.json"
