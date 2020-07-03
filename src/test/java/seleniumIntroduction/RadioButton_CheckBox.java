package seleniumIntroduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton_CheckBox {

	public static void main(String[] args) throws InterruptedException  {

System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.get("https://seleniumpractise.blogspot.com/search?q=radio+button");                           
driver.manage().window().maximize();									
driver.findElement(By.name("female")).click();
Thread.sleep(2000);
driver.findElement(By.id("python")).click();
Thread.sleep(2000);
driver.findElement(By.id("code")).click();
Thread.sleep(2000);
driver.quit();

	}

}
