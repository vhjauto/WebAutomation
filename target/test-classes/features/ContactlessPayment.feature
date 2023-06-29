Feature: This is feature file to test Contactless Payment for all the gateways: Heartland,Elavon,Rapid,Tsys ,Card Pointe ,Stripe & Fortis
 
Background: User is Logged In to Lp portal
	
  Scenario Outline: Validate the Contactless Payment in Gateway: "<Gateway>"
 	 	Given User navigate to the login page
  	Given User is logged in to Lp Portal for Gateway "<Gateway>"
    And User is on Contactless Payment page
    When User select the date of visit in Contactless
    When User Enters the patient reference number in Contactless
    When User Enter the Patient Name "<FirstName>" & "<LastName>" in Contactless
    And User enters the Phone Number "<phone_Email>" in Contactless
    And User enters the Amount "<Amount>" in Contactless
    And User click on Submit button in Contactless
   	Then Payment Link should be sent to Patient on "<phone_Email>"
   	When Navigate to Communication Report
   	And Search the patient record by passing reference number
   	And Get the patient link from sent messages 
   	When Patient Open the link for in Contactless payment
   	Then CardInfomation page should be display
   	When Patient enters the CardNumber of cardtype as "<CardType>" in Gateway "<Gateway>"
   	And Patient enters the Card Expiry as "<ExpMonth>" and "<ExpYear>"
   	And Patient enters the Card CVV for card type "<CardType>"
   	And Patient enters the AccountHolderName "<FirstName>" "<LastName>"
   	And Patient enters the ZipCode "<zipCode>"
   	And Patient Click on Pay Now button
   	Then Patient should display Transaction Successfull page
    
 
		Examples:
	|Gateway						|FirstName					 	|LastName					|phone_Email	|Amount		  |CardType					|ExpMonth 	|ExpYear	|zipCode			|
	|Heartland					|Vinod								|Jadhav						|9548406651		|100				|Visa							|02					|2026			|12345				|		
#	|Elavon							|Raghu								|nath							|9548406526		|2					|Visa							|11					|2025			|12345				|		
#	|Tsys								|Vinod								|QA								|9548406651		|1					|Visa							|12					|2025			|12345				|
#	|CardPointe					|Vinod								|QA								|9548406651		|2					|Amex							|12					|2025			|12345				|
#	|Stripe							|Vinod								|QA								|9548406651		|5					|Visa							|12					|2025			|12345				|
#	|Rapid							|Vinod								|QA								|9548406651		|6					|Visa							|12					|2025			|12345				|
	
@UnitTest
  Scenario Outline: Validate the given Speciality is displaying on Collect Card Page & Transaction Report for Gateway: "<Gateway>"
 	 	Given User navigate to the login page
  	Given User is logged in to Lp Portal for Gateway "<Gateway>"
    And User is on Contactless Payment page
    When User select the date of visit in Contactless
    When User Enters the patient reference number in Contactless
    When User Enter the Patient Name "<FirstName>" & "<LastName>" in Contactless
    And User enters the Phone Number "<phone_Email>" in Contactless
    And User enters the Speciality in Contactless Form
    And User enters the Amount "<Amount>" in Contactless
    And User click on Submit button in Contactless
   	Then Payment Link should be sent to Patient on "<phone_Email>"
   	When Navigate to Communication Report
   	And Search the patient record by passing reference number
   	And Get the patient link from sent messages 
   	And Patient Open the link for in Contactless payment	
   	Then CardInfomation page should be display
   	And Speciality should display in Collect Card Patient Page   
   	When Patient enters the CardNumber of cardtype as "<CardType>" in Gateway "<Gateway>"
   	And Patient enters the Card Expiry as "<ExpMonth>" and "<ExpYear>"
   	And Patient enters the Card CVV for card type "<CardType>"
   	And Patient enters the AccountHolderName "<FirstName>" "<LastName>"
   	And Patient enters the ZipCode "<zipCode>"
   	And Patient Click on Pay Now button
   	Then Patient should display Transaction Successfull page
   	When User naviagate to Home Menu
   	And User navigate to Transaction Search Page
   	And User check the Speciality check box and run the report
   	Then User should see transaction in Transaction Report with Speciality for Contactless
    
 
		Examples:
	|Gateway						|FirstName					 	|LastName					|phone_Email	|Amount		  |CardType					|ExpMonth 	|ExpYear	|zipCode			|
	|Heartland					|Vinod								|Jadhav						|9548406651		|1					|Visa							|02					|2026			|12345				|		
#	|Elavon							|Raghu								|nath							|9548406526		|2					|Visa							|11					|2025			|12345				|		
#	|Tsys								|Vinod								|QA								|9548406651		|1					|Visa							|12					|2025			|12345				|
#	|CardPointe					|Vinod								|QA								|9548406651		|2					|Amex							|12					|2025			|12345				|
#	|Stripe							|Vinod								|QA								|9548406651		|5					|Visa							|12					|2025			|12345				|
#	|Rapid							|Vinod								|QA								|9548406651		|6					|Visa							|12					|2025			|12345				|
	


 Scenario Outline: Validate the Void transaction for Contactless Payment in Gateway: "<Gateway>"
 	 	Given User navigate to the login page
  	Given User is logged in to Lp Portal for Gateway "<Gateway>"
    And User is on Contactless Payment page
    When User select the date of visit in Contactless
    When User Enters the patient reference number in Contactless
    When User Enter the Patient Name "<FirstName>" & "<LastName>" in Contactless
    And User enters the Phone Number "<phone_Email>" in Contactless
    And User enters the Amount "<Amount>" in Contactless
    And User click on Submit button in Contactless
   	Then Payment Link should be sent to Patient on "<phone_Email>"
   	When Navigate to Communication Report
   	And Search the patient record by passing reference number
   	And Get the patient link from sent messages 
   	When Patient Open the link for in Contactless payment
   	Then CardInfomation page should be display
   	When Patient enters the CardNumber of cardtype as "<CardType>" in Gateway "<Gateway>"
   	And Patient enters the Card Expiry as "<ExpMonth>" and "<ExpYear>"
   	And Patient enters the Card CVV for card type "<CardType>"
   	And Patient enters the AccountHolderName "<FirstName>" "<LastName>"
   	And Patient enters the ZipCode "<zipCode>"
   	And Patient Click on Pay Now button
   	Then Patient should display Transaction Successfull page
   	When User naviagate to Home Menu
   	And User should see transaction in Transaction Report for Contactless Payment
   	When User clicks on Void Icon for Contactless Payment
		And User select reason from drop down for Contactless Payment
		And User click on Submit Button for Contactless Payment
		Then Void should be successfull for Contactless Payment
    
  Examples:
	|Gateway						|FirstName					 	|LastName					|phone_Email	|Amount		  |CardType					|ExpMonth 	|ExpYear	|zipCode			|
	|Heartland					|Vinod								|Jadhav						|9548406651		|100				|Visa							|02					|2026			|12345				|		
	|Elavon							|Raghu								|nath							|9548406526		|2					|Visa							|11					|2025			|12345				|		
	|Tsys								|Vinod								|QA								|9548406651		|1					|Visa							|12					|2025			|12345				|
	|CardPointe					|Vinod								|QA								|9548406651		|2					|Amex							|12					|2025			|12345				|
	|Stripe							|Vinod								|QA								|9548406651		|5					|Visa							|12					|2025			|12345				|
	|Rapid							|Vinod								|QA								|9548406651		|6					|Visa							|12					|2025			|12345				|
	

Scenario Outline: Validate the Refund transaction for Contactless Payment in Gateway: "<Gateway>"
 	 	Given User navigate to the login page
  	Given User is logged in to Lp Portal for Gateway "<Gateway>"
    And User is on Contactless Payment page
    When User select the date of visit in Contactless
    When User Enters the patient reference number in Contactless
    When User Enter the Patient Name "<FirstName>" & "<LastName>" in Contactless
    And User enters the Phone Number "<phone_Email>" in Contactless
    And User enters the Amount "<Amount>" in Contactless
    And User click on Submit button in Contactless
   	Then Payment Link should be sent to Patient on "<phone_Email>"
   	When Navigate to Communication Report
   	And Search the patient record by passing reference number
   	And Get the patient link from sent messages 
   	When Patient Open the link for in Contactless payment
   	Then CardInfomation page should be display
   	When Patient enters the CardNumber of cardtype as "<CardType>" in Gateway "<Gateway>"
   	And Patient enters the Card Expiry as "<ExpMonth>" and "<ExpYear>"
   	And Patient enters the Card CVV for card type "<CardType>"
   	And Patient enters the AccountHolderName "<FirstName>" "<LastName>"
   	And Patient enters the ZipCode "<zipCode>"
   	And Patient Click on Pay Now button
   	Then Patient should display Transaction Successfull page
   	When User naviagate to Home Menu
   	And User should see transaction in Transaction Report for Contactless Payment
   	When User clicks on Refund Icon for Contactless Payment
   	And User enter refund amount for Contactless Payment
		And User select reason from drop down for Contactless Payment
		And User click on Submit Button for Contactless Payment
		Then Void should be successfull for Contactless Payment
    
    
   	Examples:
	|Gateway						|FirstName					 	|LastName					|phone_Email	|Amount		  |CardType					|ExpMonth 	|ExpYear	|zipCode			|
	|Heartland					|Vinod								|Jadhav						|9548406651		|100				|Visa							|02					|2026			|12345				|		
	|Elavon							|Raghu								|nath							|9548406526		|2					|Visa							|11					|2025			|12345				|		
	|Tsys								|Vinod								|QA								|9548406651		|1					|Visa							|12					|2025			|12345				|
	|CardPointe					|Vinod								|QA								|9548406651		|2					|Amex							|12					|2025			|12345				|
	|Stripe							|Vinod								|QA								|9548406651		|5					|Visa							|12					|2025			|12345				|
	|Rapid							|Vinod								|QA								|9548406651		|6					|Visa							|12					|2025			|12345				|
	
Scenario Outline: Validate the Refund transaction for Contactless Payment in Gateway: "<Gateway>"
 	 	Given User navigate to the login page
  	Given User is logged in to Lp Portal for Gateway "<Gateway>"
    And User is on Contactless Payment page
    When User select the date of visit in Contactless
    When User Enters the patient reference number in Contactless
    When User Enter the Patient Name "<FirstName>" & "<LastName>" in Contactless
    And User enters the Phone Number "<phone_Email>" in Contactless
    And User enters the Amount "<Amount>" in Contactless
    And User click on Submit button in Contactless
   	Then Payment Link should be sent to Patient on "<phone_Email>"
   	When Navigate to Communication Report
   	And Search the patient record by passing reference number
   	And Get the patient link from sent messages 
   	When Patient Open the link for in Contactless payment
   	Then CardInfomation page should be display
   	When Patient enters the CardNumber of cardtype as "<CardType>" in Gateway "<Gateway>"
   	And Patient enters the Card Expiry as "<ExpMonth>" and "<ExpYear>"
   	And Patient enters the Card CVV for card type "<CardType>"
   	And Patient enters the AccountHolderName "<FirstName>" "<LastName>"
   	And Patient enters the ZipCode "<zipCode>"
   	And Patient Click on Pay Now button
   	Then Patient should display Transaction Successfull page
   	When User naviagate to Home Menu
   	And User should see transaction in Transaction Report for Contactless Payment
   	When User clicks on Refund Icon for Contactless Payment
   	And User enter refund amount for Contactless Payment
		And User select reason from drop down for Contactless Payment
		And User click on Submit Button for Contactless Payment
		Then Void should be successfull for Contactless Payment
    
 	Examples:
	|Gateway						|FirstName					 	|LastName					|phone_Email	|Amount		  |CardType					|ExpMonth 	|ExpYear	|zipCode			|
	|Heartland					|Vinod								|Jadhav						|9548406651		|100				|Visa							|02					|2026			|12345				|		
	|Elavon							|Raghu								|nath							|9548406526		|2					|Visa							|11					|2025			|12345				|		
	|Tsys								|Vinod								|QA								|9548406651		|1					|Visa							|12					|2025			|12345				|
	|CardPointe					|Vinod								|QA								|9548406651		|2					|Amex							|12					|2025			|12345				|
	|Stripe							|Vinod								|QA								|9548406651		|5					|Visa							|12					|2025			|12345				|
	|Rapid							|Vinod								|QA								|9548406651		|6					|Visa							|12					|2025			|12345				|
	

 Scenario Outline: Validate the Speciality on Collect Card Patient link page for Conctactless Payment in Gateway: "<Gateway>"
 	 	Given User navigate to the login page
  	Given User is logged in to Lp Portal for Gateway "<Gateway>"
    And User is on Contactless Payment page
    When User select the date of visit in Contactless
    When User Enters the patient reference number in Contactless
    When User Enter the Patient Name "<FirstName>" & "<LastName>" in Contactless
    And User enters the Phone Number "<phone_Email>" in Contactless
    And User enter the Speciality in Contactless
    And User enters the Amount "<Amount>" in Contactless
    And User click on Submit button in Contactless
   	Then Payment Link should be sent to Patient on "<phone_Email>"
   	When Navigate to Communication Report
   	And Search the patient record by passing reference number
   	And Get the patient link from sent messages 
   	When Patient Open the link for in Contactless payment
   	Then CardInfomation page should be display
   	When Patient enters the CardNumber of cardtype as "<CardType>" in Gateway "<Gateway>"
   	And Patient enters the Card Expiry as "<ExpMonth>" and "<ExpYear>"
   	And Patient enters the Card CVV for card type "<CardType>"
   	And Patient enters the AccountHolderName "<FirstName>" "<LastName>"
   	And Patient enters the ZipCode "<zipCode>"
   	And Patient Click on Pay Now button
   	Then Patient should display Transaction Successfull page
    
		Examples:
	|Gateway						|FirstName					 	|LastName					|phone_Email	|Amount		  |CardType					|ExpMonth 	|ExpYear	|zipCode			|
	|Heartland					|Vinod								|Jadhav						|9548406651		|100				|Visa							|02					|2026			|12345				|		
	|Elavon							|Raghu								|nath							|9548406526		|2					|Visa							|11					|2025			|12345				|		
	|Tsys								|Vinod								|QA								|9548406651		|1					|Visa							|12					|2025			|12345				|
	|CardPointe					|Vinod								|QA								|9548406651		|2					|Amex							|12					|2025			|12345				|
	|Stripe							|Vinod								|QA								|9548406651		|5					|Visa							|12					|2025			|12345				|
	|Rapid							|Vinod								|QA								|9548406651		|6					|Visa							|12					|2025			|12345				|
	