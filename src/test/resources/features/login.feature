Feature:

Background:
  Given The user go to ZeroBank login page

  Scenario: valid credentials test
    When The user should input credentials userName: "username" and password "password"


  Scenario Outline: invalid credentials test
    Given The user go to ZeroBank login page
    When The user should input credentials userName: "<userName>" and password "<passWord>"
    Then The user verify that "<wrongMessage>"

    Examples:
      | userName | passWord | wrongMessage                     |
      |          | password | Login and/or password are wrong. |
      | username |          | Login and/or password are wrong. |
      |          |          | Login and/or password are wrong. |
      | userName | passWord | Login and/or password are wrong. |
      | userName | password | Login and/or password are wrong. |
      | username | passWord | Login and/or password are wrong. |

