package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import Pages.InsurnacePaymentPage;
import Pages.ProviderCardEntryPage;
import Pages.SuccessPage;
import TestBase.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.Utility;

public class InsurancePaymentStepDef extends BaseClass {

	InsurnacePaymentPage insurance;
	ProviderCardEntryPage cardinfo;
	String cardType;
	String Gateway;
	String paymentType="Insurance Payment";
	SuccessPage success;
	int totalPatients;

	Object [][] data;
	public InsurancePaymentStepDef() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}



	@Given("User is on Insurance Payment page in Gateway {string}")
	public void user_is_on_insurance_payment_page_in_gateway(String gateway) throws IOException {
		this.Gateway=gateway;
		insurance= new InsurnacePaymentPage();
		insurance.selectPaymentType();
	}
	@Given("User uncheck the check box of {string}")
	public void user_uncheck_the_check_box_of(String string) {
		insurance.uncheckPatientInfoCheckBox();

	}
	@Given("Get patient data from excel")
	public void get_patient_data_from_excel() throws IOException {
		data=Utility.getInsuranceData(totalPatients);
	}
	@Then("User Enter the Insurance Company Name {string}")
	public void user_enter_the_insurance_company_name(String InsName) throws InterruptedException {
		insurance.enterInsuranceCompanyName(InsName);

	}

	@Then("User Enter the Insurance Company Name {string} & {string}")
	public void user_enter_the_insurance_company_name(String fname, String lname) throws InterruptedException {

		insurance.enterInsuranceCompanyName(fname+" "+lname);
	}
	@Then("User enters the Amount {string} in Insurance Form")
	public void user_enters_the_amount_in_insurance_form(String amount) throws InterruptedException {
		insurance.enterAmount(amount);
	}
	@Then("User click on Submit button  in Insurance Form")
	public void user_click_on_submit_button_in_insurance_form() throws InterruptedException {
		insurance.submitButton();
		Thread.sleep(2000);
	}
	@Then("User should redirect to Collect Card Payment form for Insurance")
	public void user_should_redirect_to_collect_card_payment_form_for_insurance() throws IOException {
		cardinfo=new ProviderCardEntryPage();
		Boolean isCollectCardPageDisplay=insurance.collectCardDetailsForm();
		Assert.assertTrue(isCollectCardPageDisplay);
	}
	@When("User enters card number card type as {string} in Gateway {string} in Insurance Form")
	public void user_enters_card_number_card_type_as_in_gateway_in_insurance_form(String cardType, String gateway) throws IOException, InterruptedException {
		cardinfo.enterCardNumber(cardType, gateway,paymentType);
		this.cardType=cardType;
		this.Gateway=gateway;
	}
	@When("User enters ExpiryMonth {string} & ExpiryYear {string} in Insurance Form")
	public void user_enters_expiry_month_expiry_year_in_insurance_form(String expMonth, String expYear) throws InterruptedException {
		cardinfo.enterCardExpiry(Gateway,expMonth,expYear,paymentType);
	}
	@When("User enters the Cvv for card type {string}  in Insurance Form")
	public void user_enters_the_cvv_for_card_type_in_insurance_form(String cardType) throws InterruptedException {
		cardinfo.enterCardCVV(Gateway, cardType,paymentType);
	}
	@When("User enters ZipCode {string} in Insurance Form")
	public void user_enters_zip_code_in_insurance_form(String zipCode) {
		cardinfo.enterZipCode(zipCode);

	}
	@When("User enters the Address, State & City in Insurance Form")
	public void user_enters_the_address_state_city_in_insurance_form() {
		cardinfo.enterAddress(prop.getProperty("Address"));
		cardinfo.enterState(prop.getProperty("State"));
		cardinfo.enterCity(prop.getProperty("City"));
	}
	@When("User submit the Collect Card form in Insurance Form")
	public void user_submit_the_collect_card_form_in_insurance_form() throws InterruptedException {
		cardinfo.submitCardDetailsForm(Gateway,paymentType);
	}
	@Then("User should see payment successfull message in Insurance Form")
	public void user_should_see_payment_successfull_message_in_insurance_form() throws IOException {
		success=new SuccessPage();
		Assert.assertTrue(success.printReceipt());

	}
	@Given("User check the check box of {string}")
	public void user_check_the_check_box_of(String string) throws InterruptedException {
		insurance.checkPatientInfoCheckBox();

	}
	@Then("User add the patients rows {string}")
	public void user_add_the_patients_rows(String totalPatients) throws InterruptedException {
		insurance.addRowsforMultiPatients(totalPatients,Gateway);
		int total=Integer.parseInt(totalPatients);
		this.totalPatients=total;
	}
	@Then("User enters the Patient Reference Number")
	public void user_enters_the_patient_reference_number() throws InterruptedException {
		for(int i=1;i<=totalPatients;i++) {
			String refNo=(String) data[i][0];
			insurance.enterPatientRefNumber(refNo, i);
		}

	}
	@Then("User enters the Patient FirstName & LastName")
	public void user_enters_the_patient_first_name_last_name() throws InterruptedException {
		for(int i=1;i<=totalPatients;i++) {
			String fname=(String) data[i][1];
			insurance.enterFirstName(fname, i);
		}
		for(int i=1;i<=totalPatients;i++) {
			String lname=(String) data[i][2];
			insurance.enterLastName(lname, i);
		}

	}
	@Then("user enters the Patient Phone_Email")
	public void user_enters_the_patient_phone_email() throws InterruptedException {
		for(int i=1;i<=totalPatients;i++) {
			String phone_email=(String) data[i][3];
			insurance.enterMultiPatientPhoneEmail(phone_email, i);
		}

	}
	@Then("User enters the Patient Insurance Amount in Insurance Form")
	public void user_enters_the_patient_insurance_amount_in_insurance_form() throws InterruptedException {
		for(int i=1;i<=totalPatients;i++) {
			String amount=(String) data[i][4];
			insurance.enterMultiPatientAmount(amount, i);

		}

	}

}
