@swagger
Feature: Payment

  #  -----------POST PAYMENT------------

  @post-payment @positive @login-1
  Scenario: Success create payment
    When user send POST payment request with body "success-payment.json"
    Then response status code should be 200
    And response body should be equal with jsonSchema "payment-successfull.json"

  @post-payment @negative @login-1
  Scenario: Create payment with invalid order id
    When user send POST payment request with body "payment-invalid-order-id.json"
    Then response status code should be 200
    And response body should be equal with jsonSchema "payment-unsuccessfull.json"


  #  -----------GET PAYMENT------------
  @get-payment @positive @login-1
  Scenario: Get all payment
    When user send GET request payment
    Then response status code should be 200
    And response body should be equal with jsonSchema "get-payment-successfull.json"

  @get-payment @negative
  Scenario: Get payment without login
    When user send GET request payment without login
    Then response status code should be 401
    And response body should be equal with jsonSchema "get-payment-unsuccessfull.json"