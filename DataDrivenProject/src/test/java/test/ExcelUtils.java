package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowCount(String xlFile, String xlSheet) throws Exception {
		fis = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(xlSheet);
		int rowCount = sheet.getLastRowNum();
		wb.close();
		fis.close();
		return rowCount;
	}

	public static int getCellCount(String xlFile, String xlSheet, int rowNum) throws Exception {
		fis = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(xlSheet);
		row = sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		wb.close();
		fis.close();
		return cellCount;
	}

	public static String getCellData(String xlFile, String xlSheet, int rowNum, int cellNum) throws IOException {
		fis = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(xlSheet);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);

		String data;

		// data=cell.toString();
		try {
			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell);
			return data;
		} catch (Exception e) {
			data = "";
		}
		wb.close();
		fis.close();

		return data;
	}

	public static void setCellData(String xlFile, String xlSheet, int rowNum, int cellNum, String data)
			throws IOException {
		fis = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(xlSheet);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		
		fos= new FileOutputStream(xlFile);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
		

	}

}
