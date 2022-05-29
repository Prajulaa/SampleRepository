package com.modules.adactin.execution;

import com.modules.adactin.HotelSearch;

public class HotelSearchExecution extends HotelSearch {
	
	
	public void hotelSearch() {
	HotelSearch search = new HotelSearch();
       selectValue(search.getLocation(), "Paris");
		selectIndex(search.getHotels(), 2);
		selectVisibleText(search.getRoomType(), "Super Deluxe");
		selectValue(search.getNumberOfRooms(), "5");
		selectValue(search.getNumberOfAdultRooms(), "3");
		selectIndex(search.getNumberOfChildRooms(), 0);
		search.getSearchButon().click();  
	
	}

}
