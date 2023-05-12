Feature: BookCart Application test

Background:
Given User navigate to Practise application

Scenario: Successful login

And user enter username as "milton@abc.com"
And user eneterd password as "Milly@123*"
When user clicks on login btn 
Then Login should be successful


Scenario: UnSuccessful login

And user enter username as "abc@com"
And user eneterd password as "red"
When user clicks on login btn 
But Login should be failed
