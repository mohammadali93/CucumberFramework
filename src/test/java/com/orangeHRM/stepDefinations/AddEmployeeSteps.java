package com.orangeHRM.stepDefinations;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.orangeHRM.pages.AddEmployeePage;
import com.orangeHRM.pages.HomePage;
import com.orangeHRM.pages.LoginPage;
import com.orangeHRM.utils.CommonMethods;
import com.orangeHRM.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AddEmployeeSteps extends CommonMethods {
	LoginPage login;
	HomePage home;
	AddEmployeePage emp;

	@Given("I logged in into OrangeHrm")
	public void i_logged_in_into_OrangeHrm() {
		login = new LoginPage();
		home = new HomePage();
		emp = new AddEmployeePage();
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	}

	@When("I click on PIM link")
	public void i_click_on_PIM_link() {
		click(home.PIM);
	}

	@When("I click on  Add Employee link")
	public void i_click_on_Add_Employee_link() {
		click(home.addEmployee);
	}

	@When("I provide {string}, {string}, {string} and {string}")
	public void i_provide_and(String fName, String mName, String lName, String location) {
		sendText(emp.firstName, "fName");
		sendText(emp.middleName, mName);
		sendText(emp.lastName, lName);
		click(emp.location);
		selectList(emp.locationList, location);
	}

	@When("I click on save button")
	public void i_click_on_save_button() {
		click(emp.saveBtn);
	}

	@Then("I see {string}, {string} is displayed")
	public void i_see_is_displayed(String fName, String lName) {
		waitForElementBeClickable(emp.empCheck, 20);
		String empName = emp.empCheck.getText();
		Assert.assertEquals(fName + " " + lName, empName);

	}

	@Then("I see following labels")
	public void i_see_following_labels(DataTable addEmpLabels) {
		System.out.println("----Printing expected labels from cucumber dataTable----");
		List<String> expectedLabels = addEmpLabels.asList();
		for (String label : expectedLabels) {
			System.out.println(label);
		}
		// create an empty arraylist where we store labels text
		List<String> actualLabels = new ArrayList<String>();
		// get all label elements
		List<WebElement> labelList = emp.addEmpLabels;
		for (WebElement label : labelList) {
			String labeltxt = label.getText();
			// if text is not empty replace * and store it inside actualLabels
			if (!labeltxt.isEmpty()) {
				actualLabels.add(labeltxt.replace("*", ""));
			}
		}
		Assert.assertTrue(actualLabels.equals(expectedLabels));
	}

	@When("I provide employee details from {string}")
	public void i_provide_employee_details(String sheetName) {
		// lets say they come from excel
		/*
		 * fis workbook worksheet(sheetName) number #rows number# cols loop (rows){ loop
		 * (cols){
		 *
		 * sendText(emp.firstName, valueFromeachCell); sendText(emp.middleName,
		 * valueFromeachCell); sendText(emp.lastName, valueFromeachCell);
		 * click(emp.location); selectList(emp.locationList, valueFromeachCell);
		 * 
		 * 
		 * } }
		 */
	}
}