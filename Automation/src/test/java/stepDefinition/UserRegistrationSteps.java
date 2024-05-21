package stepDefinition;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageClass.RegistrationPage;
import utilities.DriverFactory;

public class UserRegistrationSteps {

	private RegistrationPage registrationPage = new RegistrationPage(DriverFactory.getDriver());

	@Given("the user is on the registration page")
	public void the_user_is_on_the_registration_page() {
		registrationPage.validateTitle();
	}

	@When("the user enters a valid email")
	public void the_user_enters_a_valid_email() {
		registrationPage.enterEmail();
	}

	@When("the user enters a valid password")
	public void the_user_enters_a_valid_password() {
		registrationPage.enterPassword();
	}

	@When("the user enters confirm password correctly")
	public void the_user_enters_confirm_password_correctly() {
		registrationPage.enterConfirmPassword();
	}

	@When("the user submits the registration form")
	public void the_user_submits_the_registration_form() {
		registrationPage.clickOnNextButton();
	}

	@Then("user should move to the contact page")
	public void user_should_move_to_the_contact_page() {
		registrationPage.verifyUserEmailAvailableForVerification();
	}

	// Email, Password, Confirm Password- Error message validation on Registration
	// Page

	@Given("user is on the registration page")
	public void user_is_on_the_registration_page() {
		registrationPage.validateTitle();
	}

	@When("user click on the Next button without entering any details")
	public void user_click_on_the_button_without_entering_any_details() {
		registrationPage.clickOnNextButton();
	}

	@Then("user should see the error message Email Address is required for the email field")
	public void user_should_see_the_error_message_email_address_is_required_for_the_email_field() {
		registrationPage.verifyEmailErrorMsg();
	}

	@Then("user should see the error message Password is required for the password field")
	public void user_should_see_the_error_message_password_is_required_for_the_password_field() {
		registrationPage.verifyPasswordErrorMsg();
	}

	@Then("user should see the error message Confirm Password is required for the confirm password field")
	public void user_should_see_the_error_message_confirm_password_is_required_for_the_confirm_password_field() {
		registrationPage.verifyConfirmPasswordErrorMsg();
	}

	@When("the user enters {string} in the email field")
	public void the_user_enters_in_the_email_field(String email) {
		registrationPage.enterEmail(email);
	}

	@When("the user enters {string} in the password field")
	public void the_user_enters_in_the_password_field(String password) {
		registrationPage.enterPassword(password);
	}

	@When("the user enters {string} in the confirmation password field")
	public void the_user_enters_in_the_confirmation_password_field(String confirmPassword) {
		registrationPage.enterConfirmPassword(confirmPassword);
	}

	@Then("the user should see an error message {string}")
	public void the_user_should_see_an_error_message(String expectedErrorMessage) {
		 String actualErrorMessage = registrationPage.getErrorMessage();
		 assertEquals(expectedErrorMessage, actualErrorMessage);
		 
	}

}
