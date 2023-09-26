package javaPack;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class CyclosBase {
	
	WebDriver driver;
	
	@Parameters({"browser"})
	@BeforeClass
	public void setUp(String browser) {
		
		if(browser.equals("GC"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equals("FF"))
		{
			driver = new FirefoxDriver();
		}
		else if(browser.equals("Edge"))
		{
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	}

	@AfterClass
	public void tearDown() throws IOException {
		driver.close();
	}

}
