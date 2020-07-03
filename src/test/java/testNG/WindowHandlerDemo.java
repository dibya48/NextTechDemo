/*Scenario: Verify user find state to apply for Home loan
 Given launch url "https://www.bankofamerica.com/"
 Then click on link 'Home loans'
 Then click on link 'Find a Home'
 Then click on 'New construction'
 Then click on new window's link 'Alabama'
 Then verify user find state to apply Home loan
 And verify user come back to Parent window
 */

package testNG;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowHandlerDemo {
	
	WebDriver driver;
	@Test
	public void WindowHandler(){
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.bankofamerica.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Home Loans")).click();
		driver.findElement(By.linkText("Find a home")).click();
		driver.findElement(By.xpath("//a[@title='Opens New Construction in a new tab.']")).click();
		
		Set<String> handle = driver.getWindowHandles();      //Starting Window Handler
		Iterator<String> it = handle.iterator();
		
		String parentWindow = it.next();  								//creating parent window
		System.out.println("This is a parent window: "+ parentWindow);
		
		String childWindow = it.next();									//creating child window
		System.out.println("This is a child window: "+ childWindow);
		
		driver.switchTo().window(childWindow);							//Switching to child window
		driver.findElement(By.linkText("Alabama (134)")).click();
		boolean boa = driver.findElement(By.xpath("//span[@class='no-mobile']")).isDisplayed();
		Assert.assertTrue(boa);
		driver.close();
		
		driver.switchTo().window(parentWindow);			//switch to parent window
		
		boolean homepage = driver.findElement(By.xpath("//a[@class='reco-host-header-link']/h1")).isDisplayed();
		Assert.assertTrue(homepage);
		System.out.println("We returned to Parent window?:" + homepage);
		
		driver.quit();
	}

}
