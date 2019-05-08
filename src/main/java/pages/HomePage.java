package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import data.Constants;
import utils.Utils;

public class HomePage {
	private WebDriver driver;
	
	@FindBy(xpath = "//section[@id='landing_section_1']//a")
	WebElement btn_SignUpSection1;

	@FindBy(id = "menu-item-992")
	WebElement lnk_SignIn;

	@FindBy(id = "menu-item-6393")
	WebElement lnk_PricingMenu;

	@FindBy(id = "menu-item-6395")
	WebElement lnk_EduPricing;

	// Initializing the Page Objects:
	public HomePage(WebDriver d) {
		this.driver = d;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(this.driver, (int) Constants.IMPLICIT_WAIT);
		PageFactory.initElements(factory, this);

	}
	
	
	public void clickPricingMenu()
	{
		Utils.clickElement(this.driver, lnk_PricingMenu);
	}

}
