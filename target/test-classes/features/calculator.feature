@tag
Feature: Calculator

  Scenario: calculate square root of a divided by b
    Given Two input values, 4 and 1
    When I calculate the square root of 4 divided by 1
    Then I expect the result 2

  Scenario: calculate square root of a divided by b
    Given Two input values, 36 and 4
    When I calculate the square root of 36 divided by 4
    Then I expect the result 3


  Scenario Outline: calculate square root of a divided by b
    Given Two input values, <first> and <second>
    When I calculate the square root of <first> divided by <second>
    Then I expect the result <result>

    Examples:
      | first | second | result    |
      | 4     | 1      | 2       |
      | 36    | 4      | 3       |
      | -9    | 3      | error     |
      | 9     | -3     | error     |
      | -27    | -3     | 3     |
      | 100   | 10     | 3.16227     |
      | 1     | 0      | error     |
      | 0     | 0      | error     |
      | 0     | 1      | 0.0       |
