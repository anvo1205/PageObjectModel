package utils;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import data.*;

public class Utils extends BaseClass{
	
	public static String getValueFromPropertiesFile(String key)
	{
		try {
			pros = new Properties();
			FileInputStream configureFile = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/data/config.properties");
			pros.load(configureFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pros.getProperty(key);
	}
	
	/**
	 * Method name	: captureWebElement
	 * Description	: This method will use driver to find an element 
	 * Accept		: By element
	 * Return		: WebElement	
	 */	
	public static WebElement captureWebElement(By element)
	{
		return driver.findElement(element);
	}
	
	/**
	 * Method name	: captureWebElements
	 * Description	: This method will use driver to find a list of elements
	 * Accept		: By element
	 * Return		: List<WebElement>	
	 */	
	public static List<WebElement> captureWebElements(By element)
	{
		return driver.findElements(element);
	}
	
	/**
	 * Method name	: moveMouseToElement
	 * Description	: This method will hover mouse to indicated element
	 * Accept		: By element
	 * Return		: void	
	 */	
	public static void moveMouseToElement(WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	/**
	 * Method name	: clickElement
	 * Description	: This method will wait until element is visible then click element
	 * Accept		: By element
	 * Return		: void	
	 */	
	public static void clickElement(WebElement element)
	{
		waitUntilElementIsVisible(element);
		element.click();
	}
	
	/** 
	 * Method name	: inputValueIntoTextbox
	 * Description	: This method will clear existing value and input new value into text box
	 * Accept		: By element, String value
	 * Return		: void	
	 */	
	public static void inputValueIntoTextbox(WebElement txt, String value)
	{
		waitUntilElementIsVisible(txt);
		if (!txt.getAttribute("value").isEmpty() || !txt.getText().isEmpty())
		{
			txt.clear();
		}
		txt.sendKeys(value);
	}
	
	/** 
	 * Method name	: waitUntilElementIsVisible
	 * Description	: This method will wait until element is visible or timeout
	 * Accept		: By element
	 * Return		: void	
	 */	
	public static void waitUntilElementIsVisible(WebElement element)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch (NoSuchElementException e)
		{
			System.out.println("Element is not visible");
		}	

	}
	
	
	
	/** 
	 * Method name	: waitUntilElementInVisible
	 * Description	: This method will wait until element is invisible or timeout
	 * Accept		: By element
	 * Return		: void	
	 */	
	public static void waitElementInvisible(WebElement element) {
		try
		{
			wait.until(ExpectedConditions.invisibilityOf(element));
		}
		catch (NoSuchElementException e)
		{
			System.out.println("Element is visible");
		}	
	}
	
	/**Method name	: waitUntilElementInVisible
	 * Description	: This method will wait until element is invisible or timeout defined by test
	 * @param By
	 * @param int	
	 */	
	public static void waitElementInvisible(WebElement element, int timeoutInSeconds) {
		wait = new WebDriverWait(driver, timeoutInSeconds);
		try
		{
			wait.until(ExpectedConditions.invisibilityOf(element));
		}
		catch (NoSuchElementException e)
		{
			System.out.println("Element is visible");
		}	
		
	}
	
	/** 
	 * Method name	: generateRandomEmail
	 * Description	: This method will generate a random email using current date time
	 * Accept		: void
	 * Return		: String (email)	
	 */	
	public static String generateRandomEmail(String prefix)
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddhhmmss");
		String dateAsString = simpleDateFormat.format(new Date());
		if (prefix.isEmpty())
		{
			return "test" + dateAsString + "@autotest.com";
		}
		else
		{
			return prefix + dateAsString + "@autotest.com";
		}
	}
	
	/** Method name	: generateRandomInteger
	 * Description	: This method will return an integer value within a range
	 * @param		: int
	 * @param		: int
	 * Return		: int (random value)
	 */	
	public static int generateRandomInteger(int min, int max)
	{
		Random r = new Random();
		return r.nextInt(max - min + 1) + min;
	}

	/** 
	 * Method name	: selectDropDownListValue
	 * Description	: This method will select an option from dropdown list by text displays
	 * Accept		: By (element), String (tagName of options), String (text value)
	 * Return		: void
	 */	
	public static void selectDropDownListValue(WebElement ddl, String tagName, String value) {
		List<WebElement> listItems = ddl.findElements(By.tagName(tagName));
		for (WebElement item: listItems)
		{
			if (item.getText().equalsIgnoreCase(value))
			{
				item.click();
			}
		}	
	}
	
	/** 
	 * Method name	: getDropDownListItems
	 * Description	: This method will get all list options from a dropdown
	 * Accept		: By (element), String (tagName of options)
	 * Return		: void
	 */	
	public static List<String> getDropDownListItems(WebElement ddl, String tagName) {
		List<String> list = new ArrayList<String>();
		List<WebElement> listItems = ddl.findElements(By.tagName(tagName));
		for (WebElement item: listItems)
		{
			list.add(item.getText());
		}	
		return list;
	}
	
	/**
	 * Method name	: readXmlNodeById
	 * Description	: This method will read the content of an xml node by id
	 * Accept		: String (file path including file name, id of xml node)
	 * Return		: String (xml node content)
	 */	
	public static String readXmlNodeByTagname(String filePath, String tagName)
	{
		String result = "";
		try
		{
			File fXmlFile = new File(filePath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			Node node = doc.getElementsByTagName(tagName).item(0);
			result = node.getTextContent();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	/** 
	 * Method name	: scrollToElement
	 * Description	: This method will scroll the view to expected element
	 * Accept		: By (element)
	 * Return		: void
	 */	
	public static void scrollToElement(WebElement element) throws InterruptedException
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); 
	}
	
	/** 
	 * Method name	: dragAndDrop
	 * Description	: This method will drag and drop an element
	 * Accept		: By (element), int (x-axis), int (y-axis)
	 * Return		: void
	 */	
	public static void dragAndDropElement(WebElement element, int x, int y)
	{
		Actions action = new Actions(driver);
		action.dragAndDropBy(element, x, y);
	}
	
	/**
	 * This method will take the unixDate as long value, then convert it to calendar date
	 * @param long: unixDate
	 * @return date: calendar date
	 * */
	public static Date convertUnixTimeToCalendarDate(long unixDate)
	{
		return new Date(unixDate * 1000);
	}
	
	/**
	 * This method will add a number of days to calendar date
	 * @param Date: current date
	 * @param int: number of days
	 * @return date: calendar date
	 * */
	public static Date addDays(Date date, int days) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		gc.add(Calendar.DATE, days);
		return gc.getTime();
	}
	
	/**
	 * This method converts a date to a string in provided format
	 * @param Date
	 * @param String
	 * @return String
	 * */
	public static String formatDateString(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	/**
	 * This method gets date only from date time value
	 * @param Long
	 * @return String
	 * */
	public static String getDateFromDateTime(Date date)
	{
		String[] dateTime = date.toString().split(" ");
		return dateTime[0] + dateTime[1] + dateTime[2] + dateTime[5];
	}
	
	/**
	 * This method gets length of an indicated month of a year
	 * @param int, int
	 * @return int
	 * */
	public static int getLengthOfMonth(int year, int month)
	{
		if (month > 12)
		{
			month -= 12;
			year += 1;
		}
		YearMonth ym = YearMonth.of(year, month);
		return ym.lengthOfMonth();
	}
	
	/**
	 * This method calculates the expected End Date of quarterly plan from indicated date
	 * @param Date
	 * @return Date
	 * */
	public static Date calculateExpectedEndDateQuarterlyPlan(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int monthIndex = cal.get(Calendar.MONTH);
		for (int i = 0; i < 3; i++)
		{
			int monthLength = YearMonth.of(year, ++monthIndex).lengthOfMonth();
			date = Utils.addDays(date, monthLength);
			if (monthIndex == 12)
			{
				monthIndex = 0;
				year++;
				
			}
		}
		return date;
	}

	/* Method name	: deleteFile
	 * Description	: This method will delete a file specified by filePath
	 * Accept		: String filePath
	 * Return		: void
	 */	
	public static boolean deleteFile(String filePath)
	{
		File f = new File(filePath);
		if (f.exists()){
			return f.delete();
		 }
		else
		{
			return false;
		}
	}
	
	/** Method name	: verifyTextElement
	 * Description	: This method will compare actual text of an element with expected value
	 * Accept		: By, String
	 * Return		: boolean
	 */	
	public static boolean verifyTextElement(WebElement element, String textValue)
	{
		String actualValue = element.getText();
		if(!actualValue.equals(textValue))
		{
			System.out.println("Text value is not correct!");
			System.out.println("Actual value: " + actualValue);
			System.out.println("Expected value: " + textValue);
			return false;
		}
		return true;
	}
	
	/**Method name	: getDifferenceImage
	 * Description	: This method will compare 2 images pixel by pixel and produce the difference
	 * Accept		: String (source and destination images)
	 * Return		: boolean (true if there is no difference)
	 * @throws IOException 
	 */		
	public static boolean compareTwoImages(String srcFilePath, String desFilePath) throws IOException {
	    boolean result = true;
	    
	    //Read file to buffer image
		BufferedImage img1 = null;
		BufferedImage img2 = null;
		
		try {
			File src = new File(srcFilePath);
			File des = new File(desFilePath);
			
			//Read and store images in RAM
			img1 = ImageIO.read(src);
			img2 = ImageIO.read(des);
		}
		catch(Exception e)
		{
			System.out.println("File not found");;
		}
	    
		//Convert images to pixel arrays...
	    int w = img1.getWidth();
	    int h = img1.getHeight(); 
	    int highlight = Color.MAGENTA.getRGB();
	    int[] p1 = img1.getRGB(0, 0, w, h, null, 0, w);
	    int[] p2 = img2.getRGB(0, 0, w, h, null, 0, w);
	    
	    // compare img1 to img2, pixel by pixel. If different, highlight img1's pixel...
	    for (int i = 0; i < p1.length; i++) {
	        if (p1[i] != p2[i]) {
	            p1[i] = highlight;
	            System.out.println("different at pixel " + p1[i]);
	            result = false;
	        }
	    }
	    //Save img1's pixels to a new BufferedImage
	    //(May require TYPE_INT_ARGB)
	    if (!result)
	    {
	    	BufferedImage difImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		    difImg.setRGB(0, 0, w, h, p1, 0, w);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddhhmmss");
			String dateAsString = simpleDateFormat.format(new Date());
		    ImageIO.write(difImg, "png", new File(Constants.DOWNLOAD_DESTINATION +  "/dif " + dateAsString + ".png"));
	    }
	    return result;
	}

	/**Method name	: compare2JSONObjectsDifferentOrder
	 * Description	: This method will sort then compare 2 json objects
	 * Accept		: JSONObject
	 * Return		: boolean (true if there is no difference)
	 * @throws JSONException 
	 */			
	public static boolean compare2JSONObjectsDifferentOrder(JSONObject expected, JSONObject actual) throws JSONException
	{
		JSONArray actualKeys = actual.names();
		JSONArray keys = expected.names();
		if (actualKeys.length() != keys.length())
		{
			System.out.println("Lengths are different!");
			System.out.println("expected: " + expected);
			System.out.println("actual: " + actual);
			return false;
		}
		else
		{
			for (int i = 0; i < keys.length (); i++) 
			{
				   String key = keys.getString(i);
				   String expectedValue = expected.get(key).toString();
				   String actualValue = actual.get(key).toString();
				   if (!actualValue.equalsIgnoreCase(expectedValue))
				   {
					   System.out.println("Values are different:");
					   System.out.println("Actual: " + actualValue);
					   System.out.println("Expected: " + expectedValue);
					   return false;
				   }
				}
			return true;
		}
	}
	
	/**Method name	: takeScreenshot
	 * Description	: This method will take screenshot of current screen and save it to project directory
	 * Accept		: fileName
	 * Return		: void
	 * @throws IOException 
	 */		
	public static void takeScreenshot(String fileName) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/screenshots/" + fileName + ".png"));
	}
	
}
