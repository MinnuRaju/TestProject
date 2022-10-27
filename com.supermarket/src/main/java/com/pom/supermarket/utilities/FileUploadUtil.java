package com.pom.supermarket.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploadUtil {
	WebDriver driver;
	
	public void fileUploadBySendkeys(WebElement element,String path) {
     element.sendKeys(path); 
          
		
	}
	
	public void fileUploadByRobotClass(String path,WebElement element) throws AWTException {
		 StringSelection s=new StringSelection(path);
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		  element.click();
		  Robot r=new Robot();
		  r.delay(250);
		  r.keyPress(KeyEvent.VK_ENTER);
		  r.keyRelease(KeyEvent.VK_ENTER);
		  r.keyPress(KeyEvent.VK_CONTROL);
		  r.keyPress(KeyEvent.VK_V);
		  r.keyRelease(KeyEvent.VK_CONTROL);
		  r.keyRelease(KeyEvent.VK_V);
		  r.keyPress(KeyEvent.VK_ENTER);
		  r.keyRelease(KeyEvent.VK_ENTER);
		  r.delay(250);
		  
		 // System.getProperty("user.dir")+"\\src\\main\\resources\\UploadFile\\excelfile.jpg"
		
	}

}
