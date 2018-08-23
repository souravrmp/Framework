package com.test.utilityclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;



public class BaseLib {
 public WebDriver driver;
 
	@BeforeMethod
	@Parameters({"browser"})
	public void setup(String browser){
		if(browser.equalsIgnoreCase("chrome")){
			String chromekey=ReadProp.readData("c_key");
			String chromevalue=ReadProp.readData("c_value");
		System.setProperty(chromekey,chromevalue);
		driver= new ChromeDriver();
		}
		if(browser.equalsIgnoreCase("firefox")){
			String firefoxkey = ReadProp.readData("f_key");
			String firefoxvalue = ReadProp.readData("f_value");
			System.setProperty(firefoxkey,firefoxvalue);
			driver= new FirefoxDriver();
			
			}
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
                
                driver.get(ReadProp.readData("url"));
	}
	   @AfterMethod 
	   public void teardown(ITestResult result){
		   String filename=result.getMethod().getMethodName();
		   if(result.isSuccess()){
			   Reporter.log(filename+" : is passed", true);
		   }
		   else{
			   ScreenShotlib scr= new ScreenShotlib(); 
			   scr.takeScreenshot(driver, filename);
		   }
		   //driver.close();
	   }
}

