Feature: Login to OpenMRS Application

  Scenario: Login with invalid credentials
    Given the user is on the OpenMRS login page
    When they enter username "wrongUser" and password "wrongPass"
    And they select the location and click login
    Then they should see an error message

  Scenario: Login with valid credentials
    Given the user is on the OpenMRS login page
    When they enter username "admin" and password "Admin123"
    And they select the location and click login
    Then they should be redirected to the home page
