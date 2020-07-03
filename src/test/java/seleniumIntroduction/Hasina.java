package seleniumIntroduction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Hasina {
WebDriver driver;

@BeforeMethod
public void setUpBrowser(){
System.setProperty("webdriver.chrome.driver","C:\\\\Driver\\\\chromedriver.exe");
driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
driver.get("https://www.yahoo.com/");
}
@Test
public void YahooTitleTest(){
String title = driver.getTitle();
System.out.println(title);

}
@Test
public void Yahooverification(){
boolean b = driver.findElement(By.xpath("//img[@title = 'Yahoo']")).isDisplayed();
Assert.assertTrue(b);

}
@Test
public void Newslink(){
boolean b = driver.findElement(By.xpath("//*[@id='header-nav-bar']/li[3]/a")).isDisplayed();
Assert.assertTrue(b);

}
@Test
public void clickNews(){
driver.findElement(By.linkText("News")).click();

}
@AfterMethod
public void quitBrowser(){
driver.close();
driver.quit();
}



}

