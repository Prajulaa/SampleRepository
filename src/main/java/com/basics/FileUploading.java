package com.basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utility.BaseClass;

public class FileUploading extends BaseClass{

	public static void main(String[] args) {

		/*Ways to handle various window pop ups
		 * 
		 * 1. Alert 
		 * -Written in JS
		 * -Can be handled using driver.switchTo().alerts();
		 * 
		 * 2. Authentication 
		 * -Also writen in JS i guess
		 * -Cannot be handled by driver.switchTo().alerts();
		 * -Can be handled by sending username and password in the URL
		 * 
		 * 
		 */
		
		
		launchChrome();
		get("https://admin:admin@the-internet.herokuapp.com/");
		
		List<WebElement> allLinks = driver.findElements(By.xpath("//li/a"));
		
		for(WebElement link: allLinks) {
			if(link.getText().contains("Basic Auth")) {
				link.click();
				break;
			}
		}
		
		
	}

}
