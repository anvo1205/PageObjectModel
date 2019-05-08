package smoke_tests;

import org.testng.annotations.Test;

import pages.SignUpPage;
import utils.BaseClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class CreateUser {
	private WebDriver driver;
	BaseClass bc = new BaseClass(this.driver);
	@Parameters("numberOfUsers")
	@Test
  public void createUsers(int numberOfUsers) throws InterruptedException {
	  for (int i = 0; i < numberOfUsers; i++)
	  {
		  SignUpPage signup = new SignUpPage(this.driver, "singlepage.convert" + i);
		  driver.get("https://infograph.venngage.beer/register");
		  signup.Register();
		  
	  }
  }
  @Parameters(value={"platform", "browser", "language"})
  @BeforeMethod
  public void beforeClass(String platform, String browser, String lang) throws Exception {
		  bc.setUp(platform, browser, lang);  
  }

  @AfterMethod
  public void afterClass() throws Exception {
	  bc.tearDown();
  }

}
