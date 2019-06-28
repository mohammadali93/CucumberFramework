package com.orangeHRM.stepDefinations;

import org.junit.Before;

import com.orangeHRM.utils.BaseClass;
import com.orangeHRM.utils.CommonMethods;

import cucumber.api.Scenario;
import cucumber.api.java.After;

public class Hooks {

	@Before
	public void start(Scenario scenario)
	{
		System.out.println("Starting test :"+scenario.getName());
		BaseClass.setUp();
		
	}
	
	
	@After
	public void end(Scenario scenario)
	
	{
		System.out.println("Ending test :"+scenario.getName());
		
		if(scenario.isFailed())
		{
			byte [] shot= CommonMethods.takeScreenshot();
			scenario.embed(shot, "image/png");
		}
		
		BaseClass.tearDown();
	}
}
