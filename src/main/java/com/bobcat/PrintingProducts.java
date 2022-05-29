package com.bobcat;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utility.BaseClass;

public class PrintingProducts extends BaseClass {

	public static void main(String[] args) throws InterruptedException {

		launchEdge();
		get("https://www.bobcat.com/index");	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement acceptTerms = driver.findElement(By.xpath("//strong[text()='Accept and Close']"));

		acceptTerms.click();

		//loader
		WebElement loader =driver.findElement(By.xpath("//ul[@id='main-nav']/li/a[text()='Loaders']"));
		loader.click();
		Thread.sleep(4000);

		List<WebElement> loaderProducts = loader.findElements(By.xpath("//div[@class='product-family']/a/span"));

		for(WebElement loaderProduct: loaderProducts) {

			String loaderProductText = loaderProduct.getText();
			if(!loaderProductText.isEmpty()) System.out.println(loaderProductText);

		}
		System.out.println();
		//Excavator
		WebElement  excavators = driver.findElement(By.xpath("//li[@data-nav-type='Product Family']/a[text()='Excavators']"));
		excavators.click();
		Thread.sleep(4000);
		List<WebElement> excavatorModels = excavators.findElements(By.xpath("//div[@class='product-family']/a/span"));

		for(WebElement excavatorModel : excavatorModels) {
			String excavatorModelText = excavatorModel.getText();
			if(!excavatorModelText.isEmpty())	System.out.println(excavatorModelText);

		}
		System.out.println();


		//tractor
		WebElement tractor = driver.findElement(By.xpath("//li[@data-nav-type='Product Family']/a[text()='Tractors']"));
		tractor.click();
		Thread.sleep(4000);

		List<WebElement> tractorProducts = tractor.findElements(By.xpath("//div[@class='product-family']/a/span"));
		for(WebElement tractorProduct: tractorProducts) {
			String tractorProductText = tractorProduct.getText();
			if(!tractorProductText.isEmpty()) System.out.println(tractorProductText);
		}





	}

}