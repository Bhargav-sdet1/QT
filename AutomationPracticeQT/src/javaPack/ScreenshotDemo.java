package javaPack;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScreenshotDemo {

	WebDriver driver;

	@Test
	public void testLinks() throws IOException, InterruptedException {
		// Load WebPage
		driver.get("https://www.letskodeit.com/practice");
		
		TakesScreenshot ts = (TakesScreenshot)driver;	
		File targetFile=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(targetFile, new File("C:\\Users\\bharg\\QT-Selenium-Java\\AutomationPracticeQT\\Screenshots\\abc.png"));
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
