package com.scp.utility;

/**
 * Jar POI > 2007 > HSSF
 * JAR POI-OOXML >2007 > XSSF
 * 
 */
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.sql.Date;
	import java.util.HashMap;
	import java.util.Iterator;
	import java.util.Map;
	import java.util.Set;

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelReadWrite {
		
		public static void main(String[] args) throws IOException { 
			
		String filePath = new File("").getAbsolutePath().concat("\\src\\test\\java\\seleniumReadExcel.xlsx");
		File excel = new File(filePath); 
		//File excel = new File("../seleniumReadExcel.xlsx");
		FileInputStream fis = new FileInputStream(excel);
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheetAt(2);
		//Read Excel File 
		readExcelFile(sheet);
		// writing data into XLSX file
		 writeExcelSheet(sheet,excel,book,fis);
		}
		
		private static void writeExcelSheet(XSSFSheet sheet, File excel, XSSFWorkbook book, FileInputStream fis) throws IOException {
			Map<String, Object[]> newData = new HashMap<String, Object[]>();
			 newData.put("10", new Object[] { 7d, "ABC", "123", "GG", "AV" });
			 newData.put("11", new Object[] { 8d, "PQR", "123", "AA", "AA" });
			 newData.put("12", new Object[] { 9d, "AXY", "123", "S", "VV" });
			 Set<String> newRows = newData.keySet();
			 int rownum = sheet.getLastRowNum();
			 for (String key : newRows) { 
			Row row = sheet.createRow(rownum++);
			 Object[] objArr = newData.get(key);
			 int cellnum = 0;
			 for (Object obj : objArr) { 
				 Cell cell = row.createCell(cellnum++);
			 if (obj instanceof String) { 
				 cell.setCellValue((String) obj);
			 } else if (obj instanceof Boolean) { 
				 cell.setCellValue((Boolean) obj);
			 } else if (obj instanceof Date) { 
				 cell.setCellValue((Date) obj);
			 } else if (obj instanceof Double) { 
				 cell.setCellValue((Double) obj);
			 } 
			} 
		} // open an OutputStream to save written data into Excel file 
			 FileOutputStream os = new FileOutputStream(excel);
			 book.write(os);
			 System.out.println("Writing on Excel file Finished ...");
			 // Close workbook, OutputStream and Excel file to prevent leak 
			 os.close();
			// book.close();
			 fis.close();
		}


		public static void readExcelFile(XSSFSheet sheet){
			Iterator<Row> itr = sheet.iterator();
			 // Iterating over Excel file in Java 
			 while (itr.hasNext()) { 
			Row row = itr.next();
			 // Iterating over each column of Excel file 
			 Iterator<Cell> cellIterator = row.cellIterator();
			 while (cellIterator.hasNext()) { 
			Cell cell = cellIterator.next();
			 switch (cell.getCellType()) { 
			 case Cell.CELL_TYPE_STRING: 
				 System.out.print(cell.getStringCellValue() + "\t");
			 break;
			 case Cell.CELL_TYPE_NUMERIC: 
				 System.out.print(cell.getNumericCellValue() + "\t");
			 break;
			 case Cell.CELL_TYPE_BOOLEAN: 
				 System.out.print(cell.getBooleanCellValue() + "\t");
			 break;
			 default: 
				 } 
			 } 
			 System.out.println("");
			 }

		}
		


}
