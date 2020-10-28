package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class MyUtils extends BasePage {
    public void Sleep1(int time)//Method for Thread Sleep Wait
    {
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public  void whenClickablemehtodNotWorking(By by) {
        WebElement element = driver.findElement(by);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
    public  void waitUntilElementClickable(By by, int waittime)//Method for Explicit Wait
    {
        WebDriverWait wait =new WebDriverWait(driver,waittime);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public  void waituntillElmentVisible(By by,int time)
    {
        WebDriverWait wait=new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public  String getElement(By by)//Method for GetText from Element
    {
        return driver.findElement(by).getText();
    }


    public  void clickable(By by)
    {
        driver.findElement(by).click(); }//Method for Clickable Element

    public  void sendKeyElements(By by, String Text1){//Method for Send Text Element
        driver.findElement(by).click();
        driver.findElement(by).sendKeys(Text1);
    }
    public  long TimeStamp() {//Method for DateTimeStamp

        return (System.currentTimeMillis());
    }

        public void screenShot(String screenShotName){
        //method for taking screenshot
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(srcFile, new File("src\\test\\ScreenShots\\" +screenShotName+" .png"));

            //Another way to take ScreenShot by using FileUtils Dependency.
            //   FileUtils.copyFile(srcFile,new File("src\\test\\ScreenShots" +screenShotName+" .png"));

        }
        catch (IOException e) {
            e.printStackTrace();
        }}
    public static String getUrl(){
        return driver.getCurrentUrl();
    }
}



