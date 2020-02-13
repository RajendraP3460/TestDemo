package testscripts;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoProperties {
	
	/*DemoProperties () throws Exception{
		
		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\application.properties");
		obj.load(objfile);
	}*/
	
	public String baseURL = "http://demo.guru99.com/test/guru99home/";
	public WebDriver driver;
	String driverPath = "C:\\Automation\\Selenium\\Latest_Dirvers\\chromedriver.exe";
	
  //@Test
  public void f() throws Exception {
	  
	    Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\application.properties");
		obj.load(objfile);
	    System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseURL);
		
		// Nagigate to link Mobile Testing and Back		
	    driver.findElement(By.xpath(obj.getProperty("MobileTesting"))).click();							
	    driver.navigate().back();			
	    // Enter Data into Form		
	    driver.findElement(By.id(obj.getProperty("EmailTextBox"))).sendKeys("testguru99@gmail.com");									
	    driver.findElement(By.id(obj.getProperty("SignUpButton"))).click();
	    driver.close();
	 
  }
}
