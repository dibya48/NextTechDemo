package seleniumIntroduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TitleComparison {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		WebDriver driver =  new ChromeDriver();  
		driver.get("https://www.amazon.com/");  
		driver.manage().window().maximize();
		
		String ExpectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
		String ActualTitle = driver.getTitle();
		
		if (ActualTitle.equalsIgnoreCase(ExpectedTitle))
		{
			System.out.println("Test case passed");
		}
		else
		{
			System.out.println("Test case failed");
		}
		
			driver.quit();
	}

}
