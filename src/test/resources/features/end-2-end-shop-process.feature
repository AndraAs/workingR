#Author: Rares Dadarlat - rares.dadarlat@msg.group
#Keywords Summary: test automation, serenity, cucumber, destatis, tricentis

#Background: user already has a registered account - account email: wonasa5819@mail3tech.com | account password: testpw

## (Comments):

Feature: End2End shopping process on the TricentisWebShop application

Scenario: As a shopper, the user should be able to register new user, log in with valid credentials, add product(s) to cart and check-out

Given the user navigates to the registration page
And the user adds new user information
When the user enters the valid account information
Then the user should be able to log in

Given the user navigates to product category
When the user should be able to pick a product and add the chosen product to cart
Then the cart should show the chosen product
And user enters check-out credentials and should be able to check-out
And user should see confirmation message
Then user should be able to log-off