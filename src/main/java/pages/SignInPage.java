package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import data.Constants;
import utils.Utils;

public class SignInPage{

	private WebDriver driver;
	private String email;
	private String password;
	
//	 Utils utl = new Utils(this.driver);
	
	@FindBy (id = "user_email")
	WebElement txt_Email;
	
	@FindBy (id = "user_password")
	WebElement txt_Password;
	
	@FindBy (id = "btn_login")
	WebElement btn_Login;
	
	@FindBy (xpath = "//a[@href='/register']")
	WebElement lnk_Register;
	
	// Initializing the Page Objects:
	public SignInPage(WebDriver d) {
		this.driver = d;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(this.driver, (int) Constants.IMPLICIT_WAIT);
		PageFactory.initElements(factory, this);
	}
	
	//Constructor to assign values
	public SignInPage(WebDriver d, String userEmail) {
		this.driver = d;
		this.email = userEmail;
		this.password = "123456";
		
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, (int) Constants.IMPLICIT_WAIT);
		PageFactory.initElements(factory, this);
	}
	
	public String getEmail ()
	{
		return this.email;
	}
	public String getPassword ()
	{
		return this.password;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public void setPassword(String pass)
	{
		this.password = pass;
	}
	
	public void SignIn() throws InterruptedException
	{
		Utils.inputValueIntoTextbox(this.driver, txt_Email, this.email);
		Utils.inputValueIntoTextbox(this.driver, txt_Password, this.password);
		this.byPassGoogleCapcha();
		Thread.sleep(2000);
	}
	
	public void byPassGoogleCapcha()
	{
		((JavascriptExecutor) driver).executeScript("$('#g-recaptcha-response').val('test');");
		((JavascriptExecutor) driver).executeScript("$('#sign_in_form').submit();");
	}
	
}
