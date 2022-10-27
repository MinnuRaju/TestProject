package com.pom.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.supermarket.utilities.GeneralUtility;
import com.supermarket.constants.Constants;

public class ManageOrderPage {
	WebDriver driver;
	GeneralUtility general;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-shopping-basket']")
	WebElement manageorder;
	@FindBy(xpath="//a[@class='btn btn-block btn-outline-info btn-sm']")
	WebElement view;
	@FindBy(xpath="//div[@class='col text-left']")
	WebElement orederId;
	@FindBy(xpath="//a[@class='btn btn-success btn-sm'][1]")
	WebElement changestatus;
	@FindBy(xpath="//a[@class='btn btn-default']")
	WebElement back;
	@FindBy(xpath="//select[@id='status']")
	public
	WebElement updatedrop;
	@FindBy(xpath="//button[@name='Update_st'][1]")
	public
	WebElement updatebtn;
	@FindBy(xpath="//div[@class='col text-left']")
	WebElement textmessage;
	@FindBy(xpath="//a[@class='btn btn-primary btn-sm'][1]")
	public
	WebElement changedeliverydate;
	@FindBy(xpath="//input[@class='jquery-datepicker__input datepicker1']")
	public
	WebElement deliverydate;
	
	
	
	
   public void manageOrder() {
	   manageorder.click();
	   view.click();
	   back.click();	
	  
   }
   public void changeStatus() {
	   changestatus.click();
   }
   
  
   
      
   
   public ManageOrderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	

}
