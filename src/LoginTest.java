package com.test.script;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.test.pageObject.LoginPo;
import com.test.pageObject.OdooPo;
import com.test.utilityclass.BaseLib;
import com.test.utilityclass.ExelUtilities;
import com.test.utilityclass.WaitStatementlib;

public class LoginTest extends BaseLib{
@Test
public void validLogin(){
	String name = ExelUtilities.readData("Sheet2",1,2);
	String pass = ExelUtilities.readData("Sheet2",1,3);
	
     System.out.println(name);
     System.out.println(pass);
	 LoginPo lp= new LoginPo(driver);
	 lp.loginPage(name,pass);
	 
	 OdooPo od = new OdooPo(driver);
	 WaitStatementlib wb= new WaitStatementlib();
	 wb.isleep(3);
	 String str=driver.getTitle();
	 String str2= ExelUtilities.readData("Sheet2",1,4);
	 
	 Assert.assertEquals(str, str2);
	 System.out.println("Home Page Title ");
	 if(str.equals(str2)){
		 System.out.println("Home Page Title Verified");
	 }
	 else
	 {
		 System.out.println("Home Page Tile Mismatch");
	 }
	 od.crmSelect();
	 
}
	
    @Test(priority=2)
	public void inValidLogin(){
	String name = ExelUtilities.readData("Sheet2",2,2);	
	String pass = ExelUtilities.readData("Sheet2",2,3);	
    LoginPo lp= new LoginPo(driver);
    lp.loginPage(name, pass);
    
    lp.invalidConfirmation();
    
	}
	
}

