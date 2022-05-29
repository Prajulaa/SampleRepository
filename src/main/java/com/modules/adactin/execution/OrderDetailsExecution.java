package com.modules.adactin.execution;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.modules.adactin.OrderDetails;

public class OrderDetailsExecution extends OrderDetails{
 String orderNumber;

	public void orderDetails() {
		OrderDetails details = new OrderDetails();
        orderNumber= details.getOrderNumber().getAttribute("value");
        
	}

	public void excelWrite() throws IOException {
		orderDetails();
		System.out.println("Booking is complete.\nYour order number is: "+orderNumber);
		File file = new File("C:\\Users\\Prajula-50628\\Desktop\\AdactinHotelBooking.xlsx");
		FileInputStream fis = new FileInputStream(file);
	    wps = new XSSFWorkbook(fis);
		Sheet output = wps.createSheet("Output-BookingDetails");
		output.createRow(0).createCell(0).setCellValue("Order No."); 
		output.getRow(0).createCell(1).setCellValue(orderNumber);
		FileOutputStream fos = new FileOutputStream(file);
		wps.write(fos);
		
	}

}
