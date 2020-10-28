package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class Login_Page extends MyUtils {
//Create object of LoadProp Class
    LoadProp loadProp =new LoadProp();
    //Store locators in variables
    private By _verifyloginpagetext = By.cssSelector("div#logInPanelHeading");
    private String expectedTextofloginpage = "LOGIN Panel";
    private By _loginname =By.cssSelector("input#txtUsername");
    private By _password = By.cssSelector("input#txtPassword");
    private By _clickonLoginbutton = By.cssSelector("input#btnLogin");


    //Locators for Text "Password cannot be empty"
    private By _invalidPassword =By.xpath("//span[text()='Password cannot be empty']");

    //Locators for text "Invalid credentials".......................
    private By _invaliddata_blank =By.xpath("//span[text()='Invalid credentials']");

    //Locators for Text "Username cannot be empty"........................
    private By _invalidUserName =By.xpath("//span[text()='Username cannot be empty']");

    public void loginpageverification() {//create method
        //Assert to check Expected match to actual
        Assert.assertEquals(getElement(_verifyloginpagetext), expectedTextofloginpage, "PAGE NOT FOUND");
    }

    //Create method for enter Username for login
    public void login_Page(){
        sendKeyElements(_loginname,loadProp.getProperty("userNameOforangehrmlive"));
        sendKeyElements(_password,loadProp.getProperty("Password"));
    }

    //Create mehtod for click on Login Button.
    public void clickonLoginButton(){

        clickable(_clickonLoginbutton);
    }

////////////////////////// Methods For Invalid Credentials....................................//////////////////////////////


//Creat method for enter invalid username
     public void invalidUserName(String invalidUsername) {
       waitUntilElementClickable(_loginname,100);
         sendKeyElements(_loginname, invalidUsername);

     }
     //Create method to Enter invalid password
     public void invalidPassword(String invalidPassword){
       waitUntilElementClickable(_password,100);
        sendKeyElements(_password,invalidPassword);

     }

     //Create method for verify related message while using different data by Using Assert
      public void reletedLoginMessageVerify(String reletedmessage){

          waituntillElmentVisible(_invalidUserName, 300);
          Assert.assertEquals(getElement(_invalidUserName), reletedmessage, "Username Can not Empty");

          waituntillElmentVisible(_invalidUserName, 500);
          Assert.assertEquals(getElement(_invalidUserName), reletedmessage, "Username Can not Empty");

          waituntillElmentVisible(_invaliddata_blank, 900);
          Assert.assertEquals(getElement(_invaliddata_blank), reletedmessage, "Invalid credential");

          waituntillElmentVisible(_invaliddata_blank, 200);
          Assert.assertEquals(getElement(_invaliddata_blank), reletedmessage, "Invalid Credential");


          Assert.assertEquals(getElement(_invalidPassword), reletedmessage, "Password can not be Empty");


          Assert.assertEquals(getElement(_invalidUserName), reletedmessage, "Username can not be empty");


          Assert.assertEquals(getElement(_invaliddata_blank), reletedmessage, "Login Failed");

          waituntillElmentVisible(_invalidPassword, 400);
          Assert.assertEquals(getElement(_invalidPassword), reletedmessage, "Password cannot be empty");
      }
}
