package com.basics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utility.BaseClass;

public class WebTableData extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		String number ="";
		launchEdge();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://t2.devero.com/?site=qaautomation1");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("sa");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("testing123");
		driver.findElement(By.id("submitButton")).click();	

		WebElement patrollRates= driver.findElement(By.xpath("//span[text()='Payroll Rates']"));

		//click payroll rights here
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", patrollRates);

		WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='form-frame-container']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.linkText("Create/Modify Payroll Rate")).click();
		driver.switchTo().parentFrame();
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='form-frame-container']"));
		driver.switchTo().frame(frame2);

		//scroll to the bottom of the page
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

		driver.findElement(By.xpath("//input[@value='New Payroll Rate']")).click();

		WebElement newData =driver.findElement(By.xpath("//select[contains(@id,'selectedAgency')]"));
		//selecting the value from dropdown
		Select select = new Select(newData);
		select.selectByIndex(25);

		//printing the value selected by user
		WebElement selectedValue = select.getFirstSelectedOption();
		String value = selectedValue.getText();
		System.out.println(value);

		driver.findElement(By.xpath("//input[@value='Save']")).click();



		//getting the matching value
		List<WebElement> desiredColumn =   driver.findElements(By.xpath("//table[@id='tbl1']/tbody/tr[@disabledrow='false']/td[1]/select"));
		System.out.println(desiredColumn.size());
		for(WebElement data: desiredColumn) {
			Select se = new Select(data);
			WebElement selValue = se.getFirstSelectedOption();
			String setValueText = selValue.getText();
			System.out.println(setValueText);
			if(setValueText.equals(value)) {
				String getAttribute = (String)js.executeScript("return arguments[0].getAttribute('name')", data);
				number = getAttribute.replaceAll("[^0-9]", "");
				WebElement savedData = driver.findElement(By.xpath("//select[@name='"+getAttribute+"']"));
				js.executeScript("arguments[0].setAttribute('style', 'background:pink; border:3px solid orange;')", savedData);

			}

		}
		driver.findElement(By.xpath("//a[contains(@onclick, "+number+")]"));











		//		driver.findElement(By.linkText("New Patient")).click();
		//		WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='form-frame-container']"));
		//		driver.switchTo().frame(frame1);
		//		driver.findElement(By.id("M0040FirstName")).sendKeys("Prajula");
		//		driver.findElement(By.xpath("//input[@name='value(M0040LastName)']")).sendKeys("kiran");
		//		driver.findElement(By.id("agencySearchText_value:CPCAgencyID:__2")).sendKeys("auto_agency_hospice_internal");
		//
		//		driver.findElement(By.xpath("//input[@type='button' and @value='Save']")).click();
		//		driver.switchTo().parentFrame();
		//		
		//		driver.findElement(By.linkText("Physician Orders")).click();



	}

}
