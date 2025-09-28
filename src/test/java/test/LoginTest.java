package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.BaseClass;
import page.LoginPage;
import page.Sign_UP_Page;

public class LoginTest extends BaseClass 
{
	LoginPage lp;
	WebDriverWait wait;
	@BeforeMethod
	public void browseropen()
	{
		openbrowser();
		lp=new LoginPage(driver);
	}
	@Test(priority=1)
	public void LoginWithInvalidEmail()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input_your_working_email']")));
		lp.loginpageenter_Email("himefa4172@gddcorp.com");
		lp.loginpageenter_Password("Ringne@123");
		lp.loginpageenter_Loginbutton();
		
	    String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='MuiAlert-message css-1xsto0d']"))).getText();
			
		Assert.assertEquals(text,"User doesn't exist");
		
		
	}
	
	@Test(priority=2)
	public void LoginWithValidEmail()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input_your_working_email']")));
		lp.loginpageenter_Email("himefa4170@gddcorp.com");
		lp.loginpageenter_Password("Ringne@123");
		lp.loginpageenter_Loginbutton();
		
	    String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Onboarding Process']"))).getText();
			
		Assert.assertEquals(text,"Onboarding Process");
		
		
	}
	@AfterMethod
	public void closeb()
	{
		driver.close();
	}

}
