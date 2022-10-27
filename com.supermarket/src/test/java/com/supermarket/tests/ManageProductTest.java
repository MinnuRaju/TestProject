package com.supermarket.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pom.supermarket.pages.LoginPage;
import com.pom.supermarket.pages.ManageproductPage;
import com.pom.supermarket.utilities.ExcelUtil;
import com.pom.supermarket.utilities.FileUploadUtil;
import com.pom.supermarket.utilities.GeneralUtility;
import com.supermarket.constants.Constants;
import com.supermarket.extenreport.TestListener;

import junit.framework.Assert;

public class ManageProductTest extends BaseClass {
	
	GeneralUtility general;
	ExcelUtil excel;
	LoginPage loginp;
	ManageproductPage mproduct;
	FileUploadUtil filepload;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

	
@Test(description="Check stock status change",priority=0,enabled=true)
    public void changeStatus() throws IOException {
	     excel=new ExcelUtil();
	     loginp=new LoginPage(driver);
		 extentTest.get().log(Status.PASS, "LOGIN TO THE APPLICATION");
	     loginp.login(excel.readData(0, 1), excel.readData(1, 1));
	     mproduct=new ManageproductPage(driver);
	     Assert.assertEquals(mproduct.stockStatusChange(), Constants.alertmessage);
	     extentTest.get().log(Status.PASS, "PASS");
}
@Test(description=" validate Status and featured button ",enabled=true,priority=1)
    public void StatusAndFeaturedButtonClick() throws IOException {
	     mproduct=new ManageproductPage(driver); 
	     mproduct.StatusFeaturedButton();
        // Assert.assertEquals(mproduct.StatusFeaturedButton(), Constants.alertmessagetext);   
	
}
@Test(description="Validate new data created",enabled=true,priority=2)
   public void createNewItem() throws IOException, InterruptedException {
	    excel=new ExcelUtil();
        mproduct=new ManageproductPage(driver);
        mproduct.createnew(excel.readData(9, 1),excel.readData(10, 1));
        general=new GeneralUtility();
        general.selectByValue(mproduct.category, Constants.categorydropdown);
        Thread.sleep(3000);
        general.selectByVisibletext(mproduct.subcategory, Constants.subcategorydropdown);
        general.selectByVisibletext(mproduct.group, Constants.groupdropdown);
        general.clickCommand(mproduct.radiobtnpricetype);
        general.selectByVisibletext(mproduct.minpiece, Constants.minimumpiece);
        mproduct.createnewfields(excel.readData(11, 1), excel.readData(12, 1), excel.readData(13, 1), excel.readData(14, 1), excel.readData(15, 1));
        Thread.sleep(3000);
        general.scrollUptoDown(driver);
     //   general.clickCommand(mproduct.checkbox);
    //  general.sendKeysCommand(mproduct.description, Constants.description);
        mproduct.descriptionField(excel.readData(16, 1));
        general.scroll(driver);
        Thread.sleep(3000);
        general.clickCommand(mproduct.nocheckbox);
        Thread.sleep(3000);
        filepload=new FileUploadUtil();
        filepload.fileUploadBySendkeys(mproduct.choosefile1, Constants.path);
        Thread.sleep(3000);
        filepload.fileUploadBySendkeys(mproduct.choosefile2, Constants.pathimage);
        general.clickCommand(mproduct.nofeatured);
        Assert.assertEquals(mproduct.getText(), Constants.alertmessagenew);
        general.clickCommand(mproduct.cancel);
        
 
}
@Test(description="validate delete",enabled=false)
   public void deletefunction() throws IOException, InterruptedException{
	  excel=new ExcelUtil();
      mproduct=new ManageproductPage(driver);
      Thread.sleep(3000);
      general=new GeneralUtility();
      general.alertAccept(driver);
      Assert.assertEquals(mproduct.delete(), Constants.deletealert);
    
}

@Test(description="search manage product",enabled=false)
   public void search() throws IOException, InterruptedException {
	  excel=new ExcelUtil();
	 /// loginp=new LoginPage(driver);
     // loginp.login(excel.readData(0, 1), excel.readData(1, 1));
      mproduct=new ManageproductPage(driver);
      mproduct.search(excel.readData(17, 1), excel.readData(18, 1));
      general=new GeneralUtility();
      Thread.sleep(3000);
      general.selectByVisibletext(mproduct.categorydp, Constants.manageproductcategory);
      Thread.sleep(3000);
      general.selectByVisibletext(mproduct.subcat, Constants.manageproductsubcat);
      general.clickCommand(mproduct.searchbtn);
      String text= mproduct.tableTest(1, 1, excel.readData(17, 1));
      Assert.assertEquals(text, excel.readData(17, 1));
      
     
      

	
	
	
	
}


	
}
