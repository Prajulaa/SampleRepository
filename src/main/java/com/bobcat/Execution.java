package com.bobcat;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.utility.BaseClass;


public class Execution extends BaseClass{
	@Test
	@Parameters("URL")
	public void gettingTheListOfElements(@Optional("ok") String url) throws InterruptedException {
		
		Pom pom = new Pom();
		launchEdge();
		
		get(url);
			
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		click(pom.getAcceptAndClose());
		
		//accessing the loader section
		pom.getLoaderHeader().click();
		Thread.sleep(2000);
		//printing the products in the loader section
		for(WebElement loaderModule: pom.getLoaderModels()) {
			String loaderProductText = loaderModule.getText();
			if(!loaderProductText.isEmpty()) System.out.println(loaderProductText);
		}
		System.out.println();
		
		//accessing the excavator section
		pom.getExcavatorHeader().click();
		Thread.sleep(2000);
		//printing the products in the excavation section
		for(WebElement excavatorModel : pom.getExcavatorModels()) {
			String excavatorModelText = excavatorModel.getText();
			if(!excavatorModelText.isEmpty())	System.out.println(excavatorModelText);
		}
		System.out.println();
		//accessing the tractor section
		pom.getTractor().click();
		Thread.sleep(2000);
		//printing all the products in the tractor section
		for(WebElement tractorProduct: pom.getTractorModels()) {
			String tractorProductText = tractorProduct.getText();
			if(!tractorProductText.isEmpty()) System.out.println(tractorProductText);
		}
		close();
	}

}

