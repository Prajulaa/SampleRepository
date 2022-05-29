package com.modules.adactin.execution;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.modules.adactin.UserDetails;


public class UserDetailsExecution extends UserDetails{

	static List<String> excelData = new LinkedList<String>();
	List<String> ex = new LinkedList<String>();


	public  void excelRead() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Prajula-50628\\Desktop\\AdactinHotelBooking.xlsx");
		Workbook wps = new XSSFWorkbook(fis);
		Sheet sheet= wps.getSheetAt(0);
			
			int cellCount = sheet.getRow(1).getLastCellNum();
		
			for(int j=1; j<cellCount; j++) {

				int cellType = sheet.getRow(1).getCell(j).getCellType();
				if(cellType==1) {
					String value = sheet.getRow(1).getCell(j).getStringCellValue();
					excelData.add(value);
				}	
				if(cellType==0) {
					int intValue = (int) sheet.getRow(1).getCell(j).getNumericCellValue();
					String stringValue = String.valueOf(intValue);
					excelData.add(stringValue);
				}
			}
		}

	public void userDetails() throws IOException {
		//		UserDetailsExecution exe = new UserDetailsExecution();
		UserDetails details = new UserDetails();
		excelRead();

		details.getFirstName().sendKeys(excelData.get(0));
		details.getLastName().sendKeys(excelData.get(1));
		details.getAddress().sendKeys(excelData.get(2));
		details.getCcNum().sendKeys(excelData.get(3));
		selectVisibleText( details.getCcType(), "VISA");
		selectVisibleText(details.getCcExpMonth(), "December");
		selectVisibleText(details.getCcExpYear(), "2022");
		details.getCcCvv().sendKeys(excelData.get(4));
		details.getBookNowButton().click();


	}


}
