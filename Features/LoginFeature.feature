Feature: Login Fuctionality

@sanity
Scenario: Successfull Login with Valid Credentials
Given User Launch browser
When User Opens Url "https://admin-demo.nopcommerce.com/login"
And User enters Email as "admin@yourstore.com", Password as "admin" and Clicks on Login button
Then Page Title should be "Dashboard / nopCommerce administration"
When User click on Logout button
Then Page Title "Your store. Login"
And Close Chrome browser

@regression @smoke
Scenario Outline: Successfull Login with Valid Credentials DTT
Given User Launch browser
When User Opens Url "https://admin-demo.nopcommerce.com/login"
And User enters Email as "<Email>", Password as "<Password>" and Clicks on Login button
Then Page Title should be "Dashboard / nopCommerce administration"
When User click on Logout button
Then Page Title "Your store. Login"
And Close Chrome browser

Examples:
|Email|Password|
|admin@yourstore.com|admin|
|sfvf@gmail.com|ghh|


@DataDriven
Scenario Outline: Successfull Login with Valid Credentials DTT
Given User Launch browser
When User Opens Url "https://admin-demo.nopcommerce.com/login"
Then check User navigates to MyAccount Page by passing Email and Password with excel row "<row_index>"


 Examples:
      |row_index|
      |1|
      |2|
      |3|
      |4|
      |5|
