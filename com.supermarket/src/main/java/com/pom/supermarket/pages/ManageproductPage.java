package com.pom.supermarket.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.supermarket.utilities.GeneralUtility;

public class ManageproductPage {
	WebDriver driver;
	GeneralUtility general;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-tasks']")
	WebElement manageproduct;
	@FindBy(xpath="//span[@class='badge bg-success']")
	WebElement yesbutton;
	@FindBy(xpath="//span[text()='Limited']")
	WebElement limited;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	public
	WebElement alert;
	@FindBy(xpath="//span[text()='Active']")
	WebElement activebutton;
	@FindBy(xpath="//span[@class='badge btn btn-xs bg-warning']")
	WebElement nobutton;
	@FindBy(xpath="//button[@class='close']")
	WebElement closebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement noalertmsg;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newbtn;
	@FindBy(xpath="//input[@name='title']")
	WebElement title;
	@FindBy(xpath="//label[@class='radio-inline'][2]")
	WebElement radiobtnproducttype;
	@FindBy(xpath="//input[@name='tag']")
	WebElement tag;
	@FindBy(xpath="//select[@name='cat_id']")
	public
	WebElement category;
	@FindBy(xpath="//select[@name='sub_id']")
	public
	WebElement subcategory;
	@FindBy(xpath="//select[@name='grp_id']")
	public
	WebElement group;
	@FindBy(xpath="//input[@id='purpose1']")
	public
	WebElement radiobtnpricetype;
	@FindBy(xpath="//select[@name='p_minimum']")
	public
	WebElement minpiece;
	@FindBy(xpath="//input[@name='p_max']")
	WebElement maxqty;
	@FindBy(xpath="//input[@name='p_price']")
	WebElement price;
	@FindBy(xpath="//input[@name='p_mrp']")
	WebElement mrp;
	@FindBy(xpath="//input[@name='p_stock']")
	WebElement stock;
	@FindBy(xpath="//input[@name='p_pp']")
	WebElement purchaseprice;
	@FindBy(xpath="//input[@name='unlimitp[]']")
	public
	WebElement checkbox;
	@FindBy(xpath="//div[@class='note-editable card-block']")
	public
	WebElement description;
	@FindBy(xpath="//input[@value='no']")
	public
	WebElement nocheckbox;
	@FindBy(xpath="//input[@name='main_img']")
	public
	WebElement choosefile1;
	@FindBy(xpath="//input[@name='subfile[]']")
	public
	WebElement choosefile2;
	@FindBy(xpath="//input[@name='featured'][1]'")
	public
	WebElement nofeatured;
	@FindBy(xpath="//button[@name='create']")
	WebElement save;
	@FindBy(xpath="//i[@class='icon fas fa-check']")
	WebElement alert1;
	@FindBy(xpath="//a[@class='btn btn-default btn-fix']")
	public
	WebElement cancel;
	@FindBy(xpath="//i[@class='fas fa-trash-alt'][1]")
	public
	WebElement delete;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement deletealert;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement search;
	@FindBy(xpath="//input[@name='un']")
	WebElement title1;
	@FindBy(xpath="//input[@name='cd']")
	WebElement productcode;
	@FindBy(xpath="//select[@name='cat_id']")
	public
	WebElement categorydp;
	@FindBy(xpath="//select[@name='sb']")
	public
	WebElement subcat;
	@FindBy(xpath="//button[@name='Search']")
	public
	WebElement searchbtn;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr")
	List<WebElement> rElement;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td")
	List<WebElement> cElement;
	String tPath="//table[@class='table table-bordered table-hover table-sm']/tbody";
	
	
	public String stockStatusChange() {
		manageproduct.click();
		yesbutton.click();
		closebutton.click();
		limited.click();
		return alert.getText();
		
	}
	public String StatusFeaturedButton() {
		//manageproduct.click();
		activebutton.click();
		closebutton.click();
		nobutton.click();
		System.out.println(noalertmsg.getText()); 
		return noalertmsg.getText();
		
		
	}
	public void createnew(CharSequence title1, CharSequence tagdec) {
	//	manageproduct.click();
		newbtn.click();
		title.sendKeys(title1);
		radiobtnproducttype.click();
		tag.sendKeys(tagdec);
		
	}
	public void createnewfields(String quantity, String priceforitem, String mrpfroritem, String stockitem, String prprice) {
		maxqty.sendKeys(quantity);
		price.sendKeys(priceforitem);
		mrp.sendKeys(mrpfroritem);
		stock.sendKeys(stockitem);
		purchaseprice.sendKeys(prprice);
		//checkbox.click();
		
		
	}
	public void descriptionField(String descriptionitem) {
		description.sendKeys(descriptionitem);
		
	}
	public String getText() {
		return alert1.getText();
	}
	
	public String delete() {
		delete.click();
		return deletealert.getText();	
	}
	
	public void search( String tilesearch, String pcode) {
		manageproduct.click();
		search.click();
		title1.sendKeys(tilesearch);
		productcode.sendKeys(pcode);
		
	}
	public String tableTest(int rowstart,int columnstart,String expected) {
		general=new GeneralUtility();
		return general.tableIteration(driver, rElement, cElement, rowstart, columnstart, expected, tPath);
		
}
 public ManageproductPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
		}
		

}
