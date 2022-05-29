package com.basics;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions {
static int sum;
@BeforeClass
public void add() {
	var number1=10;
	var number2=20;
     sum= number1+number2;
     
}

public void assertEquals() {
	System.out.println(sum);
	
	//#### IMPORTANT: if an assert fails, the program execution shall be stopped ####
	Assert.assertEquals(sum, 21);
	System.out.println("Will this sentence after assert failure be printted?");// this line will not be printed
}


public void assertTrueFalse() {
	System.out.println(sum);
	
	//#### IMPORTANT: if an assert fails, the program execution shall be stopped ####
	Assert.assertTrue(true, "Will this be printed?????");
	Assert.assertFalse(true, "When will this message be displayed?");//this message will be deleted when the assert fails
	System.out.println("Will this sentence after assert failure be printed?");
}


public void assertEqualsCondition() {
Assert.assertEquals("Prajula", "Praju", "This is the message that will be displayed when the assert fails");	
	//#### IMPORTANT: if an assert fails, the program execution shall be stopped ####
	
}

@Test
//soft asserts are also known as 'Verify'
public void softAssert() {
	//#### IMPORTANT: if an soft assert fails, the program execution shall be continued ####
	String fullName = "Prajula Ravichandran";
	SoftAssert softAssert = new SoftAssert();
	 softAssert.assertEquals(fullName, "Prajula", "This will be displayed");
	System.out.println("This is after the soft assertions failure");
	softAssert.assertAll();
	softAssert.fail();
}



}
