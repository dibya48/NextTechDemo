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

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DatePicker {
	
	WebDriver driver;
	@Test
	public void WindowHandler() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.southwest.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@id='LandingAirBookingSearchForm_originationAirportCode']")).clear();
		driver.findElement(By.xpath("//input[@id='LandingAirBookingSearchForm_originationAirportCode']")).sendKeys("FLL");
	
		driver.findElement(By.xpath("//input[@id='LandingAirBookingSearchForm_destinationAirportCode']")).sendKeys("DFW");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('LandingAirBookingSearchForm_departureDate').value='08/27/2020'");   //Always use Id for this.
		js.executeScript("document.getElementById('LandingAirBookingSearchForm_returnDate').value='09/13/2020'");
		Thread.sleep(5000);
		
		driver.quit();
	}

}
