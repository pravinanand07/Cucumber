#Author: your.email@your.domain.com
Feature: Creating a new customer

  Scenario: Add customer
    Given User launch the telecom site
    And User click on add customer button
    When User filling up all the details
    And User click on submit button
    Then User will be displayed with the customer ID generated

  Scenario: Add customer
    Given User launch the telecom site
    And User click on add customer button
    When User filling up all the details with one dim list
    |java|selenium|pr@gmail.com|Albuquerque|8939497464|
    And User click on submit button
    Then User will be displayed with the customer ID generated
 