package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import Pages.LoginPage;
import Pages.ManualEntryPage;
import Pages.ProviderCardEntryPage;
import Pages.SuccessPage;
import Pages.TransactionReportPage;
import Pages.TransactionSearchPage;
import TestBase.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.Utility;

public class ManualEntryStepDef extends BaseClass {

	LoginPage login;
	ManualEntryPage manualentry;
	ProviderCardEntryPage cardinfo;
	String Gateway;
	String cardType;
	SuccessPage success;
	String cardNo;
	TransactionSearchPage tranactionsearch;
	TransactionReportPage report;
	String refNumber;
	String amount;

	public ManualEntryStepDef() throws IOException {
		super();

		// TODO Auto-generated constructor stub
	}


	@Given("User is on Manual Entry Payment page")
	public void user_is_on_manual_entry_payment_page() throws IOException {
		manualentry=new ManualEntryPage();
		Boolean isManualEntryPageDisplay=manualentry.selectPaymentType();
		Assert.assertTrue(isManualEntryPageDisplay);
		
	

	}
	@Given("User select the Verify Card Option")
	public void user_select_the_verify_card_option() {
		Boolean isVerifCardSelected=manualentry.selectVerifyCardOption();
		Assert.assertTrue(isVerifCardSelected);
		Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());
	}
	@Given("User select the date of visit")
	public  void User_select_the_date_of_visit() {
		manualentry.enterDateOfVisit();
		Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());
	}
	@When("User Enters the patient reference number")
	public void User_Enters_the_patient_reference_number() {
		refNumber=Utility.getTimeStamp();
		manualentry.enterReferenceNumber(refNumber);
		scenario.log("Entered the Reference Number:"+refNumber);
		Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());

	}
	@When("User Enter the Patient Name {string} & {string}")
	public void user_enter_the_patient_name(String firstName, String lastName) throws InterruptedException {
		manualentry.enterFirstName(firstName);
		scenario.log("Entered the Patient FirstName "+firstName);
		Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());
		manualentry.enterLastName(lastName);
		scenario.log("Entered the Patient LastName "+lastName);
		Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());
	}
	@When("User enters the Phone Number {string}")
	public void user_enters_the_phone_number(String phoneNumber) {
		manualentry.enterPhoneOrEmail(phoneNumber);
		scenario.log("Entered the phone/email: "+phoneNumber);
	}
	@When("User enters the Amount {string}")
	public void user_enters_the_amount(String amount) {
		this.amount=amount;
		manualentry.enterAmount(amount);
		scenario.log("Entered the amount: "+amount);
		Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());
	}
	@When("User click on Submit button")
	public void user_click_on_submit_button() throws InterruptedException {
		manualentry.submitButton();
		scenario.log("Submit Button clicked");
		Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());
	}
	@Then("User should redirect to Collect Card Payment form")
	public void user_should_redirect_to_collect_card_payment_form() throws IOException {
		cardinfo=new ProviderCardEntryPage();
		Boolean isCollectCardPageDisplay=manualentry.collectCardDetailsForm();
		Assert.assertTrue(isCollectCardPageDisplay);
		scenario.log("Card Information is displaying");
		Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());
	}

	@When("User enters card number card type as {string} in Gateway {string}")
	public void user_enters_card_number_card_type_as_in_gateway(String cardType, String gateway) throws IOException, InterruptedException {
		String paymentType="Manual Entry";
		cardinfo.enterCardNumber(cardType, gateway,paymentType);
		this.cardType=cardType;
		this.Gateway=gateway;
		super.gateway_COF=gateway;
		scenario.log("Card Number has entered successfully "+super.cardNo);
		Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());

	}


	@When("User enters ExpiryMonth {string} & ExpiryYear {string}")
	public void user_enters_expiry_month_expiry_year(String expMonth, String expYear) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		String paymentType="Manual Entry";
		cardinfo.enterCardExpiry(Gateway,expMonth,expYear,paymentType);
		scenario.log("Expiry Month & Year has entered successfully");
		Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());
	}
	@When("User enters the Cvv for card type {string}")
	public void user_enters_the_cvv_for_card_type(String cardType) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions

			String paymentType="Manual Entry";
			cardinfo.enterCardCVV(Gateway, cardType,paymentType);
			scenario.log("Cvv has entered successfully");
			Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());


	}

	@When("User enters ZipCode {string}")
	public void user_enters_zip_code(String zipCode) throws InterruptedException {
		if(Gateway.contains("Stripe")) {


		}else {
			cardinfo.enterZipCode(zipCode);
			scenario.log("Zip code entered successfully");
		}
		Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());
	}

	@When("User enters the Address, State & City")
	public void User_enters_the_Address_State_City() {
		if(Gateway.contains("Stripe")) {


		}else {
			cardinfo.enterAddress(prop.getProperty("Address"));
			cardinfo.enterState(prop.getProperty("State"));
			cardinfo.enterCity(prop.getProperty("City"));
			scenario.log("Address entered "+prop.getProperty("Address"));
			scenario.log("State entered "+prop.getProperty("State"));
			scenario.log("City entered "+prop.getProperty("City"));
			Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());
		}


	}
	@When("User submit the Collect Card form")
	public void user_submit_the_collect_card_form() throws InterruptedException {
		String paymentType="Manual Entry";
		cardinfo.submitCardDetailsForm(Gateway,paymentType);
		scenario.log("Card Information submitted successfully");
		Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());
	}
	@Then("User should see payment successfull message")
	public void user_should_see_payment_successfull_message() throws IOException {
		success=new SuccessPage();
		Assert.assertTrue(success.printReceipt());
		scenario.log("Manual Entry payment displayed successfully");
		Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());

	}
	@Then("User should see transaction in Transaction Report")
	public void user_should_see_transaction_in_transaction_report() throws IOException, InterruptedException {
		tranactionsearch=new TransactionSearchPage();
		tranactionsearch.navigateToTransactionSearchPage();
		scenario.log("Navigated to Transaction Report search Page");
		Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());
		tranactionsearch.searchPatientReferenceNumber(refNumber);
		scenario.log("Searching transaction by entering reference number"+refNumber);
		tranactionsearch.runTransactionReport();
		report=new TransactionReportPage();
		report.searchTransactionInReport("manual entry");
		scenario.log("Transaction record is displayed in Transaction Report");
		Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());
		
		

	}

	@When("User clicks on Refund Icon for Manual Entry payment")
	public void user_clicks_on_refund_icon_for_manual_entry_payment() throws InterruptedException {
		report.clickActionIcon(refNumber, "refund",Gateway);
		Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());
	//	scenario.log("");

	}
	@When("User enter refund amount for Manual Entry payment")
	public void user_enter_refund_amount_for_manual_entry_payment() {
		report.enterRefundAmount(amount);
		Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());
	}
	@When("User select reason from drop down for Manual Entry payment")
	public void user_select_reason_from_drop_down_for_manual_entry_payment() {
		report.selectReasonOption();
		Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());
	}
	@When("User click on Submit Button for Manual Entry payment")
	public void user_click_on_submit_button_for_manual_entry_payment() {
		report.refundVoidSubmitBtn();
	}
	@Then("Refund should be successfull")
	public void refund_should_be_successfull() {
		report.verifyRefundVoidTransactionSuccess();
		Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());
	}
	@When("User clicks on Void Icon for Manual Entry payment")
	public void user_clicks_on_void_icon_for_manual_entry_payment() throws InterruptedException {
		report.clickActionIcon(refNumber, "void",Gateway);
		Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());
	}
	@Then("Void should be successfull")
	public void void_should_be_successfull() {
		report.verifyRefundVoidTransactionSuccess();
		Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());
	}
	@When("User enters the speciality in Manual Entry page")
	public void user_enters_the_speciality_in_manual_entry_page() throws InterruptedException {
		manualentry.enterSpeciality();
	}
	@Then("User navigate to Transaction Search Page for ME")
	public void user_navigate_to_transaction_search_page_for_me() throws IOException, InterruptedException {
		tranactionsearch=new TransactionSearchPage();
		tranactionsearch.navigateToTransactionSearchPage();
	     
	}
	@Then("User check the Speciality check box and run the report for ME")
	public void user_check_the_speciality_check_box_and_run_the_report_for_me() throws InterruptedException {
		tranactionsearch.selectSepcialityCheckBox();
		tranactionsearch.runTransactionReport();		
	     
	}
	@Then("User should see transaction in Transaction Report with Speciality for ManualEntry")
	public void user_should_see_transaction_in_transaction_report_with_speciality_for_manual_entry() throws IOException {
		report=new TransactionReportPage();
		report.searchTransactionInReport("manual entry");
		scenario.log("Transaction record is displayed in Transaction Report");
		Utility.takeScreenshotforeachStep(scenario, driver,new Throwable().getStackTrace()[0].getMethodName());
		report.isSpecialityDisplayInGrid(prop.getProperty("Speciality"), refNumber);
	     
	}

}
