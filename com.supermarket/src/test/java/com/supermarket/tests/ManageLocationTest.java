package com.supermarket.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pom.supermarket.pages.LoginPage;
import com.pom.supermarket.pages.ManageLocation;
import com.pom.supermarket.utilities.ExcelUtil;
import com.pom.supermarket.utilities.GeneralUtility;
import com.supermarket.constants.Constants;
import com.supermarket.extenreport.TestListener;

import junit.framework.Assert;

public class ManageLocationTest extends BaseClass {
	WebDriver diver;
	GeneralUtility general;
	ExcelUtil excel;
	LoginPage login;
	ManageLocation mloc;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	
@Test(description="validate new location created",enabled=true,priority=0)	
	public void createNewLocation() throws IOException {
		excel=new ExcelUtil();
		login=new LoginPage(driver);
		extentTest.get().log(Status.PASS, "LOGIN TO THE APPLICATION");
		login.login(excel.readData(0, 1), excel.readData(1, 1));
	    mloc=new ManageLocation(driver);
	    mloc.createNew();
	    general=new GeneralUtility();
	    general.selectByVisibletext(mloc.countrydrop, Constants.countrydrop);
	    general.selectByVisibletext(mloc.statedrop, Constants.statedrop);
	    Assert.assertEquals( mloc.locationAndDeliverdata(excel.readData(22, 1), excel.readData(23, 1)), Constants.locationalertsuccess);
	    general.clickCommand(mloc.alertclose);
	    general.clickCommand(mloc.cancelbtn);
	    extentTest.get().generateLog(Status.PASS, "TEST PASS");
		
	}

@Test(description="Validate edited location",enabled=true,priority=1)
   public void editlocationdetails() throws IOException{
	excel=new ExcelUtil();
    mloc=new ManageLocation(driver);
    general=new GeneralUtility();
    general.clickCommand(mloc.editbtn);
    general.selectByVisibletext(mloc.countrydrop, Constants.countrydrop);
    general.selectByVisibletext(mloc.statedrop, Constants.statedropedit);
    Assert.assertEquals(mloc.edit(excel.readData(24, 1), excel.readData(25, 1)), Constants.locationalertedit);
	 
}

@Test(description="Validate the search result",priority=2,enabled=true)
   public void search() throws IOException, InterruptedException {
	  excel=new ExcelUtil();
	  general=new GeneralUtility();
	  general.clickCommand(mloc.search);
	  general.selectByVisibletext(mloc.countrydrop, Constants.countrydrop);
	  Thread.sleep(3000);
	  general.selectByVisibletext(mloc.statedrop, Constants.statedrop);
      mloc.searchItem(excel.readData(26, 1));
      String text=mloc.tableTest(1, 1, excel.readData(26, 1));
      Assert.assertEquals(text, excel.readData(26, 1));
      general.clickCommand(mloc.resetsearch);
      
	
}

@Test(description="Validate the delete item",enabled=true,priority=3)   
    public void delete() {
       mloc=new ManageLocation(driver);
       Assert.assertEquals(mloc.deleteItem(), Constants.deletelocalertmsg);

      
      
      
	
	
}

}
