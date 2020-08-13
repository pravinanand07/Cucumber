#Author: your.email@your.domain.com
Feature: Tariff plan of the new customer

  Scenario: Tariff plan
    Given User launch the telecom site
    And User Click on Add Tariff Plan button
    When User filling up all the details of the tariff plan
    And User clicks the submit button
    Then User will be displayed with congratulation message

  Scenario: Tariff plan with 1d list
    Given User launch the telecom site
    And User Click on Add Tariff Plan button
    When User filling up all the details of the tariff plan with one dim list
      | 45 | 200 | 50 | 70 | 1 | 5 | 1 |
    And User clicks the submit button
    Then User will be displayed with congratulation message

  Scenario: Tariff plan with 1d map
    Given User launch the telecom site
    And User Click on Add Tariff Plan button
    When User filling up all the details of the tariff plan with one dim map
      | Rent | 100 |
      | Flm  | 150 |
      | Fim  | 200 |
      | Fsp  | 120 |
      | Lpm  |   1 |
      | Ipm  |   5 |
      | Spc  |   1 |
    And User clicks the submit button
    Then User will be displayed with congratulation message

  Scenario: Tariff plan with 2d list
    Given User launch the telecom site
    And User Click on Add Tariff Plan button
    When User filling up all the details of the tariff plan with two dim list
      |  80 | 100 | 120 | 150 | 2 |  7 | 3 |
      |  90 | 110 | 150 | 190 | 5 | 10 | 5 |
      |  70 | 160 | 105 | 200 | 4 |  4 | 2 |
      |  30 |  40 |  50 |  70 | 6 |  8 | 7 |
      | 120 | 145 | 110 | 180 | 6 | 10 | 4 |
    And User clicks the submit button
    Then User will be displayed with congratulation message

  Scenario: Tariff plan with 2d map
    Given User launch the telecom site
    And User Click on Add Tariff Plan button
    When User filling up all the details of the tariff plan with two dim map
      | Rent | Flm | Fim | Fsp | Lpm | Ipm | Spc |
      |   80 | 100 | 120 | 150 |   2 |   7 |   3 |
      |   90 | 110 | 150 | 190 |   5 |  10 |   5 |
      |   70 | 160 | 105 | 200 |   4 |   4 |   2 |
      |   30 |  40 |  50 |  70 |   6 |   8 |   7 |
      |  120 | 145 | 110 | 180 |   6 |  10 |   4 |
    And User clicks the submit button
    Then User will be displayed with congratulation message
