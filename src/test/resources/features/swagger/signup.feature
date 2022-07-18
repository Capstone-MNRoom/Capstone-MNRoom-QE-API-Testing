@swagger
Feature: Signup


  @post-signup @positive
  Scenario: Signup successfully
    When user send POST signup request with body "success-signup.json"
    Then response status code should be 200
    And response body should be equal with jsonSchema "successfull-signup.json"

  @post-signup @negative
  Scenario: Signup with invalid email
    When user send POST signup request with body "signup-with-invalid-email.json"
    Then response status code should be 400
    And response body should be equal with jsonSchema "invalid-email-signup.json"

  @post-signup @negative
  Scenario: Signup with invalid password
    When user send POST signup request with body "signup-with-invalid-password.json"
    Then response status code should be 400
    And response body should be equal with jsonSchema "invalid-password-signup.json"

  @post-signup @negative
  Scenario: Signup with existing email
    When user send POST signup request with body "signup-with-existing-email.json"
    Then response status code should be 400
    And response body should be equal with jsonSchema "email-already-exist.json"

  @post-signup @negative
  Scenario: Signup with existing phone number
    When user send POST signup request with body "signup-with-existing-phone-number.json"
    Then response status code should be 400
    And response body should be equal with jsonSchema "phone-number-already-exist.json"
