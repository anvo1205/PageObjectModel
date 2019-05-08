package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import bsh.util.Util;
import data.Constants;
import utils.Utils;

public class PricingPage{
	private WebDriver driver;
//	 Utils utl = new Utils(this.driver);
	
	@FindBy(id = "option-pricing-monthly")
	WebElement tab_Monthly;
	
	@FindBy(id = "option-pricing-quarterly")
	WebElement tab_Quarterly;
	
	@FindBy(id = "option-pricing-yearly")
	WebElement tab_Yearly;
	
	@FindBy(id = "CTA-get-started-free-1")
	WebElement btn_GetStartedFree1;
	
	@FindBy(id = "CTA-get-started-free-2")
	WebElement btn_GetStartedFree2;
	
	@FindBy(id = "CTA-get-started-business-1")
	WebElement btn_GetStartedBuz1;
	
	@FindBy(id = "CTA-get-started-business-2")
	WebElement btn_GetStartedBuz2;
	
	@FindBy(id = "CTA-get-started-premium-1")
	WebElement btn_GetStartedPre1;
	
	@FindBy(id = "CTA-get-started-premium-2")
	WebElement btn_GetStartedPre2;
	
	// Initializing the Page Objects:
	public PricingPage(WebDriver d) {
		this.driver = d;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(this.driver, (int) Constants.IMPLICIT_WAIT);
		PageFactory.initElements(factory, this);
	}
	
	public void selectQuarterlyTab()
	{
		Utils.clickElement(this.driver, tab_Quarterly);
	}
	
	public void clickGetStartedFree1()
	{
		Utils.clickElement(this.driver, btn_GetStartedFree1);
	}
	
	public void clickGetStartedFree2()
	{
		Utils.clickElement(this.driver, btn_GetStartedFree2);
	}
	
	public void clickGetStartedPre1()
	{
		Utils.clickElement(this.driver, btn_GetStartedPre1);
	}
	
	public void clickGetStartedPre2()
	{
		Utils.clickElement(this.driver, btn_GetStartedPre2);
	}
	
	public void clickGetStartedBuz1()
	{
		Utils.clickElement(this.driver, btn_GetStartedBuz1);
	}
	
	public void clickGetStartedBuz2()
	{
		Utils.clickElement(this.driver, btn_GetStartedBuz2);
	}
	
}
