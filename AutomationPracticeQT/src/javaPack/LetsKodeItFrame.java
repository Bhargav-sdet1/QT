package javaPack;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LetsKodeItFrame {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.letskodeit.com/practice");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Scroll to Iframe
		WebElement iframeHead=driver.findElement(By.xpath("//div[@id='iframe-example-div']//legend"));
		JavascriptExecutor js2=(JavascriptExecutor) driver;
		js2.executeScript("arguments[0].scrollIntoView(true)", iframeHead);
		
		//Switch to frame
		driver.switchTo().frame("iframe-name");
		driver.findElement(By.xpath("//a[text()='Sign In']")).click();
		
		//Switch to webpage
		driver.switchTo().defaultContent();
		
	}

}
