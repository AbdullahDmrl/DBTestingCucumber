Feature: Testing Cities DB with JDBC in Cucumber

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully

  @Regression
  Scenario: Cities Database Check
    And  Navigate to cities page
    When Create MySQL cities table and insert values with jdbc
    When Select country "Sweden"
    Then Send Query and check both database/UI results match


