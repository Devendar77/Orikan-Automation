package stepDefinition;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageClass.ContactPage;
import utilities.DriverFactory;

public class UserContactCreationSteps {
	
	private ContactPage contactPage = new ContactPage(DriverFactory.getDriver());
	
	
	@When("the user is on the contact page")
	public void the_user_is_on_the_contact_page() {
		
	}
	
	@When("the user enters {string} in the First Name field")
    public void the_user_enters_in_the_first_name_field(String firstName) {
        contactPage.enterFirstName(firstName);
    }

    @When("the user enters {string} in the Middle Name field")
    public void the_user_enters_in_the_middle_name_field(String middleName) {
        contactPage.enterMiddleName(middleName);
    }

    @When("the user enters {string} in the Last Name field")
    public void the_user_enters_in_the_last_name_field(String lastName) {
        contactPage.enterLastName(lastName);
    }

    @When("the user enters preferred_full_name in the Preferred Full Name field")
    public void the_user_enters_preferred_full_name_in_the_preferred_full_name_field() throws InterruptedException {
        contactPage.enterPreferredFullName();
    }

    @When("the user enters {string} in the Address Line 1 field")
    public void the_user_enters_in_the_address_line_1_field(String addressLine1) {
        contactPage.enterAddressLine1(addressLine1);
    }

    @When("the user enters {string} in the Address Line 2 field")
    public void the_user_enters_in_the_address_line_2_field(String addressLine2) {
        contactPage.enterAddressLine2(addressLine2);
    }

    @When("the user enters {string} in the Address Line 3 field")
    public void the_user_enters_in_the_address_line_3_field(String addressLine3) {
        contactPage.enterAddressLine3(addressLine3);
    }

    @When("the user enters {string} in the Postcode field")
    public void the_user_enters_in_the_postcode_field(String postcode) {
        contactPage.enterPostcode(postcode);
    }

    @When("the user enters {string} in the City field")
    public void the_user_enters_in_the_city_field(String city) {
        contactPage.enterCity(city);
    }

    @When("the user enters {string} in the State field")
    public void the_user_enters_in_the_state_field(String state) throws InterruptedException {
        contactPage.selectState(state);
    }

    @When("the user submits the contact form")
    public void the_user_submits_the_contact_form() {
        contactPage.submitForm();
    }

    @Then("the user should see the Payment page")
    public void the_user_should_see_the_payment_page() { 
        contactPage.verify_UserIsOnPaymentPage();
       
    }

}
