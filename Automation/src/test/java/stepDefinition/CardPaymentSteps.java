package stepDefinition;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageClass.CardPaymentPage;
import utilities.DriverFactory;

public class CardPaymentSteps {
	
	private CardPaymentPage cardPaymentPage = new CardPaymentPage(DriverFactory.getDriver());
	
	@Given("the user is on the card payment page")
    public void the_user_is_on_the_card_payment_page() {
	
	}
	
	@When("the user enters {string} in the Card Holder Name field")
    public void the_user_enters_in_the_card_holder_name_field(String cardHolderName) {
        cardPaymentPage.enterCardHolderName(cardHolderName);
    }

    @When("the user selects {string} as the Card Type")
    public void the_user_selects_as_the_card_type(String cardType) {
        cardPaymentPage.selectCardType(cardType);
    }

    @When("the user enters {string} in the Card Number field")
    public void the_user_enters_in_the_card_number_field(String cardNumber) {
        cardPaymentPage.enterCardNumber(cardNumber);
    }

    @When("the user enters {string} in the Card CVV field")
    public void the_user_enters_in_the_card_cvv_field(String cardCVV) {
        cardPaymentPage.enterCardCVV(cardCVV);
    }

    @When("the user selects {string} as the Card Expiry Month")
    public void the_user_selects_as_the_card_expiry_month(String expiryMonth) {
        cardPaymentPage.selectExpiryMonth(expiryMonth);
    }

    @When("the user selects {string} as the Card Expiry Year")
    public void the_user_selects_as_the_card_expiry_year(String expiryYear) {
        cardPaymentPage.selectExpiryYear(expiryYear);
    }

    @When("the user submits the card payment form")
    public void the_user_submits_the_card_payment_form() {
        cardPaymentPage.submitForm();
    }

    @Then("the payment details should be saved successfully")
    public void the_payment_details_should_be_saved_successfully() {
    	cardPaymentPage.verifyPaymentDetails();
		/*
		 * String successMessage = cardPaymentPage.getSuccessMessage();
		 * Assert.assertEquals("Payment processed successfully!", successMessage);
		 */
    }
    
    //Terms and Condition Page Validation Steps
    
    @When("the user accepts the terms conditions")
    public void the_user_accepts_the_terms_conditions() throws InterruptedException {
    	cardPaymentPage.getTermsAndConditionsText();
    	cardPaymentPage.checkTermsAndConditions();
    }

    @When("the user submit the terms and conditions")
    public void the_user_submit_the_terms_and_conditions() {
       cardPaymentPage.submitForm();
    }

    @Then("the user regestration is successfully completed")
    public void the_user_regestration_is_successfully_completed() {
        cardPaymentPage.getSuccessMessage();
    }
}
