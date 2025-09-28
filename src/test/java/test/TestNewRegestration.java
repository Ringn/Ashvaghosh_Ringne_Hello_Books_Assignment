package test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.BaseClass;
import page.Sign_UP_Page;

public class TestNewRegestration extends BaseClass
{
	Sign_UP_Page sp;
	WebDriverWait wait;
	@BeforeMethod
	public void ob()
	{
		
		openbrowser();
		sp=new Sign_UP_Page(driver);
		
	}
	
	@Test(priority=1)
	public void NewRegestration()
	{
		 String emailPrefix = "qa.automation" + System.currentTimeMillis();
		    String emailAddress = emailPrefix + "@mailinator.com";
		    
		sp.click_On_sign_up_link();
		sp.Signup_Page_Enter_FirstName("Adr");
		sp.Signup_Page_Enter_LastName("def");
		sp.Signup_Page_Enter_Emaild(emailAddress);
		sp.Signup_Page_Enter_Password("Sansane@123");
		sp.Signup_Page_ReEnter_Password("Sansane@123");
		sp.Signup_Page_click_Checkbox();
		sp.Signup_Page_click_signupbutton();
		
		//step2
		  ((JavascriptExecutor) driver).executeScript("window.open()");
		    ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		    driver.switchTo().window(tabs.get(1));
		    driver.get("https://www.mailinator.com/v4/public/inboxes.jsp?to=" + emailPrefix);
	 
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		    driver.navigate().refresh();
		 // 4. Wait for OTP email
		     wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		    WebElement gobutton = wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.xpath(" //button[@class='primary-btn']")
		    ));
		     gobutton.click(); 
		    WebElement emailrow = wait.until(ExpectedConditions.visibilityOfElementLocated(
			        By.xpath("//tr[@class='ng-scope']")
			    ));
		    emailrow.click();
		    
		 // 5. Switch to iframe and extract OTP
		    driver.switchTo().frame("html_msg_body");
		    String emailBody = driver.findElement(
		    	    By.xpath("//div[contains(@style,'display: inline-block')]//div[@style='display: flex']")
		    	).getText();
		    System.out.println(emailBody);
		    driver.switchTo().defaultContent();
		    Pattern otpPattern = Pattern.compile("\\b(\\d{6})\\b");
		    Matcher matcher = otpPattern.matcher(emailBody);
		    String otpCode = "";
		    if (matcher.find()) {
		        otpCode = matcher.group(1);
		    }

		    // 6. Switch back to signup tab and enter OTP
		    driver.switchTo().window(tabs.get(0));
		    sp.enterOTP(otpCode);   // create this method in your Page class
		    sp.clickVerifyOTPButton();
		
		    //fetch onboarding text
		    
		    String result = sp.getTextonboarding();
		    Assert.assertEquals(result,"Onboarding Process");
		    
		    
	}
	//email field is blank here
	@Test(priority=2)
	public void leaveMandetoryFieldsBlank() 
	{
		sp.click_On_sign_up_link();
		sp.Signup_Page_click_signupbutton();
	    wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//p[text()='Email is required']"))).getText();
		
		Assert.assertEquals(text,"Email is required");
	}
	
	@Test(priority=3)
	public void signupwithout_TC_Check() 
	{
		sp.click_On_sign_up_link();
		
		 String emailPrefix = "qa.automation" + System.currentTimeMillis();
		    String emailAddress = emailPrefix + "@mailinator.com";
		
		sp.Signup_Page_Enter_FirstName("Adr");
		sp.Signup_Page_Enter_LastName("def");
		sp.Signup_Page_Enter_Emaild(emailAddress);
		sp.Signup_Page_Enter_Password("Sansane@123");
		sp.Signup_Page_ReEnter_Password("Sansane@123");
		
		sp.Signup_Page_click_signupbutton();
	    wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='MuiAlert-message css-1xsto0d']"))).getText();
		
		Assert.assertEquals(text,"Please accept the terms and conditions");
	}
	
	@Test(priority=4)
	public void signupwithWeakPassword() 
	{
		sp.click_On_sign_up_link();
		
		 String emailPrefix = "qa.automation" + System.currentTimeMillis();
		    String emailAddress = emailPrefix + "@mailinator.com";
		
		sp.Signup_Page_Enter_FirstName("Adr");
		sp.Signup_Page_Enter_LastName("def");
		sp.Signup_Page_Enter_Emaild(emailAddress);
		sp.Signup_Page_Enter_Password("sane123");
		sp.Signup_Page_ReEnter_Password("sane123");
		sp.Signup_Page_click_Checkbox();
		sp.Signup_Page_click_signupbutton();
	    wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//p[text()='Password must include at least 8 characters, 1 uppercase letter, 1 number and 1 symbol']"))).getText();
		
		Assert.assertEquals(text,"Password must include at least 8 characters, 1 uppercase letter, 1 number and 1 symbol");
	}
	
	
	
	@AfterMethod
	public void closebrowser()
	{
		driver.quit();
	}

}
