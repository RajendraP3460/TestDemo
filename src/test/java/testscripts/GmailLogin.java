package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailLogin {
	
	public String baseURL = "https://www.google.co.in/";
	public WebDriver driver;
	String driverPath = "C:\\Automation\\Selenium\\Latest_Dirvers\\chromedriver.exe";
	
	  @BeforeTest
	  public void beforeTest() {
		  
		    System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		  }
  
	  //@Test
	  public void login() throws Exception {
		  
		  WebDriverWait wait=new WebDriverWait(driver, 20);
		  System.out.println("launching Application");
		  driver.get(baseURL);
		  Thread.sleep(2000);
		  driver.findElement(By.linkText("Sign in")).click();
		  
		  driver.findElement(By.xpath("//input[@autocomplete='username']")).sendKeys("rajendrap3460");
		  // $x("//span[contains(text(),'Next')]")
		  
		  try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Next')]")));
		  }catch (Exception e){
			  System.out.print(e.getMessage());
		  }
		  
		  driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		  
		  try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Next')]")));
		  }catch (Exception e){
			  System.out.print(e.getMessage());
		  }
		  
		  driver.findElement(By.xpath("//input[@autocomplete='current-password']")).sendKeys("Search!ng6");
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		  
		  
		  
	  }
	  
	  @	AfterTest
	  public void afterTest(){
		  driver.close();
	  }
	  
	  //@Test
	  public void testActions(){
		  
		  System.out.println("launching Amazon Application");
		  driver.get("https://www.amazon.com/");
		  
		  Actions a = new Actions(driver);
		  
		  a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("HELLO").doubleClick().build().perform();
		  
		  //a.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Hello, Sign in')]"))).build().perform();
		  
	  }
}
