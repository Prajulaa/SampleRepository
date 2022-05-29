package com.execution;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.junit.Test;

import com.modules.adactin.execution.HotelSearchExecution;
import com.modules.adactin.execution.HotelSelectExecution;
import com.modules.adactin.execution.LoginExecution;
import com.modules.adactin.execution.OrderDetailsExecution;
import com.modules.adactin.execution.UserDetailsExecution;
import com.modules.orangehrm.OrangeHrmLogin;

public class Execution extends OrangeHrmLogin {


	//Orange HRM login
	public void exe() throws IOException {
		launchEdge();
		
		get(propertiesReader("URL"));
		OrangeHrmLogin login = new OrangeHrmLogin();
		sendKeys(login.getUserName(), propertiesReader("userName"));//Admin
		sendKeys(login.getPassword(), propertiesReader("password"));//admin123
		click(login.getLogin());	
	}



	//ADACTIN Hotel Booking 
	@Test
	public void adactin() throws IOException, InterruptedException {
		launchEdge();
		get(propertiesReader("adactinUrl"));
		LoginExecution.login();	
		HotelSearchExecution search = new HotelSearchExecution();
		search.hotelSearch();
		HotelSelectExecution select = new HotelSelectExecution();
		select.hotelSelect();
		UserDetailsExecution details = new UserDetailsExecution();
		details.userDetails();

		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		OrderDetailsExecution orderNumber = new OrderDetailsExecution();
		orderNumber.excelWrite();

	}

}
