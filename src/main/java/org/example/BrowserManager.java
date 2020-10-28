package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Test
public class BrowserManager extends MyUtils
{
    static LoadProp loadProp = new LoadProp();
    String browsername = loadProp.getProperty("browser");
   // public static final boolean SAUSCE_LAB = false;
    public static final String USERNAME = loadProp.getProperty("UserName");
    public static final String ACCESSKEY = loadProp.getProperty("Access_Key");
    public static final String URL = "https://" + USERNAME + ":" + ACCESSKEY + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
   // https://Purvi_mit:9ff1abc9-bfbf-442e-9cc8-493eeb0a64c5@ondemand.eu-central-1.saucelabs.com:443/wd/hub
    //Method for Open HomePage
    public void browserSelector() throws MalformedURLException {
        // If SauceLab is True........................................
       boolean SAUSCE_LAB =true;
        if (SAUSCE_LAB)
        {

            if (browsername.equalsIgnoreCase("chrome")) {
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                capabilities.setCapability("platform", "windows 10");
                capabilities.setCapability("version", "83");
                try {
                    driver = new RemoteWebDriver(new URL(URL), capabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else if (browsername.equalsIgnoreCase("Firefox")) {
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                capabilities.setCapability("platform", "windows 10");
                capabilities.setCapability("version", "84");
                try {
                    driver = new RemoteWebDriver(new URL(URL), capabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else if (browsername.equalsIgnoreCase("IE")) {
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                capabilities.setCapability("platform", "windows 10");
                capabilities.setCapability("version", "84");
                try {
                    driver = new RemoteWebDriver(new URL(URL), capabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else {

                System.out.println("Browser Not Open.... " + loadProp.getProperty("browser") + "Try Again");
            }
            // If SauceLab is False......................................
        } else
            {
            if (loadProp.getProperty("browser").equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src\\test\\Resources\\Browser Drivers\\chromedriver.exe");
                //Create ChromeDriver object to open Google Chrome Browser
                driver = new ChromeDriver();
            } else if (loadProp.getProperty("browser").equalsIgnoreCase("Firefox")) {
                //Open Firefox .Exe
                System.setProperty("webdriver.gecko.driver", "src\\test\\Resources\\Browser Drivers\\geckodriver.exe");
                //Create geckodriver object to open FireFox Browser
                driver = new FirefoxDriver();

            } else if (loadProp.getProperty("browser").equalsIgnoreCase("IE")) {
                //Open IE.Exe
                System.setProperty("webdriver.ie.driver", "src\\test\\Resources\\Browser Drivers\\IEDriverServer.exe");
                DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability("ignoreZoomSetting", true);
                //Create object of IEDriver to open IE Browser
                driver = new InternetExplorerDriver();
            } else {
                System.out.println("Browser Not Open.... " + loadProp.getProperty("browser") + "Try Again");
            }
        }
        //open Url by using TestdataConfig.properties
        driver.get(loadProp.getProperty("Url"));
        //window maximize
        driver.manage().window().maximize();
        //default implicit wait for 30 sec to driver instance
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    }
        public void closeApplication ()
       {
            driver.close();//Close Application
        }


}




