package javaPack;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KeyboardActions {
WebDriver driver;
	
	@Test
	public void cssSelector() throws InterruptedException
	{
		driver.get("https://www.tsrtconline.in/oprs-web/guest/home.do?h=1");
		
		driver.findElement(By.xpath("//input[@name='fromPlaceName']")).sendKeys("Hyd");
		
		List<WebElement> dd=driver.findElements(By.xpath("//ul[@id='ui-id-1']//li"));
		Thread.sleep(2000);
		System.out.println(dd.size());
		for(WebElement list:dd)
		{
			if(list.getText().contains("HYDERABAD DARSHAN 3"))
			{
				list.click();
				break;
			}
		}
	}
	@BeforeTest
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	//@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
