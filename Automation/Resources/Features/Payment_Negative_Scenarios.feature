Feature: Verify Card Payment Negative Scenarios

  Background: 
    Given the user is on the registration page
    When the user enters a valid email
    And the user enters a valid password
    And the user enters confirm password correctly
    And the user submits the registration form
    Then user should move to the contact page

@smokeTest
  Scenario Outline: User enters invalid card payment details
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
    Then the user should see the Payment page
    When the user is on the card payment page
    And the user enters "<card_holder_name>" in the Card Holder Name field
    And the user selects "<card_type>" as the Card Type
    And the user enters "<card_number>" in the Card Number field
    And the user enters "<card_cvv>" in the Card CVV field
    And the user selects "<expiry_month>" as the Card Expiry Month
    And the user selects "<expiry_year>" as the Card Expiry Year
    And the user submits the card payment form
    Then the user should see an error message "<error_message>"

    Examples: 
      | first_name | middle_name | last_name | address_line_1 | address_line_2 | address_line_3 | postcode | city     | state           | success_message                             | card_holder_name | card_type | card_number      | card_cvv | expiry_month | expiry_year | error_message                 |
      | Test       | autoamtion  | Orikan    | 123 Main St    | 4th Road       | New NY         |    12345 | New York | New South Wales | Your Contact Details are saved successfully |                  | VISA      | 4111111111111111 |      123 | April        |        2025 | Cardholder Name is required   |
      | Test       | autoamtion  | Orikan    | 123 Main St    | 4th Road       | New NY         |    12345 | New York | New South Wales | Your Contact Details are saved successfully | User1            |           | 4111111111111111 |      123 | February     |        2025 | Card Type is required         |
      | Test       | autoamtion  | Orikan    | 123 Main St    | 4th Road       | New NY         |    12345 | New York | New South Wales | Your Contact Details are saved successfully | User1            | VISA      |                  |      123 | April        |        2025 | Card Number is required       |
      | Test       | autoamtion  | Orikan    | 123 Main St    | 4th Road       | New NY         |    12345 | New York | New South Wales | Your Contact Details are saved successfully | User1            | VISA      | 4111111111111111 |          | August       |        2025 | Card CVV is required          |
      | Test       | autoamtion  | Orikan    | 123 Main St    | 4th Road       | New NY         |    12345 | New York | New South Wales | Your Contact Details are saved successfully | User1            | VISA      | 4111111111111111 |      123 |              |        2025 | Card Expiry Month is required |
      | Test       | autoamtion  | Orikan    | 123 Main St    | 4th Road       | New NY         |    12345 | New York | New South Wales | Your Contact Details are saved successfully | User1            | VISA      | 4111111111111111 |      123 | April        |             | Card Expiry Year is required  |
      | Test       | autoamtion  | Orikan    | 123 Main St    | 4th Road       | New NY         |    12345 | New York | New South Wales | Your Contact Details are saved successfully | User1            | VISA      |             7896 |      123 | May          |        2025 | Card Number is invalid        |
      | Test       | autoamtion  | Orikan    | 123 Main St    | 4th Road       | New NY         |    12345 | New York | New South Wales | Your Contact Details are saved successfully | User1            | VISA      | 4111111111111111 |       12 | March        |        2025 | Card CVV is invalid           |
