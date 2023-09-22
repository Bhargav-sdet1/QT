package javaPack;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrokenLinks {

	WebDriver driver;

	@Test
	public void testLinks() {
		// Load WebPage
		driver.get("https://www.letskodeit.com/practice");
		// Verify Home link
		assertTrue(driver.findElement(By.xpath("//img[@class='img-fluid']")).isDisplayed());

		List<WebElement> links = driver
				.findElements(By.xpath("//div[contains(@class,'container')]//div[@data-component='list']//ul//li//a"));

		for (WebElement l : links) {
		//	System.out.println(l.getAttribute("href"));
			try {
				if (l.getAttribute("href") != null) {
					URL url = new URL(l.getAttribute("href"));
					HttpURLConnection con = (HttpURLConnection)url.openConnection();
					con.setConnectTimeout(60000);
					con.connect();

					if (con.getResponseCode() == 200) {
						System.out.println("Link" + url + "is working fine");
					} else {
						System.out.println("Link" + url + "is not working fine");
					}
				}

			} catch (Exception e) {
				System.out.println(e);
				Assert.fail();
			}
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
