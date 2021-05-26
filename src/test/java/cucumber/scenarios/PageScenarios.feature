@PageModel
Feature: Test Page Endpoint

  Scenario: REST API should return existing page by id
    Given page id is 5
    When I try to get page by id
    Then I receive status code 200
    And I receive page with id 5

  Scenario: REST API should create new page
    Given page with next data:
      | createdAt | name    | pageUrl    |
      | 2016-10-05T08:20:10+05:30[Asia/Kolkata]     | test | huh |
    When I try to create new page
    Then I receive status code 201
    And I receive page with id 69

  Scenario: REST API should modify existing page
    Given page with next data:
      | id | createdAt | title    | body    |
      | 11  | 2016-10-05T08:20:10+05:30[Asia/Kolkata]      | test | huh |
    When I try to modify page
    Then I receive status code 200
    And I receive page with id 11

  Scenario: REST API should delete existing page
    Given page id is 2
    When I try to delete page
    Then I receive status code 200