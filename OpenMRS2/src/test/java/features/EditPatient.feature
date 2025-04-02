Feature: Edit Patient Information

  Scenario: Update family name for a registered patient
    Given the user is on the patient details page
    When they click on Edit Registration Information
    And they update the family name to "Smith"
    And they navigate through demographic steps
    Then the patient details should be updated successfully
