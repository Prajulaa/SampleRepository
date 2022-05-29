package com.modules.orangehrm;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.BaseClass;

public class OrangeHrmLogin extends BaseClass{

	//to initiate all the WebElements found
	public OrangeHrmLogin() { //pageFactory 
		PageFactory.initElements(driver, this);
	}

	/*By username =By.id("txtUsername");
	By password =By.id("txtPassword");
	By loginBtn =By.id("btnLogin");

	public WebElement userName() {
		return driver.findElement(username);
	}

	public WebElement passWord() {
		return driver.findElement(password);
	}
	public WebElement loginBtn() {
		return driver.findElement(loginBtn);
	}
}
	 * 
	 * 
	 */

	@FindBy(id= "txtUsername") private WebElement userName;
	@FindBy(id = "txtPassword") private WebElement password;
	@FindBy(id = "btnLogin") private WebElement login;

	public  WebElement getUserName() {
		return userName;
	}
	public void setUserName(WebElement userName) {
		this.userName = userName;
	}
	public WebElement getPassword() {
		return password;
	}
	public void setPassword(WebElement password) {
		this.password = password;
	}
	public WebElement getLogin() {
		return login;
	}
	public void setLogin(WebElement login) {
		this.login = login;
	}



}
