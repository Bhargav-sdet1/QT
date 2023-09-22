package javaPack;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScreenshotWithDate {

	WebDriver driver;

	@Test
	public void testLinks() throws IOException, InterruptedException {
		// Load WebPage
		driver.get("https://www.letskodeit.com/practice");
		//Verify logo
		assertTrue(driver.findElement(By.xpath("//img[@class='img-fluid']")).isDisplayed());

		//Date 
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		Date date = new Date();
		
		//Screenshot
		TakesScreenshot ts = (TakesScreenshot)driver;	
		File targetFile=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(targetFile, new File("C:\\Users\\bharg\\QT-Selenium-Java\\AutomationPracticeQT\\Screenshots\\"+sdf.format(date)+".png"));
		Thread.sleep(2000);
		
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
