Feature: Taktik maktik yok Bam Bam Bam
@wip6
  Scenario Outline: The user should NOT able to complete pay operation with invalid credentials
    Given The user go to ZeroBank login page
    When The user should input credentials userName: "username" and password "password"
    And The user click to "Pay Bills" tab
    When The user select payee by text "Apple" and account by index "4"
    And The user input amount "<amount>"
    When The user input date "<date>"
    And The user click pay button
    Then The user should be able to see payment message: "<message>"


    Examples:
      | amount | date       | message                   |
      |        | 2023-06-10 | Lütfen bu alanı doldurun. |
      | 777    |            | Lütfen bu alanı doldurun. |