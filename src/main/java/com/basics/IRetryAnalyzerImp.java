package com.basics;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryAnalyzerImp implements IRetryAnalyzer {
int counter=0;
	int retryCount=5;
	@Override
	public boolean retry(ITestResult result) {
		if(counter<retryCount){
			counter++;
			return true;
		}
		
		return false;
	}

//	@Test(retryAnalyser=RetryFailedTests.class)
}
