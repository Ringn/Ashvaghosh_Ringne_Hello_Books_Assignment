package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sign_UP_Page 
{
	@FindBy(xpath="(//button[@type='button'])[3]")private WebElement Signuplink;
	@FindBy(xpath="//input[@id='input_first_name']")private WebElement FirstName;
	@FindBy(xpath="//input[@id='input_last_name']")private WebElement LastName;
	@FindBy(xpath="//input[@id='input_your_working_email']")private WebElement EmailId;
	@FindBy(xpath="//input[@id='input_password']")private WebElement Password;
	@FindBy(xpath="//input[@id='input_confirm_password']")private WebElement ConfirmPassword;
	@FindBy(xpath="//input[@id='terms']")private WebElement TCcheckbox;
	@FindBy(xpath="//button[@type='submit']")private WebElement Signupbutton;
	@FindBy(xpath="(//input[@type='text'])[1]")private WebElement OTP1;
	@FindBy(xpath="(//input[@type='text'])[2]")private WebElement OTP2;
	@FindBy(xpath="(//input[@type='text'])[3]")private WebElement OTP3;
	@FindBy(xpath="(//input[@type='text'])[4]")private WebElement OTP4;
	@FindBy(xpath="(//input[@type='text'])[5]")private WebElement OTP5;
	@FindBy(xpath="(//input[@type='text'])[6]")private WebElement OTP6;

	
	@FindBy(xpath="(//button[@type='button'])[2]")private WebElement VerifyOTPButton;
	@FindBy(xpath="//div[text()='Onboarding Process']")private WebElement onboarding;

	WebDriverWait wait;
	
	public Sign_UP_Page(WebDriver driver)
	{
		
		PageFactory.initElements(driver,this);
		
		wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	}
	
	public void click_On_sign_up_link()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(
			    By.xpath("//button[contains(normalize-space(text()),'Sign up')]")
			)).click();
		//Signuplink.click();
			
	}
	
	public void Signup_Page_Enter_FirstName(String Fname)
	{
		FirstName.sendKeys(Fname);
	}
	public void Signup_Page_Enter_LastName(String Lname)
	{
		LastName.sendKeys(Lname);
	}
	public void Signup_Page_Enter_Emaild(String Emailid)
	{
		EmailId.sendKeys(Emailid);
	}
	public void Signup_Page_Enter_Password(String password)
	{
		Password.sendKeys(password);
	}
	public void Signup_Page_ReEnter_Password(String Password)
	{
		ConfirmPassword.sendKeys(Password);
	}
	public void Signup_Page_click_Checkbox()
	{
		TCcheckbox.click();
	}
	public void Signup_Page_click_signupbutton()
	{
		Signupbutton.click();
	}
	public void enterOTP(String otp)
	{
		OTP1.sendKeys(otp.substring(0,1));
	    OTP2.sendKeys(otp.substring(1,2));
	    OTP3.sendKeys(otp.substring(2,3));
	    OTP4.sendKeys(otp.substring(3,4));
	    OTP5.sendKeys(otp.substring(4,5));
	    OTP6.sendKeys(otp.substring(5,6));
	}
	
	public void clickVerifyOTPButton()
	{
		VerifyOTPButton.click();
		
	}
	public String getTextonboarding()
	{
		String text = onboarding.getText();
		return text;
	}
	
	
}
