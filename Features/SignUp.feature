Feature: Account creation

  @Regression
  Scenario Outline: AccountCreation with valid Details
    Given User launch browser
    And Opens URL "https://staging.dolbyio.com/"
    And user hits on SignUp and Navigate to signupwith email
    When user hits on SignUpwithEmail 
    And user enters firstname as "<firstname>" lastname as "<lastname>" email as "<email address>" password as "<password>" and confirmpassword as "<confirm password>"
    And user select terms and conditions checkbox
    And user select Captcha check box
    And user hits on submit 
    Then user is able to dashboard page
   
    Examples:
      |firstname|lastname|email address|password|confirm password|
      |Suresh   |pari    |Spari+randomstring1@dolby.com|A@d12345|A@d12345|