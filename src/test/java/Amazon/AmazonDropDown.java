package Amazon;
//This is for test
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonDropDown {
	WebDriver driver;
//This is added for Git test
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void departmentNames() {
		driver.get("https://www.amazon.com/");
		WebElement item = driver.findElement(By.id("searchDropdownBox"));
		Select dept = new Select(item);
		dept.selectByVisibleText("Books");
		driver.findElement(By.xpath("//input[@value='Go']")).click();

		boolean books = driver.findElement(By.xpath("//img[@alt='Books at Amazon']")).isDisplayed();
		Assert.assertTrue(books);
	}

	@Test(priority = 0)
	public void languagePreference() {
		driver.get("https://www.amazon.com/");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Radio button");
		driver.findElement(By.xpath("//input[@value='Go']")).click();
		driver.findElement(By.xpath("//i[@aria-label='Prime Eligible']")).click();

		boolean lang = driver.findElement(By.id("p_85-title")).isDisplayed();
		Assert.assertTrue(lang);
	}

	@AfterTest
	public void quit() {
		driver.quit();
	}

}
