package eBankingPageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	
	WebDriver driver;
	
	public loginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement usernameBox()
	{
		WebElement id = driver.findElement(By.name("uid"));
		return id;
	}
	
	public WebElement passwordBox()
	{
		WebElement passw = driver.findElement(By.name("password"));
		return passw;
	}
	
	public WebElement submitButton()
	{
		WebElement submit = driver.findElement(By.name("btnLogin"));
		return submit;
	}

}
