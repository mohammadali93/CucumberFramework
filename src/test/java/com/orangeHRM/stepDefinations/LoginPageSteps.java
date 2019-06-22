package com.orangeHRM.stepDefinations;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageSteps  {

@Given("I navigated to the Google")
public void i_navigated_to_the_Google() {
    System.out.println("i am on google page");
}

@When("I type search item")
public void i_type_search_item() {
   System.out.println("i search for item");
}

@When("I click on google search button")
public void i_click_on_google_search_button() {
   System.out.println("clicked search button");
}

@Then("I see search results are displayed")
public void i_see_search_results_are_displayed() {
    System.out.println("results are displayed");
}

}
