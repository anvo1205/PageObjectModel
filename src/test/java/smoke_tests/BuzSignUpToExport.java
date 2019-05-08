package smoke_tests;

import org.testng.annotations.Test;

import data.Constants;
import pages.EditorPage;
import pages.HomePage;
import pages.OnbSurveyPage;
import pages.PricingPage;
import pages.SignUpPage;
import pages.SubscriptionPage;
import pages.TemplatesPage;
import utils.BaseClass;
import utils.Utils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class BuzSignUpToExport{
	private WebDriver driver;
	BaseClass bc = new BaseClass(driver);
	
  @Test(priority = 1, enabled = true)
  public void MonthlyBuzSignUpToExport() throws InterruptedException {
	  driver = bc.setDriver();
	  HomePage homepage = new HomePage(driver);
	  PricingPage pricing = new PricingPage(driver);
	  SignUpPage signup = new SignUpPage(driver, Utils.generateRandomEmail("buzM"));
	  SubscriptionPage sub = new SubscriptionPage(driver, Constants.VISA1);
	  List<String> recommendedTemplate = null;
	  OnbSurveyPage onb = new OnbSurveyPage(driver, "sm-business", "it-eng", "", "infographics", recommendedTemplate);
	  TemplatesPage  temp = new TemplatesPage(driver);
	  EditorPage editor = new EditorPage(driver);
	  
	  homepage.clickPricingMenu();
	  
	  pricing.clickGetStartedBuz1();
	  
	  signup.Register();
	  
	  sub.completePayment();
	  sub.clickGetStartedOnbuzSuccessModal();;
	  
	  onb.completeOnboardingWithoutAutoBrand();
	  
	  temp.waitUntilTooltipAppears();
	  temp.clickCreateUpgradeOnATemplate("77613e4d-7d4b-4b14-b317-85cc3cad32d1");
	  
	  editor.waitUntilEditorAppears();
	  editor.skipEditorTourGuide();
	  
  }
  
  
  @Parameters(value={"platform", "browser", "language"})
  @BeforeMethod
  public void beforeMethod(String platform, String browser, String lang) throws Exception {
	  bc.setUp(platform, browser, lang);
  }

  @AfterMethod
  public void afterMethod() throws Exception {
	 bc.tearDown();
  }

}
