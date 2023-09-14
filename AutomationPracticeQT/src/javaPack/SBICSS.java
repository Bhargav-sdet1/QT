package javaPack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SBICSS {
	WebDriver driver;
	@BeforeTest
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@Test
	public void cssSelector() throws InterruptedException
	{
		driver.get("https://www.onlinesbi.sbi/");
		driver.findElement(By.cssSelector(".classicTxt")).click();
		driver.findElement(By.cssSelector("div.continue_btn a.login_button")).click();
		driver.findElement(By.cssSelector("ul.user_links")).click();
		Thread.sleep(2000);
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	

}
