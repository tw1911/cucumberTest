Feature: Check login
  User with valid name should successful login

  Scenario: user have valid login and password
    * Open main page
    * Click Log In button
    * Open login page
    * enter credantials
    * check that he is signed in
    * log out
    * close browser
