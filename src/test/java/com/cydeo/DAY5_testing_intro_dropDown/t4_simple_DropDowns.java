package com.cydeo.DAY5_testing_intro_dropDown;

import com.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class t4_simple_DropDowns {

    WebDriver driver;

    @BeforeMethod
    public void seupMethod(){
        // open chrome browser

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //go tp http://practice.cydeo.com/dropdown
        driver.get("http://practice.cydeo.com/dropdown");
    }
    @Test
    public void simpleDropdownTest(){


        //VERIFY "SIMPLE DROPDOWN" default selected value is correct

        Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        //expected "please select ban option "

        //verify "state selection" default selected value is correct

        //expected "select a state"
    }


}
