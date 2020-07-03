package seleniumIntroduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterMercuryTours {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");                    //get url on the browser
		driver.manage().window().maximize();						   //To maximize the website
		driver.findElement(By.name("userName")).sendKeys("mercury");
		Thread.sleep(1000);
		driver.findElement(By.name("password")).sendKeys("mercury");
		Thread.sleep(1000);
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
		driver.navigate().to("https://www.yahoo.com/");    //To navigate to another website
		driver.navigate().back();
		driver.navigate().forward();
		driver.quit();
	}

}  
