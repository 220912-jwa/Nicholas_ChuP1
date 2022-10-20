Feature: Login

  Scenario Outline: Login with correct credentials
    Given The employee is on the login page
    When  The employee types "<username>" into username input
    When The employee types "<password>" into password input
    When The employee clicks on the login button
    Then The employee should be on Main Menu page
    Then The employee should see their "<fname>" on the home page

    Examples:
      | username | password | fname |
      | iWearFullRune    | passpass | Daryl |
      | lyndon9   | pass123 | Lyndon  |
      | MrCurry | passpass123 | Suki  |


  Scenario: Login as a Manager
      Given The Manager is on the login page
      When The Manager logs in
      Then The Manager should be on the Home page and see edit buttons

  Scenario: Login Correct Username Wrong Password
      Given The employee is on the login page
      When The employee types in lyndon9 into the username input
      When The employee types in passpass into the password input
      When The employee clicks on the login button
      Then The employee should see an alert saying they have the wrong password