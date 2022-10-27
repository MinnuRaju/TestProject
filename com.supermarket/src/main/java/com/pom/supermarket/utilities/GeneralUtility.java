package com.pom.supermarket.utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GeneralUtility {
WebDriver driver;
	
	public WebDriver browserLaunch(String browser,String url) {
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
		return driver;
		
	}
	public void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	
	}
  public void alertDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();

	}
  public void selectByValue(WebElement element, String value) {
	  Select obj=new Select(element);
	  obj.selectByValue(value);
  }
  public void selectByIndex(WebElement element,int index) {
	  Select obj=new Select(element);
	  obj.selectByIndex(index);
  }
  public void selectByVisibletext(WebElement element,String text) {
	  Select obj=new Select(element);
	  obj.selectByVisibleText(text);
  }
  public void sendKeysCommand(WebElement element,String text) {
	  element.sendKeys(text);
  }
  public void clickCommand(WebElement element) {
	  element.click();
  }
  public void clearCommand(WebElement element) {
	  element.clear();
  }
  public void scroll(WebDriver driver) {
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("window.scrollBy(0,1000)");
	 // js.executeScript("window.scrollBy(0,-6000)");
	 // js.executeScript("arguments[0].scrollIntoView()", element);
	  
  }
  public void scrollUptoDown(WebDriver driver) {
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
  }
  public void rightClick(WebElement element) {
	  Actions obj=new Actions(driver);
	  obj.contextClick(element).build().perform();
  }
  public void doubleClick(WebElement element) {
	  Actions obj=new Actions(driver);
	  obj.doubleClick(element).build().perform();
  }
  public void mouseOver(WebElement element) {
	  Actions obj=new Actions(driver);
	  obj.moveToElement(element).build().perform();
  }
  public void dragndDrop(WebElement source,WebElement target) {
	  Actions obj=new Actions(driver);
	  obj.dragAndDrop(source, target).build().perform();
  }
  public void windowHandle() {
	  driver.getWindowHandles();
  }
  
	public void javaScriptExecutorClick(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	public String tableIteration(WebDriver driver,List<WebElement> rElement,List<WebElement> cElement,int rowstart,int columnstart,String expected,String tPath) {
		String webData=null;     
		boolean flag = false;
			  int rowCount=rElement.size();
			   int colCount=cElement.size();
			  
			  
			  for(int i=rowstart;i<=rowCount;i++)
			  {
				  if(flag==true) {
					  break;
				  }
				  for(int j=columnstart;j<=colCount;j++) {
					  if(j==1) {
					  WebElement element=driver.findElement(By.xpath(""+tPath+"/tr["+i+"]/td["+j+"]"));
					   webData=element.getText();
					
					  if(webData.equalsIgnoreCase(expected)) {
						  flag = true;
						  
					  }
					  
				  }
				  }
				  
				  
				  }
			return webData;
			  }
}
