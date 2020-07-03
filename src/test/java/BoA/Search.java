package BoA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Search {
	
WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
		@Test (priority=1)
		public void loginCredentials() {
			driver.get("https://www.bankofamerica.com/");
			driver.findElement(By.id("onlineId1")).sendKeys("dibya1000");
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys("NextTech2020");
			driver.findElement(By.xpath("//button[@id='signIn']")).click();
			
			boolean alert = driver.findElement(By.xpath("//h1[@id='skip-to-h1']")).isDisplayed();
			Assert.assertTrue(alert);
			}
		
		@Test (priority=0)
		public void searchField() {
			driver.get("https://www.bankofamerica.com/");
			driver.findElement(By.xpath("//input[@id='nav-search-query']")).sendKeys("Locations in Irving");
			
			WebDriverWait wait = new WebDriverWait(driver, 10);      // Line 44 and 45 are for Explicit wait example, which wait for individual webElement   
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Search']")));
			driver.findElement(By.xpath("//input[@value='Search']")).click();
			
			boolean locations = driver.findElement(By.linkText("Find financial centers & ATM locations")).isDisplayed();
			Assert.assertEquals(locations, true);
		}
		
		@AfterTest
		public void quit() {
			driver.quit();
		}
		
	}


