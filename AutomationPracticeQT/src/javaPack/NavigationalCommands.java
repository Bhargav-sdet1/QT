package javaPack;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NavigationalCommands {
	WebDriver driver;

	@Test
	public void navCommands() {
		// Load WebPage
		driver.navigate().to("https://retail.onlinesbi.sbi/");
		// Verify Home link
		assertTrue(driver.findElement(By.xpath("//a[@id='logo']")).isDisplayed());
		
		driver.findElement(By.xpath("//a[@class='login-new']")).click();
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.manage().deleteAllCookies();
		
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
