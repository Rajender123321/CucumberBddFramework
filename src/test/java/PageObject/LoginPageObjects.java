package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {

	WebDriver driver;
	public LoginPageObjects(WebDriver driver)
	{
	this.driver = driver;
    PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//*[@id ='Email']")
	WebElement txt_Email;
	
	@FindBy(xpath = "//*[@name = 'Password']")
	WebElement txt_Password;
	
	@FindBy(xpath = "//*[@class = 'button-1 login-button']")
	WebElement btn_Login;
	
	@FindBy(xpath = "//*[text() = 'Logout']")
	WebElement btn_Logout;
	
	
	
	public void Enter_Email(String Email)
	{
		txt_Email.clear();
		txt_Email.sendKeys(Email);
	}
	
	public void Enter_Password(String Pwd)
	{
		txt_Password.clear();
		txt_Password.sendKeys(Pwd);
	}
	
	public void Login_Button()
	{
		btn_Login.click();
	}
	
	public void Logout_Button()
	{
		btn_Logout.click();
	}
}
