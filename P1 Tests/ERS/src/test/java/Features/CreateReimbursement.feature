Feature: Create Reimbursement

  Background:
      Given The employee logs in
      Given The employee should be on Main Menu page

    Scenario: The employee makes new a reimbursement request
      When The employee clicks on New Reimbursement
      When The employee fills out the reimbursement form
      When the employee clicks on Submit
      Then The employee is back on the Main Menu
      And see their current request


