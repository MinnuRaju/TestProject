package com.pom.supermarket.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class DataProviderUtility {

	WebDriver driver;
	
@DataProvider(name="loginData")
	 public Object[][] getData() {
		 return new Object[][] {
		      new Object[] { "username1", "password1" },
		      new Object[] { "username2", "password2" },
		    };


}
}
