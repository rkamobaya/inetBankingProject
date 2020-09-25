package eBankingPageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
	
	WebDriver driver;
	
	
	public LoginPageFactory(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="uid")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="btnLogin")
	WebElement loginButton;
	
	
	public WebElement setUsername()
	{
		return username;
	}
	
	public WebElement setPassword()
	{
		return password;
	}
	
	public WebElement submitButton()
	{
		return loginButton;
	}

}
