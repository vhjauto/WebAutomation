Feature: This is feature file to test Card on File functionality for all the gateways gateways: Heartland,Elavon,Rapid,Tsys ,Card Pointe ,Stripe & Fortis
 
Background: User is Logged In to Lp portal
	

  Scenario Outline: Validate the Card On File as Card Entry by Provider in Gateway "<Gateway>"
 	 	Given User navigate to the login page
  	Given User is logged in to Lp Portal for Gateway "<Gateway>"
    And User is on Card On File Payment page
    When User select the date of visit in Card on File
    When User Enters the patient reference number in Card on File
    When User Enter the Patient Name "<FirstName>" & "<LastName>" in Card on File
    And User enters the Phone Number "<phone>" in Card on File
    And User enters the Phone Email "<email>" in Card on File
    And User enters the Amount "<Amount>" in Card on File
    And User select the Proceed with card on File as No and select the option Card Entry by Provider Yes
    And User click on Submit button in Card on File
    Then COF User should redirect to Collect Card Payment form
    When COF User enters card number card type as "<CardType>" in Gateway "<Gateway>"
    And COF User enters ExpiryMonth "<ExpMonth>" & ExpiryYear "<ExpYear>"
    And COF User enters the Cvv for card type "<CardType>"
    And COF User enters ZipCode "<zipCode>"
    And COF User enters the Address, State & City
    And COF User submit the Collect Card form
		Then COF User should see payment successfull message
		And COF User should see transaction in Transaction Report
		
		# Please give the GatewName as Heartland , Elavon ,Tsys ,CardPointe ,Stripe ,Fortis
		Examples:
	|Gateway						|FirstName					 	|LastName					|phone				|email									|Amount		|CardType					|ExpMonth 	|ExpYear	|zipCode			|
 	|Heartland					|Vinod								|Jadhav						|9548406651		|												|1				|Visa							|02					|2026			|12345				|		
	|Elavon							|Raghu								|nath							|9548406526		|												|2				|Master						|11					|2025			|12345				|		
 	|Tsys								|Saidulu							|QA								|9548406651		|												|3				|Amex							|12					|2025			|12345				|
	|CardPointe					|Vinod								|QA								|9548406651		|												|4				|Amex							|12					|2025			|12345				|
 	|Stripe							|Vinod								|QA								|9548406651		|												|5				|Amex							|12					|2025			|12345				|
	|Rapid							|Vinod								|QA								|9548406651		|												|5				|Amex							|12					|2025			|12345				|
	
	
	
  Scenario Outline: Validate the Card On File Payment as Card Entry by Patient in Gateway "<Gateway>"
 	 	Given User navigate to the login page
  	Given User is logged in to Lp Portal for Gateway "<Gateway>"
    And User is on Card On File Payment page
    When User select the date of visit in Card on File
    When User Enters the patient reference number in Card on File
    When User Enter the Patient Name "<FirstName>" & "<LastName>" in Card on File
    And User enters the Phone Number "<phone>" in Card on File
    And User enters the Phone Email "<email>" in Card on File
    And User enters the Amount "<Amount>" in Card on File
    And User select the Proceed with card on File as No and select the option Card Entry by Patient
    And User click on Submit button in Card on File
  	Then COF Payment Link should be sent to Patient on "<phone>"
   	When COF Navigate to Communication Report
   	And COF Search the patient record by passing reference number
   	And COF Get the patient link from sent messages 
   	When COF Patient Open the link for in Contactless payment
   	Then COF CardInfomation page should be display
   	When COF Patient enters the CardNumber of cardtype as "<CardType>" in Gateway "<Gateway>"
   	And COF Patient enters the Card Expiry as "<ExpMonth>" and "<ExpYear>"
   	And COF Patient enters the Card CVV for card type "<CardType>"
   	And COF Patient enters the AccountHolderName "<FirstName>" "<LastName>"
   	And COF Patient enters the ZipCode "<zipCode>"
   	And COF Patient Click on Pay Now button
   	Then COF Patient should display Transaction Successfull page
   	
   	
		
		# Please give the GatewName as Heartland , Elavon ,Tsys ,CardPointe ,Stripe ,Fortis
		Examples:
	|Gateway						|FirstName					 	|LastName					|phone				|email											|Amount		|CardType					|ExpMonth 	|ExpYear	|zipCode			|
 	|Heartland					|Vinod								|Jadhav						|							|jadhavvinod9096@gmail.com	|1				|Visa							|02					|2026			|12345				|		
	|Elavon							|Raghu								|nath							|9548406526		|														|2				|Master						|11					|2025			|12345				|		
 	|Tsys								|Saidulu							|QA								|9548406651		|														|3				|Amex							|12					|2025			|12345				|
 	|CardPointe					|Vinod								|QA								|9548406651		|														|4				|Amex							|12					|2025			|12345				|
 	|Stripe							|Vinod								|QA								|9548406651		|														|5				|Amex							|12					|2025			|12345				|
 	|Rapid							|Vinod								|QA								|9548406651		|														|5				|Amex							|12					|2025			|12345				|
	
	
	
  Scenario Outline: Validate the Card On File Payment with Proceed with Card on File in Gateway "<Gateway>"
 		Given User navigate to the login page
  	Given User is logged in to Lp Portal for Gateway "<Gateway>"
    And User is on Manual Entry Payment page
    And User select the Verify Card Option
    When User select the date of visit
    When User Enters the patient reference number
    When User Enter the Patient Name "<FirstName>" & "<LastName>"
    And User enters the Phone Number "<phone>"
    And User click on Submit button
    Then User should redirect to Collect Card Payment form
    When User enters card number card type as "<CardType>" in Gateway "<Gateway>"
    And User enters ExpiryMonth "<ExpMonth>" & ExpiryYear "<ExpYear>"
    And User enters the Cvv for card type "<CardType>"
    And User enters ZipCode "<zipCode>"
    And User enters the Address, State & City
    And User submit the Collect Card form
		Then User should see payment successfull message
    And User is on Card On File Payment page
    When User select the date of visit in Card on File
    When User Enters the patient reference number in Card on File
    When User Enter the Patient Name "<FirstName>" & "<LastName>" in Card on File
    And User enters the Phone Number "<phone>" in Card on File
    And User enters the Phone Email "<email>" in Card on File
    And User enters the Amount "<Amount>" in Card on File
    And User select the Proceed with card on File as yes
    And User select the Card from Select Card drop down 
    And User click on Submit button in Card on File
  	Then COF Patient should display Transaction Successfull page
		
		# Please give the GatewName as Heartland , Elavon ,Tsys ,CardPointe ,Stripe ,Fortis
		Examples:
	|Gateway						|FirstName					 	|LastName					|phone				|email											|Amount		|CardType					|ExpMonth 	|ExpYear	|zipCode			|
 	|Heartland					|Vinod								|Jadhav						|9548406526		|														|1				|Visa							|02					|2026			|12345				|		
	|Elavon							|Raghu								|nath							|9548406526		|														|2				|Master						|11					|2025			|12345				|		
 	|Tsys								|Saidulu							|QA								|9548406651		|														|3				|Amex							|12					|2025			|12345				|
 	|CardPointe					|Vinod								|QA								|9548406651		|														|4				|Amex							|12					|2025			|12345				|
 	|Stripe							|Vinod								|QA								|9548406651		|														|5				|Amex							|12					|2025			|12345				|
 	|Rapid							|Vinod								|QA								|9548406651		|														|5				|Amex							|12					|2025			|12345				|
	

  Scenario Outline: Validate void tranasction for Card On File Payment done by Patient in Gateway "<Gateway>"
 	 	Given User navigate to the login page
  	Given User is logged in to Lp Portal for Gateway "<Gateway>"
    And User is on Card On File Payment page
    When User select the date of visit in Card on File
    When User Enters the patient reference number in Card on File
    When User Enter the Patient Name "<FirstName>" & "<LastName>" in Card on File
    And User enters the Phone Number "<phone>" in Card on File
    And User enters the Phone Email "<email>" in Card on File
    And User enters the Amount "<Amount>" in Card on File
    And User select the Proceed with card on File as No and select the option Card Entry by Patient
    And User click on Submit button in Card on File
  	Then COF Payment Link should be sent to Patient on "<phone>"
   	When COF Navigate to Communication Report
   	And COF Search the patient record by passing reference number
   	And COF Get the patient link from sent messages 
   	When COF Patient Open the link for in Contactless payment
   	Then COF CardInfomation page should be display
   	When COF Patient enters the CardNumber of cardtype as "<CardType>" in Gateway "<Gateway>"
   	And COF Patient enters the Card Expiry as "<ExpMonth>" and "<ExpYear>"
   	And COF Patient enters the Card CVV for card type "<CardType>"
   	And COF Patient enters the AccountHolderName "<FirstName>" "<LastName>"
   	And COF Patient enters the ZipCode "<zipCode>"
   	And COF Patient Click on Pay Now button
   	Then COF Patient should display Transaction Successfull page
   	When User naviagate to Home Menu from COF Contactless Payment
   	And User should see transaction in Transaction Report for COF Contactless Payment
   	When User clicks on Void Icon for COF Contactless Payment
		And User select reason from drop down for COF Contactless Payment
		And User click on Submit Button for COF Contactless Payment
		Then Void should be successfull for COF Contactless Payment
   	
		
		# Please give the GatewName as Heartland , Elavon ,Tsys ,CardPointe ,Stripe ,Fortis
		Examples:
	|Gateway						|FirstName					 	|LastName					|phone				|email											|Amount		|CardType					|ExpMonth 	|ExpYear	|zipCode			|
 	|Heartland					|Vinod								|Jadhav						|							|jadhavvinod9096@gmail.com	|1				|Visa							|02					|2026			|12345				|		
#	|Elavon							|Raghu								|nath							|9548406526		|														|2				|Master						|11					|2025			|12345				|		
#	|Tsys								|Saidulu							|QA								|9548406651		|														|3				|Amex							|12					|2025			|12345				|# 	|CardPointe					|Vinod								|QA								|9548406651		|														|4				|Amex							|12					|2025			|12345				|
#	|Stripe							|Vinod								|QA								|9548406651		|														|5				|Amex							|12					|2025			|12345				|
#	|Rapid							|Vinod								|QA								|9548406651		|														|5				|Amex							|12					|2025			|12345				|
	
	

  Scenario Outline: Validate void transaction for Card On File Payment done by provider with selecting card on File in Gateway "<Gateway>"
 		Given User navigate to the login page
  	Given User is logged in to Lp Portal for Gateway "<Gateway>"
    And User is on Manual Entry Payment page
    And User select the Verify Card Option
    When User select the date of visit
    When User Enters the patient reference number
    When User Enter the Patient Name "<FirstName>" & "<LastName>"
    And User enters the Phone Number "<phone>"
    And User click on Submit button
    Then User should redirect to Collect Card Payment form
    When User enters card number card type as "<CardType>" in Gateway "<Gateway>"
    And User enters ExpiryMonth "<ExpMonth>" & ExpiryYear "<ExpYear>"
    And User enters the Cvv for card type "<CardType>"
    And User enters ZipCode "<zipCode>"
    And User enters the Address, State & City
    And User submit the Collect Card form
		Then User should see payment successfull message
    And User is on Card On File Payment page
    When User select the date of visit in Card on File
    When User Enters the patient reference number in Card on File
    When User Enter the Patient Name "<FirstName>" & "<LastName>" in Card on File
    And User enters the Phone Number "<phone>" in Card on File
    And User enters the Phone Email "<email>" in Card on File
    And User enters the Amount "<Amount>" in Card on File
    And User select the Proceed with card on File as yes
    And User select the Card from Select Card drop down 
    And User click on Submit button in Card on File
  	Then COF Patient should display Transaction Successfull page
  	And User should see transaction in Transaction Report for PR/COF
   	When User clicks on Void Icon for PR/COF
		And User select reason from drop down for PR/COF
		And User click on Submit Button for PR/COF
		Then Void should be successfull for PR/COF
	
		# Please give the GatewName as Heartland , Elavon ,Tsys ,CardPointe ,Stripe ,Fortis
		Examples:
	|Gateway						|FirstName					 	|LastName					|phone				|email											|Amount		|CardType					|ExpMonth 	|ExpYear	|zipCode			|
 	|Heartland					|Vinod								|Jadhav						|							|jadhavvinod9096@gmail.com	|1				|Visa							|02					|2026			|12345				|		
	|Elavon							|Raghu								|nath							|9548406526		|														|2				|Master						|11					|2025			|12345				|		
 	|Tsys								|Saidulu							|QA								|9548406651		|														|3				|Amex							|12					|2025			|12345				|
 	|CardPointe					|Vinod								|QA								|9548406651		|														|4				|Amex							|12					|2025			|12345				|
 	|Stripe							|Vinod								|QA								|9548406651		|														|5				|Amex							|12					|2025			|12345				|
 	|Rapid							|Vinod								|QA								|9548406651		|														|5				|Amex							|12					|2025			|12345				|
		
		

Scenario Outline: Validate the void transaction for Card On File done by Provider with entering Card maually in Gateway "<Gateway>"
 	 	Given User navigate to the login page
  	Given User is logged in to Lp Portal for Gateway "<Gateway>"
    And User is on Card On File Payment page
    When User select the date of visit in Card on File
    When User Enters the patient reference number in Card on File
    When User Enter the Patient Name "<FirstName>" & "<LastName>" in Card on File
    And User enters the Phone Number "<phone>" in Card on File
    And User enters the Phone Email "<email>" in Card on File
    And User enters the Amount "<Amount>" in Card on File
    And User select the Proceed with card on File as No and select the option Card Entry by Provider Yes
    And User click on Submit button in Card on File
    Then COF User should redirect to Collect Card Payment form
    When COF User enters card number card type as "<CardType>" in Gateway "<Gateway>"
    And COF User enters ExpiryMonth "<ExpMonth>" & ExpiryYear "<ExpYear>"
    And COF User enters the Cvv for card type "<CardType>"
    And COF User enters ZipCode "<zipCode>"
    And COF User enters the Address, State & City
    And COF User submit the Collect Card form
		Then COF User should see payment successfull message
		And User should see transaction in Transaction Report for COF/Manual Entry
   	When User clicks on Void Icon for COF/Manual Entry
		And User select reason from drop down for COF/Manual Entry
		And User click on Submit Button for COF/Manual Entry
		Then Void should be successfull for COF/Manual Entry
		
		# Please give the GatewName as Heartland , Elavon ,Tsys ,CardPointe ,Stripe ,Fortis
		Examples:
	|Gateway						|FirstName					 	|LastName					|phone				|email									|Amount		|CardType					|ExpMonth 	|ExpYear	|zipCode			|
 	|Heartland					|Vinod								|Jadhav						|9548406651		|												|1				|Visa							|02					|2026			|12345				|		
	|Elavon							|Raghu								|nath							|9548406526		|												|2				|Master						|11					|2025			|12345				|		
 	|Tsys								|Saidulu							|QA								|9548406651		|												|3				|Amex							|12					|2025			|12345				|
 	|CardPointe					|Vinod								|QA								|9548406651		|												|4				|Amex							|12					|2025			|12345				|
 	|Stripe							|Vinod								|QA								|9548406651		|												|5				|Amex							|12					|2025			|12345				|
 	|Rapid							|Vinod								|QA								|9548406651		|												|5				|Amex							|12					|2025			|12345				|
	
	

  Scenario Outline: Validate Refund tranasction for Card On File Payment done by Patient in Gateway "<Gateway>"
 	 	Given User navigate to the login page
  	Given User is logged in to Lp Portal for Gateway "<Gateway>"
    And User is on Card On File Payment page
    When User select the date of visit in Card on File
    When User Enters the patient reference number in Card on File
    When User Enter the Patient Name "<FirstName>" & "<LastName>" in Card on File
    And User enters the Phone Number "<phone>" in Card on File
    And User enters the Phone Email "<email>" in Card on File
    And User enters the Amount "<Amount>" in Card on File
    And User select the Proceed with card on File as No and select the option Card Entry by Patient
    And User click on Submit button in Card on File
  	Then COF Payment Link should be sent to Patient on "<phone>"
   	When COF Navigate to Communication Report
   	And COF Search the patient record by passing reference number
   	And COF Get the patient link from sent messages 
   	When COF Patient Open the link for in Contactless payment
   	Then COF CardInfomation page should be display
   	When COF Patient enters the CardNumber of cardtype as "<CardType>" in Gateway "<Gateway>"
   	And COF Patient enters the Card Expiry as "<ExpMonth>" and "<ExpYear>"
   	And COF Patient enters the Card CVV for card type "<CardType>"
   	And COF Patient enters the AccountHolderName "<FirstName>" "<LastName>"
   	And COF Patient enters the ZipCode "<zipCode>"
   	And COF Patient Click on Pay Now button
   	Then COF Patient should display Transaction Successfull page
   	When User naviagate to Home Menu from COF Contactless Payment
   	And User should see transaction in Transaction Report for COF Contactless Payment
   	When User clicks on Refund Icon for COF Contactless Payment
   	And User enters the refund amount for COF
		And User select reason from drop down for COF Contactless Payment
		And User click on Submit Button for COF Contactless Payment
		Then Refund should be successfull for COF Contactless Payment
   	
		
		# Please give the GatewName as Heartland , Elavon ,Tsys ,CardPointe ,Stripe ,Fortis
		Examples:
	|Gateway						|FirstName					 	|LastName					|phone				|email											|Amount		|CardType					|ExpMonth 	|ExpYear	|zipCode			|
 	|Heartland					|Vinod								|Jadhav						|							|jadhavvinod9096@gmail.com	|1				|Visa							|02					|2026			|12345				|		
	|Elavon							|Raghu								|nath							|9548406526		|														|2				|Master						|11					|2025			|12345				|		
	|Tsys								|Saidulu							|QA								|9548406651		|														|3				|Amex							|12					|2025			|12345				|
 	|CardPointe					|Vinod								|QA								|9548406651		|														|4				|Amex							|12					|2025			|12345				|
 	|Stripe							|Vinod								|QA								|9548406651		|														|5				|Amex							|12					|2025			|12345				|
 	|Rapid							|Vinod								|QA								|9548406651		|														|5				|Amex							|12					|2025			|12345				|
	
	

  Scenario Outline: Validate Refund transaction for Card On File Payment done by provider with selecting card on File in Gateway "<Gateway>"
 		Given User navigate to the login page
  	Given User is logged in to Lp Portal for Gateway "<Gateway>"
    And User is on Manual Entry Payment page
    And User select the Verify Card Option
    When User select the date of visit
    When User Enters the patient reference number
    When User Enter the Patient Name "<FirstName>" & "<LastName>"
    And User enters the Phone Number "<phone_Email>"
    And User click on Submit button
    Then User should redirect to Collect Card Payment form
    When User enters card number card type as "<CardType>" in Gateway "<Gateway>"
    And User enters ExpiryMonth "<ExpMonth>" & ExpiryYear "<ExpYear>"
    And User enters the Cvv for card type "<CardType>"
    And User enters ZipCode "<zipCode>"
    And User enters the Address, State & City
    And User submit the Collect Card form
		Then User should see payment successfull message
    And User is on Card On File Payment page
    When User select the date of visit in Card on File
    When User Enters the patient reference number in Card on File
    When User Enter the Patient Name "<FirstName>" & "<LastName>" in Card on File
    And User enters the Phone Number "<phone_Email>" in Card on File
    And User enters the Amount "<Amount>" in Card on File
    And User select the Proceed with card on File as yes
    And User select the Card from Select Card drop down 
    And User click on Submit button in Card on File
  	Then COF User should see payment successfull message
  	And User should see transaction in Transaction Report for PR/COF
   	When User clicks on Refund Icon for PR/COF
   	And User enters the refund amount for COF
		And User select reason from drop down for PR/COF
		And User click on Submit Button for PR/COF
		Then Refund should be successfull for PR/COF
		
	
		# Please give the GatewName as Heartland , Elavon ,Tsys ,CardPointe ,Stripe ,Fortis
		Examples:
	|Gateway						|FirstName					 	|LastName					|phone_Email	|Amount		|CardType					|ExpMonth 	|ExpYear	|zipCode			|
 	|Heartland					|Vinod								|Jadhav						|9548406651		|1				|Visa							|02					|2026			|12345				|		
#	|Elavon							|Raghu								|nath							|9548406526		|2				|Master						|11					|2025			|12345				|		
#	|Tsys								|Saidulu							|QA								|9548406651		|3				|Amex							|12					|2025			|12345				|
#	|CardPointe					|Vinod								|QA								|9548406651		|4				|Amex							|12					|2025			|12345				|
#	|Stripe							|Vinod								|QA								|9548406651		|5				|Amex							|12					|2025			|12345				|
#	|Rapid							|Vinod								|QA								|9548406651		|5				|Amex							|12					|2025			|12345				|
		
		
	
Scenario Outline: Validate the Refund transaction for Card On File done by Provider with entering Card in Gateway "<Gateway>"
 	 	Given User navigate to the login page
  	Given User is logged in to Lp Portal for Gateway "<Gateway>"
    And User is on Card On File Payment page
    When User select the date of visit in Card on File
    When User Enters the patient reference number in Card on File
    When User Enter the Patient Name "<FirstName>" & "<LastName>" in Card on File
    And User enters the Phone Number "<phone>" in Card on File
    And User enters the Phone Email "<email>" in Card on File
    And User enters the Amount "<Amount>" in Card on File
    And User select the Proceed with card on File as No and select the option Card Entry by Provider Yes
    And User click on Submit button in Card on File
    Then COF User should redirect to Collect Card Payment form
    When COF User enters card number card type as "<CardType>" in Gateway "<Gateway>"
    And COF User enters ExpiryMonth "<ExpMonth>" & ExpiryYear "<ExpYear>"
    And COF User enters the Cvv for card type "<CardType>"
    And COF User enters ZipCode "<zipCode>"
    And COF User enters the Address, State & City
    And COF User submit the Collect Card form
		Then COF User should see payment successfull message
		And User should see transaction in Transaction Report for COF/Manual Entry
   	When User clicks on Refund Icon for COF/Manual Entry
   	And User enters the refund amount for COF
		And User select reason from drop down for COF/Manual Entry
		And User click on Submit Button for COF/Manual Entry
		Then Refund should be successfull for COF/Manual Entry
		
		#  Please give the GatewName as Heartland , Elavon ,Tsys ,CardPointe ,Stripe ,Fortis
		Examples:
	|Gateway						|FirstName					 	|LastName					|phone				|email									|Amount		|CardType					|ExpMonth 	|ExpYear	|zipCode			|
 	|Heartland					|Vinod								|Jadhav						|9548406651		|												|1				|Visa							|02					|2026			|12345				|		
	|Elavon							|Raghu								|nath							|9548406526		|												|2				|Master						|11					|2025			|12345				|		
 	|Tsys								|Saidulu							|QA								|9548406651		|												|3				|Amex							|12					|2025			|12345				|
 	|CardPointe					|Vinod								|QA								|9548406651		|												|4				|Amex							|12					|2025			|12345				|
 	|Stripe							|Vinod								|QA								|9548406651		|												|5				|Amex							|12					|2025			|12345				|
 	|Rapid							|Vinod								|QA								|9548406651		|												|5				|Amex							|12					|2025			|12345				|
		