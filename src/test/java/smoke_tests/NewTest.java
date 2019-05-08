package smoke_tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import utils.*;

public class NewTest {
  @Test
  public void f() {
	  System.out.println(Utils.getValueFromPropertiesFile("browser"));
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

}
