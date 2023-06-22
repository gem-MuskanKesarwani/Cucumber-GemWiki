Feature: Login Page

  Scenario: Texts validation on login page
    Given User is on the login page
    Then Validate all the texts are displayed

  Scenario:login testing
    Given User is on the login page
    When  User clicks on azure directory
    Then  Validate user has logged in

