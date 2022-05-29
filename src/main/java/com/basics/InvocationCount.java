package com.basics;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.modules.orangehrm.OrangeHrmLogin;
import com.utility.BaseClass;

public class InvocationCount extends BaseClass {

	@BeforeMethod
	public void setUp() {
		launchEdge();
		get("https://opensource-demo.orangehrmlive.com/");
	}
	
	@Test(invocationCount=3)
	public void login() {
		OrangeHrmLogin orange = new OrangeHrmLogin();
		sendKeys(orange.getUserName(), "Admin");
		sendKeys(orange.getPassword(), "admin123");
		click(orange.getLogin());
	}
	
	@AfterMethod
	public void cleanUp() {
		driver.close();
	}
}
