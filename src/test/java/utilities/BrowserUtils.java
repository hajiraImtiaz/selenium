package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

/*
in this class only general utility methods that are not related to some specific page
 */
public class BrowserUtils {
    /*
    this method will accept in (in seconds) and execute Thread.sleep
    for given duration
     */
    public static void sleep(int second){
        second *=1000;
        try {
            Thread.sleep(second);
        }catch (InterruptedException e){

        }
    }

    /*
    This method accept 3 arguments.
    Arg1: webdriver
    Arg2: expectedInUrl: for verify if the url contains given string.
    -if condition matches, will break loop
    Arg3:expectedInTitle to be compared against actualTitle
     */

    public static void switchWindowAndVerify(WebDriver driver, String expectedInUrl, String expectedTitle){

        Set<String> allWindowsHandles = driver.getWindowHandles();

        for (String each : allWindowsHandles) {
            driver.switchTo().window(each);
            System.out.println("current URL:" + driver.getCurrentUrl());
            if (driver.getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }


        //5. Assert: Title contains “expectedInTitle”
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    /*
    this method accepts a string "expectedTitle"and Asserts if it is true
     */
    public static void verifyTitle(WebDriver driver,String expectedTitle){

        Assert.assertEquals(driver.getTitle(), expectedTitle);

    }



}
