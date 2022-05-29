package com.modules.adactin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.BaseClass;

public class Loginn extends BaseClass{
	public Loginn() {
		PageFactory.initElements(driver, this);
	}
 public WebElement getUserName() {
		return userName;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLoginButton() {
		return loginButton;
	
	}
@FindBy(css="#username") private WebElement userName;
 @FindBy(css = "#password") private WebElement password;
 @FindBy(css = "#login") private WebElement loginButton;
 
}