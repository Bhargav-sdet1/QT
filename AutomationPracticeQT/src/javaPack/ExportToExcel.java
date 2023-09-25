package javaPack;

import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExportToExcel {
	
	String fileLoc="C:\\Users\\bharg\\Selenium_Script_Sept2023\\Files\\Write1.xlsx";
	
	@Test
	public void exportExcel() throws Exception
	{
		FileOutputStream fos = new FileOutputStream(fileLoc);
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet s = wb.createSheet("Sheet99");
		XSSFRow r = s.createRow(0);
		r.createCell(0).setCellValue("Selenium");
		wb.write(fos);
		wb.close();
		
	}
}
