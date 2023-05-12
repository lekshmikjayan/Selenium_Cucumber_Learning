Feature: Application product

Background:
 Given user go to app
 
 @smoke @cleanCart
Scenario Outline: Add to cart

And user login into app with "<username>" and "<password>"
And user search for  "<book>"
When user add book to cart
Then cart badge updated

Examples:
|username|password|book|
|mango|Mango990|Roomies|