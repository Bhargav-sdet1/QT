@login
Feature: Login check

@Smoke @Regression
Scenario Outline: Verify user is able to login with valid credentials
Given User is on login page
When User click on login link
And User enters valid "<Uname>" and "<Password>"
Then Verify logout link
Examples:
	|Uname|Password|
	|demo | 1234|
	|asdf | 1234|