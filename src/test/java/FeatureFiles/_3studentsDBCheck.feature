Feature: Testing JDBC States

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully

    @Regression
   Scenario: States Database Check
     And Navigate to students page
     When Create MySQL students table and insert values by jdbc
     When Select "Active" status and "2" grade level then search students
     Then Check database data match with UI results data


