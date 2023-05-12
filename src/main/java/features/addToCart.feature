Feature: Shopping site

Background:

@smoke
Scenario Outline: Add to cart
Given User navigate to cart app
And User login with "<username>" and "<password>"
And user search for a "<item>"
When user clicks add to cart
Then cart badge should get updated
 
Examples: 
	|username|password|item|
	|milton@abc.com|Milly@123*|ZARA COAT 3|
	|abc@com|red|ADIDAS ORIGINAL|