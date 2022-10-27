package com.pom.supermarket.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.supermarket.utilities.GeneralUtility;

public class Managepage {
	WebDriver driver;
	GeneralUtility generakobj;
	
	@FindBy(xpath="//a[@class='small-box-footer']")
	WebElement moreinfo;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement search;
	@FindBy(xpath="//input[@class='form-control']")
	WebElement title;
	@FindBy(xpath="//button[@name='Search']")
	WebElement searchbtn;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newbtn;
	@FindBy(xpath="//input[@name='title']")
	WebElement title1;
	@FindBy(xpath="//div[@class='note-editable card-block']")
	WebElement descrption;
	@FindBy(xpath="//input[@name='page']")
	WebElement page;
	@FindBy(xpath="//button[@class='btn btn-danger']")
	public
	WebElement save;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	public
	WebElement savealert;
	@FindBy(xpath="//a[@class='btn btn-default btn-fix']")
	public
	WebElement cancelsavebtn;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement edit;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement editalert;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement delete;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement deletealert;
	@FindBy(xpath="//a[@class='btn btn-default btn-fix']")
	public
	WebElement reset;
	@FindBy(xpath="//input[@name='main_img']")
	public
	WebElement choosefile;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr")
	List<WebElement> rElement;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td")
	List<WebElement> cElement;
	String tPath="//table[@class='table table-bordered table-hover table-sm']/tbody";
	@FindBy(xpath="//a[@class='btn btn-default btn-fix']")
	public
	WebElement resetbtnsearch;
	

	
	public void searchMoreInfo(String searchInput) {
		moreinfo.click();
		search.click();
		title.sendKeys(searchInput);
		searchbtn.click();
		resetbtnsearch.click();
		
		
	}
	public String tableTest(int rowstart,int columnstart,String expected) {
		generakobj=new GeneralUtility();
		return generakobj.tableIteration(driver, rElement, cElement, rowstart, columnstart, expected, tPath);
		
}

	
	public void createNew(String tiltle,String description,String page1){
		newbtn.click();
		title1.sendKeys(tiltle);
		descrption.sendKeys(description);
		page.sendKeys(page1);
		//save.click();
	}
	public String createAlert() {
		return savealert.getText();
	}
	
	public void EditItem(String Item1,String Item2,String Item3) {
		edit.click();
		title1.clear();
		title1.sendKeys(Item1);
		descrption.clear();
		descrption.sendKeys(Item2);
		page.clear();
		page.sendKeys(Item3);
		
	}
	public String getEditalert() {
		return editalert.getText();
	}
	
	
	public void deleteItem() {
		delete.click();
	}
	
	public String getTextdeleteAlert() {
		return(deletealert.getText());
	}
	
	public Managepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	

}
