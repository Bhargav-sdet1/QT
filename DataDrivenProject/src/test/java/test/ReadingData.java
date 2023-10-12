package test;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingData {

	public static void main(String args[]) throws Exception {
		FileInputStream fis = new FileInputStream("C:\\Users\\bharg\\TestExcel.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		XSSFRow row = sheet.getRow(1);
		XSSFCell cell = row.getCell(1);
		
		int rowSize=sheet.getLastRowNum();
		System.out.println(rowSize);
		
		int colSize =sheet.getRow(1).getLastCellNum();
		System.out.println(colSize);
		System.out.println(cell.toString());
		wb.close();
		fis.close();

	}

}
