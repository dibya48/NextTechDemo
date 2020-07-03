package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class MultipleDropDownButtonNG {

	@Test
	public void MultNG() {
		System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		WebElement Month = driver.findElement(By.id("month"));
		Select m = new Select(Month);
		m.selectByVisibleText("Aug");
		
		//driver.findElement(By.className("inputtext _58mg _5dba _2ph-")).sendKeys("Dibya"); //We can't use class attribute which has space. These type 
		                                                                                   //of value is called compound value.
		driver.findElement(By.name("firstname")).sendKeys("Dibya");
		driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Rajbhandari");          // using cssSelector.
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("dibya@gmail.com");
		driver.findElement(By.xpath("//input[@autocomplete='new-password']")).sendKeys("abcd1234");
		
		WebElement DoB = driver.findElement(By.id("day"));
		Select D = new Select(DoB);
		D.selectByValue("9");
	
		WebElement year = driver.findElement(By.id("year"));
		Select y = new Select(year);
		y.selectByIndex(11);
		
		//driver.findElement(By.className("_8esa")).click();          // we can't use class because it gave 1 of 3 values.
		driver.findElement(By.xpath("//input[@value='2']")).click();
			
		driver.quit();

	}

}
