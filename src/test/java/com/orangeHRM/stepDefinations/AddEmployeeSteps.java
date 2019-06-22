package com.orangeHRM.stepDefinations;

import com.orangeHRM.pages.AddEmployeePage;
import com.orangeHRM.pages.HomePage;
import com.orangeHRM.pages.LoginPage;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class AddEmployeeSteps extends CommonMethods {

	HomePage home;

	@Given("I navigated to OrangeHrm")
	public void i_navigated_to_OrangeHrm() {
		LoginPage login= new LoginPage();
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	}

	@Given("I logged in into OrangeHrm")
	public void i_logged_in_into_OrangeHrm() {
		
	}

	@Given("I click in PIM Link")
	public void i_click_in_PIM_Link() {
		home= new HomePage();
		click(home.addEmployee);
	}

	@Given("I click on Add Employee link")
	public void i_click_on_Add_Employee_link() {
		click(home.addEmployee);
		
	}

	@Given("I provide details {string} and {string} and {string} and {string}")
	public void i_provide_details_and_and_and(String fName, String mName, String lName, String location) {
		sendText(, value);
	}

	@Given("I click on save button")
	public void i_click_on_save_button() {

	}

	@Then("I see {string} and {string}  is added successfully")
	public void i_see_and_is_added_successfully(String string, String string2) {

	}

@Then("I close browser")
public void i_close_browser() {

}}