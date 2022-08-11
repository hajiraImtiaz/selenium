package com.cydeo.DAY6_alters_iframes_windows;

import com.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_iframePractice {


    //TC #4: Iframe practice
 public WebDriver driver;
// 1. Create a new class called: T4_Iframes
// 2. Create new test and make set ups
@BeforeMethod
public void setupMethod() {
    // 1. Open browser
    driver = WebDriverFactory.getDriver("chrome");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
// 3. Go to: https://practice.cydeo.com/iframe
    driver.get("http://practice.cydeo.com/iframe");
}
@Test
    public void iframe_test(){

    //we need to switch driver's focus to iframe
    //option:1 sitchng the iframe using id attribute value
    //driver.switchTo().frame("mce_0_ifr");

    //option:2 passing index number to iframe
   // driver.switchTo().frame(0);

    //option:3 locate as web element and pass in frame() method
    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));

    //locate the p tag
    WebElement yourContantGoesHereText = driver.findElement(By.xpath("//p"));

    Assert.assertTrue(yourContantGoesHereText.isDisplayed());

    //verify "An iFrame containing the TinyMCE WYSIWYG Editor"
    //to be able to verify the header,we must switch back to"main HTML"
    driver.switchTo().parentFrame();

    WebElement headerText = driver.findElement(By.xpath("//h3"));

    //assertion of header text isdisplayed or not
    Assert.assertTrue(headerText.isDisplayed());

driver.close();
}

           // 4. Assert: “Your content goes here.” Text is displayed.
//5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”

}
