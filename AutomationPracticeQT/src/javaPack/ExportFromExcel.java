package javaPack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExportFromExcel {
	
	String fileName= "C:\\Users\\bharg\\Selenium_Script_Sept2023\\Files\\LoginData.xlsx";
	
	@Test
	public void importExcel() throws Exception
	{
		FileInputStream fis = new FileInputStream(fileName);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet s= wb.getSheet("Sheet1");
		String ss=s.getRow(1).getCell(0).getStringCellValue();
		System.out.println(ss);
	}

}
