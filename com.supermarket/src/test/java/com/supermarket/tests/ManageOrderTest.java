package com.supermarket.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pom.supermarket.pages.LoginPage;
import com.pom.supermarket.pages.ManageOrderPage;
import com.pom.supermarket.utilities.ExcelUtil;
import com.pom.supermarket.utilities.GeneralUtility;
import com.supermarket.constants.Constants;
import com.supermarket.extenreport.TestListener;

public class ManageOrderTest extends BaseClass {
	GeneralUtility general;
	LoginPage loginp;
	ExcelUtil excel;
	ManageOrderPage mpage;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

	
	
@Test(description="view order",priority=0)	
public void viewOrder() throws IOException {
	   excel= new ExcelUtil();
	   loginp=new LoginPage(driver);
	   extentTest.get().log(Status.PASS, "LOGIN TO THE APPLICATION");
	   loginp.login(excel.readData(0, 1 ),excel.readData(1, 1));
	   mpage=new ManageOrderPage(driver);
	   mpage.manageOrder();
	   extentTest.get().log(Status.PASS, "TEST PASS");

}

@Test(description="update status",priority=1,retryAnalyzer=com.pom.supermarket.utilities.RetryAnalyserUtil.class)
public void updateStatus() throws InterruptedException {
	Thread.sleep(3000);
	mpage=new ManageOrderPage(driver);
	mpage.changeStatus();
	general=new GeneralUtility();
	general.selectByVisibletext(mpage.updatedrop, Constants.manageorderchangestatus);
	general.clickCommand(mpage.updatebtn);
	driver.navigate().back();
	
	
	
	
	
	
}

}
