Feature: Login as a registered user
  I want to login as a registered user
  
  Background:
Given I am on home page
And I loginas a user
|Username| Password|
|tester@testing.com|tester|

Scenario: Verify the page header name
Then I verify the page header name "My account - My Store"

Scenario: Verify the landing page
Then I verify the below Accountlinks are available
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
