package com.basics;

import org.testng.annotations.Parameters;

public class OptionalAnnotation {
	
	
	@org.testng.annotations.Test
	@Parameters("lastName")
	public void details(@org.testng.annotations.Optional("Ravichandran") String name) {
		System.out.println(name);
	}

}
