Feature: Login check

Scenario: Verify user is able to login with valid credentials

Given User is on login page
When User click on login link
And User enters valid Uname and Password
Then Verify logout link