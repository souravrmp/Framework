package com.test.utilityclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExelUtilities {

	public static String readData(String sheet,int r,int c) {
		File f=new File(ReadProp.readData("ExcelSheetPath"));
		FileInputStream ExcelFile = null;
		try {
			ExcelFile = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		XSSFWorkbook ExcelWBook = null;
		try {
			ExcelWBook = new XSSFWorkbook(ExcelFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String data = ExcelWBook.getSheet(sheet).getRow(r).getCell(c).getStringCellValue();
		return data;
	}
}


