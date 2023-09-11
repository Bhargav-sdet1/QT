package javaPack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonXpathSiblings {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//div[@id='nav-xshop-container']//a[5]")).click();
		driver.findElement(By.xpath("//div[@id='nav-xshop-container']//a[5]/preceding-sibling::a[1]")).click();
		driver.findElement(By.xpath("//div[@id='nav-xshop-container']//a[5]/following-sibling::a[1]")).click();
		
		driver.close();
	}

}
