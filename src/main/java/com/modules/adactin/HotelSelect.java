package com.modules.adactin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.BaseClass;

public class HotelSelect extends BaseClass{
	
	public HotelSelect() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#radiobutton_0") private WebElement hotelSelect;
	@FindBy(css="#continue") private WebElement continueButton;
	public WebElement getHotelSelect() {
		
		return hotelSelect;
	}
	public WebElement getContinueButton() {
		return continueButton;	

	}

}
