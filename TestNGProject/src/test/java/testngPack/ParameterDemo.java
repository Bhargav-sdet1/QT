package testngPack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterDemo {
	WebDriver driver;

	@BeforeClass
	@Parameters({ "browser","url" })
	void setUp(String br, String url1) {
		if (br.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (br.equals("Firefox")) {
			driver = new FirefoxDriver();
		}

		if (url1.equals("qa")) {
			driver.get("https://muse-qa.goarya.com/");
		} else if (url1.equals("prod")) {
			driver.get("https://muse.goarya.com/");
		}

		//driver.get("https://muse.goarya.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	void login() throws InterruptedException {
		Thread.sleep(3000);
		// Enter UName
		WebElement UEmail = driver.findElement(By.xpath("//input[@name='username']"));
		UEmail.clear();
		UEmail.sendKeys("nov9@yopmail.com");
		// Enter Password
		WebElement uPassword = driver.findElement(By.xpath("//input[@name='password']"));
		uPassword.clear();
		uPassword.sendKeys("Asdfg1@34");
		// Click Submit
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		boolean homeicon = driver.findElement(By.xpath("//li[@role='menuitem']//a")).isDisplayed();
		Assert.assertTrue(homeicon);
	}

	@AfterClass
	void tearDown() {
		driver.quit();
	}
}
