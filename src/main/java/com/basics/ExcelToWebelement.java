package com.basics;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.By;

import com.utility.BaseClass;

public class ExcelToWebelement extends BaseClass  {

	//reading one value from the excel
	public void enteringNameFromExcelToWebElement() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Prajula-50628\\Desktop\\ProjectTask.xlsx");
		Workbook wps = new XSSFWorkbook(fis);
		Sheet sheet = wps.getSheet("AdactinHotelBooking"); //you can also use, getSheetAt(index)
		var row = sheet.getRow(1);
		var firstName = row.getCell(1);
		var firstNameValue = firstName.getStringCellValue();
		System.out.println(firstName);
		BaseClass.launchEdge();
		BaseClass.get(BaseClass.propertiesReader("URL"));
		sendKeys(driver.findElement(By.id("txtUsername")), firstNameValue);

	}
	//reading a simple excel data using base class
	public void xlsxUsingBaseClass() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Prajula-50628\\Desktop\\ProjectTask.xlsx");
		Workbook wps = new XSSFWorkbook(fis);
		Sheet sheet = wps.getSheet("AdactinHotelBooking");
		var row = sheet.getRow(1);
		var firstName = row.getCell(1);
		var firstNameValue = firstName.getStringCellValue();
		System.out.println(firstName);
		BaseClass.launchEdge();
		BaseClass.get(BaseClass.propertiesReader("URL"));
		sendKeys(driver.findElement(By.id("txtUsername")), firstNameValue);

	}

	//getting the row count, first rownum and last row num
	public void rowAndColumLenght() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Prajula-50628\\Desktop\\ProjectTask.xlsx");
		Workbook wps = new XSSFWorkbook(fis);
		Sheet sheet = wps.getSheet("AdactinHotelBooking"); //you can also use, getSheetAt(index)
		int lastRow = sheet.getLastRowNum(); //tells the last row in which entry is done - works on index basis.. ex 0-18 (even if the middle few rows are empty)
		int firstRow = sheet.getFirstRowNum(); //check the range of the rows that contains content
		int rowCount = lastRow-firstRow;
		int rowCountMethod = sheet.getPhysicalNumberOfRows(); //--> does not work on index basis + gets only the count of the rows that has value in it
		System.out.println("Getting the physical number of rows: "+ rowCountMethod);
		System.out.println("Row count using getLastRowNum() and getFirstRowNum(): "+rowCount);
		System.out.println(lastRow + " "+firstRow);
	}


	//iterating all cells in the sheet
	public void iteratingAllCells() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Prajula-50628\\Desktop\\ProjectTask.xlsx");
		Workbook wps = new XSSFWorkbook(fis);
		Sheet sheet = wps.getSheet("AdactinHotelBooking");
		int lastRow = sheet.getLastRowNum(); int firstRow = sheet.getFirstRowNum(); 
		int rowCount = lastRow-firstRow;
		System.out.println("RowCount: " + rowCount);
		for(int i=0; i<rowCount; i++) {

			int cellCount = sheet.getRow(i).getLastCellNum();
			System.out.println("Cell Count: "+ cellCount);
			for(int j=0; j<cellCount; j++) {

				int cellType = sheet.getRow(i).getCell(j).getCellType();
				if(cellType==1) {
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					System.out.println(value);
				}	
				if(cellType==0) {
					int value = (int) sheet.getRow(i).getCell(j).getNumericCellValue();
					System.out.println(value);
				}
			}
			System.out.println();
		}
	}

	//iterating a particular row with a stupid condition
	@Test
	public void iteratingASingleRow() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Prajula-50628\\Desktop\\ProjectTask.xlsx");
		Workbook wps = new XSSFWorkbook(fis);
		Sheet sheet = wps.getSheet("AdactinHotelBooking");
		System.out.println();
		for(int i=1; i==1; i++) {//This is stupid but okay for now

			int cellCount = sheet.getRow(i).getLastCellNum();
			for(int j=1; j<cellCount; j++) {

				int cellType = sheet.getRow(i).getCell(j).getCellType();
				if(cellType==1) {
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					System.out.println(value);
				}	
				if(cellType==0) {
					int value = (int) sheet.getRow(i).getCell(j).getNumericCellValue();
					System.out.println(value);
				}
			}

		}
		System.out.println();
		
	}
}

