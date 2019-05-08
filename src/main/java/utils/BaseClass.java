package utils;

import data.Constants;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	private WebDriver driver;

	public BaseClass(WebDriver d) {
		driver = d;
	}

	public WebDriver setDriver() {
		return this.driver;
	}

	@SuppressWarnings("deprecation")
	@BeforeMethod(alwaysRun = true)
	public void setUp(String platform, String browser, String lang) throws Exception {

		if (platform.equalsIgnoreCase("window")) {
			if (browser.equalsIgnoreCase("chrome")) {
				DesiredCapabilities jsCapabilities = DesiredCapabilities.chrome();
				ChromeOptions options = new ChromeOptions();
				Map<String, Object> prefs = new HashMap<>();
				prefs.put("intl.accept_languages", lang);
				options.setExperimentalOption("prefs", prefs);
				jsCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
				System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH_WINDOW);
				driver = new ChromeDriver(options);
			} 
			
			else if (browser.equalsIgnoreCase("headless chrome")) {
				DesiredCapabilities jsCapabilities = DesiredCapabilities.chrome();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless", "--disable-gpu", "--ignore-certificate-errors");
				Map<String, Object> prefs = new HashMap<>();
				prefs.put("intl.accept_languages", lang);
				options.setExperimentalOption("prefs", prefs);
				jsCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
				driver = new ChromeDriver(options);
			} 
			
			else if (browser.equalsIgnoreCase("firefox")) {
				DesiredCapabilities caps = new DesiredCapabilities();
				FirefoxProfile profile = new FirefoxProfile();
				profile.setPreference("intl.accept_languages", "de");
				caps.setCapability(FirefoxDriver.PROFILE, profile);

				System.setProperty("webdriver.gecko.driver", Constants.FIREFOX_DRIVER_PATH_WINDOW);
				driver = new FirefoxDriver(caps);
			} 
			
			else if (browser.equalsIgnoreCase("safari")) {
				driver = new SafariDriver();
			}
		}

		else if (platform.equalsIgnoreCase("mac")) {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH_MAC);
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", Constants.FIREFOX_DRIVER_PATH_MAC);
				driver = new FirefoxDriver();
			}
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);// implicit wait

		if (!lang.equalsIgnoreCase("en"))
		{
			driver.get("https://" + lang + ".venngage.beer");
		}
		else
		{
			driver.get(Constants.BASE_URL);
		}
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
	}

}
