package com.basics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import com.graphbuilder.struc.LinkedList;

public class ExcelRead {

	@Test
	public void read() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Prajula-50628\\Desktop\\ProjectTask.xlsx");
		Workbook wps = new XSSFWorkbook(fis);
		//finding the total number of sheets in the workbook
		int numberOfSheets = wps.getNumberOfSheets();
		System.out.println(numberOfSheets);
		Sheet sheet = wps.getSheet("AdactinHotelBooking"); //you can also use, getSheetAt(index)
		
		//getting the header details
		Row header = sheet.getRow(0);
		Iterator<Cell> headerValues = header.cellIterator();
		Map<Cell, Cell> dataNeeded = new LinkedHashMap<Cell, Cell>();
		while(headerValues.hasNext()) {
			dataNeeded.put(headerValues.next(), null);
		}
		
		//checking if all the key is added in the map collection
		Set<Cell> keys = dataNeeded.keySet();
		System.out.println(keys);
		
		//checking the desired row in the sheet
		var rows= sheet.rowIterator();
//		while(rows.hasNext()) {
//			var row = rows.next();
//			if(row.equalsIgno)
//		}
		
	


	}

}
