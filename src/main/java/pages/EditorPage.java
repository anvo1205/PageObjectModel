package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import data.Constants;
import utils.Utils;

public class EditorPage{
	private WebDriver driver;
	
	@FindBy (xpath = "//button[@data-role='next']")
	WebElement btn_EditorTourGuideNext;
	
	@FindBy (xpath = "//button[@data-role='prev']")
	WebElement btn_EditorTourGuidePrevious;
	
	@FindBy (xpath = "//button[@title='End Tour']")
	WebElement btn_EditorTourGuideSkip;
	
	@FindBy (xpath = "//div[@id='preview_modal']//a")
	WebElement btn_PreUpgradeFromModal;
	
	@FindBy (id = "other_controls_download")
	WebElement btn_Download_Group;
	
	@FindBy (xpath = "//div[@id='ReactSettingsExport']//button[contains(@class,'exportBtn')][1]")
	WebElement btn_PNG_Download;
	
	@FindBy (xpath = "//div[@id='ReactSettingsExport']//button[contains(@class,'exportBtn')][2]")
	WebElement btn_PNG_HD_Download;
	
	@FindBy (xpath = "//div[@id='ReactSettingsExport']//button[contains(@class,'exportBtn')][3]")
	WebElement btn_PDF_Download;
	
	@FindBy (xpath = "//div[@id='ReactSettingsExport']//button[contains(@class,'exportBtn')][4]")
	WebElement btn_Interactive_PDF_Download;
	

	
	// Initializing the Page Objects:
	public EditorPage(WebDriver d) {
		this.driver = d;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(this.driver, (int) Constants.IMPLICIT_WAIT);
		PageFactory.initElements(factory, this);
	}
	
	public void waitUntilEditorAppears()
	{
		Utils.waitUntilElementIsVisible(this.driver, btn_Download_Group);
	}
	
	public void skipEditorTourGuide()
	{
		waitUntilEditorAppears();
		Utils.clickElement(this.driver, btn_EditorTourGuideSkip);
	}
	
	public void exportInfographic(String type) throws InterruptedException, FindFailed
	{
		WebElement downloadOption = null;
		switch(type)
		{
		case "PNG":
			downloadOption = btn_PNG_Download;
			break;
		case "PNG HD":
			downloadOption = btn_PNG_HD_Download;
			break;
		case "PDF":
			downloadOption = btn_PDF_Download;
			break;
		case "Interactive PDF":
			downloadOption = btn_Interactive_PDF_Download;
			break;
		}
		
		{
			
			if (!btn_PNG_Download.isDisplayed())
			{
				Utils.clickElement(this.driver, btn_Download_Group);
			}
			Utils.clickElement(this.driver, downloadOption);
		}
		
		if (Utils.getValueFromPropertiesFile("browser").equalsIgnoreCase("firefox"))
		{
			Screen s = new Screen();
	        Pattern download_Popup = new Pattern("C:\\Users\\anvo1\\OneDrive\\Desktop\\" + "download popup.PNG");
	        Pattern saveOption = new Pattern("C:\\Users\\anvo1\\OneDrive\\Desktop\\" + "save option.PNG");
	        Pattern okBtn = new Pattern("C:\\Users\\anvo1\\OneDrive\\Desktop\\" + "ok button.PNG");
	        
	        s.wait(download_Popup ,10);
	        s.click(saveOption);
	        s.click(okBtn);
		}
	}
	
	
	
	//My Brand Kit
	public static By btn_UpgradeBrandLogo = By.xpath("//div[@data-widget-type='brand-media-image']");
	public static By btn_BuzUpgradeBrandModal = By.xpath("//div[@id='upgrade_modal']//div[@class='modal-body']//button");
	public static By lnk_BuzUpgradeBrandLogo = By.xpath("//a[@href='/subscription/business']");
	public static By lnk_BuzUpgradeBrandcolor = By.xpath("//p/a[@href='/account/subscription/business']");
	public static By menu_My_Brand_Kit = By.id("editor_menu_brand_kit");
	public static By btn_Add_To_Brand_Kit = By.xpath("//a[@href='/brand']");
	public static By img_BrandLogo = By.xpath("//div[@data-widget-type='brand-media-image']");
	public static By btn_BrandColor(String[] rgb)
	{
		return By.xpath("//li[@id='ReactBrandKitColourPalette']//div[contains(@style,'rgb(" + rgb[0] + ", " + rgb[1] + ", " + rgb[2] + ")')]");
	}
	//Text
	public static By menu_Text = By.id("editor_menu_text");
	public static By wid_Text_Title = By.id("editor_widget_text_1");
	public static By wid_Text_Subtitle = By.id("editor_widget_text_2");
	public static By wid_Text_Normal = By.id("editor_widget_text_3");
	public static By wid_Text_Html = By.id("editor_widget_text_4");
	public static By added_Text_Widget = By.id("new_text_widget_v4");
	//Icons
	public static By menu_Icons = By.id("editor_menu_icons");
	public static By txt_Icons_Search = By.id("editor_widget_icon_search");
	public static By btn_Icons_Search = By.id("editor_widget_icon_submit");
	public static By btn_Icons_Style_All = By.id("icon-filter-all");
	public static By btn_Icons_Style_Mono = By.id("icon-filter-color");
	public static By btn_Icons_Style_Color = By.id("icon-filter-mono");
	public static By cat_ShapeSymbolIcons = By.id("editor_widget__dropdown_0");
	public static By wid_Ricon_Floral_Icon = By.xpath("//div[@data-widget-type='ricon-floral']");
	public static By btn_UpgradeIconModal = By.xpath("//div[@id='upgrade_modal']//div[@class='modal-body']//button");
	//Charts
	public static By menu_Charts = By.id("editor_menu_charts");
	public static By wid_3DColumnChart = By.xpath("//div[@data-widget-type='viz.widget.standard.3dcolumn']");
	//Maps
	public static By menu_Maps = By.id("editor_menu_maps");
	public static By wid_EuropeMap = By.id("editor_widget_maps_5");
	//Background
	public static By menu_Background = By.id("editor_menu_background");
	public static By lnk_UpgradeFromBackground = By.xpath("//li[@id='ReactBackgroundSettings']//a");
	//Image Upload
	public static By menu_Image_Uploads = By.id("editor_menu_uploads");
	public static By menu_Photos = By.id("editor_menu_img");
	public static By btn_Upload_Image = By.id("user_media_upload_button");
	public static By btn_Browse_Image = By.id("upload_filename");
	public static By btn_Upload = By.xpath("//input[@value='Upload']");
	//Photos
	public static By txt_ImageSearch = By.id("image_search");
	//Image Frames
	public static By menu_Image_Frames = By.id("editor_menu_img_frames");
	public static By wid_SquareleImageFrame = By.id("editor_widget_img_frames_3");
	//Icon Charts
	public static By menu_Icon_Charts = By.id("editor_menu_icon_chart");
	//Marketing Features
	public static By menu_Interactive = By.id("editor_menu_marketing");
	public static By wid_Content_Gating = By.id("content_gate_button");
	
	
	
	
	
	//Toolbar
	public static By btn_Snap_To_Guide = By.id("toggle_snapToGuide");
	public static By btn_Grid = By.id("toggle_grid_display");
	public static By ddl_Zoom = By.id("ReactZoomOption");
	public static By list_Zoom_Options = By.xpath("//div[@id='ReactZoomOption']//ul");
	public static By btn_Undo = By.id("page_undo");
	public static By btn_Redo = By.id("page_redo");
	public static By btn_Group_Widgets = By.id("group_control_container");
	public static By btn_Lock = By.id("lock");
	public static By lbl_Title = By.id("infographic_title");
	
	
	//Context toolbar
	public static By btn_TextColorPicker = By.xpath("//div[@id='ReactSettingsToolbar']//div[contains(@class,'styles__colorPreview')]");
	public static By lnk_UpgradeFromTextColorPicker = By.xpath("//div[@id='ReactSpecialRenderLayer']//a"); 
	
	//Pubish
	public static By btn_Publish_Group = By.id("other_controls_publish");
	public static By txt_Infographic_Title = By.id("publish_infographic_title");
	public static By opt_Publish = By.id("publish_to_community");
	public static By opt_Preview = By.id("btn_preview");
	public static By btn_Publish = By.id("publish_submit_btn");
	public static By txt_Embed_Code = By.id("textarea_embed");
	public static By btn_CloseUnpublishSuccessModal = By.xpath("//div[@id='unpublished_modal']//button[text()='Close']");
	//Share
	public static By btn_Share_Group = By.id("other_controls_share");
	public static By lbl_Share_Link = By.id("private_share_link_field");
	public static By btn_Copy_Link = By.id("copy_private_link");
	public static By txt_Shared_Email = By.id("share_via_email");
	public static By btn_Send_Email = By.id("private_share_via_email_btn");
	public static By btn_Team_Share = By.id("slider_switch");
	public static By lnk_Share_Pinterest = By.xpath("//a[@title='Share on Pinterest']");
	public static By lnk_Share_Facebook = By.xpath("//a[@title='Share on Facebook']");
	public static By lnk_Share_Twitter = By.xpath("//a[@title='Share on Twitter']");
	public static By lnk_Share_LinkedIn = By.xpath("//a[@title='Share on LinkedIn']");
	public static By lnk_UpgradeFromShare = By.xpath("//div[@id='private_share_panel']//a");
	public static By lbl_Team_Share_Success_Msg = By.xpath("//label[@for='team_share_toggle']");
	//Download
//	public static By btn_Download_Group = By.id("other_controls_download");
	public static By btn_PNG = By.xpath("//div[@id='ReactSettingsExport']//button[text()='PNG']");
	public static By btn_HD_PNG = By.xpath("//div[@id='ReactSettingsExport']//button[text()='PNG HD']");
	public static By btn_PDF = By.xpath("//div[@id='ReactSettingsExport']//button[text()='PDF']");
	public static By btn_I_PDF = By.xpath("//div[@id='ReactSettingsExport']//button[text()='Interactive PDF']");
	public static By lnk_PreUpgradeFromDownload = By.xpath("//div[@id='ReactSettingsExport']//a[@href='/account/subscription']");
	public static By lnk_BuzUpgradeFromDownload = By
			.xpath("//div[@id='ReactSettingsExport']//a[@href='/account/subscription/business']");
	//Page size
	public static By btn_Settings_Group = By.id("other_controls_settings");
	public static By btn_Poitrait = By.xpath("//span[@class='flaticon-portrait normalized styles__closed___f6zvC']");
	public static By btn_Landscape = By.xpath("//span[@class='flaticon-landscape normalized styles__open___1bIjM']");
	public static By btn_Copy_Design = By.id("btn_save_as_new_infographic");
	public static By btn_Save_As_Template = By.id("btn_save_as_template");
	public static By lnk_BuzUpgradeFromSettings = By.id("my_template_upgrade_btn");
	
	//Multipage control
	
	//Chart settings
	

	

}
