package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetSpreadSheetData extends BaseClass{
	public FileInputStream inputStream;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public XSSFRow rows=null;
	public XSSFCell cells=null;
	public String filePath;
	

	public GetSpreadSheetData(String excelFilePath) throws IOException {//constractor
		try {
			File file = new File(excelFilePath);
			inputStream = new FileInputStream(file);
			workbook = new XSSFWorkbook(inputStream);
			sheet = workbook.getSheet(sheetName);
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	
	} 
	//method to count total row;
		public int getRowCount(String sheetName) {
			sheet = workbook.getSheet(sheetName);
			int totalRow =sheet.getLastRowNum();
			totalRow = totalRow+1;
			return totalRow;
		}
		
	//method to read string cell data
	public String getCellData(String sheetName, int row, String columnName) {
		sheet = workbook.getSheet(sheetName);
		XSSFRow rowHeader = sheet.getRow(0);
		int col = 0;
		for(int r=0; r<rowHeader.getLastCellNum();r++) {
			if(rowHeader.getCell(r).getStringCellValue().equals(columnName)) {
				col=r;
				break;
			}
		}
		String data =sheet.getRow(row).getCell(col).getStringCellValue();
		return data;
	}
	
	//method to read numeric cell data
	public long getNumericCellData(String sheetName, int row, String columnName) {
		sheet = workbook.getSheet(sheetName);
		XSSFRow rowHeader = sheet.getRow(0);
		int col = 0;
		for(int r=0; r<rowHeader.getLastCellNum();r++) {
			if(rowHeader.getCell(r).getStringCellValue().equals(columnName)) {
				col=r;
				break;
			}
		}
		long data =(long) sheet.getRow(row).getCell(col).getNumericCellValue();
		return data;
	}

	

}
