package com.supermarket.tests;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pom.supermarket.pages.LoginPage;
import com.pom.supermarket.pages.Managepage;
import com.pom.supermarket.utilities.ExcelUtil;
import com.pom.supermarket.utilities.FileUploadUtil;
import com.pom.supermarket.utilities.GeneralUtility;
import com.supermarket.constants.Constants;
import com.supermarket.extenreport.TestListener;

import junit.framework.Assert;

public class ManagePageTest extends BaseClass {
	GeneralUtility general;
	ExcelUtil excel;
	LoginPage loginp;
	Managepage mpage;
	FileUploadUtil fileup;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

	
@Test(enabled=true,description="Validate the search",retryAnalyzer=com.pom.supermarket.utilities.RetryAnalyserUtil.class,groups="sanity",priority=0)	
   public void search() throws IOException, InterruptedException {
	   excel= new ExcelUtil();
	   loginp=new LoginPage(driver);
	   extentTest.get().log(Status.PASS, "LOGIN TO THE APPLICATION");
	   loginp.login(excel.readData(0, 1 ),excel.readData(1, 1));
	   mpage=new Managepage(driver);
	   mpage.searchMoreInfo(excel.readData(2, 1));
	   String text= mpage.tableTest(1, 1, excel.readData(2, 1));
	   Assert.assertEquals(text, excel.readData(2, 1));
	   extentTest.get().log(Status.PASS, "PASS");

	   
}

@Test(description="Validate new item created",priority=1,enabled=true)
    public void createItem() throws IOException, AWTException, InterruptedException {
	 excel= new ExcelUtil();
	 mpage= new Managepage(driver);
	 mpage.createNew(excel.readData(3, 1),excel.readData(4, 1),excel.readData(5, 1));
	 fileup=new FileUploadUtil();
	// fileup.fileUploadByRobotClass(Constants.path,mpage.choosefile);
	 Thread.sleep(3000);
	 fileup.fileUploadBySendkeys(mpage.choosefile, Constants.path);
	 general=new GeneralUtility();
	 general.scroll(driver);
	 Thread.sleep(3000);
	 general.clickCommand(mpage.save);
	 driver.navigate().back();
	 Assert.assertEquals(mpage.createAlert(), Constants.savealertmsg);
	 general.clickCommand(mpage.cancelsavebtn);
	 
}

@Test(description="Validate edit",priority=2,enabled=true)
    public void editItem() throws IOException, InterruptedException {
	 excel= new ExcelUtil();
	 mpage= new Managepage(driver);
	 mpage.EditItem(excel.readData(6, 1),excel.readData(7, 1),excel.readData(8, 1));
	 Thread.sleep(3000);
	 fileup=new FileUploadUtil();
	 fileup.fileUploadBySendkeys(mpage.choosefile,Constants.path);
	 general=new GeneralUtility();
	 general.scroll(driver);
	 Thread.sleep(3000);
	 general.clickCommand(mpage.save);
	 Assert.assertEquals(mpage.getEditalert(), Constants.editalert);
}

@Test(description="Validate delete",priority=3,enabled=true)
     public void deleteItem() throws InterruptedException {
	 mpage= new Managepage(driver);
	 mpage.deleteItem();
	 Thread.sleep(3000);
	 general=new GeneralUtility();
	 general.alertAccept(driver);
	 Assert.assertEquals(mpage.getTextdeleteAlert(), Constants.deletealert1); 
	
	 
	 
}


	
	

}
