package com.orangeHRM.stepDefinations;

import org.junit.Assert;

import com.orangeHRM.pages.LoginPage;
import com.syntax.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class OrangeHRMloginSteps extends CommonMethods{

	LoginPage login;
	
	



@Given("i navigated to orange hrm")
public void i_navigated_to_orange_hrm() {
   setUp();
}

@Given("i send text to username and password")
public void i_send_text_to_username_and_password() {
	login= new LoginPage();
  sendText(login.userName, "Admin");
  sendText(login.password, "V9YwHwi@0Y");
}

@Then("i click login button")
public void i_click_login_button() {
    click(login.loginBtn);
}

@Then("i see the results are displayed")
public void i_see_the_results_are_displayed() {
    
}
@Then("i close the browser")
public void i_close_the_browser() {
	tearDown();
}
@Given("i enter invalid username and password")
public void i_enter_invalid_username_and_password() {
	login=new LoginPage();
   sendText(login.userName, "Test");
   sendText(login.password, "test123");
}

@Then("i see error message displayed")
public void i_see_error_message_displayed() {
Assert.assertTrue(login.message.isDisplayed());
String errorText=login.message.getText().trim();
Assert.assertEquals("Invalid Credentials", errorText);
}

}
