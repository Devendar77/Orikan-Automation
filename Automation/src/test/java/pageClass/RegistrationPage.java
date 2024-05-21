package pageClass;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ConfigReader;

public class RegistrationPage {

	private WebDriver driver;
	ConfigReader configReader = new ConfigReader();
	Properties prop;

	//Email, Password, Confirm password Field WebElements
	
	private By userRegistration_Form = By.xpath("//div[@class='form-field']/..");
	private By emailAddressField = By.xpath("//input[@id='emailAddress']");
	private By passwordField = By.xpath("//input[@id='password']");
	private By confirmPasswordField = By.xpath("//input[@id='confirmPassword']");
	private By RegistrationNextButton = By.xpath("//button[text()='Next']");
	private By emailAvailableForRegistartion_Msg = By.xpath("//div[text()='Email address is available for registration']");
	
	//Email, Password, Confirm password Error Message WebElements
	
	private By emailErrorMsg = By.xpath("//div[@class='validation error']/span[text()='Email Address is required']");
	private By passwordErrorMsg = By.xpath("//div[@class='validation error']/span[text()='Password is required.']");
	private By confirmPasswordErrorMsg = By.xpath("//div[@class='validation error']/span[text()='Confirm Password is required']");
	
	private By errorMessage = By.xpath("//div[@class='validation error']/span");
	

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		prop = configReader.init_prop();
	}

	public void validateTitle() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(userRegistration_Form));
		String expectedTitle = prop.getProperty("Orikan_url");
		String actualTitle = driver.getCurrentUrl();
		System.out.println(expectedTitle);
		System.out.println(actualTitle);
		assertEquals(expectedTitle, actualTitle);
	}

	public void enterEmail() {
		driver.findElement(emailAddressField).sendKeys(prop.getProperty("emailId"));
	}

	public void enterPassword()
	{
		driver.findElement(passwordField).sendKeys(prop.getProperty("password"));
	}
	
	public void enterConfirmPassword()
	{
		driver.findElement(confirmPasswordField).sendKeys(prop.getProperty("confirmPassword"));
	}
	
	public void clickOnNextButton()
	{
		driver.findElement(RegistrationNextButton).click();
	}
	
	public void verifyUserEmailAvailableForVerification()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailAvailableForRegistartion_Msg));
		String actual = driver.findElement(emailAvailableForRegistartion_Msg).getText().trim();
		String expected = "Email address is available for registration";
		assertEquals(actual,expected);

	}
	
	public void verifyEmailErrorMsg()
	{
		String actualEmailErrorMsg = driver.findElement(emailErrorMsg).getText();
		String expectedEmailErrorMsg = "Email Address is required";
		assertEquals(actualEmailErrorMsg,expectedEmailErrorMsg);
	}
	
	public void verifyPasswordErrorMsg()
	{
		String actualPasswordErrorMsg = driver.findElement(passwordErrorMsg).getText();
		String expectedPasswordErrorMsg = "Password is required.";
		assertEquals(actualPasswordErrorMsg,expectedPasswordErrorMsg);
	}
	
	public void verifyConfirmPasswordErrorMsg()
	{
		String actualEmailErrorMsg = driver.findElement(confirmPasswordErrorMsg).getText();
		String expectedEmailErrorMsg = "Confirm Password is required";
		assertEquals(actualEmailErrorMsg,expectedEmailErrorMsg);
	}
	
	public void enterEmail(String email) {
        driver.findElement(emailAddressField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
    }

    public void submitForm() {
        driver.findElement(RegistrationNextButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}


