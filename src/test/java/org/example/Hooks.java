package org.example;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.net.MalformedURLException;

public class Hooks extends MyUtils{
    BrowserManager browserManager = new BrowserManager();

    @Before
    // Create method to open Browser
    public void openBrowser() throws MalformedURLException {
        browserManager.browserSelector();
    }
    @After
    //create method for close URL
    public void closeBrowser() {

        browserManager.closeApplication();
    }
}
