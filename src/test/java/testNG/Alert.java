package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Alert {
	WebDriver driver;
	@Test
	public void WindowHandler() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       
		driver.findElement(By.name("proceed")).click();
		Thread.sleep(5000);
		
		driver.switchTo().alert().accept();           //accept is equal to click. We can't inspect Alert button.
		driver.close();
}
}
