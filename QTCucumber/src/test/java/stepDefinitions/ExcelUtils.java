package stepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	XSSFWorkbook wb;
	XSSFSheet s;
	ExcelUtils(String excelPath,String sheetName) throws Exception
	{
		FileInputStream fis=new FileInputStream(excelPath);
		wb=new XSSFWorkbook(fis);
		s=wb.getSheet(sheetName);
	}
	public void setCellData(int rowindex,int colindex,String result,String excelPath) throws Exception
	{
		s.getRow(rowindex).createCell(colindex).setCellValue(result);
		FileOutputStream fos=new FileOutputStream(excelPath);
		wb.write(fos);
	}
	public String getCellData(int rowindex,int colindex)
	{
		return s.getRow(rowindex).getCell(colindex).getStringCellValue();
	}

}
