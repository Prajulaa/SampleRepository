package com.modules.adactin.execution;

import java.io.IOException;


import com.modules.adactin.Loginn;

public class LoginExecution extends Loginn  {

	public static void login() throws IOException, InterruptedException {

		Loginn login = new Loginn();
		login.getUserName().sendKeys(propertiesReader("adactinUsername"));
		login.getPassword().sendKeys(propertiesReader("adactinPassword"));
		login.getLoginButton().click();


	}
}
