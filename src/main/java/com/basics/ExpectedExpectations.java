package com.basics;

import java.io.IOException;

import org.testng.annotations.Test;

public class ExpectedExpectations {
	
	@Test(expectedExceptions = {IOException.class})
	public void data() {
		System.out.println("this is a method to illustrate expected expectations");
		int num = 9/0;
	}

}
