  @Login
  Feature: User Login Successfully on Application
  Background:
    Given : User is Already on LoginPage.
 @Valid
  Scenario: User can able to login successfully with valid Username and Valid Password.
    When User enter valid username enter valid Password.
    And user click on Login Button.
    Then user can login successfully and can see  HomePage of Application.

  @Invalid
  Scenario Outline: User can not able to login with  invalid Username and invalid Password and shows related message.
    When User enter invalid "<invalid Username>"
    And User enter "<invalid Password>"
    And user click on Login Button.
    Then user should not login successfully and can see  "<related message>".
    Examples:
      | invalid Username | invalid Password | related message          |
      |                  | admin123         | Username cannot be empty |
      |                  |                  | Username cannot be empty |
      | Admin            | admin1234        | Invalid credentials      |
      | abccdf           | Admin1234        | Invalid credentials      |
      | adsaf            |                  | Password cannot be empty |
      |                  | admin            | Username cannot be empty |
      | login123         | admin123         | Invalid credentials      |
      | Admin            |                  | Password cannot be empty |