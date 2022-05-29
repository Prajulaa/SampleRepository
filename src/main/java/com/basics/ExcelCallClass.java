package com.basics;

import java.io.IOException;
import java.util.Map;

public class ExcelCallClass {

	public static void main(String[] args) throws IOException {
		ExcelOneRowData excel = new ExcelOneRowData();
		Map<String, String> data = excel.getDesiredRow("C:\\Users\\Prajula-50628\\Desktop\\DataProvider.xlsx", 0, "Chandru");
		System.out.println(data);

	}


}
