package com.orangeHRM.stepDefinations;

import org.junit.Assert;

import com.orangeHRM.pages.HomePage;
import com.orangeHRM.pages.LoginPage;
import com.orangeHRM.utils.CommonMethods;
import com.orangeHRM.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.ast.DataTable;

public class OrangeHRMloginSteps extends CommonMethods{

	LoginPage login;

	@Given("I see OrangeHrm logo")
	public void i_see_OrangeHrm_logo() {
	  login=new LoginPage();
	  boolean isDisplayed=login.logo.isDisplayed();
	  Assert.assertTrue(isDisplayed);
	}

	@When("I enter valid username and password")
	public void i_enter_valid_username_and_password() {
	    sendText(login.userName, ConfigsReader.getProperty("username"));
	    sendText(login.password, ConfigsReader.getProperty("password"));
	}

	@When("I click login button")
	public void i_click_login_button() {
	    click(login.loginBtn);
	}

	@Then("I successfully logged in")
	public void i_successfully_logged_in() {
		HomePage home=new HomePage();
		Assert.assertTrue(home.dashboardText.isDisplayed());
	}
	
	@Then("I close browser")
	public void i_close_browser() {
	    tearDown();
	}
	
	@When("I enter invalid username and password")
	public void i_enter_invalid_username_and_password() {
	    sendText(login.userName, "Test");
	    sendText(login.password, "Test123");
	}

	@Then("I see error message is displayed")
	public void i_see_error_message_is_displayed() {
	    Assert.assertTrue(login.message.isDisplayed());
	    String errorText=login.message.getText().trim();
	    Assert.assertEquals("Invalid Credentials", errorText);
	}
	
	
	@When("I enter invalid username and password I see errorMessage")
	public void i_enter_invalid_username_and_password_I_see_errorMessage(DataTable wrongCredentials) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	 
	}
}