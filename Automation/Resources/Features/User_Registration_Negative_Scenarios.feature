Feature: Registration Page Negative Test Cases Validation


  #Scenario for Negative test case validation on Registration page
  @smokeTest
  Scenario Outline: User enters invalid registration details
    Given the user is on the registration page
    When the user enters "<email>" in the email field
    And the user enters "<password>" in the password field
    And the user enters "<confirm_password>" in the confirmation password field
    And the user submits the registration form
    Then the user should see an error message "<error_message>"

    Examples: 
      | email             | password          | confirm_password      | error_message                                                                                                    |
      | invalidemail.com  | ValidPassword123! | ValidPassword123!     | Invalid email address.                                                                                           |
      |                   | ValidPassword123! | ValidPassword123!     | Email Address is required                                                                                        |
      | user@example.com  | 123               | 123                   | Password must be at least 8 characters                                                                           |
      | user@example1.com | password          | password              | Password must include at least one uppercase letter, one lowercase letter, one number, and one special character |
      | user@example2.com | ValidPassword123! | DifferentPassword123! | Passwords do not mach                                                                                            |
      | user@example.com  |                   | ValidPassword123!     | Password is required.                                                                                            |
      | user@example.com  | ValidPassword123! |                       | Confirm Password is required                                                                                     |
