package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import data.Constants;
import utils.BaseClass;
import utils.Utils;

public class TemplatesPage extends BaseClass{
	
	@FindBy (id = "templatesH1")
	WebElement lbl_CategoryTitle;
	
	@FindBy (xpath = "//h3[contains(@class,'styles__message')]")
	WebElement lbl_Tooltip;
	
	@FindBy (xpath = "//div[contains(@class,'tourWrapper')]//span")
	WebElement btn_Close_Tooltip;
	
	@FindBy (xpath = "//div[contains(@class,'styles__leftPanel')]//input")
	WebElement txt_Search;
	
	@FindBy (xpath = "//div[contains(@class,'styles__leftPanel')]//div[contains(@class,'styles__searchSVG')]")
	WebElement btn_Search;
	
	@FindBy (id = "cat-recommeded")
	WebElement btn_Cat_Recommended;
	
	@FindBy (id = "cat-featured")
	WebElement btn_Cat_Feature;
	
	@FindBy (id = "cat-layouts")
	WebElement btn_Cat_Layouts;
	
	@FindBy (id = "cat-see-all-templates")
	WebElement btn_Cat_All_Templates;
	
	@FindBy (id = "cat-infographics")
	WebElement btn_Cat_Infographics;
	
	@FindBy (id = "cat-presentations")
	WebElement btn_Cat_Presentations;
	
	@FindBy (id = "cat-reports")
	WebElement btn_Cat_Reports;
	
	@FindBy (id = "cat-charts")
	WebElement btn_Cat_Charts;
	
	@FindBy (id = "cat-mind-maps")
	WebElement btn_Cat_Mindmaps;
	
	@FindBy (id = "cat-roadmaps")
	WebElement btn_Cat_Roadmaps;
	
	@FindBy (id = "cat-brochures")
	WebElement btn_Cat_Brochures;
	
	@FindBy (id = "cat-resumes")
	WebElement btn_Cat_Resumes;
	
	@FindBy (id = "cat-educatnon")
	WebElement btn_Cat_Education;
	
	@FindBy (id = "cat-certificates")
	WebElement btn_Cat_Certificate;
	
	@FindBy (id = "cat-letterheads")
	WebElement btn_Cat_Letter_Heads;

	@FindBy (id = "cat-white-papers")
	WebElement btn_Cat_White_Papers;
	
	@FindBy (id = "cat-proposals")
	WebElement btn_Cat_Proposals;
	
	@FindBy (id = "cat-posters")
	WebElement btn_Cat_Posters;
	
	@FindBy (id = "cat-flyers")
	WebElement btn_Cat_Flyers;
	
	@FindBy (id = "cat-newsletters")
	WebElement btn_Cat_Newsletters;
	
	@FindBy (id = "cat-invitations")
	WebElement btn_Cat_invitations;
	
	@FindBy (id = "cat-cards")
	WebElement btn_Cat_Cards; 
	
	@FindBy (id = "cat-coupons")
	WebElement btn_Cat_Coupons; 
	
	@FindBy (id = "cat-social-media")
	WebElement btn_Cat_Social_Media; 
	
	@FindBy (id = "cat-logos")
	WebElement btn_Cat_Logos; 
	
	@FindBy (id = "cat-ebooks")
	WebElement btn_Cat_eBooks; 
	
	@FindBy (id = "cat-banners")
	WebElement btn_Cat_Banners;
	
	@FindBy (id = "cat-menus")
	WebElement btn_Cat_Menus;
	
	@FindBy (id = "infographics-informational")
	WebElement btn_Sub_Informational;
	
	@FindBy (id = "infographics-statistical")
	WebElement btn_Sub_Statistical;
	
	@FindBy (id = "infographics-process")
	WebElement btn_Sub_Processs;
	
	@FindBy (id = "infographics-geographic")
	WebElement btn_Sub_Geographics;
	
	@FindBy (id = "infographics-timeline")
	WebElement btn_Sub_timeline;
	
	@FindBy (id = "infographics-comparison")
	WebElement btn_Sub_Comparisoon;
	
	@FindBy (id = "infographics-list")
	WebElement btn_Sub_List;
	
	@FindBy (id = "infographics-fun-data")
	WebElement btn_Sub_Fun_Data;
	
	@FindBy (id = "infographics-tutorials")
	WebElement btn_Sub_Tutorials;
	
	@FindBy (id = "infographics-nonprofit")
	WebElement btn_Sub_Nonprofit;
	
	@FindBy (id = "infographics-human-resources")
	WebElement btn_Sub_Human_Resources;
	
	@FindBy (id = "infographics-real-estate")
	WebElement btn_Sub_Real_Estate;
	
	@FindBy (id = "presentations-pitch-decks")
	WebElement btn_Sub_Human_Pitch_Decks;
	
	@FindBy (id = "presentations-business")
	WebElement btn_Sub_Pre_Business;
	
	@FindBy (id = "presentations-creative")
	WebElement btn_Sub_Pre_Creative;
	
	@FindBy (id = "reports-annual")
	WebElement btn_Sub_Reports_Annual;
	
	@FindBy (id = "reports-monthly")
	WebElement btn_Sub_Reports_Monthly;
	
	@FindBy (id = "reports-survey-results")
	WebElement btn_Sub_Reports_Survey;
	
	@FindBy (id = "reports-nonprofit")
	WebElement btn_Sub_Reports_Nonprofit;
	
	@FindBy (id = "reports-marketing")
	WebElement btn_Sub_Reports_Marketing;
	
	@FindBy (id = "charts-pie")
	WebElement btn_Sub_Charts_Pie;
	
	@FindBy (id = "charts-bar")
	WebElement btn_Sub_Charts_Bar;
	
	@FindBy (id = "charts-line")
	WebElement btn_Sub_Charts_Line;
	
	@FindBy (id = "charts-venn-diagram")
	WebElement btn_Sub_Charts_Venn_Diagram;
	
	@FindBy (id = "charts-bubble")
	WebElement btn_Sub_Charts_Bubble;
	
	@FindBy (id = "charts-venn_area")
	WebElement btn_Sub_Charts_Area;
	
	@FindBy (id = "charts-flow")
	WebElement btn_Sub_Charts_Flow;
	
	@FindBy (id = "charts-map")
	WebElement btn_Sub_Charts_Map;
	
	@FindBy (id = "charts-scatterplot")
	WebElement btn_Sub_Charts_Scatterplot;
	
	@FindBy (id = "charts-stacked")
	WebElement btn_Sub_Charts_Stacked;
	
	@FindBy (id = "charts-word-cloud")
	WebElement btn_Sub_Charts_Word_Cloud;
	
	@FindBy (id = "charts-single")
	WebElement btn_Sub_Charts_Single;
	
	@FindBy (id = "charts-mixed")
	WebElement btn_Sub_Charts_Mixed;
	
	@FindBy (id = "charts-editorial")
	WebElement btn_Sub_Charts_Editorial;
	
	@FindBy (id = "mind-maps-business")
	WebElement btn_Sub_Mindmaps_Business;

	@FindBy (id = "mind-maps-simple")
	WebElement btn_Sub_Mindmaps_Simple;
	
	@FindBy (id = "roadmaps-product")
	WebElement btn_Sub_Roadmaps_Product;
	
	@FindBy (id = "roadmaps-marketing")
	WebElement btn_Sub_Roadmaps_Marketing;
	
	@FindBy (id = "brochures-tri-fold")
	WebElement btn_Sub_brochures_Tri_Fold;
	

	// subcategories
	public static By lnk_SubcatTravel = By.id("brochures-travel");
	public static By lnk_SubcatProcessional = By.id("resumes-professional");
	public static By lnk_SubcatCoverLetter = By.id("resumes-cover-letters");
	public static By lnk_SubcatTeachingAids = By.id("education-teaching-aids");
	public static By lnk_SubcatLessonPlans = By.id("education-lesson-plans");
	public static By lnk_SubcatRecognition = By.id("certificates-recognition");
	public static By lnk_SubcatComletion = By.id("certificates-completion");
	public static By lnk_SubcatLetterHeadBusiness = By.id("letterheads-business");
	public static By lnk_SubcatSimple = By.id("white-papers-simple");
	public static By lnk_SubcatProposalBusiness = By.id("proposals-business");
	public static By lnk_SubcatPosterEvent = By.id("posters-event");
	public static By lnk_SubcatPosterHoliday = By.id("posters-holiday");
	public static By lnk_SubcatFlyerBusiness = By.id("flyers-business");
	public static By lnk_SubcatFlyerProduct = By.id("flyers-product");
	public static By lnk_SubcatFlyerEvent = By.id("flyers-event");
	public static By lnk_SubcatNewLetterEvent = By.id("newsletters-event");
	public static By lnk_SubcatNewLetterHoliday = By.id("newsletters-holiday");
	public static By lnk_SubcatSchool = By.id("newsletters-school");
	public static By lnk_SubcatInviHoliday = By.id("invitations-holiday");
	public static By lnk_SubcatWedding = By.id("invitations-wedding");
	public static By lnk_SubcatInviBirthday = By.id("invitations-birthday");
	public static By lnk_SubcatBabyShower = By.id("invitations-baby-shower");
	public static By lnk_SubcatBridalShower = By.id("invitations-bridal-shower");
	public static By lnk_SubcatSaveTheDate = By.id("invitations-save-the-date");
	public static By lnk_SubcatParty = By.id("invitations-party");
	public static By lnk_SubcatCardBirthday = By.id("cards-birthday");
	public static By lnk_SubcatCongratulation = By.id("cards-congratulations");
	public static By lnk_SubcatGreeting = By.id("cards-greeting");
	public static By lnk_SubcatThankYou = By.id("cards-thank-you");
	public static By lnk_SubcatHoliday = By.id("cards-holiday");
	public static By lnk_SubcatThanksGiving = By.id("cards-thanksgiving");
	public static By lnk_SubcatChristmas = By.id("cards-christmas");
	public static By lnk_SubcatHannukah = By.id("cards-hannukah");
	public static By lnk_SubcatMothersDay = By.id("cards-mothers-day");
	public static By lnk_SubcatFathersDay = By.id("cards-fathers-day");
	public static By lnk_SubcatGetWell = By.id("cards-get-well");
	public static By lnk_SubcatGiftCertificates = By.id("coupons-gift-certificates");
	public static By lnk_SubcatVouchers = By.id("coupons-vouchers");
	public static By lnk_SubcatInstagram = By.id("social-media-instagram");
	public static By lnk_SubcatFacebook = By.id("social-media-facebook");
	public static By lnk_SubcatPinterest = By.id("social-media-pinterest");
	public static By lnk_SubcatTwiter = By.id("social-media-twitter");
	public static By lnk_SubcatLinkedIn = By.id("social-media-linkedin");
	public static By lnk_SubcatLogoBusiness = By.id("logos-business");
	public static By lnk_SubcatLogoCreative = By.id("logos-creative");
	public static By lnk_SubcatEbookSimple = By.id("ebooks-simple");
	public static By lnk_SubcatBlog = By.id("banners-blog");
	public static By lnk_SubcatEmail = By.id("banners-email");
	public static By lnk_SubcatBannerFacebook = By.id("banners-facebook");
	public static By lnk_SubcatBannerInstagram = By.id("banners-instagram");
	public static By lnk_SubcatBannerTwitter = By.id("banners-twitter");
	public static By lnk_SubcatBannerLinkedIn = By.id("banners-linkedin");
	public static By lnk_SubcatBannerYoutube = By.id("banners-youtube");
	public static By lnk_SubcatRestaurant = By.id("menus-restaurant");
	
	@FindBy (id = "preview-create-btn")
	WebElement btn_CreateFromPreview;
	
	@FindBy (id = "preview-upgrade-btn")
	WebElement btn_UpgradeFromPreview;
	
	// Initializing the Page Objects:
	public TemplatesPage() {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, (int) Constants.IMPLICIT_WAIT);
		PageFactory.initElements(factory, this);
	}
	
	public void searchTemplates(String keyword)
	{
		Utils.inputValueIntoTextbox(txt_Search, keyword);
		Utils.clickElement(btn_Search);
	}
	
	public void clickCreateUpgradeOnATemplate(String templateId) throws InterruptedException
	{
		WebElement btn_CreateUpgrade = driver.findElement(By.xpath("//a[contains(@href,'" + templateId + "')]/ancestor::div/center/div[1]"));
		Utils.scrollToElement(btn_CreateUpgrade);
		Utils.moveMouseToElement(btn_CreateUpgrade);
		btn_CreateUpgrade.click();
	}
	
	public void clickPreviewOnATemplate(String templateId) throws InterruptedException
	{
		WebElement btn_Preview = driver.findElement(By.xpath("//a[contains(@href,'" + templateId + "')]/ancestor::div/center/div[2]"));
		Utils.scrollToElement(btn_Preview);
		Utils.moveMouseToElement(btn_Preview);
		btn_Preview.click();
	}

}
