Feature: A new user account can be created if a proper unused username and a proper password are given

  Scenario: creation is successful with valid username and password
    Given   command new user is selected
    When    a valid username "liisa" and password "salainen1" and matching password confirmation are entered
    Then    a new user is created

  Scenario: creation fails with too short username and valid password
    Given   command new user is selected
    When    an invalid username "as" and valid password "salainen1" and matching password confirmation are entered
    Then    user is not created and error "username should have at least 3 characters" is reported

  Scenario: creation fails with correct username and too short password
    Given   command new user is selected
    When    username "good" is valid but password "p" is too short
    Then    user cannot be created and error "password should have at least 8 characters" is reported

  Scenario: creation fails when password and password confirmation do not match
    Given   command new user is selected
    When    a valid username "correct" is given but password "salainen1" and password confirmation "salainen2" do not match
    Then    user will not be created and error message "password and password confirmation do not match" is given

  Scenario: user can login with successfully generated account
    Given   user with username "lea" with password "salainen1" is successfully created
    And     login is selected
    When    valid username "lea" is entered and working password "salainen1" are entered
    Then    lea is logged in

  Scenario: user can not login with account that is not successfully created
    Given   user with username "aa" and password "bad" is tried to be created
    And     login is selected
    When    wannabe user "aa" tries to login with password "bad"
    Then    login is denied