package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import data.Constants;
import utils.BaseClass;

public class PricingPage extends BaseClass{
	
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
	public PricingPage() {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, (int) Constants.IMPLICIT_WAIT);
		PageFactory.initElements(factory, this);
	}
	
}
