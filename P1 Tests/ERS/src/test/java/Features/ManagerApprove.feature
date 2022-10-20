 Feature: Manager Approval

   Background:
     Given The Manager is on the login page
     Given The Manager logs in


     Scenario: Manager approves Reimbursement
       When The Manager clicks on edit on one of the current requests
       When The Manager clicks on Calculate
       And sees the refund amount
       When The Manager clicks on Approve
       Then The Manager is on the home page