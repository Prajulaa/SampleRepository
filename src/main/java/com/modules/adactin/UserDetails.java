package com.modules.adactin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.BaseClass;

public class UserDetails extends BaseClass {
	
	public UserDetails() {
		PageFactory.initElements(driver, this);
	}

	@FindBy (id = "first_name")	private WebElement firstName;
	@FindBy (id = "last_name") private WebElement lastName;
	@FindBy (id = "address") private WebElement address;
	@FindBy (id="cc_num") private WebElement ccNum;
	@FindBy (id="cc_type") private WebElement ccType;
	@FindBy(id="cc_exp_month") private WebElement ccExpMonth;
	@FindBy (id = "cc_exp_year") private WebElement ccExpYear;
	@FindBy (id="cc_cvv") private WebElement ccCvv;
	@FindBy (css="#book_now") private WebElement bookNowButton;
	public WebElement getFirstName() {
		return firstName;
	}
	public WebElement getLastName() {
		return lastName;
	}
	public WebElement getAddress() {
		return address;
	}
	public WebElement getCcNum() {
		return ccNum;
	}
	public WebElement getCcType() {
		return ccType;
	}
	public WebElement getCcExpMonth() {
		return ccExpMonth;
	}
	public WebElement getCcExpYear() {
		return ccExpYear;
	}
	public WebElement getCcCvv() {
		return ccCvv;
	}
	public WebElement getBookNowButton() {
		return bookNowButton;
	
	}

}
