package com.pom.supermarket.utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {
	WebDriver driver;
	
public void implicitWait() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
}
public void explicitWait() {
	 WebDriverWait explicitwait=new WebDriverWait(driver,Duration.ofSeconds(10));
	 
}
public void fluentWait() {
	  FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		       .withTimeout(Duration.ofSeconds(30L))
		       .pollingEvery(Duration.ofSeconds(5L))
		       .ignoring(NoSuchElementException.class);
			}
}
