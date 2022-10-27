package com.pom.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	@FindBy(xpath="//button[@type='submit']")
	WebElement signin;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement errorMessage;
	@FindBy(xpath="//li[@class='breadcrumb-item active']")
	WebElement textMessage;
	
	public void login(String username1,String password1) {
		username.sendKeys(username1);
		password.sendKeys(password1);
		signin.click();
		
	
	}
	public String getErrorMessage() {
	//	System.out.println(errorMessage.getText());
		return errorMessage.getText();
		
	}
	public String getTextMessage() {
		System.out.println(textMessage.getText());
		return textMessage.getText();
	}
	public void clearUsernameAndPassword() {
		username.clear();
		password.clear();
		
	}
	 
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
}
