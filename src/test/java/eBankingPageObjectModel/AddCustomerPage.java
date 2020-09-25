package eBankingPageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver driver;
	
	public AddCustomerPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(linkText="New Customer")
	WebElement newCustomer;
	
	@FindBy(name="name")
	WebElement newCustomerName;
	
	@FindBy(name="rad1")
	WebElement genderF;
	
	
	
	@FindBy(id="dob")
	WebElement txtdob;
	
	
	
	
	
	
	
	
	
	
	
	@FindBy(name="addr")
	WebElement Address;
	
	@FindBy(how= How.NAME, using="city")
	WebElement cityName;
	
	@FindBy(name="state")
	WebElement stateName;
	
	@FindBy(name="pinno")
	WebElement pinNumber;
	
	@FindBy(how=How.NAME, using="telephoneno")
	WebElement phoneNumber;
	
	@FindBy(how=How.NAME, using ="emailid")
	WebElement emailaddress;
	
	@FindBy(name="sub")
	WebElement submitButton;
	
	
	
	
	
	public WebElement submitCustomer()
	{
		return submitButton;
	}
	
	public WebElement emailAddress()
	{
		return emailaddress;
	}
	
	public WebElement setPhoneNumber()
	{
		return phoneNumber;
	}
	
	public WebElement setPin()
	{
	return pinNumber;
	}
			
	public WebElement defineCity()
	{
		return cityName;
	}
	
	public WebElement selectState()
	{
		return stateName;
	}
	
	public WebElement setAddress()
	{
		return Address;
	}
	
	
	
	
	
	
	
	public void custdob(String mm,String dd,String yy)
	{
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public WebElement selectGender()
	{
		return genderF;
	}
			
	public WebElement setNewCustomerName()
	{
		return newCustomerName;
	}
	
	public WebElement addNewCustomer()
	{
		return newCustomer;
	}

}
