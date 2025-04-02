Feature: Register a New Patient

  Scenario: Successful patient registration
    Given the user is logged into OpenMRS
    When they navigate to the Register Patient page
    And they enter "John" as the given name and "Doe" as the family name
    And they select "Male" as gender and enter birthdate "10 March 1995"
    And they provide address "123 Main Street" and phone number "9876543210"
    And they submit the registration form
    Then the patient should be successfully registered
