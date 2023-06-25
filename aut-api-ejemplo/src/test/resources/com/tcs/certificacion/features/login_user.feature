Feature: Login user


  Scenario Outline: Login user with valid credentials
#    Given I can query the reqres.in api
    When I login with credentials with data
      | email   | password   |
      | <email> | <password> |
    Then The service answers me status code <statusCode>
    And I get a token

    Examples:
      | email                  | password   | statusCode |
      | eve.holt@reqres.in     | cityslicka | 200        |
      | george.bluth@reqres.in | cityslicka | 200        |
      | janet.weaver@reqres.in | cityslicka | 200        |
      | emma.wong@reqres.in    | cityslicka | 200        |


  Scenario Outline: Login user with invalid credentials
#    Given I can query the reqres.in api
    When I login with credentials with data
      | email   | password   |
      | <email> | <password> |
    Then The service answers me status code <statusCode>
    And I get a token

    Examples:
      | email                  | password   | statusCode |
      | juan@gmail.com         | juan       | 400        |
      | pedro@outlook.com      | pedro      | 400        |
      | emmawong@reqres.in     | cityslicka | 400        |
      |                        |            | 400        |
      | george.bluth@reqres.in |            | 400        |
