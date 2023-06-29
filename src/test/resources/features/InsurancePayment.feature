Feature: This is feature file for Insurance Payment for all the gateways: Heartland,Elavon,Rapid,Tsys ,Card Pointe ,Stripe & Fortis
 
Background: User is Logged In to Lp portal
	
	
  Scenario Outline: Validate the Insurnace Payment without Including Patient Info in Gateway "<Gateway>"
 	 	Given User navigate to the login page
  	Given User is logged in to Lp Portal for Gateway "<Gateway>"
     And User is on Insurance Payment page in Gateway "<Gateway>"
    And User uncheck the check box of "Include Patient Information ?"
   	Then User Enter the Insurance Company Name "<FirstName>" & "<LastName>"
    And User enters the Amount "<Amount>" in Insurance Form
    And User click on Submit button  in Insurance Form
    Then User should redirect to Collect Card Payment form for Insurance
    When User enters card number card type as "<CardType>" in Gateway "<Gateway>" in Insurance Form
    And User enters ExpiryMonth "<ExpMonth>" & ExpiryYear "<ExpYear>" in Insurance Form
    And User enters the Cvv for card type "<CardType>"  in Insurance Form
    And User enters ZipCode "<zipCode>" in Insurance Form
    And User enters the Address, State & City in Insurance Form
    And User submit the Collect Card form in Insurance Form
		Then User should see payment successfull message in Insurance Form
		And User should see transaction in Transaction Report
	
	Examples:
	|Gateway						|FirstName					 	|LastName					|phone_Email	|Amount		|CardType					|ExpMonth 	|ExpYear	|zipCode			|
	|Heartland					|Vinod								|Jadhav						|9548406651		|1				|Visa							|02					|2026			|12345				|		
	|Elavon							|Raghu								|nath							|9548406526		|2				|Master						|11					|2025			|12345				|		
	|Tsys								|Saidulu							|QA								|9548406651		|3				|Amex							|12					|2025			|12345				|
	|CardPointe					|Vinod								|QA								|9548406651		|4				|Amex							|12					|2025			|12345				|
	|Stripe							|Vinod								|QA								|9548406651		|5				|Amex							|12					|2025			|12345				|
	|Rapid							|Vinod								|QA								|9548406651		|5				|Amex							|12					|2025			|12345				|
	

Scenario Outline: Validate the Insurnace Payment with Including multiple Patient Info in Gateway "<Gateway>"
 	 	Given User navigate to the login page
  	Given User is logged in to Lp Portal for Gateway "<Gateway>"
    And User is on Insurance Payment page in Gateway "<Gateway>"
    And User check the check box of "Include Patient Information ?"
    And User add the patients rows "<TotalPatients>"
    And Get patient data from excel
    Then User Enter the Insurance Company Name "<InsuranceCompany>"
    And User enters the Patient Reference Number
   	And User enters the Patient FirstName & LastName
   	And user enters the Patient Phone_Email
    And User enters the Patient Insurance Amount in Insurance Form
    And User click on Submit button  in Insurance Form
    Then User should redirect to Collect Card Payment form for Insurance
    When User enters card number card type as "<CardType>" in Gateway "<Gateway>" in Insurance Form
    And User enters ExpiryMonth "<ExpMonth>" & ExpiryYear "<ExpYear>" in Insurance Form
    And User enters the Cvv for card type "<CardType>"  in Insurance Form
    And User enters ZipCode "<zipCode>" in Insurance Form
    And User enters the Address, State & City in Insurance Form
    And User submit the Collect Card form in Insurance Form
		Then User should see payment successfull message in Insurance Form
		And User should see transaction in Transaction Report
		
			Examples:
	|Gateway						|	InsuranceCompany	|	TotalPatients	|CardType					|ExpMonth 	|ExpYear	|zipCode			|
	|Heartland					|Liquid Payments		|	6							|Visa							|02					|2026			|12345				|		
	|Elavon							|Liquid Payments		|	3							|Master						|11					|2025			|12345				|		
	|Tsys								|Liquid Payments		|	2							|Amex							|12					|2025			|12345				|
	|CardPointe					|Liquid Payments		| 3							|Amex							|12					|2025			|12345				|
	|Rapid							|Liquid Payments 		| 6							|Amex							|12					|2025			|12345				|
