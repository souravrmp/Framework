package com.test.utilityclass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;



public class ScreenShotlib {

	public void takeScreenshot(WebDriver driver,String filename){
		EventFiringWebDriver efw= new EventFiringWebDriver(driver);
		File srcfile=efw.getScreenshotAs(OutputType.FILE);
		File destfile=new File("./src/test/resources/ScreenShot/"+filename+".png");
		try {
			FileUtils.copyFile(srcfile, destfile);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
