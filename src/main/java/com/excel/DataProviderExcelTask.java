package com.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExcelTask {

	@DataProvider
	public static String[][] excel() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Prajula-50628\\Desktop\\DataProvider.xlsx");
		Workbook wps = new XSSFWorkbook(fis);
		Sheet sheet = wps.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();
		int cellCount= sheet.getRow(0).getPhysicalNumberOfCells();

		String[][] array = new String[rowCount-1][cellCount];

for(int i=0; i<rowCount-1; i++) { 
for(int j=0; j<cellCount ; j++) {

int cellType = sheet.getRow(i+1).getCell(j).getCellType();
if(cellType==1) {
String value = sheet.getRow(i+1).getCell(j).getStringCellValue();
array[i][j]=value;
}	
if(cellType==0) {
String value = NumberToTextConverter.toText( sheet.getRow(i+1).getCell(j).getNumericCellValue());
array[i][j]=value;
				}
			}
		}
		return array;
	}
 @Test(dataProvider="excel")
 public void TC_001(String userName, String password) {
	 System.out.println(userName + " " + password);
 }

}
