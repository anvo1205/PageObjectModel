package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import data.Constants;
import utils.Utils;

public class SignUpPage{
	
	private WebDriver driver;
	private String fName;
	private String lName;
	private String email;
	private String password;
	
//	 Utils utl = new Utils(this.driver);
	
	@FindBy (id = "user_first_name")
	WebElement txt_FistName;
	
	@FindBy (id = "user_last_name")
	WebElement txt_LastName;
	
	@FindBy (id = "user_email")
	WebElement txt_Email;
	
	@FindBy (id = "user_password")
	WebElement txt_Password;
	
	@FindBy (id = "btn_register")
	WebElement btn_Register;
	
	@FindBy (id = "facebook")
	WebElement btn_Facebook;
	
	@FindBy (id = "email")
	WebElement txt_FbEmail;
	
	@FindBy (id = "password")
	WebElement txt_FbPassword;
	
	@FindBy (id = "loginbutton")
	WebElement btn_FbLogin;
	
	@FindBy (id = "google")
	WebElement btn_Google;
	
	@FindBy (id = "identifierId")
	WebElement txt_GMail;
	
	@FindBy (id = "identifierNext")
	WebElement btn_GMailNext;
	
	@FindBy (xpath = "//div[@id='password']//input\"")
	WebElement txt_GPassword;
	
	@FindBy (id = "passwordNext")
	WebElement btn_GPassNext;
	
	@FindBy (xpath = "//a[@href='/']")
	WebElement lnk_Login;
	
	// Initializing the Page Objects:
	public SignUpPage(WebDriver d) {
		this.driver = d;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(this.driver, (int) Constants.IMPLICIT_WAIT);
		PageFactory.initElements(factory, this);
	}
	
	//Constructor to assign values
	public SignUpPage(WebDriver d, String userEmail) {
		this.driver = d;
		this.fName = "Automation";
		this.lName = "Test";
		this.email = userEmail;
		this.password = "123456";
		
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, (int) Constants.IMPLICIT_WAIT);
		PageFactory.initElements(factory, this);
	}
	
	public String getFirstName ()
	{
		return this.fName;
	}
	public String getLastName ()
	{
		return this.lName;
	}
	public String getEmail ()
	{
		return this.email;
	}
	public String getPassword ()
	{
		return this.password;
	}
	
	public void setFirtName(String fName)
	{
		this.fName = fName;
	}
	
	public void setLastName(String lName)
	{
		this.lName = lName;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public void setPassword(String pass)
	{
		this.password = pass;
	}
	
	/* Method name	: Register
	 * Description	: This method will input register information into Sign Up page 
	 * Accept		: void
	 * Return		: void
	 */	
	public void Register() throws InterruptedException
	{
		Utils.inputValueIntoTextbox(this.driver, txt_FistName, this.fName);
		Utils.inputValueIntoTextbox(this.driver, txt_LastName ,this.lName);
		Utils.inputValueIntoTextbox(this.driver, txt_Email, this.email);
		Utils.inputValueIntoTextbox(this.driver, txt_Password, this.password);
		Utils.clickElement(this.driver, btn_Register);
		Thread.sleep(2000);
	}
	
	public void SignUpUsingFb() throws InterruptedException
	{
		Utils.clickElement(this.driver, btn_Facebook);
		Utils.inputValueIntoTextbox(this.driver, txt_FbEmail, email);
		Utils.inputValueIntoTextbox(this.driver, txt_FbPassword, password);
		Utils.clickElement(this.driver, btn_FbLogin);
		Thread.sleep(2000);
	}
	
	public void SignUpUsingGoogle() throws InterruptedException
	{
		Utils.clickElement(this.driver, btn_Google);
		Utils.inputValueIntoTextbox(this.driver, txt_GMail, email);
		Utils.clickElement(this.driver, btn_GMailNext);
		Utils.inputValueIntoTextbox(this.driver, txt_GPassword, password);
		Utils.clickElement(this.driver, btn_GPassNext);
		Thread.sleep(2000);
	}	

}
