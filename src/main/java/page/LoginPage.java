package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	@FindBy(xpath="//input[@id='input_your_working_email']")private WebElement Email;
	@FindBy(xpath="//input[@id='input_password']")private WebElement Pass;
	@FindBy(xpath="(//button[@type='button'])[2]")private WebElement loginbutton;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	
	public void loginpageenter_Email(String mail)
	{
		Email.sendKeys(mail);
	}
	
	public void loginpageenter_Password(String password)
	{
		Pass.sendKeys(password);
	}

	public void loginpageenter_Loginbutton()
	{
		loginbutton.click();
	}

}
