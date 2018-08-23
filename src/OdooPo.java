package com.test.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class OdooPo {
	
@FindBy(xpath="//div[@class='o_apps']//a[4]")
private WebElement crmapp;

public OdooPo(WebDriver driver){
	PageFactory.initElements(driver,this);
}
public void crmSelect(){

 crmapp.click();
}
}
