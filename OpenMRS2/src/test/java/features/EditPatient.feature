Feature: Edit Patient Details

  Scenario: Update family name for a selected patient
    Given the user logs into OpenMRS
    And they navigate to Find Patient Record
    When they select a patient record
    And they click on Edit Registration Information
    And they update the family name to "Smith"
    And they navigate through demographic steps
    Then the patient details should be updated successfully
