package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Frame {
	WebDriver driver;
	@Test
	public void WindowHandler() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://docs.oracle.com/javase/7/docs/api/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       
		driver.switchTo().frame("classFrame");                 //selecting specific frame; we have to select 'frame at parent'
		Thread.sleep(4000);
		driver.findElement(By.linkText("java.awt")).click();
		driver.switchTo().defaultContent();                    //This will bring back to homepage.  
		Thread.sleep(4000);
		driver.quit();
	}		

}
