package com.supermarket.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pom.supermarket.pages.LoginPage;
import com.pom.supermarket.utilities.DataProviderUtility;
import com.pom.supermarket.utilities.ExcelUtil;
import com.pom.supermarket.utilities.GeneralUtility;
import com.supermarket.constants.Constants;
import com.supermarket.extenreport.TestListener;



public class LoginTestCase extends BaseClass {
     
	
	 GeneralUtility general;
	 ExcelUtil excel;
	 LoginPage loginp;
	 ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

	 
@Test(description="validate the login page with valid credentails")
	  public void validateWithValidCredentials() throws IOException {
	       excel= new ExcelUtil();
		   loginp=new LoginPage(driver);
		   extentTest.get().log(Status.PASS, "LOGIN TO THE APPLICATION");
		   loginp.clearUsernameAndPassword();
		   loginp.login(excel.readData(0, 1 ),excel.readData(1, 1));
		   Assert.assertEquals(loginp.getTextMessage(), Constants.expectedTextMessage);
		   extentTest.get().log(Status.PASS, "TEST PASS");
		  }

		   

	 
 @Test(dataProvider="loginData",dataProviderClass=DataProviderUtility.class,enabled=false)
		   public void validateWithInvalidCredentials(String username,String password) {
	        loginp=new LoginPage(driver);
	        loginp.clearUsernameAndPassword();
	        loginp.login(username, password);
	        Assert.assertEquals(loginp.getErrorMessage(),Constants.expectedErrorMessage);
	 
	
 }
 
}
