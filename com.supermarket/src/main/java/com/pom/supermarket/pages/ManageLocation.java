package com.pom.supermarket.pages;

import java.util.List;

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
@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
public
WebElement search;
@FindBy(xpath="//input[@name='location']")
WebElement locationinput;
@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr")
List<WebElement> rElement;
@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td")
List<WebElement> cElement;
String tPath="//table[@class='table table-bordered table-hover table-sm']/tbody";
@FindBy(xpath="//button[@name='Search']")
WebElement searchbtnclick;
@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss'][1]")
WebElement delete;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
WebElement deletealert;
@FindBy(xpath="//a[@class='btn btn-default btn-fix']")
public
WebElement resetsearch;


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
 	public void searchItem(String locationin) {
 		locationinput.sendKeys(locationin);
 		searchbtnclick.click();
 	
 	}
 	public String deleteItem() {
 		delete.click();
 		general=new GeneralUtility();
 		general.alertAccept(driver);
 		return deletealert.getText();
 		
 	}
 	public String tableTest(int rowstart,int columnstart,String expected) {
		general=new GeneralUtility();
		return general.tableIteration(driver, rElement, cElement, rowstart, columnstart, expected, tPath);
		
}
}
