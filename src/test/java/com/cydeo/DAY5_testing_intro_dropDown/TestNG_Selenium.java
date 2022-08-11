package com.cydeo.DAY5_testing_intro_dropDown;

import com.tests.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNG_Selenium {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //Do browser driver setup
        //open browser
        driver = WebDriverFactory.getDriver("chrome");
        //maximize the paage
        driver.manage().window().maximize();

        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

    @Test
    public void selenium_test(){

        //get "http://google.com"
        driver.get("http://google.com");
        //Assert:title is "Google"

       // Assert.assertEquals(driver.getTitle(),"Google");
        //or
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";

        Assert.assertEquals(actualTitle,expectedTitle,"title is not matching here.");

    }

}
