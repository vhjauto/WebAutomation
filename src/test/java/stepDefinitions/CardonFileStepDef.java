package stepDefinitions;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import Pages.CardOnFilePage;
import Pages.CommunicationReportsPage;
import Pages.PatientCardEntryPage;
import Pages.ProviderCardEntryPage;
import Pages.SuccessPage;
import Pages.TransactionReportPage;
import Pages.TransactionSearchPage;
import TestBase.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.Utility;

public class CardonFileStepDef extends BaseClass {

	CardOnFilePage cardOnFile;
	ProviderCardEntryPage cardinfo;
	SuccessPage success;
	CommunicationReportsPage commReport;
	PatientCardEntryPage cardEntry;
	String Gateway;
	String cardType;
	String PaymentType="PatientResponsibility/COF";
	String url;
//	String cardNo;
	TransactionSearchPage tranactionsearch;
	String refNumber;
	SoftAssert soft;
	TransactionReportPage report;
	String amount;


public CardonFileStepDef() throws IOException {
			super();
			soft=new SoftAssert();
			// TODO Auto-generated constructor stub
}
@Given("User is on Card On File Payment page")
public void user_is_on_card_on_file_payment_page() throws IOException {

	cardOnFile=new CardOnFilePage();
	Boolean cardOnFileDisplay=cardOnFile.selectPaymentType();
	Assert.assertTrue(cardOnFileDisplay);


}
@When("User select the date of visit in Card on File")
public void user_select_the_date_of_visit_in_card_on_file() {
	cardOnFile.enterDateOfVisit();

}
@When("User Enters the patient reference number in Card on File")
public void user_enters_the_patient_reference_number_in_card_on_file() {
	String refNumber=Utility.getTimeStamp();
	this.refNumber=refNumber;
	cardOnFile.enterReferenceNumber(refNumber);

}


@When("User Enter the Patient Name {string} & {string} in Card on File")
public void user_enter_the_patient_name_in_card_on_file(String fName, String lName) throws InterruptedException {
	cardOnFile.enterPatientName(fName+" "+lName);

}
@When("User enters the Phone Number {string} in Card on File")
public void user_enters_the_phone_number_in_card_on_file(String phoneNumber) throws InterruptedException {
	cardOnFile.enterPhone(phoneNumber);

}

@When("User enters the Phone Email {string} in Card on File")
public void user_enters_the_phone_email_in_card_on_file(String email) {
	cardOnFile.enterEmail(email);

}
@When("User enters the Amount {string} in Card on File")
public void user_enters_the_amount_in_card_on_file(String amount) throws InterruptedException {
	this.amount=amount;
	cardOnFile.enterAmount(amount);

}
@When("User select the Proceed with card on File as No and select the option Card Entry by Provider Yes")
public void user_select_the_proceed_with_card_on_file_as_no_and_select_the_option_card_entry_by_provider_yes() throws InterruptedException {
	Boolean provider=cardOnFile.ProceedWithCardEntryByProvider();
	Assert.assertTrue(provider);

}
@When("User select the Proceed with card on File as yes")
public void user_select_the_proceed_with_card_on_file_as_yes() throws InterruptedException {
	cardOnFile.ProceedWithCardonFileYes();
}
@When("User select the Card from Select Card drop down")
public void user_select_the_card_from_select_card_drop_down() throws InterruptedException {
	System.out.println("Card No: "+super.cardNo);
	cardOnFile.selectCard(super.cardNo);

}
@When("User click on Submit button in Card on File")
public void user_click_on_submit_button_in_card_on_file() throws InterruptedException {
	cardOnFile.submitButton();
	Thread.sleep(2000);

}
@Then("COF User should redirect to Collect Card Payment form")
public void cof_user_should_redirect_to_collect_card_payment_form() throws IOException {
	cardinfo=new ProviderCardEntryPage();
	Boolean isCollectCardPageDisplay=cardOnFile.collectCardDetailsForm();
	Assert.assertTrue(isCollectCardPageDisplay);


}
@When("COF User enters card number card type as {string} in Gateway {string}")
public void cof_user_enters_card_number_card_type_as_in_gateway(String cardType, String gateway) throws IOException, InterruptedException {
	this.cardType=cardType;
	this.Gateway=gateway;
	cardinfo.enterCardNumber(cardType, Gateway,PaymentType);
	
}
@When("COF User enters ExpiryMonth {string} & ExpiryYear {string}")
public void cof_user_enters_expiry_month_expiry_year(String expMonth, String expYear) throws InterruptedException {
	cardinfo.enterCardExpiry(Gateway,expMonth,expYear,PaymentType);
}
@When("COF User enters the Cvv for card type {string}")
public void cof_user_enters_the_cvv_for_card_type(String cardType) throws InterruptedException {
	cardinfo.enterCardCVV(Gateway, cardType,PaymentType);

}
@When("COF User enters ZipCode {string}")
public void cof_user_enters_zip_code(String zipCode) {
	cardinfo.enterZipCode(zipCode);
	

}
@When("COF User enters the Address, State & City")
public void cof_user_enters_the_address_state_city() {

		cardinfo.enterAddress(prop.getProperty("Address"));
		cardinfo.enterState(prop.getProperty("State"));
		cardinfo.enterCity(prop.getProperty("City"));



}

@When("COF User submit the Collect Card form")
public void cof_user_submit_the_collect_card_form() throws InterruptedException {
	cardinfo.submitCardDetailsForm(Gateway,PaymentType);

}
@Then("COF User should see payment successfull message")
public void cof_user_should_see_payment_successfull_message() throws IOException {
	success=new SuccessPage();
	Assert.assertTrue(success.printReceipt());

}
@Then("COF User should see transaction in Transaction Report")
public void cof_user_should_see_transaction_in_transaction_report() {

}
@When("User select the Proceed with card on File as No and select the option Card Entry by Patient")
public void user_select_the_proceed_with_card_on_file_as_no_and_select_the_option_card_entry_by_patient() throws InterruptedException {
	cardOnFile.ProceedWithCardEntryByPatient();

}
@Then("COF Payment Link should be sent to Patient on {string}")
public void cof_payment_link_should_be_sent_to_patient_on(String phone_Email) throws IOException {
	success=new SuccessPage();
	String status=success.verifyStatus();
	soft.assertEquals(status, "Success");

}
@When("COF Navigate to Communication Report")
public void cof_navigate_to_communication_report() throws IOException, InterruptedException {


	commReport=new CommunicationReportsPage();
	commReport.navigateToCommunicationReport();

}
@When("COF Search the patient record by passing reference number")
public void cof_search_the_patient_record_by_passing_reference_number() throws InterruptedException {

	commReport.searchPatientReferenceNumber(refNumber);
	commReport.runCommunicationReport();

}
@When("COF Get the patient link from sent messages")
public void cof_get_the_patient_link_from_sent_messages() throws InterruptedException, AWTException {
	url=commReport.getCollectCardPaymentlink(refNumber);

}
@When("COF Patient Open the link for in Contactless payment")
public void cof_patient_open_the_link_for_in_contactless_payment() throws InterruptedException {
	driver.get(url);
	Thread.sleep(4000);
}
@Then("COF CardInfomation page should be display")
public void cof_card_infomation_page_should_be_display() throws IOException {
	cardEntry=new PatientCardEntryPage();


}
@When("COF Patient enters the CardNumber of cardtype as {string} in Gateway {string}")
public void cof_patient_enters_the_card_number_of_cardtype_as_in_gateway(String cardType, String gateway) throws IOException, InterruptedException {
	cardEntry.enterCardNumber(cardType, gateway);
	this.Gateway=gateway;

}
@When("COF Patient enters the Card Expiry as {string} and {string}")
public void cof_patient_enters_the_card_expiry_as_and(String ExpMonth, String ExpYer) throws InterruptedException {
	cardEntry.enterCardExpiry(Gateway, ExpMonth, ExpYer);

}
@When("COF Patient enters the Card CVV for card type {string}")
public void cof_patient_enters_the_card_cvv_for_card_type(String cardType) throws InterruptedException {
	cardEntry.enterCardCVV(Gateway, cardType);
}
@When("COF Patient enters the AccountHolderName {string} {string}")
public void cof_patient_enters_the_account_holder_name(String firstName, String lastName) {
	cardEntry.enterAccountHolderName(firstName+" "+lastName);

}
@When("COF Patient enters the ZipCode {string}")
public void cof_patient_enters_the_zip_code(String zipCode) {
	cardEntry.enterZipCode(zipCode,"cof");
}
@When("COF Patient Click on Pay Now button")
public void cof_patient_click_on_pay_now_button() throws InterruptedException {
	cardEntry.submitCardDetailsForm(Gateway,"cof");

}
@Then("COF Patient should display Transaction Successfull page")
public void cof_patient_should_display_transaction_successfull_page() throws IOException, InterruptedException {
	Boolean status=cardEntry.verifyTransactionStatus("cof");
	Assert.assertTrue(status);
	Thread.sleep(2000);;

}
@When("User naviagate to Home Menu from COF Contactless Payment")
public void user_naviagate_to_home_menu_from_cof_contactless_payment() {
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
@When("User should see transaction in Transaction Report for COF Contactless Payment")
public void user_should_see_transaction_in_transaction_report_for_cof_contactless_payment() throws IOException, InterruptedException {
	tranactionsearch=new TransactionSearchPage();
	tranactionsearch.navigateToTransactionSearchPage();
	tranactionsearch.searchPatientReferenceNumber(refNumber);
	tranactionsearch.runTransactionReport();
	report=new TransactionReportPage();
	report.searchTransactionInReport("manual entry");
}
@When("User clicks on Void Icon for COF Contactless Payment")
public void user_clicks_on_void_icon_for_cof_contactless_payment() throws InterruptedException {
	report.clickActionIcon(refNumber, "void",Gateway);
	
    
}
@When("User select reason from drop down for COF Contactless Payment")
public void user_select_reason_from_drop_down_for_cof_contactless_payment() {
	report.selectReasonOption();

}
@When("User click on Submit Button for COF Contactless Payment")
public void user_click_on_submit_button_for_cof_contactless_payment() {
	report.refundVoidSubmitBtn();
}
@Then("Void should be successfull for COF Contactless Payment")
public void void_should_be_successfull_for_cof_contactless_payment() {
	report.verifyRefundVoidTransactionSuccess();
}
@Then("User should see transaction in Transaction Report for PR\\/COF")
public void user_should_see_transaction_in_transaction_report_for_pr_cof() throws IOException, InterruptedException {
	tranactionsearch=new TransactionSearchPage();
	tranactionsearch.navigateToTransactionSearchPage();
	tranactionsearch.searchPatientReferenceNumber(refNumber);
	tranactionsearch.runTransactionReport();
	report=new TransactionReportPage();
	report.searchTransactionInReport("manual entry");
}
@When("User clicks on Void Icon for PR\\/COF")
public void user_clicks_on_void_icon_for_pr_cof() throws InterruptedException {
	report.clickActionIcon(refNumber, "void",Gateway);
}
@When("User select reason from drop down for PR\\/COF")
public void user_select_reason_from_drop_down_for_pr_cof() {
	report.selectReasonOption();
}
@When("User click on Submit Button for PR\\/COF")
public void user_click_on_submit_button_for_pr_cof() {
	report.refundVoidSubmitBtn();
}
@Then("Void should be successfull for PR\\/COF")
public void void_should_be_successfull_for_pr_cof() {
	report.verifyRefundVoidTransactionSuccess();
}
@Then("User should see transaction in Transaction Report for COF\\/Manual Entry")
public void user_should_see_transaction_in_transaction_report_for_cof_manual_entry() throws IOException, InterruptedException {
	tranactionsearch=new TransactionSearchPage();
	tranactionsearch.navigateToTransactionSearchPage();
	tranactionsearch.searchPatientReferenceNumber(refNumber);
	tranactionsearch.runTransactionReport();
	report=new TransactionReportPage();
	report.searchTransactionInReport("manual entry");

}
@When("User clicks on Void Icon for COF\\/Manual Entry")
public void user_clicks_on_void_icon_for_cof_manual_entry() throws InterruptedException {
	report.clickActionIcon(refNumber, "void",Gateway);
}
@When("User select reason from drop down for COF\\/Manual Entry")
public void user_select_reason_from_drop_down_for_cof_manual_entry() {
	report.selectReasonOption();

}
@When("User click on Submit Button for COF\\/Manual Entry")
public void user_click_on_submit_button_for_cof_manual_entry() {
	report.refundVoidSubmitBtn();
}
@Then("Void should be successfull for COF\\/Manual Entry")
public void void_should_be_successfull_for_cof_manual_entry() {
	report.verifyRefundVoidTransactionSuccess();
}
@When("User clicks on Refund Icon for COF Contactless Payment")
public void user_clicks_on_refund_icon_for_cof_contactless_payment() throws InterruptedException {
	report.clickActionIcon(refNumber, "Refund",Gateway);
}

@When("User clicks on Refund Icon for COF\\/Manual Entry")
public void user_clicks_on_refund_icon_for_cof_manual_entry() throws InterruptedException {
	report.clickActionIcon(refNumber, "refund",Gateway);
}
@When("User clicks on Refund Icon for PR\\/COF")
public void user_clicks_on_refund_icon_for_pr_cof() throws InterruptedException {
	report.clickActionIcon(refNumber, "refund",super.gateway_COF);
}
@When("User enters the refund amount for COF")
public void user_enters_the_refund_amount_for_cof() {
	report.enterRefundAmount(amount);
}
@Then("Refund should be successfull for COF\\/Manual Entry")
public void refund_should_be_successfull_for_cof_manual_entry() {
	report.verifyRefundVoidTransactionSuccess();
}
@Then("Refund should be successfull for COF Contactless Payment")
public void refund_should_be_successfull_for_cof_contactless_payment() {
	report.verifyRefundVoidTransactionSuccess();
}
@Then("Refund should be successfull for PR\\/COF")
public void refund_should_be_successfull_for_pr_cof() {
	report.verifyRefundVoidTransactionSuccess();
}


}
