package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PrintingAllExcelData {

	public static void main(String[] args) throws Exception {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\bharg\\TestExcel.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int rowSize=sheet.getLastRowNum();
		int colSize=sheet.getRow(0).getLastCellNum();
	
		
		for(int r=0;r<=rowSize;r++)
		{	
			for(int c=0;c<colSize;c++)
			{
				System.out.print(sheet.getRow(r).getCell(c).toString());
				System.out.print("  ");
			}
			System.out.println();
		}
		
	}

}
