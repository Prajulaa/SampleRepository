package com.bobcat;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.BaseClass;

public class Pom extends BaseClass {

	public Pom(){
		PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath="//strong[text()='Accept and Close']") private   WebElement acceptAndClose;
@FindBy(xpath="//ul[@id='main-nav']/li/a[text()='Loaders']") private  WebElement loaderHeader;
@FindBy(xpath="//div[@class='product-family']/a/span") private  List<WebElement> loaderModels;
@FindBy(xpath="//li[@data-nav-type='Product Family']/a[text()='Excavators']") private   WebElement excavatorHeader;
@FindBy(xpath="//div[@class='product-family']/a/span") private  List<WebElement> excavatorModels;
@FindBy(xpath="//li[@data-nav-type='Product Family']/a[text()='Tractors']") private  WebElement tractor;
@FindBy(xpath="//div[@class='product-family']/a/span") private  List<WebElement> tractorModels;


public  WebElement getAcceptAndClose() {
	return acceptAndClose;
}
public  WebElement getLoaderHeader() {
	return loaderHeader;
}
public  List<WebElement> getLoaderModels() {
	return loaderModels;
}
public  WebElement getExcavatorHeader() {
	return excavatorHeader;
}
public  List<WebElement> getExcavatorModels() {
	return excavatorModels;
}
public  WebElement getTractor() {
	return tractor;
}
public  List<WebElement> getTractorModels() {
	return tractorModels;
}










}
