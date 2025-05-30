@authentification
Feature: I want to verify login page

@authentification-valid
Scenario:I want to verify login page 
Given I launch may app
When I fill email "admin@yourstore.com"
And  I fill password "admin"
And I click login button
Then I will be redirected to home page 


