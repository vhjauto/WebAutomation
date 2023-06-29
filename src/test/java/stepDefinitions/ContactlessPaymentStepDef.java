package stepDefinitions;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import Pages.CommunicationReportsPage;
import Pages.ContactLessPage;
import Pages.PatientCardEntryPage;
import Pages.SuccessPage;
import Pages.TransactionReportPage;
import Pages.TransactionSearchPage;
import TestBase.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.Utility;

public class ContactlessPaymentStepDef extends BaseClass {

	ContactLessPage contactless;
	CommunicationReportsPage commReport;
	SuccessPage success;
	String url;
	String refNumber;
	PatientCardEntryPage cardEntry;
	String Gateway;
	SoftAssert soft;
	TransactionSearchPage tranactionsearch;
	TransactionReportPage report;
	String amount;
	
	

	public ContactlessPaymentStepDef() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		contactless=new ContactLessPage();

	}
	@Given("User is on Contactless Payment page")
	public void user_is_on_contactless_payment_page() {

		soft=new SoftAssert();
		Boolean displayContactLess=contactless.selectPaymentType();
		soft.assertTrue(displayContactLess);
	}


	@When("User select the date of visit in Contactless")
	public void user_select_the_date_of_visit_in_contactless() throws InterruptedException {
		contactless.enterDateOfVisit();

	}
	@When("User Enters the patient reference number in Contactless")
	public void user_enters_the_patient_reference_number_in_contactless() {
		String refNumber=Utility.getTimeStamp();
		this.refNumber=refNumber;
		contactless.enterReferenceNumber(refNumber);

	}
	@When("User Enter the Patient Name {string} & {string} in Contactless")
	public void user_enter_the_patient_name_in_contactless(String firstName, String lastName) throws InterruptedException {
		contactless.enterFirstName(firstName);
		contactless.enterLastName(lastName);
	}
	@When("User enters the Phone Number {string} in Contactless")
	public void user_enters_the_phone_number_in_contactless(String phoneNumber) {
		contactless.enterPhoneOrEmail(phoneNumber);
	}
	@When("User enters the Amount {string} in Contactless")
	public void user_enters_the_amount_in_contactless(String amount) {
		this.amount=amount;
		contactless.enterAmount(amount);

	}
	@When("User click on Submit button in Contactless")
	public void user_click_on_submit_button_in_contactless() throws InterruptedException {
		contactless.submitButton();
	}
	@Then("Payment Link should be sent to Patient on {string}")
	public void payment_link_should_be_sent_to_patient_on(String phone_email) throws IOException {
		success=new SuccessPage();
		String status=success.verifyStatus();
		soft.assertEquals(status, "Success");

	}

	@When("Navigate to Communication Report")
	public void navigate_to_communication_report() throws InterruptedException, IOException {
		commReport=new CommunicationReportsPage();
		commReport.navigateToCommunicationReport();


	}
	@When("Search the patient record by passing reference number")
	public void search_the_patient_record_by_passing_reference_number() throws InterruptedException {
		commReport.searchPatientReferenceNumber(refNumber);
		commReport.runCommunicationReport();
	}
	@When("Get the patient link from sent messages")
	public void get_the_patient_link_from_sent_messages() throws InterruptedException, AWTException {
		url=commReport.getCollectCardPaymentlink(refNumber);
	}

	@When("Patient Open the link for in Contactless payment")
	public void patient_open_the_link_for_in_contactless_payment() throws InterruptedException {
	//	driver=new ChromeDriver();
		driver.get(url);
		Thread.sleep(4000);

	}
	@Then("CardInfomation page should be display")
	public void card_infomation_page_should_be_display() throws IOException {
		cardEntry=new PatientCardEntryPage();


	}
	@When("Patient enters the CardNumber of cardtype as {string} in Gateway {string}")
	public void patient_enters_the_card_number_of_cardtype_as_in_gateway(String cardType, String Gateway) throws IOException, InterruptedException {
		cardEntry.enterCardNumber(cardType, Gateway);
		this.Gateway=Gateway;

	}
	@When("Patient enters the Card CVV for card type {string}")
	public void patient_enters_the_card_cvv_for_card_type(String cardType) throws InterruptedException {
		cardEntry.enterCardCVV(Gateway, cardType);
	}
	@When("Patient enters the Card Expiry as {string} and {string}")
	public void patient_enters_the_card_expiry_as_and(String ExpMonth, String ExpYer) throws InterruptedException {
		cardEntry.enterCardExpiry(Gateway, ExpMonth, ExpYer);

	}

	@When("Patient enters the AccountHolderName {string} {string}")
	public void patient_enters_the_account_holder_name(String firstName, String lastName) {
		cardEntry.enterAccountHolderName(firstName+" "+lastName);
	}
	@When("Patient enters the ZipCode {string}")
	public void patient_enters_the_zip_code(String zipCode) {
		cardEntry.enterZipCode(zipCode,"contactless");

	}
	@When("Patient Click on Pay Now button")
	public void patient_click_on_pay_now_button() throws InterruptedException {
		cardEntry.submitCardDetailsForm(Gateway,"contactless");


	}
	@Then("Patient should display Transaction Successfull page")
	public void patient_should_display_transaction_successfull_page() throws InterruptedException {
		Boolean status=cardEntry.verifyTransactionStatus("contactless");
	//	Assert.assertTrue(status);
		Thread.sleep(2000);

	}
	@When("User naviagate to Home Menu")
	public void user_naviagate_to_home_menu() {
		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{
			String child_window=I1.next();

			if(!parent.equals(child_window))
			{
				driver.switchTo().window(child_window);

			}

		}
	}
	@Then("User should see transaction in Transaction Report for Contactless Payment")
	public void user_should_see_transaction_in_transaction_report_for_contactless_payment() throws IOException, InterruptedException {
		tranactionsearch=new TransactionSearchPage();
		tranactionsearch.navigateToTransactionSearchPage();
		tranactionsearch.searchPatientReferenceNumber(refNumber);
		tranactionsearch.runTransactionReport();
		report=new TransactionReportPage();
		report.searchTransactionInReport("manual entry");
	}
	@When("User clicks on Void Icon for Contactless Payment")
	public void user_clicks_on_void_icon_for_contactless_payment() throws InterruptedException {
		report.clickActionIcon(refNumber, "void",Gateway);

	}
	@When("User enters the Speciality in Contactless Form")
	public void user_enters_the_speciality_in_contactless_form() throws InterruptedException {
		contactless.enterSpeciality();
	}
	@Then("Speciality should display in Collect Card Patient Page")
	public void speciality_should_display_in_collect_card_patient_page() {
		cardEntry.verifySpecialityInCollectCard(prop.getProperty("Speciality"));
	    
	}
	@When("User navigate to Transaction Search Page")
	public void user_navigate_to_transaction_search_page() throws IOException, InterruptedException {
		tranactionsearch=new TransactionSearchPage();
		tranactionsearch.navigateToTransactionSearchPage();
		tranactionsearch.searchPatientReferenceNumber(refNumber);
		
	   
	}
	@When("User check the Speciality check box and run the report")
	public void user_check_the_speciality_check_box_and_run_the_report() throws InterruptedException, IOException {
	//	tranactionsearch.searchPatientReferenceNumber(refNumber);
		tranactionsearch.selectSepcialityCheckBox();
		tranactionsearch.runTransactionReport();
		report=new TransactionReportPage();
		
	   
	}
	@Then("User should see transaction in Transaction Report with Speciality for Contactless")
	public void user_should_see_transaction_in_transaction_report_with_speciality_for_contactless() {
	 //  Assert.assertTrue(report.searchTransactionInReport("Contactless"));
		report.searchTransactionInReport("manual entry");
	   Assert.assertTrue(report.isSpecialityDisplayInGrid(prop.getProperty("Speciality"),refNumber));
	    
	}

	@When("User enter refund amount for Contactless Payment")
	public void user_enter_refund_amount_for_contactless_payment() {
		report.enterRefundAmount(amount);

	}
	@When("User select reason from drop down for Contactless Payment")
	public void user_select_reason_from_drop_down_for_contactless_payment() {
		report.selectReasonOption();

	}
	@When("User click on Submit Button for Contactless Payment")
	public void user_click_on_submit_button_for_contactless_payment() {
		report.refundVoidSubmitBtn();

	}
	@Then("Void should be successfull for Contactless Payment")
	public void void_should_be_successfull_for_contactless_payment() {
		report.verifyRefundVoidTransactionSuccess();

	}


}
