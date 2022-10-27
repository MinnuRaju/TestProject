package com.supermarket.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pom.supermarket.pages.LoginPage;
import com.pom.supermarket.pages.ManageUserPage;
import com.pom.supermarket.utilities.ExcelUtil;
import com.pom.supermarket.utilities.GeneralUtility;
import com.supermarket.constants.Constants;
import com.supermarket.extenreport.TestListener;

import junit.framework.Assert;

public class ManageUserTest extends BaseClass {
	WebDriver diver;
	GeneralUtility general;
	ExcelUtil excel;
	LoginPage login;
	ManageUserPage muser;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	
@Test(description="search manage user",enabled=true,priority=0)
   public void search() throws IOException, InterruptedException {
	excel=new ExcelUtil();
	login=new LoginPage(driver);
	extentTest.get().log(Status.PASS, "LOGIN TO THE APPLICATION");
	login.login(excel.readData(0, 1), excel.readData(1, 1));
	muser=new ManageUserPage(driver);
	muser.searchuser(excel.readData(19, 1), excel.readData(20, 1),excel.readData(21, 1));
	Thread.sleep(3000);
	general=new GeneralUtility();
	general.selectByValue(muser.status, Constants.manageuserstatus);
	general.clickCommand(muser.searchbtn);
	//String text=muser.tableTest(1, 1, excel.readData(19, 1));
	//Assert.assertEquals(text, excel.readData(19, 1));
	general.clickCommand(muser.resetbtn);
	extentTest.get().log(Status.PASS, "TEST PASS");

	
}
@Test(description="Validate the password",priority=1)
  public void passwordValidation() {
	muser=new ManageUserPage(driver);
	Assert.assertEquals(muser.passwordView(), Constants.passwordtext);

	
	
}
  
	

}
