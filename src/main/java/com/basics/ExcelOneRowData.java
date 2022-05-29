package com.basics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class ExcelOneRowData {
	//String filePath, int sheetIndex, String desiredData
//Refer to handle excel sheets with formula - https://www.tabnine.com/code/java/methods/org.apache.poi.ss.usermodel.CellValue/getCellTypeEnum
	
	//this is WIP - need to handle date and formulas
	
	@Test
	public Map<String, String> getDesiredRow(String filePath, int sheetIndex, String desiredValue) throws IOException {
		Map<String, String> excelData = new LinkedHashMap<String, String>();
		String[] headerData = null;
		String[] desiredData = null;
		int desiredRowIndex = 0;

		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		Workbook wps = new XSSFWorkbook(fis);
		Sheet sheet = wps.getSheetAt(sheetIndex); // getting access to all the elements in sheet
		int lastRow = sheet.getLastRowNum();

		//reading header values into Array
		for(int i=0;i<1;i++) {//rows iterator

			int lastCell = sheet.getRow(i).getLastCellNum();
			headerData = new String[lastCell];
			for(int j=0;j<lastCell;j++) {//cell iterator
				if(sheet.getRow(i).getCell(j).getCellTypeEnum()==CellType.STRING) {
					String headerValue = sheet.getRow(i).getCell(j).getStringCellValue();
					headerData[j]=headerValue;	
				}
				else {
					String headerValue = NumberToTextConverter.toText(sheet.getRow(i).getCell(j).getNumericCellValue());
					headerData[j]=headerValue;	
				}
			}
		}
		System.out.println(Arrays.toString(headerData));
		//getting the desired row index -- not working to check
		for(int i=1;i<=lastRow;i++) {

			int lastCell = sheet.getRow(i).getLastCellNum();
			for(int j=0; j<lastCell;j++) {
				if(sheet.getRow(i).getCell(j).getCellTypeEnum()==CellType.STRING) {
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					if(value.equalsIgnoreCase(desiredValue)) {
						desiredRowIndex = i;
					}
				}
				if(sheet.getRow(i).getCell(j).getCellTypeEnum()==CellType.NUMERIC) {
					String value = NumberToTextConverter.toText(sheet.getRow(i).getCell(j).getNumericCellValue());
					if(value.equalsIgnoreCase(desiredValue)) {
						desiredRowIndex = i;
					}
				}
			}
		}

		//getting the desired row values
		for(int i=desiredRowIndex; i==desiredRowIndex; i++) {
			int lastCell = sheet.getRow(i).getLastCellNum();
			desiredData= new String[lastCell];
			for(int j=0; j<lastCell;j++) {
				if(sheet.getRow(i).getCell(j).getCellTypeEnum()==CellType.STRING) {
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					desiredData[j]=value;
				}
				else {
					//making use of an amazing method
					String value = NumberToTextConverter.toText(sheet.getRow(i).getCell(j).getNumericCellValue());
					desiredData[j]=value;
				}
			}
		}	
		System.out.println(Arrays.toString(desiredData));
		//storing the data in a LinkedHashMap
		for(int i=0;i<headerData.length;i++) {
			excelData.put(headerData[i], desiredData[i]);	
		}

		return excelData;
	}
}


