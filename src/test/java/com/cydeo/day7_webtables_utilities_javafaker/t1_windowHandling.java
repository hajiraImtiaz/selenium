package com.cydeo.day7_webtables_utilities_javafaker;

import com.tests.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;

import java.util.concurrent.TimeUnit;

public class t1_windowHandling {
    public WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //TC #1: Window Handle practice
        // 1. Create new test and make set ups
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void window_Handling_test(){

        //2. Go to : https://www.amazon.com
        driver.get("https://www.amazon.com" );
        //3. Copy paste the lines from below into your class

        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        //4. Create a logic to switch to the tab where Etsy.com is open
       // Set<String> allWindowsHandles = driver.getWindowHandles();
        BrowserUtils.switchWindowAndVerify(driver, "etsy", "Etsy");

      //  for (String each : allWindowsHandles) {
        //    driver.switchTo().window(each);
        //    System.out.println("current URL:" + driver.getCurrentUrl());
         //   if (driver.getCurrentUrl().contains("etsy")){
          //      break;
           // }
        }


        //5. Assert: Title contains “Etsy”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Etsy";

      //  Assert.assertTrue(actualTitle.contains(expectedTitle));

        //Lines to be pasted:
        //((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        //((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        //((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
        //
        //These lines will simply open new tabs using something called JavascriptExecutor
        //and get those pages. We will learn JavascriptExecutor later as well.


    }


