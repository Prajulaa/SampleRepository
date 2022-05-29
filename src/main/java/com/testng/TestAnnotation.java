package com.testng;

import org.testng.annotations.Test;

public class TestAnnotation {
	
	@Test
	public void cat() {
		System.out.println("I am a cat!");
	}
	
	public void dog() {
		System.out.println("I am a dog!");
	}
	
	public void fish() {
		System.out.println("I am a fish!");
	}

}
