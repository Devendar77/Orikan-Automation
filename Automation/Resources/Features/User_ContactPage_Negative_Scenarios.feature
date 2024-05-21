Feature: Contact Page Negative Scenarios Validation

  Background: 
    Given the user is on the registration page
    When the user enters a valid email
    And the user enters a valid password
    And the user enters confirm password correctly
    And the user submits the registration form
    Then user should move to the contact page
    
@smokeTest
  Scenario Outline: Validate Negative Scenarios on User Contact page
    Given the user is on the contact page
    When the user enters "<first_name>" in the First Name field
    And the user enters "<middle_name>" in the Middle Name field
    And the user enters "<last_name>" in the Last Name field
    And the user enters preferred_full_name in the Preferred Full Name field
    And the user enters "<address_line_1>" in the Address Line 1 field
    And the user enters "<address_line_2>" in the Address Line 2 field
    And the user enters "<address_line_3>" in the Address Line 3 field
    And the user enters "<postcode>" in the Postcode field
    And the user enters "<city>" in the City field
    And the user enters "<state>" in the State field
    And the user submits the contact form
    Then the user should see an error message "<error_message>"

    Examples: 
      | first_name | middle_name | last_name | preferred_full_name | address_line_1 | address_line_2 | address_line_3 | postcode | city     | state           | error_message              |
      |            | Smith       | Doe       | John Smith Doe      | 123 Main St    |                |                |    12345 | New York | New South Wales | First Name is required     |
      | John       | Smith       |           | John Smith Doe      | 123 Main St    |                |                |    12345 | New York | New South Wales | Last Name is required      |
      | John       | Smith       | Doe       | John Smith Doe      |                |                |                |    12345 | New York | New South Wales | Address Line 1 is required |
      | John       | Smith       | Doe       | John Smith Doe      | 123 Main St    |                |                |          | New York | New South Wales | Postcode is required       |
      | John       | Smith       | Doe       | John Smith Doe      | 123 Main St    |                |                |    12345 |          | New South Wales | City is required           |
      | John       | Smith       | Doe       | John Smith Doe      | 123 Main St    |                |                |    12345 | New York |                 | State is required          |
      | John       | Smith       | Doe       | John Smith Doe      | 123 Main St    | Apt 4B         |                | ABCDE    | New York | New South Wales | Postcode must be numeric   |
