package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import data.Constants;
import utils.BaseClass;
import utils.Utils;

public class OnbSurveyPage extends BaseClass{

	private String org;
	private String role;
	private String website;
	private String cat;
	private List<String> template_Ids;
	
	//Organization
	public By Orgnanization(String org)
	{
		By organization = null;
		switch(org)
		{
		case "sm-business":
			organization = By.id("onboarding-option-sm-business");
			break;
		case "med-business":
			organization = By.id("onboarding-option-med-business");
			break;
		case "ngo":
			organization = By.id("onboarding-option-nonprofit");
			break;
		case "govt":
			organization = By.id("onboarding-option-govt");
			break;
		case "school":
			organization = By.id("onboarding-option-school");
			break;
		case "enterprise":
			organization = By.id("onboarding-option-enterprise");
			break;
		case "self-employed":
			organization = By.id("onboarding-option-self-employed");
			break;
		default: organization = By.xpath("//div[@id='onboarding-option-other'][1]");
		}
		return organization;
	}
	
	//Role
	public By Role(String role)
	{
		By r = null;
		switch(role)
		{
		case "lib":
			r = By.id("onboarding-option-lib");
			break;
		case "prof":
			r = By.id("onboarding-option-prof");
			break;
		case "student":
			r = By.id("onboarding-option-student");
			break;
		case "admin":
			r = By.id("onboarding-option-admin");
			break;
		case "researcher":
			r = By.id("onboarding-option-researcher");
			break;
		case "marketer":
			r = By.id("onboarding-option-marketer");
			break;
		case "tutor":
			r = By.id("onboarding-option-tutor");
			break;
		case "hr":
			r = By.id("onboarding-option-hr");
			break;
		case "progmngr":
			r = By.id("onboarding-option-progmngr");
			break;
		case "knowlmgt":
			r = By.id("onboarding-option-knowlmgt");
			break;
		case "exec":
			r = By.id("onboarding-option-exec");
			break;
		case "finance":
			r = By.id("onboarding-option-finance");
			break;
		case "sales":
			r = By.id("onboarding-option-sales");
			break;
		case "it-eng":
			r = By.id("onboarding-option-it-eng");
			break;
		case "analyst":
			r = By.id("onboarding-option-analyst");
			break;
		case "designer":
			r = By.id("onboarding-option-designer");
			break;
		case "bnsscons":
			r = By.id("onboarding-option-bnsscons");
			break;
		case "health":
			r = By.id("onboarding-option-health");
			break;
		case "real-estate":
			r = By.id("onboarding-option-real-estate");
			break;
		case "blogger":
			r = By.id("onboarding-option-blogger");
			break;
		case "recruiter":
			r = By.id("onboarding-option-recruiter");
			break;
		case "custservice":
			r = By.id("onboarding-option-custservice");
			break;
		default: r = By.xpath("//div[@id='onboarding-option-other'][2]");
		}
		return r;
	}
	
	//Autobrand
	@FindBy (xpath = "//input[contains(@class,'websiteInput')]")
	WebElement txt_Website;
	
	@FindBy (xpath = "//button[@class='styles__button--3rEXU styles__buttonSkip--2UCoE']")
	WebElement btn_NoWebSite;
	
	@FindBy (xpath = "//button[@class='styles__button--3rEXU styles__buttonSubmit--JM2ak']")
	WebElement btn_Next;
	
	@FindBy (xpath = "//button[@class='styles__button--k0K5A styles__buttonSkip--brFvl']")
	WebElement btn_EditLater;
	
	@FindBy (xpath = "//button[@class='styles__button--k0K5A styles__buttonSubmit--Xw5fg']")
	WebElement btn_Confirm;
	
	@FindBy (xpath = "//button[text()='Continue']")
	WebElement btn_Continue;
	
	//Recommended templates
	
	
	
	// Initializing the Page Objects:
	public OnbSurveyPage() {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, (int) Constants.IMPLICIT_WAIT);
		PageFactory.initElements(factory, this);
	}		
	
	
	// Initializing the Page Objects:
	public OnbSurveyPage(String org, String role, String website, String cat, List<String> templateIds) {
		this.org = org;
		this.role = role;
		this.website = website;
		this.cat = cat;
		this.template_Ids = templateIds;
		
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, (int) Constants.IMPLICIT_WAIT);
		PageFactory.initElements(factory, this);
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public List<String> getTemplate_Ids() {
		return template_Ids;
	}

	public void setTemplate_Ids(List<String> template_Ids) {
		this.template_Ids = template_Ids;
	}
	
	public void selectOganization()
	{
		WebElement orgElement = driver.findElement(Orgnanization(this.org));
		Utils.clickElement(orgElement);
	}
	
	public void selectRole()
	{
		WebElement roleElement = driver.findElement(Role(this.role));
		Utils.clickElement(roleElement);
	}
	
	public void generateAutoBrand (boolean autoDetect, String site)
	{
		if(!autoDetect)
		{
			Utils.inputValueIntoTextbox(txt_Website, site);
		}
		Utils.clickElement(btn_Next);
		Utils.waitUntilElementIsVisible(btn_Confirm);
	}
	
	public void confirmAutoBrand(boolean confirm)
	{
		if(confirm)
		{
			Utils.clickElement(btn_Confirm);
		}
		else
		{
			Utils.clickElement(btn_EditLater);
		}
	}
	
	public void selectCategory()
	{
		int catIndex = Constants.RECOMMENDED_CATEGORIES.indexOf(this.cat);
		WebElement catElement = driver.findElement(By.xpath("//div[contains(@class,'styles__horizontalThumbnailItem')]["+ (catIndex + 1) +"]"));
		Utils.clickElement(catElement);
	}
	
	public void selectRecommendedTemplates()
	{
		for(int i = 0; i< this.template_Ids.size(); i++)
		{
			Utils.clickElement(driver.findElement(By.xpath("//img[contains(@src,'" + template_Ids.get(i) + "')]")));
		}
	}
	
	public void completeOnboardingWithoutAutoBrand()
	{
		selectOganization();
		selectRole();
		selectCategory();
		selectRecommendedTemplates();
	}
	
	public void completeOnboarding(boolean autoDetect, boolean confirm)
	{
		selectOganization();
		selectRole();
		if(this.website.equalsIgnoreCase("skip"))
		{
			Utils.clickElement(btn_NoWebSite);
		}
		else if(!this.website.isEmpty())
		{
			generateAutoBrand(autoDetect, this.website);
			confirmAutoBrand(confirm);
		}
		selectCategory();
		selectRecommendedTemplates();
	}
	
}
