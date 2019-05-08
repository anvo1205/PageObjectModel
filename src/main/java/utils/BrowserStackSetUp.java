package utils;
import com.browserstack.local.Local;

import data.Constants;

import java.io.FileReader;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BrowserStackSetUp{
    private Local l;
	public static WebDriver driver;
	public static Wait<WebDriver> wait;
	public static Properties pros;

    @BeforeMethod
    @Parameters(value={"config", "environment"})
    public void setUp(String config_file, String environment) throws Exception {
        JSONParser parser = new JSONParser();
//      String configFilePath = "/Users/QA/Desktop/clonedMaster/automated-tests/src/test/java/data/single.conf.json";
      String configFilePath = System.getProperty("user.dir") + "/src/main/java/data/" + "single.conf.json";
      JSONObject config = (JSONObject) parser.parse(new FileReader(configFilePath));
      JSONObject envs = (JSONObject) config.get("environments");

      DesiredCapabilities capabilities = new DesiredCapabilities();

      Map<String, String> envCapabilities = (Map<String, String>) envs.get(environment);
      Iterator it = envCapabilities.entrySet().iterator();
      while (it.hasNext()) {
          Map.Entry pair = (Map.Entry)it.next();
          capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
      }
      
      Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
      it = commonCapabilities.entrySet().iterator();
      while (it.hasNext()) {
          Map.Entry pair = (Map.Entry)it.next();
          if(capabilities.getCapability(pair.getKey().toString()) == null){
              capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
          }
      }

      String username = System.getenv("BROWSERSTACK_USERNAME");
      if(username == null) {
          username = (String) config.get("user");
      }

      String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
      if(accessKey == null) {
          accessKey = (String) config.get("key");
      }

      String app = System.getenv("BROWSERSTACK_APP_ID");
      if(app != null && !app.isEmpty()) {
        capabilities.setCapability("app", app);
      }

      if(capabilities.getCapability("browserstack.local") != null && capabilities.getCapability("browserstack.local") == "true"){
          l = new Local();
          Map<String, String> options = new HashMap<String, String>();
          options.put("key", accessKey);
          l.start(options);
      }
      driver = new RemoteWebDriver(new URL("http://"+username+":"+accessKey+"@"+config.get("server")+"/wd/hub"), capabilities);
    	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		//Set fluent wait
		wait = new FluentWait<WebDriver>(driver)							
				.withTimeout(Duration.ofSeconds(Constants.EXPLICIT_WAIT)) 			
				.pollingEvery(Duration.ofSeconds(Constants.EXPLICIT_WAIT)) 			
				.ignoring(NoSuchElementException.class);
		
		driver.get(Constants.BASE_URL);
}
    

    @AfterMethod(alwaysRun=true)
    public void tearDown() throws Exception {
    	driver.quit();
        if(l != null) l.stop();
    }
    
}
