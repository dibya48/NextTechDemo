package seleniumIntroduction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintEntireLinks {

	public static void main(String[] args) throws InterruptedException  {

System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.get("https://www.amazon.com/");                            //get url on the browser

System.out.println(driver.getTitle());								   //Validate if page title is correct
System.out.println(driver.getCurrentUrl());							   // Validate correct url
// System.out.println(driver.getPageSource());							   // To get page source; sometimes page source is not allowed clicking 
                                                                       // right click of mouse. It's too long so we disabled for now.
driver.manage().window().maximize();									//To maximize the website


List<WebElement> wb = driver.findElements(By.tagName("a"));
System.out.println("Total links are " + wb.size());           //This will print total number of links in number, for example '339'

for (int i=0; i<wb.size(); i++)
{
	System.out.println(wb.get(i).getAttribute("href"));  // Loop with GetAttribute will print all the Link name.
}
driver.quit();

	}

}
