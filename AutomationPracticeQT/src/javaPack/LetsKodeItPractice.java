package javaPack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LetsKodeItPractice {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.letskodeit.com/practice");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Selecting benz radio button
		WebElement benzRadioBtn=driver.findElement(By.xpath("//div[@class='left-align']//input[@value='benz']"));
		benzRadioBtn.click();
		
		//Verify with Is Selected
		System.out.println(benzRadioBtn.isSelected());
		
		//Selecting BWM and Honda check boxes
		WebElement bmwCheckbox=driver.findElement(By.xpath("//div[@class='cen-align']//input[@value='bmw']"));
		bmwCheckbox.click();
		WebElement hondaCheckbox=driver.findElement(By.xpath("//div[@class='cen-align']//input[@value='honda']"));
		hondaCheckbox.click();
		
		//Verify with Is Selected
		System.out.println(bmwCheckbox.isSelected());
		System.out.println(hondaCheckbox.isSelected());
		
		//Single select DropDown
		WebElement dropDown=driver.findElement(By.xpath("//select[@id='carselect']"));
		Select select = new Select(dropDown);
		//Selecting benz
		select.selectByValue("benz");
		
		//MultiSelect DropDown
		WebElement multiDropDown=driver.findElement(By.xpath("//select[@id='multiple-select-example']"));
		Select select1 = new Select(multiDropDown);
		//Selecting Apple and Peach
		select1.selectByIndex(0);
		select1.selectByVisibleText("Peach");
		
		//Enable a field, verify isEnabled, type text
		WebElement enablebtn=driver.findElement(By.xpath("//input[@id='enabled-button']"));
		enablebtn.click();
		
		WebElement enableTextField=driver.findElement
				(By.xpath("//input[@id='enabled-example-input']"));
		boolean isEnabled=enableTextField.isEnabled();
		if (isEnabled==true) {
			enableTextField.sendKeys("Hello World");
		}
		//Disable a field and verify IsEnabled->False
		WebElement disblebtn=driver.findElement(By.xpath("//input[@id='disabled-button']"));
		disblebtn.click();
		System.out.println(enableTextField.isEnabled());
		
		
		
		
		
		
		
		

	}

}
