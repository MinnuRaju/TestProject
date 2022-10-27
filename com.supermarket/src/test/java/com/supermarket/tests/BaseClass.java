package com.supermarket.tests;

import org.testng.annotations.Test;

import com.pom.supermarket.utilities.GeneralUtility;
import com.supermarket.extenreport.ExtentManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseClass {
	  WebDriver driver;
	  GeneralUtility gnrlobj=new GeneralUtility();
	  public static Properties po;
	  
  public static void testBasic() throws IOException {
		  po=new Properties();
		  FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resource\\PropertyFile\\configuration.properties");
		  po.load(file);		  
	  }
  
  @BeforeMethod(alwaysRun=true)
  public void beforeMethod() {
  }

  @AfterMethod(alwaysRun=true)
  public void afterMethod(ITestResult result) throws IOException {
	            Date d=new Date();
		        String date=d.toString().replace(":","_" ).replace(" ", "_")+".png";  
		        if(ITestResult.FAILURE==result.getStatus()) {                                                                                    //get status of test
		           TakesScreenshot ts=(TakesScreenshot)driver;
					File source=ts.getScreenshotAs(OutputType.FILE);
					FileHandler.copy(source, new File("./ScreenShots/"+result.getName()+date));               //
			     	System.out.println("screenshot taken");
		        }
					
				
	  
  }
  
  @Parameters({"browser"})
  @BeforeClass(groups="sanity")
  public void beforeClass(String browser) throws IOException {
	  testBasic();  
	driver=gnrlobj.browserLaunch(browser, po.getProperty("URL"));
  }
  
  

  @AfterClass(groups="sanity",alwaysRun=true)
  public void afterClass() {
	//  driver.quit();
}

  @BeforeTest(alwaysRun=true)
  public void beforeTest() {
  }

  @AfterTest(alwaysRun=true)
  public void afterTest() {
	  
  }

  @BeforeSuite(alwaysRun=true)
  public void createReport(final ITestContext testContext) {
	  ExtentManager.createInstance().createTest(testContext.getName(), "message");
  }


  @AfterSuite(alwaysRun=true)
  public void afterSuite() {
  }

}
