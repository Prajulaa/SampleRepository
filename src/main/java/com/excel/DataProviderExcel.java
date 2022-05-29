package com.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DataProviderExcel {
	
	//file 
	//go to sheet
	//go to row
	//go to cell
	
	@Test
	public void data() throws IOException {
		File file = new File ("C:\\Users\\Prajula-50628\\Desktop\\DataProvider.xlsx");
	FileInputStream fis = new FileInputStream(file);
	Workbook wps = new XSSFWorkbook(fis);
    Sheet sheet = wps.getSheet("Sheet1");
    int rowCount = sheet.getPhysicalNumberOfRows();
    int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();
    
    System.out.println(rowCount);
    System.out.println(cellCount);
    
    for(int i=0; i<rowCount; i++) {
    	//row
    	for(int j=0;j<cellCount; j++) {
    		//cell
    		int cellType = sheet.getRow(i).getCell(j).getCellType(); 
    		
    		if(cellType==1) {
    		String value =	sheet.getRow(i).getCell(j).getStringCellValue();
    System.out.println(value);
    		}
    		
    		if(cellType==0) {
        		String value =	NumberToTextConverter.toText(sheet.getRow(i).getCell(j).getNumericCellValue());
        System.out.println(value);
        		}
    		
    	
    	}
    }
    

    
    
	
	
	}
	

}
