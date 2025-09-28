package page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass 
{
	public WebDriver driver;
	
	public void openbrowser()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev.hellobooks.ai/login");
		
		
	}

}
