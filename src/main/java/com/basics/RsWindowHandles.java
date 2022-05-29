package com.basics;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utility.BaseClass;

public class RsWindowHandles extends BaseClass {

	public static void main(String[] args) {
		
		launchChrome();
		get("https://admin:admin@the-internet.herokuapp.com/");
		
		List<WebElement> allLinks = driver.findElements(By.xpath("//li/a"));
		
		for(WebElement link: allLinks) {
			if(link.getText().contains("Multiple Windows")) {
				link.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> windowsIterator = windows.iterator();
		String parentWindow = windowsIterator.next();
		String childWindow = windowsIterator.next();
		
		//getting child window text
		driver.switchTo().window(childWindow);
		String childWindowText = driver.findElement(By.tagName("h3")).getText();
		System.out.println(childWindowText);
		
		//getting parent window text
		driver.switchTo().window(parentWindow);
		String parentWindowText = driver.findElement(By.tagName("h3")).getText();
		System.out.println(parentWindowText);
		
		driver.quit();

		
	}

}
