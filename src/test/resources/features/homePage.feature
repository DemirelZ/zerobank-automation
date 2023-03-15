Feature:Home Page

@wip
  Scenario: see titles of account summary
    Given The user go to ZeroBank login page
    When The user should input credentials userName: "username" and password "password"
    And The user click to "Account Summary" tab
    Then The user should see subtitles
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |
    Then The user should see titles of Credit Accounts
      | Account     |
      | Credit Card |
      | Balance     |

@wip
  Scenario: account types of account activity
    Given The user go to ZeroBank login page
    When The user should input credentials userName: "username" and password "password"
    And The user click to "Account Activity" tab
    Then The user should see type of account select menu
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |



@wip5
  Scenario: pay bills
    Given The user go to ZeroBank login page
    When The user should input credentials userName: "username" and password "password"
    And The user click to "Pay Bills" tab
    When The user select payee by text "Apple" and account by index "4"
    And The user input amount "77.77"
    When The user input date "2023/01/30"
    And The user click pay button
    Then The user should be able to see payment message: "The payment was successfully submitted."

  @wip
  Scenario: Add a new payee
  Given The user go to ZeroBank login page
    When The user should input credentials userName: "username" and password "password"
    And The user click to "Pay Bills" tab
    And User should navigate to Add New Payee
    And User should create new payee using following information

      | Payee Name    | The Law Offices of Hyde, Price & Scharks |
      | Payee Address | 100 Same st, Anytown, USA, 10001         |
      | Account       | Checking                                 |
      | Payee details | XYZ account                              |

Then "The new payee The Law Offices of Hyde, Price & Scharks was successfully created." should see
