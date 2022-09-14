@runRestAPITest
Feature: Lely Rest Services Case Study


  @case1
  Scenario: List users
    Given Send GET request to list all users
    Then Check all users with proper digits


  @case2
  Scenario Outline: Create user
    And Send POST request to add a <New user> with expected code 201
    Then Check new <New user> is created correctly

    Examples:
      | New user |
      | USER-1   |


  @case3
  Scenario Outline: Check created user
    And Send POST request to add a <Old user> with expected code 422
    Then Check the response has already been taken

    Examples:
      | Old user |
      | USER-1   |
