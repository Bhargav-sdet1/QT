package javaPack;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CyclosLogin {

	WebDriver driver;

	@Test
	public void cssSelector() throws InterruptedException {
		driver.get("https://demo.cyclos.org/ui/home");
		driver.findElement(By.xpath("//a[@id='login-link']")).click();
		// Enter UName
		WebElement uName = driver.findElement(By.xpath("//input[@autocomplete='username']"));
		uName.clear();
		uName.sendKeys("");
		String givenuname = driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value");
		// Enter Password
		WebElement uPassword = driver.findElement(By.xpath("//input[@autocomplete='password']"));
		uPassword.clear();
		uPassword.sendKeys("");
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

	}

	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
