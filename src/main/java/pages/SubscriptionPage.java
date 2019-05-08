package pages;

import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import data.Constants;
import utils.Utils;

public class SubscriptionPage{
	private WebDriver driver;
	
//	Utils utl = new Utils(this.driver);
	
	@FindBy(name = "name")
	WebElement txt_cardHolderName;
	
	@FindBy(name = "number")
	WebElement txt_cardNum;
	
	@FindBy(name = "month")
	WebElement txt_cardExpMonth;
	
	@FindBy(name = "year")
	WebElement txt_cardExpYear;
	
	@FindBy(name = "cvc")
	WebElement txt_cardCVC;
	
	@FindBy(name = "styles__root--3tkRc")
	WebElement btn_SwitchBuzOnPreModal;
	
	@FindBy(xpath = "//div[@id='styles__modalContent--Eznb_']//div[@id='styles__root--3tkRc']")
	WebElement btn_Upgrade;
	
	@FindBy(xpath = "//div[contains(@id,'styles__redirectButton')]")
	WebElement btn_ContinuePreSuccessModal;
	
	@FindBy(xpath = "//div[contains(@id,'styles__businessRedirect')]/div")
	WebElement btn_GetStartedBuzSuccessModal;
	
	@FindBy(id = "styles__businessTitle--1pb38")
	WebElement lbl_BuzUpgradeModalTitle;
	
	@FindBy(id = "styles__premiumTitle--2aZvt")
	WebElement lbl_PreUpgradeModalTitle;
	
	@FindBy(id = "styles__educationTitle--2DbQ4")
	WebElement lbl_EduUpgradeModalTitle;
	
	@FindBy(id = "monthly")
	WebElement cbb_Monthly;
	
	@FindBy(id = "quarterly")
	WebElement cbb_Quarterly;
	
	@FindBy(id = "yearly")
	WebElement cbb_Yearly;
	
	@FindBy(id = "styles__discountButton--13cO6")
	WebElement btn_Discount;
	
	@FindBy(id = "styles__inputCoupon--292Vd")
	WebElement txt_CouponCode;
	
	@FindBy(id = "styles__applyCouponButton--2ePzG")
	WebElement btn_ApplyCouponCode;
	
	@FindBy(id = "styles__closeButton--3M4UK")
	WebElement btn_CloseBuzUpgradeModal;
	
	@FindBy(xpath = "//div[contains(@id,'account__subscriptionDetails')]//td[@class='account__caps--25mYi']")
	WebElement lbl_PlanPeriod;
	
	@FindBy(xpath = "//div[contains(@id,'account__subscriptionDetails')]//tr[2]/td")
	WebElement lbl_NextInvoiceDate;
	
	@FindBy(xpath = "//div[contains(@id,'account__subscriptionDetails')]//tr[3]/td")
	WebElement lbl_NextBillingPeriod;
	
	@FindBy(xpath = "//div[contains(@id,'account__subscriptionDetails')]//tr[4]/td")
	WebElement lbl_CurrentTeamSize;
	
	@FindBy(id = "styles__closeButton--1QAjG")
	WebElement btn_CloseUpgradePreToBuzModal;
	
	@FindBy(xpath = "//div[contains(@class,'modalOrangeButton')]")
	WebElement btn_ConfirmUpgradePreToBuz;
	
	@FindBy(id = "account__addMemberInput--19yeE")
	WebElement txt_NumMember;
	
	@FindBy(id = "account__addMemberButton--B1OT0")
	WebElement btn_AddMember;
	
	@FindBy(xpath = "//div[contains(@class,'modalConfirmButton')]")
	WebElement btn_ConfirmAddMem;
	
	@FindBy(id = "styles__confirmButton--1ta5u")
	WebElement btn_CloseAddMemSuccess;
	
	@FindBy(id = "account__cancelSubscriptionButton--uOkfo")
	WebElement btn_CancelMySubscription;
	
	@FindBy(xpath = "//button[contains(@class,'Cancellation__confirmBtn')]")
	WebElement btn_ContinueAfterRating;
	
	@FindBy(id = "cancel-subscription-survey-1")
	WebElement btn_CancelOption1;
	
	@FindBy(id = "cancel-subscription-survey-2")
	WebElement btn_CancelOption2;
	
	@FindBy(id = "cancel-subscription-survey-3")
	WebElement btn_CancelOption3;
	
	@FindBy(id = "cancel-subscription-survey-4")
	WebElement btn_CancelOption4;
	
	@FindBy(id = "cancel-subscription-survey-5")
	WebElement btn_CancelOption5;
	
	@FindBy(id = "cancel-subscription-survey-6")
	WebElement btn_CancelOption6;
	
	@FindBy(xpath = "//div[contains(@class,'Cancellation__cancelOption')]")
	WebElement btn_StillCancel;
	
	@FindBy(xpath = "//button[@value='couponAccepted']")
	WebElement btn_AcceptCoupon;
	
	@FindBy(xpath = "//button[@value='pause']")
	WebElement btn_PauseAccount;
	
	@FindBy(xpath = "//button[contains(@class,'Cancellation__cancelBtn')]")
	WebElement btn_CancelAccount;
	
	@FindBy(xpath = "//button[@value='cancel']")
	WebElement btn_ConfirmCancel;
	
	@FindBy(xpath = "//div[@id='styles__feedbackContainer--1vYOU']//textarea")
	WebElement txt_Feedback;
	
	// Initializing the Page Objects:
	public SubscriptionPage(WebDriver d) {
		this.driver = d;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(this.driver, (int) Constants.IMPLICIT_WAIT);
		PageFactory.initElements(factory, this);
	}
	
	private String cardHolderName;
	private String cardNum;
	private String cardExpMonth;
	private String cardExpYear;
	private String cardCVC;
	
	public SubscriptionPage(WebDriver d, String cardNum) {
		this.driver = d;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(this.driver, (int) Constants.IMPLICIT_WAIT);
		PageFactory.initElements(factory, this);
		
		this.cardHolderName = "Test";
		this.cardNum = cardNum;
		this.cardExpMonth = "12";
		this.cardExpYear = String.valueOf((Calendar.getInstance().get(Calendar.YEAR) + 1));
		this.cardCVC = "123";
	}
	
	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getCardExpMonth() {
		return cardExpMonth;
	}

	public void setCardExpMonth(String cardExpMonth) {
		this.cardExpMonth = cardExpMonth;
	}

	public String getCardExpYear() {
		return cardExpYear;
	}

	public void setCardExpYear(String cardExpYear) {
		this.cardExpYear = cardExpYear;
	}

	public String getCardCVC() {
		return cardCVC;
	}

	public void setCardCVC(String cardCVC) {
		this.cardCVC = cardCVC;
	}
	
	public void completePayment()
	{
	Utils.waitUntilElementIsVisible(this.driver, btn_Upgrade);
	Utils.inputValueIntoTextbox(this.driver, txt_cardHolderName, this.getCardHolderName());
	Utils.inputValueIntoTextbox(this.driver, txt_cardNum, this.getCardNum());
	Utils.selectDropDownListValue(this.driver, txt_cardExpMonth, "option", this.getCardExpMonth());
	Utils.selectDropDownListValue(this.driver, txt_cardExpYear, "option", this.getCardExpYear());
	Utils.inputValueIntoTextbox(this.driver, txt_cardCVC, this.getCardCVC());
	Utils.clickElement(this.driver, btn_Upgrade);
	}
	
	public void clickContinueOnSuccessModal()
	{
		Utils.clickElement(this.driver, btn_ContinuePreSuccessModal);
	}
	
	public void clickGetStartedOnbuzSuccessModal()
	{
		Utils.clickElement(this.driver, btn_GetStartedBuzSuccessModal);
	}
	
	public void selectRatingOption(String ratingNum)
	{
		Utils.clickElement(this.driver, driver.findElement(By.xpath("//input[@value='" + ratingNum + "']")));
	}
	
	public void addMemberSubscription(int numMems) {
		Utils.inputValueIntoTextbox(this.driver, txt_NumMember, String.valueOf(numMems));
		Utils.clickElement(this.driver, btn_AddMember);
		Utils.clickElement(this.driver, btn_ConfirmAddMem);
		Utils.clickElement(this.driver, btn_CloseAddMemSuccess);
	}
	
	public void cancelSubscription(String rating, int optionNum, String feedback) throws InterruptedException
	{
		String planPeriod = lbl_PlanPeriod.getText();
		Utils.scrollToElement(this.driver, btn_CancelMySubscription);
		Utils.clickElement(this.driver, btn_CancelMySubscription);
		this.selectRatingOption(rating);
		Utils.clickElement(this.driver, btn_ContinueAfterRating);
		switch (optionNum)
		{
		case 1:
			Utils.clickElement(this.driver, btn_CancelOption1);
			if (planPeriod.contains("Yearly"))
			{
				Utils.inputValueIntoTextbox(this.driver, txt_Feedback, feedback);
				Utils.clickElement(this.driver, btn_CancelAccount);
			}
			else
			{
				Utils.clickElement(this.driver, btn_StillCancel);
				Utils.clickElement(this.driver, btn_StillCancel);
			}
			Utils.clickElement(this.driver, btn_ConfirmCancel);
			break;
		case 2:
			Utils.clickElement(this.driver, btn_CancelOption2);
			Thread.sleep(1000);
			Utils.clickElement(this.driver, btn_StillCancel);
			Utils.clickElement(this.driver, btn_CancelAccount);
			Utils.clickElement(this.driver, btn_ConfirmCancel);
			break;
		case 3:
			Utils.clickElement(this.driver, btn_CancelOption3);
			Utils.inputValueIntoTextbox(this.driver, txt_Feedback, feedback);
			Utils.clickElement(this.driver, btn_CancelAccount);
			Utils.clickElement(this.driver, btn_ConfirmCancel);
			break;
		case 4:
			Utils.clickElement(this.driver, btn_CancelOption4);
			Utils.inputValueIntoTextbox(this.driver, txt_Feedback, feedback);
			Utils.clickElement(this.driver, btn_CancelAccount);
			Utils.clickElement(this.driver, btn_ConfirmCancel);
			break;
		case 5:
			Utils.clickElement(this.driver, btn_CancelOption5);
			Utils.inputValueIntoTextbox(this.driver, txt_Feedback, feedback);
			Utils.clickElement(this.driver, btn_CancelAccount);
			Utils.clickElement(this.driver, btn_ConfirmCancel);
			break;
		case 6:
			Utils.clickElement(this.driver, btn_CancelOption6);
			Utils.inputValueIntoTextbox(this.driver, txt_Feedback, feedback);
			Utils.clickElement(this.driver, btn_CancelAccount);
			Utils.clickElement(this.driver, btn_ConfirmCancel);
			break;
		}
	}
	

}
