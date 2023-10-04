package config;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
	public static WebDriver driver;
	public static String browser ="FF";
	public static String url = "https://demo.cyclos.org/ui/home";
	public static void LaunchBrowser()
	{
		
		if(browser=="GC")
		{
			driver = new ChromeDriver();
		}
		else if(browser=="FF")
		{
			driver = new FirefoxDriver();
		}
		else if(browser=="Edge")
		{
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		// Load WebPage
		driver.get(url);
	}
	
	public static void tearDown()
	{
		driver.quit();
	}

}
