package com.basics;

public class TestClass {
	int count=1;
	@org.testng.annotations.Test
public void elder() {
	System.out.println("elder");
	int i = 9/0;
}

	@org.testng.annotations.Test(alwaysRun=false, priority = -23)
public void method() {
		

	}
	
	@org.testng.annotations.Test(groups={"one", "login"}, priority=0)
public void sister() {

	}

	@org.testng.annotations.Test(groups="two", priority=100)
public void younger() {
	System.out.println("younger");
	}

}
