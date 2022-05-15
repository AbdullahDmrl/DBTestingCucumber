Feature: Testing JDBC States

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully

    @Regression
   Scenario: States Database Check
     And Navigate to states page
      When Create states table and insert values with jdbc
     When Select country "United States of America" and show its states
     Then Check Database and UI results match


