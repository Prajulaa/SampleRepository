package com.basics;

import org.testng.annotations.Test;

public class Example {

	@Test
	public static void numberSplit() {
		// TODO Auto-generated method stub
//		String name = "selectedAgency(225)";
//		String[] firstSplit= name.split("'('");
//		String result1 = firstSplit[1];
//		String[] secondSplit = result1.split("')'");
//		String number = secondSplit[0];
//		System.out.println(number);
		
		String number = "";
		String name = "selectedAgency(225)";
		for(int i=0; i<name.length(); i++) {//will not work
			if(i==0||i==1||i==2||i==3||i==4||i==5||i==6||i==7||i==8||i==9) {
				number=number+i;
			}
		}
		System.out.println();
	}
}
