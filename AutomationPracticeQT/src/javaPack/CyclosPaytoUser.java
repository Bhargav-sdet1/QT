package javaPack;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CyclosPaytoUser {
	WebDriver driver;

	@Test
	public void QR() throws InterruptedException {
		driver.get("https://demo.cyclos.org/ui/login");
		assertTrue(driver.findElement(By.xpath("//a[@class='navbar-brand']")).isDisplayed());

		// Enter UserName
		WebElement uName = driver.findElement(By.xpath("//input[@autocomplete='username']"));
		uName.sendKeys("demo");
		// Enter Password
		WebElement uPassword = driver.findElement(By.xpath("//input[@autocomplete='password']"));
		uPassword.sendKeys("1234");
		// Click Login
		driver.findElement(By.xpath("//action-button//button[@type='button']")).click();

		// Enter 10 in Amount
		driver.findElement(By.xpath("//div[2]/div/div/div/a/div")).click();
		driver.findElement(By.xpath("//input")).sendKeys("A");

		List<WebElement> dd = driver.findElements(By.xpath("//div[@role='listbox']//a"));

		for (WebElement ll : dd) {
			if (ll.getText().equalsIgnoreCase("Active Walking")) {
				ll.click();
				break;
			}
		}
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@class='input-group']//input")).sendKeys("10");
		driver.findElement(By.xpath("//action-button//button[@type='button']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//action-button//button[@type='button']")).click();

		Thread.sleep(2000);
		WebElement logout=driver.findElement(By.xpath("//a[@id='logout-trigger']"));
		
		//Click logout
		logout.click();
	}

	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	}

	//@AfterTest
	public void tearDown() throws IOException {
		driver.close();
	}
}
