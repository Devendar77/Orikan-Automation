Feature: Registration Form Validation

 # Scenario for Successful Registration
 @smokeTest
  Scenario: Successful registration with valid details
    Given the user is on the registration page
    When the user enters a valid email
    And the user enters a valid password
    And the user enters confirm password correctly
    And the user submits the registration form
    Then user should move to the contact page 

    
    # Scenario for Error Message Validation on Registration Page
    @smokeTest
   Scenario: Verify error messages for required fields
    Given user is on the registration page
    When user click on the Next button without entering any details
    Then user should see the error message Email Address is required for the email field
    And user should see the error message Password is required for the password field
    And user should see the error message Confirm Password is required for the confirm password field
    