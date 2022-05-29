package com.basics;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.modules.orangehrm.OrangeHrmLogin;
import com.utility.BaseClass;

public class DataProvider extends BaseClass {

	@BeforeMethod
	public void setUp() {
		launchEdge();
		get("https://opensource-demo.orangehrmlive.com/");
	}

	@Test(dataProvider="userDetails", invocationCount=2)
	public void login(String userName, String password) {
		OrangeHrmLogin orange = new OrangeHrmLogin();
		sendKeys(orange.getUserName(), userName);
		sendKeys(orange.getPassword(), password);
		System.out.println(userName+" "+password);
		click(orange.getLogin());
	}

	@AfterMethod
	public void cleanUp() {
		driver.close();
	}

	@org.testng.annotations.DataProvider
	public Object[][] userDetails() {

		Object[][] details = new Object[2][2];

		details[0][0]="Mayuri";
		details[0][1]="Hari123";

		details[1][0]="Prajula";
		details[1][1]="Testing123";
		return details;

	}






}
