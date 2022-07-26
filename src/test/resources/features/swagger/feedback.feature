@swagger
Feature: Feedback

    #  -----------POST FEEDBACK------------

    @post-feedback @positive @login-1
    Scenario: Success create feedback by id room
      When user send POST feedback request with body "create-feedback-by-id-room.json" and id room 83
      Then response status code should be 200
      And response body should be equal with jsonSchema "success-create-feedback.json"

    @post-feedback @negative @login-1
    Scenario: Create feedback with invalid id rent
      When user send POST feedback request with body "feedback-invalid-id.json" and id room 83
      Then response status code should be 400
      And response body should be equal with jsonSchema "unsuccessfull-create-feedback.json"

    @post-feedback @negative @login-1
    Scenario: Create feedback with invalid rating
      When user send POST feedback request with body "feedback-invalid-rating.json" and id room 83
      Then response status code should be 400
      And response body should be equal with jsonSchema "unsuccessfull-create-feedback.json"

    #  -----------GET FEEDBACK------------
    @get-feedback @positive @login-1
    Scenario: Success get feedback by id room
      When user send GET feedback request with id room 83
      Then response status code should be 200
      And response body should be equal with jsonSchema "get-feedback-successfull.json"

    @get-feedback @negative @login-1
    Scenario: Get feedback by id room as string
      When user send GET feedback request with id room "delapan"
      Then response status code should be 400
      And response body should be equal with jsonSchema "get-feedback-unsuccessfull.json"

    @get-feedback @negative @login-1
    Scenario: Get feedback by id room as special character
      When user send GET feedback request with id room "@@@"
      Then response status code should be 400
      And response body should be equal with jsonSchema "get-feedback-unsuccessfull.json"

    @get-feedback @negative @login-1
    Scenario: Get feedback by id room doesnt exist
      When user send GET feedback request with id room 1000000
      Then response status code should be 400
      And response body should be equal with jsonSchema "get-feedback-unsuccessfull.json"


