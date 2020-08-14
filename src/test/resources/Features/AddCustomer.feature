#Author: your.email@your.domain.com
@regression
Feature: Creating a new customer

  Background: 
    And User click on add customer button

  Scenario: Add customer
    When User filling up all the details
    And User click on submit button
    Then User will be displayed with the customer ID generated

  @smoke @regression
  Scenario: Add customer with one d list
    When User filling up all the details with one dim list
      | java | selenium | pr@gmail.com | Albuquerque | 6549851234 |
    And User click on submit button
    Then User will be displayed with the customer ID generated

  Scenario: Add customer with one d map
    When User filling up all the details with one dim map
      | Fn  | Praveen      |
      | Ln  | Kumar        |
      | Ml  | pr@gmail.com |
      | Add | Delhi        |
      | Ph  |   9840145965 |
    And User click on submit button
    Then User will be displayed with the customer ID generated

  Scenario: Add customer with two d list
    When User filling up all the details with two dim list
      | java    | selenium | pr@gmail.com     | Albuquerque | 6549851234 |
      | Praveen | Kumar    | pravin@gmail.com | Mumbai      | 7586584581 |
      | Kavi    | Chax     | kavi@gmail.com   | Namakkal    | 6588563251 |
      | Madhu   | Mohan    | madhu@gmail.com  | Salem       | 8058126748 |
    And User click on submit button
    Then User will be displayed with the customer ID generated

  Scenario: Add customer with two d map
    When User filling up all the details with two dim map
      | Fn      | Ln       | Mail             | Addr        | Phn        |
      | java    | selenium | pr@gmail.com     | Albuquerque | 6549851234 |
      | Praveen | Kumar    | pravin@gmail.com | Mumbai      | 7586584581 |
      | Kavi    | Chax     | kavi@gmail.com   | Namakkal    | 6588563251 |
      | Madhu   | Mohan    | madhu@gmail.com  | Salem       | 8058126748 |
    And User click on submit button
    Then User will be displayed with the customer ID generated
