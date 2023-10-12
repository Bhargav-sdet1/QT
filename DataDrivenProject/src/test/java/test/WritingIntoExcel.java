package test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingIntoExcel {

	public static void main(String[] args) throws Exception {
		
	FileOutputStream fos = new FileOutputStream("C:\\Users\\bharg\\TestExcel1.xlsx");
	
	XSSFWorkbook wb = new XSSFWorkbook();
	XSSFSheet sheet = wb.createSheet("Sheet1");
	XSSFRow row = sheet.createRow(1);
	XSSFCell cell = row.createCell(4);
	
	cell.setCellValue("Yes");
	wb.write(fos);
	wb.close();
	fos.close();
	
	

	}

}
