package BoA;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LogoAndOpenAccount {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.bankofamerica.com/");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void logo() {
		boolean b = driver.findElement(By.xpath("//img[@itemprop='logo']")).isDisplayed();
		System.out.println("This test case is: " + b);
		Assert.assertTrue(b);
	}

	@Test(priority = 0)
	public void openAnAccount() {
		driver.findElement(By.linkText("Open an Account")).click();
		String Title = driver.getTitle();
		System.out.println("This is a Title: " + Title);

		boolean oa = driver.findElement(By.xpath("//img[@class='navigation__logo']")).isDisplayed();
		Assert.assertEquals(oa, true);
	}

	@AfterMethod
	public void tearDown() {

		driver.close();
	}

}
