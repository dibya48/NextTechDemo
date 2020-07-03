package BoA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseoverAndCheckBox {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp () {
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Driver\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.bankofamerica.com/");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test (priority=1)
	public void emergencyCash() throws InterruptedException{
	
		driver.findElement(By.linkText("Emergency cash: What are your options?")).click();
		
		Actions AboutUs = new Actions(driver);
		AboutUs.moveToElement(driver.findElement(By.linkText("Taxes & Income"))).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Planning")).click();
		
		boolean planning = driver.findElement(By.linkText("Planning")).isDisplayed();
		Assert.assertTrue(planning);
		
	}
	
	@Test (priority=0)
	public void saveOnlineID() {
		driver.findElement(By.name("onlineId1")).sendKeys("dibya1000");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("NextTech2020");
		driver.findElement(By.id("saveOnlineId")).click();
		driver.findElement(By.id("signIn")).click();
		
		boolean forgotId = driver.findElement(By.xpath("//h1[@id='skip-to-h1']")).isDisplayed();
		Assert.assertTrue(forgotId);
	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}

}
