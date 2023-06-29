package stepDefinitions;

import java.io.IOException;

import Pages.LoginPage;
import TestBase.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef extends BaseClass{

	LoginPage login;
	String gateway;

	public LoginStepDef() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Given("User navigate to the login page")
	public void user_navigate_to_the_login_page() throws IOException {
	//	login=new LoginPage();
	//	login.launchUrl(prop.getProperty("url"));

	}

	@When("User enters username and password for LP Portal {string} Gateway")
	public void user_enters_username_and_password_for_lp_portal_gateway(String Gateway) throws IOException, InterruptedException {
		login.enterUserNameAndPassoword(Gateway);
		this.gateway=Gateway;


	}
	@Then("User should be logged in")
	public void user_should_be_logged_in() throws InterruptedException {
		login.login();

	}
	@Given("User is logged in to Lp Portal for Gateway {string}")
	public void user_is_logged_in_to_lp_portal_for_gateway(String Gateway) throws IOException, InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		login=new LoginPage();
		login.launchUrl(prop.getProperty("url"));
		login.enterUserNameAndPassoword(Gateway);
		login.login();
		this.gateway=Gateway;



	}

}
