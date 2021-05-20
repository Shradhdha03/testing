Feature: Sign In

Background:
Given I open Chrome Browser

Scenario: Login Fails
Given I visit "https://maxgood.work"
And I enter email ""
And I enter password "123"
When I click submit button
Then I get error message "[Bad Request] Invalid Email Address. Invalid Password. It should be between 8 and 30 characters."
