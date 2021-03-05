package com.learautomation.utility;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Reads Data from Excel 
public class ExcelDataProvider {
	XSSFWorkbook wb;

	// Create constructor to load the Excel
	public ExcelDataProvider() {
		File src = new File("./TestData/Data.xlsx");

		// read xlsx workbook
		try {
			FileInputStream fis = new FileInputStream(src);

			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
		System.out.println("Unable to find excel file " + e.getMessage());
		}
	}
	
	public String getStringData(int sheetIndex,int row, int col)
	{
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(col).getStringCellValue();
	}
	
	public String getStringData(String sheetName,int row, int col)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
	}
	
	public Double getNumericData(String sheetName,int row, int col)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
	}
}
