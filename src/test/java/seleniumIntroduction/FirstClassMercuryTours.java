package seleniumIntroduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FirstClassMercuryTours {

	public static void main(String[] args) throws InterruptedException  {

System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.get("http://newtours.demoaut.com/");                            //get url on the browser

System.out.println(driver.getTitle());								   //Validate if page title is correct
System.out.println(driver.getCurrentUrl());							   // Validate correct url
// System.out.println(driver.getPageSource());							   // To get page source; sometimes page source is not allowed clicking 
                                                                       // right click of mouse. It's too long so we disabled for now.
driver.manage().window().maximize();									//To maximize the website

driver.findElement(By.linkText("REGISTER")).click();             //LinkText starts with Anchor tag 'a' while inspecting WebElement.
driver.findElement(By.name("firstName")).sendKeys("Dibya");
driver.findElement(By.name("lastName")).sendKeys("Rajbhandari");
driver.findElement(By.name("phone")).sendKeys("123456");
driver.findElement(By.id("userName")).sendKeys("dibya@gmail.com");
Thread.sleep(2000);
driver.findElement(By.name("address1")).sendKeys("1234 Northgate Dr");
driver.findElement(By.name("address2")).sendKeys("Apt 910");
driver.findElement(By.name("city")).sendKeys("Irving");
driver.findElement(By.name("state")).sendKeys("Texas");
driver.findElement(By.name("postalCode")).sendKeys("987456");

WebElement countryName = driver.findElement(By.name("country"));
Select con = new Select(countryName);
con.selectByValue("32");                       //If we need to find the country by number given.
Thread.sleep(2000);
con.selectByVisibleText("BANGLADESH ");		   //If we need to find country by name. This is preferred one as they don't change the name in future.
Thread.sleep(2000);
con.selectByIndex(0);						   //If we need to find country by array index number.
Thread.sleep(2000);

driver.findElement(By.id("email")).sendKeys("mercury");
driver.findElement(By.name("password")).sendKeys("mercury");
driver.findElement(By.name("confirmPassword")).sendKeys("mercury");
Thread.sleep(2000);
driver.findElement(By.name("register")).click();
Thread.sleep(5000);
driver.quit();

	}

}
