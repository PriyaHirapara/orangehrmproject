package org.example;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStepDef {
    Login_Page loginPage = new Login_Page();
    MainDashBoard_Page mainDashBoard_page = new MainDashBoard_Page();
    MyUtils myUtils = new MyUtils();


    @Given("^: User is Already on LoginPage\\.$")
    public void userIsAlreadyOnLoginPage() {
        loginPage.loginpageverification();
    }


    @When("^User enter valid username enter valid Password\\.$")
    public void userEnterValidUsernameAndValidPassword() {
        loginPage.login_Page();
    }


    @When("^user click on Login Button\\.$")
    public void user_click_on_Login_Button() {
      loginPage.clickonLoginButton();
    }

    @Then("^user can login successfully and can see  HomePage of Application\\.$")
    public void user_can_login_successfully_and_can_see_HomePage_of_Application() {
       mainDashBoard_page.loginhomepageverify();
    }
    @When("^User enter invalid \"([^\"]*)\"$")
    public void userEnterInvalid(String invalidusername) {
        loginPage.invalidUserName(invalidusername);
    }

    @And("^User enter \"([^\"]*)\"$")
    public void userEnter(String invalidPassword)  {
        loginPage.invalidPassword(invalidPassword);
    }

    @Then("^user should not login successfully and can see  \"([^\"]*)\"\\.$")
    public void userShouldNotLoginSuccessfullyAndCanSee(String reletedmessage)  {
       loginPage.reletedLoginMessageVerify(reletedmessage);

    }

}


