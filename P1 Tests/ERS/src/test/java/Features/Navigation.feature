Feature: Navigation


  Background: Logged in as a Manager
    Given The Manager is logged in as a manager
    Given The Manager is on the home page


  Scenario: Manager can click on edit
    When The Manager clicks on edit on one of the current requests
    Then The title of the page should be Active Requests