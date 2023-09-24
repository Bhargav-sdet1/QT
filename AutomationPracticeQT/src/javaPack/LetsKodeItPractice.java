package javaPack;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LetsKodeItPractice {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		
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
		
		//Element Displayed Example and verify is displayed
		WebElement showBtn= driver.findElement(By.xpath("//input[@id='show-textbox']"));
		showBtn.click();
		WebElement showtextField=driver.findElement(By.xpath("//input[@id='displayed-text']"));
		boolean showField=showtextField.isDisplayed();
		System.out.println(showField);
		if(showField==true)
		{
			showtextField.sendKeys("In Show field");
		}
		
		//Click on Hide and verify isDisplayed->false
		WebElement hideBtn= driver.findElement(By.xpath("//input[@id='hide-textbox']"));
		hideBtn.click();
		
		showField=showtextField.isDisplayed();
		System.out.println(showField);
		
		//Alert
		WebElement alertText=driver.findElement(By.xpath("//input[@name='enter-name']"));
		alertText.sendKeys("Bhargav");
		//On click alert
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		
		//On click Confirm alert and cancel
		alertText.sendKeys("Bhargav Ram");
		driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		
		WebElement hoverEle=driver.findElement(By.xpath("//button[@id='mousehover']"));
		//Scroll to a element
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", hoverEle);
		
		//Mousehover Example
		Actions actions = new Actions(driver);						
		actions.moveToElement(hoverEle).build().perform();

		//Selecting Top
		driver.findElement(By.xpath("//div[@class='mouse-hover-content']//a[text()='Top']")).click();
		Thread.sleep(2000);
		
		//Switch Tab Example

		driver.findElement(By.xpath("//a[@id='opentab']")).click();		
		Set<String> winHandles=driver.getWindowHandles();
		System.out.println(winHandles);
		Iterator<String> it=winHandles.iterator();
		String parentWin=it.next();
		String childWin=it.next();
		
		driver.switchTo().window(childWin);
		driver.findElement(By.xpath("//div/a[text()='Sign In']")).click();
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(parentWin);
		
		//Switch Window Example

		driver.findElement(By.xpath("//*[@id='openwindow']")).click();
		winHandles=driver.getWindowHandles();
		Iterator<String> it2=winHandles.iterator();
		System.out.println(winHandles);
		String parentWin2=it2.next();
		String childWin2=it2.next();
		Thread.sleep(2000);
		driver.switchTo().window(childWin2);
		driver.findElement(By.xpath("//div/a[text()='Sign In']")).click();
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(parentWin2);
		
		//Scroll to WebTable
		WebElement webTable=driver.findElement(By.xpath("//div[@id='table-example-div']//legend"));
		JavascriptExecutor js2=(JavascriptExecutor) driver;
		js2.executeScript("arguments[0].scrollIntoView(true)", webTable);
		
		//print firstcourse name
		WebElement firstCourse=driver.findElement(By.xpath("//table[@id='product']//tr[2]//td[2]"));
		System.out.println(firstCourse.getText());
		
		driver.close();
		
		
	}

}
