package com.basics;

import org.testng.annotations.Test;

public class Groups {

	@Test(groups={"clientData", "basicTestcase"})
	public void login() {
		System.out.println("login");
	}
	
	@Test
	public void homePage() {
		System.out.println("homePage");
	}
	
	@Test
	public void matches() {
		System.out.println("matches");
	}
	
	@Test
	public void interests() {
		System.out.println("interests");
	}
	
	@Test
	public void editProfile() {
		System.out.println("editProfile");
	}
	
	@Test(groups={"clientRequirement","basicTestcase"})
	public void logout() {
		System.out.println("logout");
	}
}
