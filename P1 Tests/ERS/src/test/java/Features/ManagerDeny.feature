Feature: Manager Deny

  Background:
    Given The Manager is on the login page
    Given The Manager logs in

    Scenario: Manager denies Reimbursement
      When The Manager clicks on edit on one of the current requests
      When The Manager clicks Deny
      And an alert pops up
      Then The Manager is on the home page