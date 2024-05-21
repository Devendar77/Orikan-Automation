package pageClass;

import java.awt.Window;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import utilities.ConfigReader;

public class CardPaymentPage {
	private WebDriver driver;
	ConfigReader configReader = new ConfigReader();
	Properties prop;

	//Card Payment Elements
	private By cardHolderNameField = By.xpath("//input[@id='cardHolderName']");
    private By cardType = By.id("card_type");
    private By cardNumberField = By.xpath("//input[@id='cardNumber']");
    private By cardCVVField = By.xpath("//input[@id='cardCVV']");
    private By expiryMonthDropdown = By.xpath("//select[@id='cardExpiryMonth']");
    private By Card_expiryYear = By.xpath("//input[@id='cardExpiryYear']");
    private By submitButton = By.xpath("//button[text()='Next']");
    private By termsAndConditionsPage = By.xpath("//textarea[@id='termsAndConditions']");
    private By errorMessage = By.xpath("//div[@class='validation error']/span");
    
    //Terms and Conditions Page Elements
    
    private By termsAndConditionsText = By.xpath("//textarea[@id='termsAndConditions']");
    private By termsAndConditionsCheckbox = By.xpath("//input[@id='agreedToTerms']");
    private By successMessage = By.xpath("//p[contains(text(), 'Welcome')]");

	
	public CardPaymentPage(WebDriver driver) {
		this.driver = driver;
		prop = configReader.init_prop();
	}
	
	 public void enterCardHolderName(String cardHolderName) {
	        driver.findElement(cardHolderNameField).sendKeys(cardHolderName);
	    }

	    public void selectCardType(String cardType) {
	    	if(cardType.isEmpty())
	    	{
	    		driver.findElement(cardNumberField).click();
	    		System.out.println("Passing Card Type as Empty for Negative Testing Validation");
	    	}
	    	else
	    	{
	        WebElement selectCardType = driver.findElement(By.xpath("//input[@id='cardTypeVISA']/../label[text()='"+cardType+"']/../input"));
	       		selectCardType.click();
	    	}
	 
	    }

	    public void enterCardNumber(String cardNumber) {
	        driver.findElement(cardNumberField).sendKeys(cardNumber);
	    }

	    public void enterCardCVV(String cardCVV) {
	        driver.findElement(cardCVVField).sendKeys(cardCVV);
	    }

	    public void selectExpiryMonth(String expiryMonth) {
	        new Select(driver.findElement(expiryMonthDropdown)).selectByVisibleText(expiryMonth);
	    }

	    public void selectExpiryYear(String expiryYear) {
	        driver.findElement(Card_expiryYear).sendKeys(expiryYear);
	    }

	    public void submitForm() {
	        driver.findElement(submitButton).click();
	    }
	    
	    public void verifyPaymentDetails()
	    {
	    	WebDriverWait wait = new WebDriverWait(driver, 20);
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(termsAndConditionsPage));
	    	Assert.assertTrue("User is On terms and Conditions Page", true);
	    }

		/*
		 * public String getSuccessMessage() { return
		 * driver.findElement(successMessage).getText(); }
		 */
	    
	    public void getTermsAndConditionsText() throws InterruptedException {
	    	String atualtext =  driver.findElement(termsAndConditionsText).getText();
	    	System.out.println(atualtext);
	    	driver.findElement(termsAndConditionsText).click();
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("window.scrollBy(0,250)","");
	        Thread.sleep(3000);
	    }

	    public void checkTermsAndConditions() {
			
			  driver.findElement(termsAndConditionsCheckbox).isEnabled();
			  driver.findElement(termsAndConditionsCheckbox).click();
			 
	    }
		
		  public String getSuccessMessage() {
		  System.out.println(driver.findElement(successMessage).getText()); return
		  driver.findElement(successMessage).getText(); 
		  }
		 
	   

}
