@E2E
Feature: Application check

Background:
Given user clicks login link

@reg
Scenario: Successful signin

And user enters "mango" as username
And user enetrs "Mango990" as password
When user clicks login button
Then Signin successfully passed
But signing failed