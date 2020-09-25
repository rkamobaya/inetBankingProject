package eBankingTestCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import eBankingPageObjectModel.AddCustomerPage;
import eBankingPageObjectModel.loginPage;


public class TC_AddCustomerTest_003 extends BaseClass{
	
	public static Logger logger = LogManager.getLogger("TC_AddCustomerTest_003");
	
	AddCustomerPage addNCust; 
	
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		loginPage lp = new loginPage(driver);
		lp.usernameBox().sendKeys(username);
		logger.info("username is provided");
		lp.passwordBox().sendKeys(password);
		logger.info("password is provided");
		lp.submitButton().click();
		
		Thread.sleep(3000);
		
	
		AddCustomerPage addNCust= new AddCustomerPage(driver);
		
		addNCust.addNewCustomer().click();
	logger.info("Open up an add new customer window and providing customer details");
	addNCust.setNewCustomerName().sendKeys("Paul");
	addNCust.selectGender().click();
	addNCust.custdob("10", "23", "1988");
	Thread.sleep(3000);
	addNCust.setAddress().sendKeys("123 Kent st");
	addNCust.defineCity().sendKeys("Herndon");
	addNCust.selectState().sendKeys("Virginia");
	addNCust.setPin().sendKeys(String.valueOf(200512));
	addNCust.setPhoneNumber().sendKeys("7031231458");
	
	//here there a restriction on the email address. Every time every customer is having a unique email address. So we should not hardcode the email address.
	//One time you execute your test case it will pass. Second time you executing, it will fail because every customer should have an unique email address.
	//So whenever you run your automation code every time you have to pass 
	//How we can generate random ID and random number -------> very useful in automation ---> dynamically we have to generate, not harcode

  	String email =randomstring() + "@gmail.com";    //from below statement from randomstring() method.  	
  	addNCust.emailAddress().sendKeys(email);
  	
  	addNCust.submitCustomer().click();
  	  		
  	Thread.sleep(3000);
  	
  	logger.info("Validation started ...");
  	
  	boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
  	
  	if (res==true)
  		{
  		Assert.assertTrue(true);
  		logger.info("New customer is added successfully");
  		}
  	else
  		{
  		logger.info("New customer is not added successfully - Test case failed");
  		captureScreen(driver,"addNewCustomer");
  		Assert.assertTrue(false);
  		
  		}
  	
  		
		
	}
	
	
	
	
	
	//to generate a random email i have to create a user defined function. This method will return a random string.
	//in Java we have a predefined class called RandomStringUtils to generate a random string. That class has methods like 
	//randomAlphabetic(count) to generate random string and randomNumeric() to generate random number.
	
	public String randomstring()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(8);  //generate 8 characters strings. And whater it generate, i put it in a string variable.
		return generatedString;
		//so in the test case above I just have to call this method randomString(). It will give me a string and from that 
		//string I will append to "@gmail.com".
	}
	
		

}
