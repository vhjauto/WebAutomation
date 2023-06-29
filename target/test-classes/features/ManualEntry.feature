Feature: This is feature file to test Manual Entry for all the gateways : Heartland,Elavon,Rapid,Tsys ,Card Pointe ,Stripe & Fortis
 
Background: User is Logged In to Lp portal	
	
  Scenario Outline: Validate the Manual Entry in Gateway "<Gateway>"
 	 	Given User navigate to the login page
  	Given User is logged in to Lp Portal for Gateway "<Gateway>"
    And User is on Manual Entry Payment page
    When User select the date of visit
    When User Enters the patient reference number
    When User Enter the Patient Name "<FirstName>" & "<LastName>"
    And User enters the Phone Number "<phone_Email>"
    And User enters the Amount "<Amount>"
    And User click on Submit button
    Then User should redirect to Collect Card Payment form
    When User enters card number card type as "<CardType>" in Gateway "<Gateway>"
    And User enters ExpiryMonth "<ExpMonth>" & ExpiryYear "<ExpYear>"
    And User enters the Cvv for card type "<CardType>"
    And User enters ZipCode "<zipCode>"
    And User enters the Address, State & City
    And User submit the Collect Card form
		Then User should see payment successfull message
		And User should see transaction in Transaction Report
		
	Examples:
	|Gateway						|FirstName					 	|LastName					|phone_Email	|Amount		|CardType					|ExpMonth 	|ExpYear	|zipCode			|
	|Heartland					|Vinod								|Jadhav						|9548406651		|1				|Visa							|02					|2026			|12345				|		
	|Elavon							|Raghu								|nath							|9548406526		|2				|Master						|11					|2025			|12345				|		
	|Tsys								|Saidulu							|QA								|9548406651		|3				|Amex							|12					|2025			|12345				|
	|CardPointe					|Vinod								|QA								|9548406651		|4				|Amex							|12					|2025			|12345				|
	|Stripe							|Vinod								|QA								|9548406651		|5				|Amex							|12					|2025			|12345				|
	|Rapid							|Vinod								|QA								|9548406651		|5				|Amex							|12					|2025			|12345				|
	
	

	 Scenario Outline: Validate the refund transaction for Manual Entry Payment in Gateway "<Gateway>"
 	 	Given User navigate to the login page
  	Given User is logged in to Lp Portal for Gateway "<Gateway>"
    And User is on Manual Entry Payment page
    When User select the date of visit
    When User Enters the patient reference number
    When User Enter the Patient Name "<FirstName>" & "<LastName>"
    And User enters the Phone Number "<phone_Email>"
    And User enters the Amount "<Amount>"
    And User click on Submit button
    Then User should redirect to Collect Card Payment form
    When User enters card number card type as "<CardType>" in Gateway "<Gateway>"
    And User enters ExpiryMonth "<ExpMonth>" & ExpiryYear "<ExpYear>"
    And User enters the Cvv for card type "<CardType>"
    And User enters ZipCode "<zipCode>"
    And User enters the Address, State & City
    And User submit the Collect Card form
		Then User should see payment successfull message
		And User should see transaction in Transaction Report
		When User clicks on Refund Icon for Manual Entry payment
		And User enter refund amount for Manual Entry payment
		And User select reason from drop down for Manual Entry payment
		And User click on Submit Button for Manual Entry payment
		Then Refund should be successfull

Examples:
	|Gateway						|FirstName					 	|LastName					|phone_Email	|Amount		|CardType					|ExpMonth 	|ExpYear	|zipCode			|
	|Heartland					|Vinod								|Jadhav						|9548406651		|1				|Visa							|02					|2026			|12345				|		
	|Heartland					|Vinod								|Jadhav						|9548406651		|1				|Master						|02					|2026			|12345				|		
	|Elavon							|Raghu								|nath							|9548406526		|2				|Master						|11					|2025			|12345				|		
	|Tsys								|Saidulu							|QA								|9548406651		|3				|Amex							|12					|2025			|12345				|
	|CardPointe					|Vinod								|QA								|9548406651		|4				|Amex							|12					|2025			|12345				|
	|Stripe							|Vinod								|QA								|9548406651		|5				|Amex							|12					|2025			|12345				|
	|Rapid							|Vinod								|QA								|9548406651		|5				|Amex							|12					|2025			|12345				|
	

	 Scenario Outline: Validate the refund transaction for Manual Entry Payment in Gateway "<Gateway>"
 	 	Given User navigate to the login page
  	Given User is logged in to Lp Portal for Gateway "<Gateway>"
    And User is on Manual Entry Payment page
    When User select the date of visit
    When User Enters the patient reference number
    When User Enter the Patient Name "<FirstName>" & "<LastName>"
    And User enters the Phone Number "<phone_Email>"
    And User enters the Amount "<Amount>"
    And User click on Submit button
    Then User should redirect to Collect Card Payment form
    When User enters card number card type as "<CardType>" in Gateway "<Gateway>"
    And User enters ExpiryMonth "<ExpMonth>" & ExpiryYear "<ExpYear>"
    And User enters the Cvv for card type "<CardType>"
    And User enters ZipCode "<zipCode>"
    And User enters the Address, State & City
    And User submit the Collect Card form
		Then User should see payment successfull message
		And User should see transaction in Transaction Report
		When User clicks on Void Icon for Manual Entry payment
		And User enter refund amount for Manual Entry payment
		And User select reason from drop down for Manual Entry payment
		And User click on Submit Button for Manual Entry payment
		Then Void should be successfull
	
	Examples:
	|Gateway						|FirstName					 	|LastName					|phone_Email	|Amount		|CardType					|ExpMonth 	|ExpYear	|zipCode			|
	|Heartland					|Vinod								|Jadhav						|9548406651		|1				|Visa							|02					|2026			|12345				|		
	|Elavon							|Raghu								|nath							|9548406526		|2				|Master						|11					|2025			|12345				|		
	|Tsys								|Saidulu							|QA								|9548406651		|3				|Amex							|12					|2025			|12345				|
	|CardPointe					|Vinod								|QA								|9548406651		|4				|Amex							|12					|2025			|12345				|
	|Stripe							|Vinod								|QA								|9548406651		|5				|Amex							|12					|2025			|12345				|
	|Rapid							|Vinod								|QA								|9548406651		|5				|Amex							|12					|2025			|12345				|
	
	@UnitTest1
	Scenario Outline: Validate the Speciality for Manual Entry payment in Gateway "<Gateway>"
 	 	Given User navigate to the login page
  	Given User is logged in to Lp Portal for Gateway "<Gateway>"
    And User is on Manual Entry Payment page
    When User select the date of visit
    When User Enters the patient reference number
    When User Enter the Patient Name "<FirstName>" & "<LastName>"
    And User enters the Phone Number "<phone_Email>"
    And User enters the speciality in Manual Entry page
    And User enters the Amount "<Amount>"
    And User click on Submit button
    Then User should redirect to Collect Card Payment form
    When User enters card number card type as "<CardType>" in Gateway "<Gateway>"
    And User enters ExpiryMonth "<ExpMonth>" & ExpiryYear "<ExpYear>"
    And User enters the Cvv for card type "<CardType>"
    And User enters ZipCode "<zipCode>"
    And User enters the Address, State & City
    And User submit the Collect Card form
		Then User should see payment successfull message
		And User navigate to Transaction Search Page for ME
   	And User check the Speciality check box and run the report for ME
   	Then User should see transaction in Transaction Report with Speciality for ManualEntry
		
	Examples:
	|Gateway						|FirstName					 	|LastName					|phone_Email	|Amount		|CardType					|ExpMonth 	|ExpYear	|zipCode			|
	|Heartland					|Vinod								|Jadhav						|9548406651		|1				|Visa							|02					|2026			|12345				|		
#	|Elavon							|Raghu								|nath							|9548406526		|2				|Master						|11					|2025			|12345				|		
	|Tsys								|Saidulu							|QA								|9548406651		|3				|Amex							|12					|2025			|12345				|
#	|CardPointe					|Vinod								|QA								|9548406651		|4				|Amex							|12					|2025			|12345				|
#	|Stripe							|Vinod								|QA								|9548406651		|5				|Amex							|12					|2025			|12345				|
#	|Rapid							|Vinod								|QA								|9548406651		|5				|Amex							|12					|2025			|12345				|
	
	