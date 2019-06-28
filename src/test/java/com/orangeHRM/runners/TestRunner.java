package com.orangeHRM.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Features/AddEmployee.feature"
		,glue= "com/orangeHRM/stepDefinations"
		//,dryRun=true
		, monochrome=true
		,tags= {("@temp")}
		,plugin = {"pretty","html:target/cucumber-default-reports","json:target/cucumber.json"}
		)



public class TestRunner {
	

}
