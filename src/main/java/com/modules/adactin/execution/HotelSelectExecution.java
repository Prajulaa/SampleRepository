package com.modules.adactin.execution;

import com.modules.adactin.HotelSelect;

public class HotelSelectExecution extends HotelSelect{

	public void hotelSelect() {
		
		HotelSelect select = new HotelSelect();
		select.getHotelSelect().click();
		select.getContinueButton().click();
		
	
	}
}
