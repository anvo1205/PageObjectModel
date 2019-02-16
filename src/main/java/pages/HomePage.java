package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import data.Constants;
import utils.BaseClass;

public class HomePage extends BaseClass {
	@FindBy(xpath = "//section[@id='landing_section_1']//a")
	WebElement btn_SignUpSection1;

	@FindBy(id = "menu-item-992")
	WebElement lnk_SignIn;

	@FindBy(id = "menu-item-6393")
	WebElement lnk_PricingMenu;

	@FindBy(id = "menu-item-6395")
	WebElement lnk_EduPricing;

	// Initializing the Page Objects:
	public HomePage() {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, (int) Constants.IMPLICIT_WAIT);
		PageFactory.initElements(factory, this);
	}

}
