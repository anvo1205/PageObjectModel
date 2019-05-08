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

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.sikuli.script.FindFailed;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class PreSignUpToExport {
	private WebDriver driver;
	BaseClass bc = new BaseClass(driver);

	@Test(priority = 1, enabled = true)
	public void MonthlyPreSignUpToExport() throws InterruptedException, FindFailed {
		driver = bc.setDriver();
		HomePage homepage = new HomePage(driver);
		PricingPage pricing = new PricingPage(driver);
		SignUpPage signup = new SignUpPage(driver, Utils.generateRandomEmail("preM"));
		SubscriptionPage sub = new SubscriptionPage(driver, Constants.VISA1);
		List<String> recommendedTemplate = null;
		OnbSurveyPage onb = new OnbSurveyPage(driver, "sm-business", "it-eng", "", "infographics", recommendedTemplate);
		TemplatesPage temp = new TemplatesPage(driver);
		EditorPage editor = new EditorPage(driver);

		homepage.clickPricingMenu();

		pricing.clickGetStartedPre1();

		signup.Register();

		sub.completePayment();
		sub.clickContinueOnSuccessModal();

		onb.completeOnboardingWithoutAutoBrand();

		temp.waitUntilTooltipAppears();
		temp.clickCreateUpgradeOnATemplate("77613e4d-7d4b-4b14-b317-85cc3cad32d1");

		editor.waitUntilEditorAppears();
		editor.skipEditorTourGuide();
//		editor.exportInfographic("PNG");
//		editor.exportInfographic("PDF");

	}

//  @Test(priority = 2, enabled = true)
//  public void QuarterlyPreSignUpToExport() throws InterruptedException {
//	  HomePage homepage = new HomePage();
//	  PricingPage pricing = new PricingPage();
//	  SignUpPage signup = new SignUpPage(Utils.generateRandomEmail("preQ"));
//	  SubscriptionPage sub = new SubscriptionPage(Constants.VISA1);
//	  List<String> recommendedTemplate = null;
//	  OnbSurveyPage onb = new OnbSurveyPage("mid-business", "analyst", "", "presentations", recommendedTemplate);
//	  TemplatesPage  temp = new TemplatesPage();
//	  EditorPage editor = new EditorPage();
//	  
//	  homepage.clickPricingMenu();
//	  
//	  pricing.selectQuarterlyTab();
//	  pricing.clickGetStartedPre1();
//	  
//	  signup.Register();
//	  
//	  sub.completePayment();
//	  sub.clickContinueOnSuccessModal();
//	  
//	  onb.completeOnboardingWithoutAutoBrand();
//	  
//	  temp.waitUntilTooltipAppears();
//	  temp.clickCreateUpgradeOnATemplate("d0a4f2f7-9950-4aa9-9f67-da5cf3ad3a12");
//	  
//	  editor.waitUntilEditorAppears();
//	  editor.skipEditorTourGuide();
//	  
//  }

	@Parameters(value = { "platform", "browser", "language" })
	@BeforeMethod
	public void beforeMethod(String platform, String browser, String lang) throws Exception {
		bc.setUp(platform, browser, lang);
	}

	@AfterMethod
	public void afterMethod() throws Exception {
		bc.tearDown();
	}

}
