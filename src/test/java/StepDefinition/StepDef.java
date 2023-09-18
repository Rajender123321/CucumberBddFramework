package StepDefinition;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;
//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import PageObject.LoginPageObjects;
import PageObject.SearchCustomerPage;
import Utilities.DataReader;
import PageObject.AddNewCustomerPage;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class StepDef extends BaseClass{
	

	 List<HashMap<String, String>> datamap; //Data driven
	public String RandomStrr = GenerateRandomString() + "@gmail.com";
	
	//public Logger logger;
	
	   public ResourceBundle rb; // for reading properties file
	     public String br; //to store browser name
	    
	     
	   
	    @Before
	    public void setup()    //Junit hook - executes once before starting
	    {
	        //for logging
	    	 
	    	//logger= LogManager.getLogger(this.getClass());	
	        //Reading config.properties (for browser)
	        rb=ResourceBundle.getBundle("config");
	        br=rb.getString("browser");
	       // logger = LogManager.getLogger(this.getClass());
	     
	    }  

	   // @After
	    public void tearDown(Scenario scenario) {
	        System.out.println("Scenario status ======>"+scenario.getStatus());
	        if(scenario.isFailed()) {
	        	
	        	TakesScreenshot ts=(TakesScreenshot) driver;
	        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
	        	scenario.attach(screenshot, "image/png",scenario.getName());
	        	            
	        }
	       driver.quit();
	    }  
	    
	    @After
	    public void tearDown() {
	        
	        
	       driver.quit();
	    }  
	    
	    @AfterStep
	    public void addScreenshot(Scenario scenario) {
	        System.out.println("Scenario status ======>"+scenario.getStatus());
	        if(scenario.isFailed()) {
	        	
	        	TakesScreenshot ts=(TakesScreenshot) driver;
	        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
	        	scenario.attach(screenshot, "image/png",scenario.getName());
	        	            
	        }
	      
	    }  
	
	@Given("User Launch browser")
	public void user_launch_browser() {
		 if(br.equals("chrome"))
	        {
			   WebDriverManager.chromedriver().setup();
	           driver=new ChromeDriver();
	        }
	        else if (br.equals("firefox")) {
	        	WebDriverManager.firefoxdriver().setup();
	            driver = new FirefoxDriver();
	        }
	        else if (br.equals("edge")) {
	        	WebDriverManager.edgedriver().setup();
	            driver = new EdgeDriver();
	        } 
		 
		// WebDriverManager.chromedriver().setup();
        // driver=new ChromeDriver();
		Lp = new LoginPageObjects(driver);
		addNewCustPg = new AddNewCustomerPage(driver);
		SearchCustPage = new SearchCustomerPage(driver);
		driver.manage().window().maximize();
		
	}

	@When("User Opens Url {string}")
	public void user_opens_url(String Url) {
	    driver.get(Url);
	   // logger.info("ghfghfhjfhj");
	}

	@When("User enters Email as {string}, Password as {string} and Clicks on Login button")
	public void user_enters_email_as_password_as_and_clicks_on_login_button(String Emailid, String Password) {
		
		Lp.Enter_Email(Emailid);
	    Lp.Enter_Password(Password);
	    Lp.Login_Button();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String ExpectedTiltle) throws InterruptedException
	
	{
	   Thread.sleep(3000);
	   String ActualTitle = driver.getTitle();
	   if(ActualTitle.equals(ExpectedTiltle))
	   {
		   Assert.assertTrue(true);
	   }
	   else
	   {
		   Assert.fail();
	   }
	}

	@When("User click on Logout button")
	public void user_click_on_logout_button() {
	    Lp.Logout_Button();
	}

	@Then("Page Title {string}")
	public void page_title(String ExpectedTiltle) {
		String ActualTitle = driver.getTitle();
		   if(ActualTitle.equals(ExpectedTiltle))
		   {
			   Assert.assertTrue(true);
		   }
		   else
		   {
			   Assert.fail();
		   }
	}


	
	
	
	
	

	
	@When("User Can see Dashboard")
     public void user_can_see_dashboard() {
		String actualTitle = addNewCustPg.getPageTitle();
		String expectedTitle = "Dashboard / nopCommerce administration";

		if(actualTitle.equals(expectedTitle))
		{
			
			Assert.assertTrue(true);

		}
		else
		{
			Assert.assertTrue(false);
			

		}
}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() {
		addNewCustPg.clickOnCustomersMenu();
		

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() {
		addNewCustPg.clickOnCustomersMenuItem();
		

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("click on Add new button")
	public void click_on_add_new_button() {
		addNewCustPg.clickOnAddnew();
		

	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		String actualTitle = addNewCustPg.getPageTitle();
		String expectedTitle = "Add a new customer / nopCommerce administration";

		if(actualTitle.equals(expectedTitle))
		{
			

			Assert.assertTrue(true);//pass
		}
		else
		{
		

			Assert.assertTrue(false);//fail
		}
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
		//addNewCustPg.enterEmail("cs129@gmail.com");
		//addNewCustPg.enterEmail("test955@gmail.com");
		
		addNewCustPg.enterEmail(RandomStrr);
		addNewCustPg.enterPassword("test1");
		addNewCustPg.enterFirstName("Prachi");
		addNewCustPg.enterLastName("Gupta");
		addNewCustPg.enterGender("Female");
		addNewCustPg.enterDob("6/13/1988");
		addNewCustPg.enterCompanyName("CodeStudio");
		addNewCustPg.enterAdminContent("Admin content");
		addNewCustPg.enterManagerOfVendor("Vendor 1");

		


	}

	@When("click on Save button")
	public void click_on_save_button() {
		addNewCustPg.clickOnSave();
		

	}

	/*@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String exptectedConfirmationMsg) {

		String bodyTagText = driver.findElement(By.tagName("Body")).getText();
		if(bodyTagText.contains(exptectedConfirmationMsg))
		{
			Assert.assertTrue(true);//pass
			

		}
		else
		{
			

			Assert.assertTrue(false);//fail

		}

	}*/
	

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String exptectedConfirmationMsg) {

		String bodyTagText = addNewCustPg.ConfirmationMsg();
		
		if(bodyTagText.contains(exptectedConfirmationMsg))
		{
			Assert.assertTrue(true);//pass
			

		}
		else
		{
			

			Assert.assertTrue(false);//fail

		}

	}

	@Then("Close Chrome browser")
	public void close_chrome_browser() throws InterruptedException {
	   Thread.sleep(3000);
		driver.quit();
	}


	
	          /*Search Customer*/
	@When("Enter customer EMail")
	public void enter_customer_e_mail() {
		SearchCustPage.enterEmailAdd("victoria_victoria@nopCommerce.com");
	}

	@When("Click on search button")
	public void click_on_search_button() {
		SearchCustPage.clickOnSearchButton();
		
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() 
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ExpectedEmail = "victoria_victoria@nopCommerce.com";
		Assert.assertTrue(SearchCustPage.searchCustomerByEmail(ExpectedEmail));
		
	    
	}

	

	@When("Enter customer FirstName")
	public void enter_customer_first_name() {
		SearchCustPage.enterFirstName("Victoria");
	}

	@When("Enter customer LastName")
	public void enter_customer_last_name() {
		SearchCustPage.enterLastName("Terces");
	}

	@Then("User should found Name in the Search table")
	public void user_should_found_name_in_the_search_table() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ExpectedName = "Victoria Terces";
		Assert.assertTrue(SearchCustPage.searchCustomerByName(ExpectedName));
	}


	 //*******   Data Driven test method    **************
    @Then("check User navigates to MyAccount Page by passing Email and Password with excel row {string}")
    public void check_user_navigates_to_my_account_page_by_passing_email_and_password_with_excel_data(String rows)
    {
        datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\Opencart_LoginData.xlsx", "Sheet1");

        int index=Integer.parseInt(rows)-1;
        String email= datamap.get(index).get("username");
        String pwd= datamap.get(index).get("password");
        String exp_res= datamap.get(index).get("res");

       
       // Lp.setEmail(email);
       // Lp.setPassword(pwd);
        Lp.Enter_Email(email);
        Lp.Enter_Password(pwd);
        
       // Lp.clickLogin();
        Lp.Login_Button();
        
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	   String ActualTitle = driver.getTitle();
 	 if(exp_res.equals("Valid"))
 	{
 		if(ActualTitle.equals("Dashboard / nopCommerce administration"))
  	   {
  		  Lp.Logout_Button();
  		  Assert.assertTrue(true);
  		  
  	   }
  	   else
  	   {
  		   Assert.fail();
  	   } 
 	 }
 	   
 	 else if(exp_res.equals("Invalid"))
  	{
 	   if(ActualTitle.equals("Your store. Login"))
   	   {
   		  
   		  Assert.assertTrue(true);
   		  
   	   }
   	   else
   	   {
   		   Assert.fail();
   	   } 
  	 }
    }
}
