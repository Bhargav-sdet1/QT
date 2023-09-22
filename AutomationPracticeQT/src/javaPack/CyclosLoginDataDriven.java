package javaPack;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CyclosLoginDataDriven {

	WebDriver driver;

	@Test
	public void cssSelector() throws InterruptedException, IOException {
		//Load WebPage
		driver.get("https://demo.cyclos.org/ui/home");
		//Verify Home link
		assertTrue(driver.findElement(By.xpath("//a[@id='menu_home']")).isDisplayed());
		//Read Data from Excel
		FileInputStream fis = new FileInputStream("C:\\Users\\bharg\\Selenium_Script_Sept2023\\Files\\LoginData.xlsx");
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		
		for(int i=1;i<=sheet.getLastRowNum();i++)
		{
			//Click login
			driver.findElement(By.xpath("//a[@id='login-link']")).click();
			// Enter UName
			WebElement uName = driver.findElement(By.xpath("//input[@autocomplete='username']"));
			uName.clear();
			uName.sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
			String givenuname = driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value");
			// Enter Password
			WebElement uPassword = driver.findElement(By.xpath("//input[@autocomplete='password']"));
			uPassword.clear();
			uPassword.sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());
			String givenpassword = driver.findElement(By.xpath("//input[@type='password']")).getAttribute("value");

			// Click Submit
			driver.findElement(By.xpath("//button[@type='button']//span")).click();
			
			//if user given empty uname and pwd
			if (givenuname.equals("") && givenpassword.equals("")) {
				assertEquals(driver.findElement(By.cssSelector(".principal .invalid-feedback")).getText(),
						"This field is required");
				assertEquals(driver.findElement(By.cssSelector(".d-block .invalid-feedback")).getText(),
						"This field is required");
			}
			//if user given empty pwd
			else if (!(givenuname.equals("")) && givenpassword.equals("")) {
						assertEquals(driver.findElement(By.cssSelector(".d-block .invalid-feedback")).getText(),
								"This field is required");
					}
					//if user given empty UName
			else if (givenuname.equals("") && !(givenpassword.equals(""))) {
						assertEquals(driver.findElement(By.cssSelector(".principal .invalid-feedback")).getText(),
								"This field is required");
					}
			
			//if user given valid UName and password
			else if(givenuname.equals("demo") && givenpassword.equals("1234")) {
				Thread.sleep(2000);
				WebElement logout=driver.findElement(By.xpath("//a[@id='logout-trigger']"));
				isElementPresent(driver, By.xpath("//a[@id='logout-trigger']"));
				//Click logout
				logout.click();
					}
			
			//if user given invalid UName and password
			else {
				Thread.sleep(2000);
				assertEquals(driver.findElement(By.xpath("//div[@class='notification-message']")).getText(),
						"The given name / password are incorrect. Please, try again.");
				driver.findElement(By.xpath("//span[@aria-hidden='true']")).click();
			}
					
		}
		
		
		
	}
	public boolean isElementPresent(WebDriver driver, By locator)
	{
		try {
			driver.findElement(locator);
			return true;
		}
		catch(NoSuchElementException e)
		{
			return false;
		}
		
	}

	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	}

	@AfterTest
	public void tearDown() throws IOException {
		driver.close();
	}

}
