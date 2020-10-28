package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class MainDashBoard_Page extends MyUtils {

    private By _verifyhomepagetext = By.xpath("//div[@class=\"head\"]/h1");
    private String expectedTextofHomepage = "Dashboard";

    //Create method to verify text that user successfully login and see DashBoard Page by Assert
    public void loginhomepageverify(){

        Assert.assertEquals(getElement(_verifyhomepagetext),expectedTextofHomepage,"Page Not Found");
    }


}
