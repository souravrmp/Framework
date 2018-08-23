package com.test.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPo {
@FindBy(id="login")
private WebElement username;
@FindBy(id="password")
private WebElement password;
@FindBy(xpath="//button[text()='Log in']")
private WebElement LoginBtn;
@FindBy(xpath="//p[@class='alert alert-danger']")
private WebElement alertsms;

public LoginPo(WebDriver driver){
	PageFactory.initElements(driver,this);
}
  public void  loginPage(String name,String pass)
  {    
	  username.sendKeys(name);
	  password.sendKeys(pass);
	  LoginBtn.click();
	  
	 
  }
  public void invalidConfirmation(){
	  String txtsms = alertsms.getText();
	System.out.println(txtsms);
  }

	}


