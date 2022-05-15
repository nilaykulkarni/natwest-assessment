Feature: prime numbers can be retrieved
  Scenario: client makes call to POST /prime
    When the client calls /prime
    Then the client receives status code of 200
    And the client receives prime numbers

  Scenario: client makes call with POST /prime with invalid input
    when the client calls /prime with invalid input
    Then the client receives error code of 400