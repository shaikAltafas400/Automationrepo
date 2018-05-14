package Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelProvider {

	private static XSSFWorkbook workbook = null;
	private static XSSFSheet sheet = null;
	private static XSSFRow row = null;
	private static XSSFCell cell = null ;
	private static FileInputStream fis = null;
	private String path = null ;
	
	public ExcelProvider(String path) throws IOException {
		this.path = path;
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
	sheet = workbook.getSheetAt(0);
	fis.close();
	}
	
	public static int getRowCount(String sheetname) { 
		sheet = workbook.getSheet(sheetname);
		int rows = sheet.getLastRowNum();
		return rows;
	}
	
	public static int getColumnCount(String sheetname) { 
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(0);
		int cols = row.getLastCellNum();
		return cols;
	}
	
	public static String getCellData(int mrow,int mcol)
	{
	cell = sheet.getRow(mcol).getCell(mcol);
	// cell = row.getCell(mcol);
	System.out.println(cell.getStringCellValue());
	return cell.getStringCellValue();
	
	}
	
	public static Object[][] getDataProviderData(ExcelProvider getTestDataFromExcel,String sheetName){
		
		sheet = workbook.getSheet(sheetName);
		int rowcount = ExcelProvider.getRowCount(sheetName);
		System.out.println(rowcount);
		int colCount = ExcelProvider.getColumnCount(sheetName);
		System.out.println(colCount);
		
		Object[][] data = new Object[rowcount +1][colCount];
		for(int rownum = 0;rownum <=rowcount;rownum++)
		{
			for(int colnum = 0;colnum < colCount; colnum++) {
				System.out.println();
				data[rownum][colnum] = getCellData(rownum,colnum);
			}
		}
		return data;	
	}
}
