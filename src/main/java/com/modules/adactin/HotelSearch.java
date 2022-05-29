package com.modules.adactin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.BaseClass;

public class HotelSearch extends BaseClass {
	
	public HotelSearch() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#location") private WebElement location;
	@FindBy(css="#hotels") private WebElement hotels;
	@FindBy(css="#room_type") private WebElement roomType;
	@FindBy(css="#room_nos") private WebElement numberOfRooms;
	@FindBy(css="#room_nos") private WebElement numberOfAdultRooms;
	@FindBy(css="#child_room") private WebElement numberOfChildRooms;
	@FindBy(xpath="//input[@value='Search']") private WebElement searchButon;
	
	public WebElement getLocation() {
		return location;
	}
	public WebElement getHotels() {
		return hotels;
	}
	public WebElement getRoomType() {
		return roomType;
	}
	public WebElement getNumberOfRooms() {
		return numberOfRooms;
	}
	public WebElement getNumberOfAdultRooms() {
		return numberOfAdultRooms;
	}
	public WebElement getNumberOfChildRooms() {
		return numberOfChildRooms;
	}
	public WebElement getSearchButon() {
	return searchButon;
	}

	
}
