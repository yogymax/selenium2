package com.scp.demos.Selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadNWrite {
	
	public static void main(String[] args) throws IOException {
		
		File excelFile = new File("C:\\Users\\Progvaltion_11\\Desktop\\excelRead\\readwriteexcel.xlsx");
		FileInputStream fInputStream = new FileInputStream(excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fInputStream);
	
		readExcelSheetByIndex(workbook);
		readExcelSheetByName(workbook);		
	}
	private static void readExcelSheetByName(XSSFWorkbook workbook) {
		System.out.println();	
		String [] sheetNames = {"Sheet1","Sheet2","third"};
		
		for (String sheetName : sheetNames) {
			System.out.println("#######Printing sheet "+sheetName+" Information##########");
			XSSFSheet firstSheet = workbook.getSheet(sheetName);
			Iterator<Row> rows = firstSheet.iterator();
			while(rows.hasNext()){
				Row row = rows.next();
				System.out.println();
				Iterator<Cell> cells = row.iterator();
				while(cells.hasNext()){
					Cell cell = cells.next();
					System.out.print(cell.getStringCellValue() +"\t\t");
				}
			}
		}
		
	}

	private static void readExcelSheetByIndex(XSSFWorkbook workbook) {
	System.out.println();
		for(int i=0;i<3;i++){
			XSSFSheet firstSheet = workbook.getSheetAt(i);
			System.out.println("#######Printing sheet"+i+" Information##########");
			Iterator<Row> rows = firstSheet.iterator();
			System.out.println();
			while(rows.hasNext()){
				Row row = rows.next();
				Iterator<Cell> cells = row.iterator();
				while(cells.hasNext()){
					Cell cell = cells.next();
					System.out.print(cell.getStringCellValue() +"\t\t");
				}
			}
			
			
		}
		
	}
}
