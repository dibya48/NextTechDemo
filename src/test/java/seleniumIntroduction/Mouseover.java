package seleniumIntroduction;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Mouseover {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		
		WebDriver driver =  new ChromeDriver();  
		driver.get("https://www.dell.com/en-us");  
		driver.manage().window().maximize();
		
		Actions ac =new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("//button[contains(text(),\'Financing\')]"))).build().perform();
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Pay Bill & Manage Account")).click();
		
		Thread.sleep(2000);
		driver.quit();
	}

}
