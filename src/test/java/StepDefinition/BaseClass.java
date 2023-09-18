package StepDefinition;

import org.apache.commons.lang3.RandomStringUtils;



import org.openqa.selenium.WebDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPageObjects;
import PageObject.SearchCustomerPage;


public class BaseClass {
	public LoginPageObjects Lp;
	public AddNewCustomerPage addNewCustPg;
	public SearchCustomerPage SearchCustPage;
	
	public WebDriver driver;
	
    public String GenerateRandomString()
	{
		String Random_Emailid = RandomStringUtils.randomAlphanumeric(7);
		return Random_Emailid;
	}
}
