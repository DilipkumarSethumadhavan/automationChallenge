@automationChallenge
Feature:	Automation Challenge 
	@important
	Scenario: E2E Regression on login, create order, edit order, delete order and logout  
		Given I navigate to login page
		When I enter UserName Password and click submit
		Then Validate login is successful
		When I click order 
		And Enter order details
		And click view all orders
		Then Validate the new order in the list
		When I click the edit 
		And Update the new card number and click update
		Then Validate the update customer details in the list
		When I select the order created
		And Click delete selected
		Then Validated for the delected order
		When I click logout 
		Then Validate page is logged out
