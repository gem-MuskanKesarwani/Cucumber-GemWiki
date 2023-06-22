
Feature: Home Page Testing

     Scenario:Log in
     Given User is on the login page
     When  User clicks on azure directory
     Then  Validate user has logged in

    Scenario: Text Validation
    Given User is logged in
    Then Validate title is being displayed
    And  Validate Welcome message is displayed

    Scenario Outline: Search Box automation
    Given User is logged in
    Then Validate label for search box is being displayed
    When User clicks on search box
    And Types "<text>"
    Then Validate result header is being displayed
    And Validate result containers are displayed
    And Validate language is displayed
    And Validate close button is displayed
    Examples:
    |text|
    |QA  |


    Scenario Outline: Search box invalid input
    Given User is logged in
    When User sends "<invalid text>"
    Then Validate result header is not displayed
    And No result image is displayed
    And Validate close button is displayed
    And Message is displayed
    And Click on close button
    Then Verify result page is closed

    Examples:
    |invalid text|
    |mkk         |
