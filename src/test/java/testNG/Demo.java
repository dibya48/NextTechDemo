package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo {
	
	public WebDriver driver;                                //Making driver Global so that it can be used anywhere.
	
	@BeforeTest
	public void openDell() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();                            //We changed into driver as below as we have declared in Global.
		driver =new ChromeDriver();
		//driver.get("https://www.dell.com/en-us");                         //We moved this inside test case.
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
    @Test(priority=1)
    
    public void TitleComparison1() {
    driver.get("https://www.amazon.com/");  
	driver.manage().window().maximize();
	
	String ExpectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
	String ActualTitle = driver.getTitle();
	
	if (ActualTitle.equalsIgnoreCase(ExpectedTitle))
	{
		System.out.println("Test case passed");
	}
	else
	{
		System.out.println("Test case failed");
	}
	
		driver.quit();

}

    
    @Test(priority=0)
    public void seleniumPractice1() throws InterruptedException
    {
	driver.get("https://seleniumpractise.blogspot.com/search?q=radio+button");                           
	driver.manage().window().maximize();									
	driver.findElement(By.name("female")).click();
	driver.findElement(By.id("python")).click();
	
	WebDriverWait wait = new WebDriverWait(driver, 10);     // We can create object of wait in Global to use for all test cases.
	//WebElement ee = driver.findElement(By.id("code"));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("code")));
	driver.findElement(By.id("code")).click();
	Thread.sleep(5000);
	
    }
    
    @AfterTest
    public void quit() {
	
	driver.quit();
}
}



