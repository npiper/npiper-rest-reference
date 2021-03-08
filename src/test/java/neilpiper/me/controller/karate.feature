#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@inventory @users
Feature: InventorySummary
  create an Inventory Summary and then get it by id, then delete

  @users
  Scenario: Test the User Endpoint
   Given url 'http://localhost:8090/users'
   When method GET
   Then status 200
   
  @inventory
  Scenario: Test the inventory endpoint
   Given url 'http://localhost:8090/depot/10001/inventory_summaries'
   When method GET
   Then status 200   
   
  @inventory 
  Scenario: Get an invalid list of Inventory Summaries
   Given url 'http://localhost:8090/depot/10001/inventory_summaries/898989'
   When method GET
   Then status 404