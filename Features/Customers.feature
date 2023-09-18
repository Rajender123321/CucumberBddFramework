Feature: Customer

Background: Steps common for all scenarios
  Given User Launch browser
  When User Opens Url "https://admin-demo.nopcommerce.com/login"
  And User enters Email as "admin@yourstore.com", Password as "admin" and Clicks on Login button
	And User Can see Dashboard

@regression @uiy
Scenario: Add New Customer
  When User click on customers Menu 
	And click on customers Menu Item 
	And click on Add new button 
	Then User can view Add new customer page 
	When User enter customer info 
	And click on Save button 
	Then User can view confirmation message "The new customer has been added successfully." 
	And Close Chrome browser

@regression	
Scenario: Search Customer by Email
	
	When User click on customers Menu 
	And click on customers Menu Item 
	And Enter customer EMail
	When Click on search button
	Then User should found Email in the Search table
	And Close Chrome browser
	
@sanity	
Scenario: Search Customer by Name
	
	When User click on customers Menu 
	And click on customers Menu Item 
	And Enter customer FirstName
	And Enter customer LastName
	When Click on search button
	Then User should found Name in the Search table
	And Close Chrome browser