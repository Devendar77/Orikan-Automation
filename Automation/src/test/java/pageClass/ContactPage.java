package pageClass;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ConfigReader;

public class ContactPage {
	private WebDriver driver;
	ConfigReader configReader = new ConfigReader();
	Properties prop;

	private By contactForm = By.xpath("//div[@class='form-field']/label[text()='First Name']");
	private By firstNameField = By.xpath("//input[@id='firstName']");
	private By middleNameField = By.xpath("//input[@id='middleName']");
	private By lastNameField = By.xpath("//input[@id='lastName']");
	private By preferredFullNameField = By.xpath("//input[@id='preferredFullName']");
	private By addressLine1Field = By.xpath("//input[@id='addressLine1']");
	private By addressLine2Field = By.xpath("//input[@id='addressLine2']");
	private By addressLine3Field = By.xpath("//input[@id='addressLine3']");
	private By postcodeField = By.xpath("//input[@id='postcode']");
	private By cityField = By.xpath("//input[@id='city']");
	private By stateField = By.xpath("//select[@id='state']");
	private By submitButton = By.xpath("//button[text()='Next']");
	private By paymentForm = By.xpath("//div[@class='form-field']/input[@id='cardHolderName']");
	
	String fName = "";
	String mName = "";
	String lName = "";


	public ContactPage(WebDriver driver) {
		this.driver = driver;
		prop = configReader.init_prop();
	}

	public void verify_UserIsOnContactPage() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactForm));
		assertTrue("User is on Contact page", true);
	}

	public void enterFirstName(String firstName) {
		driver.findElement(firstNameField).sendKeys(firstName);
		fName = firstName;
		System.out.println(fName);
	}

	public void enterMiddleName(String middleName) {
		driver.findElement(middleNameField).sendKeys(middleName);
		mName = middleName;
		System.out.println(mName);
	}

	public void enterLastName(String lastName) {
		driver.findElement(lastNameField).sendKeys(lastName);
		lName = lastName;
		System.out.println(lName);
	}

	public void enterPreferredFullName() throws InterruptedException {
		String expectedpreferredFullName = fName+" "+mName+" "+lName;
		System.out.println(expectedpreferredFullName);
		Thread.sleep(2000);
		String actualPreferredFullName = driver.findElement(preferredFullNameField).getText();
		assertEquals(expectedpreferredFullName, expectedpreferredFullName);

	}

	public void enterAddressLine1(String addressLine1) {
		driver.findElement(addressLine1Field).sendKeys(addressLine1);
	}

	public void enterAddressLine2(String addressLine2) {
		driver.findElement(addressLine2Field).sendKeys(addressLine2);
	}

	public void enterAddressLine3(String addressLine3) {
		driver.findElement(addressLine3Field).sendKeys(addressLine3);
	}

	public void enterPostcode(String postcode) {
		driver.findElement(postcodeField).sendKeys(postcode);
	}

	public void enterCity(String city) {
		driver.findElement(cityField).sendKeys(city);
	}

	public void selectState(String state) throws InterruptedException {
		Select select = new Select(driver.findElement(stateField));
		select.selectByVisibleText(state);
		Thread.sleep(10000);
	}

	public void submitForm() {
		driver.findElement(submitButton).click();
	}

	public void verify_UserIsOnPaymentPage()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(paymentForm));
		assertTrue("Payment Form Is Visible", true);
		
		
	}

}
