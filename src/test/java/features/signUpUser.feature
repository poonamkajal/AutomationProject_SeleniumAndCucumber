Feature: User Signup and Account Deletion

  Scenario: Verify user can signup and delete account successfully
    Given Launch browser
    When Navigate to url
    Then Verify that home page is visible successfully
    When Click on 'Signup / Login' button
    Then Verify 'New User Signup!' is visible
    When Enter name and email address
    And Click Signup button
    Then Verify that 'Enter Account Information' is visible
    When Fill details: Title, Name, Email, Password, Date of birth
    Then Select checkbox 'Sign up for our newsletter!'
    Then Select checkbox 'Receive special offers from our partners!'
    When Fill details: First name, Last name, Company, Address, Country, State, City, Zipcode, Mobile Number
    And Click Create Account button
    Then Verify that ACCOUNT CREATED! is visible
    When Click Continue button
    Then Verify that Logged in as username is visible
    When Click Delete Account button
    Then Verify that ACCOUNT DELETED! is visible and click Continue button

  Scenario: Login User with correct email and password
    Given Launch browser
    When Navigate to url
    Then Verify that home page is visible successfully
    When Click on 'Signup / Login' button
#  5. Verify 'Login to your account' is visible
#  6. Enter correct email address and password
#  7. Click 'login' button
#  8. Verify that 'Logged in as username' is visible
#  9. Click 'Delete Account' button
#  10. Verify that 'ACCOUNT DELETED!' is visible