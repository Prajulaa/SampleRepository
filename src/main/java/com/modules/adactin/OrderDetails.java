package com.modules.adactin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.BaseClass;

public class OrderDetails extends BaseClass {
	
	public OrderDetails() {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrderNumber() {
		return orderNumber;
	
	}

	@FindBy(id ="order_no") private WebElement orderNumber;
}
