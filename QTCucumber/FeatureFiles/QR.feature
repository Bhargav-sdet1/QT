Feature: Generate QR

Scenario: Verify user is able to generate QR Code

Given If user is on home page
When User click on login link
And User enters valid Uname and Password
And User click on Banking link
And User click on Receive QR code
And Enter Amount 
And user click on Generate QR Code
Then Verify QR code