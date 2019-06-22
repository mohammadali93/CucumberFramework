#Author: syntax-team // you give the name of the person who created this testcase


Feature: Login
@smoke @login
  Scenario: Search by typing
    Given i navigated to OrangeHrm
    And i send text to username and password
    Then i click login button
    Then i see the results are displayed
    Then i close the browser
    
    
    
    
@regression
  Scenario: Invalid Login
    Given i navigated to OrangeHrm
    And i enter invalid username and password
    Then i click login button
    Then i see error message displayed
    Then i close the browser
		Then i close the browser