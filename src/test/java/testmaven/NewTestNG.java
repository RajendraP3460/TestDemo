package testmaven;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTestNG {
	
	public String baseURL = "http://demo.guru99.com/test/newtours/";
	public WebDriver driver;
	String driverPath = "C:\\Automation\\Selenium\\Latest_Dirvers\\chromedriver.exe";
	
  @BeforeTest
  public void beforeTest() {
	  
	    System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	  }
  
  @Test
  public void verifyHomepageTitle() {
	  
	  System.out.println("launching Application");
	  driver.get(baseURL);
	  System.out.println(driver.get(baseURL));
	  System.out.println("After Capturing the Title");
	  String expectedTitle = "Welcome: Mercury Tours";
	  String actualTitle = driver.getTitle();
	  Assert.assertEquals(actualTitle, expectedTitle);
	  System.out.println("Verified Title of Application");
	  
  }
 

  @AfterTest
  public void afterTest() {
	  
	  driver.close();
  }

}
