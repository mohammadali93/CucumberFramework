Feature: Add Employee

  @smoke @addEmployee
  Scenario Outline: Valid login
    Given I navigated to OrangeHrm
    And I logged in into OrangeHrm
    And I click in PIM Link
    And I click on Add Employee link
    And I provide details "<fName>" and "<mName>" and "<lName>" and "<location>"
    And I click on save button
    Then I see "<fName>" and "<lName>"  is added successfully
    And I close browser

    Examples: 
      | fName    | mName | lName  | location     |
      | Asmit    | A     | Nepal  | West Office  |
      | Mohammad | K     | Ali    | North Office |
      | Tayyab   | F     | Raza   | HQ           |
      | Alex     | S     | Salihi | West Office  |

  Scenario: Add Employee and Create Login Details
    Given I click on PIM link
    And I click on Add Employee link
    And I provide fName, mName, lName, and location
    And I provide all mandatory fields
    And I click on save button
    Then I see employee is added succesfully
