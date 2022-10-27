package com.pom.supermarket.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.supermarket.utilities.GeneralUtility;

public class ManageUserPage {
	WebDriver driver;
	GeneralUtility general;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-user']")
	WebElement manageuser;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement search;
	@FindBy(xpath="//input[@name='un']")
	WebElement name;
	@FindBy(xpath="//input[@name='ut']")
	WebElement email;
	@FindBy(xpath="//input[@name='ph']")
	WebElement phno;
	@FindBy(xpath="//select[@name='st']")
	public
	WebElement status;
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-danger']")
	public
	WebElement searchbtn;
	@FindBy(xpath="//a[@class='btn btn-default btn-fix']")
	public
	WebElement resetbtn;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr")
	List<WebElement> rElement;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td")
	List<WebElement> cElement;
	String tPath="//table[@class='table table-bordered table-hover table-sm']/tbody";
	@FindBy(xpath="//i[@class='fa fa-angle-double-down'][1]")
	WebElement passwordbtn;
	@FindBy(xpath="//div[@class='profile-info-name'][1]")
	WebElement passworddisplay;
	@FindBy(xpath="//span[@class='badge bg-success'][1]")
	WebElement activebtn;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmsg;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-success btncss']")
	WebElement statuschangebtn;
	@FindBy(xpath="//button[@class='close']")
	WebElement alertclosebtn;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmsg1;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-success btncss'][1]")
	WebElement deletebtn;
	

	
	
	public void searchuser(String manusername,String useremail, CharSequence userphno) {
		manageuser.click();
		search.click();
		name.sendKeys(manusername);
		email.sendKeys(useremail);
		phno.sendKeys(userphno);
	}
	public String tableTest(int rowstart,int columnstart,String expected) {
		general=new GeneralUtility();
		return general.tableIteration(driver, rElement, cElement, rowstart, columnstart, expected, tPath);
		
   }
   public String passwordView() {
	   passwordbtn.click();
	   return passworddisplay.getText();
	   
	   
   }
	
	public ManageUserPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
}
