package com.pom.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.supermarket.utilities.GeneralUtility;
import com.supermarket.constants.Constants;

public class ManageLocation {
      WebDriver driver;
      GeneralUtility general;
      
@FindBy(xpath="//i[@class='nav-icon fas fa-map-marker']")
WebElement manageloc;
@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
WebElement newbtn;
@FindBy(xpath="//select[@name='country_id']")
public
WebElement countrydrop;
@FindBy(xpath="//select[@name='state_id']")
public
WebElement statedrop;
@FindBy(xpath="//input[@name='location']")
WebElement location;
@FindBy(xpath="//input[@name='delivery']")
WebElement delivery;
@FindBy(xpath="//button[@name='create']")
WebElement savebtn;
@FindBy(xpath="//button[@class='close']")
public
WebElement alertclose;
@FindBy(xpath="//a[@class='btn btn-default btn-fix']")
public
WebElement cancelbtn;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
WebElement alerttext;
@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss'][1]")
public
WebElement editbtn;
@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss'][1]")
WebElement deletebtn;
@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
WebElement searchbtn;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
WebElement editalert;
@FindBy(xpath="//button[@name='update']")
WebElement updatebtn;

    public void createNew() {
	       manageloc.click();
	       newbtn.click();
	
}
     public String locationAndDeliverdata(String loc, String deliverycharge) {
             location.sendKeys(loc);
 	         delivery.sendKeys(deliverycharge);
             savebtn.click();
 	         return alerttext.getText();
 	     

      
}
     public String edit(String locationedit,String editdelivery ) {
    	 location.clear();
    	 location.sendKeys(locationedit);
    	 delivery.clear();
    	 delivery.sendKeys(editdelivery);
    	 updatebtn.click();
    	 return editalert.getText();
    	 
    
     }
 	public ManageLocation(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
}
