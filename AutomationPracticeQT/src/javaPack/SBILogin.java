package javaPack;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver; 
public class SBILogin {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();

		driver.get("https://www.onlinesbi.sbi/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//span[@class='classicTxt']")).click();
		driver.findElement(By.xpath("//div[@class='continue_btn']/a")).click();
		
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Bhargav");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Bhargav");
		
		driver.findElement(By.xpath("//input[@class='chek_box']")).click();
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.switchTo().alert().accept();
		
		//driver.quit();
		
		
	}

}
