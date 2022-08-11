package com.cydeo.DAY6_alters_iframes_windows;

import com.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropdownPractices {
    public WebDriver driver;

    @BeforeTest
    public void setupMethod(){

        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown

        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/dropdown");

    }
    @Test
    public void dropdown_task5() throws InterruptedException {
        // taskTC #5: Selecting state from State dropdown and verifying result

        //we locate the dropdown and it is ready to use
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));


       // 3. Select Illinois
        Thread.sleep(1000);
        stateDropdown.selectByVisibleText("Illinois");

       // 4. Select Virginia
        Thread.sleep(1000);
        stateDropdown.selectByValue("VA");
       // 5. Select California
        Thread.sleep(1000);
        stateDropdown.selectByIndex(5);
       // 6. Verify final selected option is California
        String expectedOptionText = "California";
        String actualOptionText = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOptionText,expectedOptionText);
       // Use all Select options. (visible text, value, index)
    }

    @Test
    public void dropdown_task6() throws InterruptedException {

       // 3. Select “December 1st, 1923” and verify it is selected.
        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));

               // Select year using  : visible text
        Thread.sleep(1000);
        yearDropdown.selectByVisibleText("1923");

       // Select month using   : value attribute
        Thread.sleep(1000);
        monthDropdown.selectByValue("11");

      //  Select day using : index number
        Thread.sleep(1000);
        dayDropdown.selectByIndex(0);

        //creating expected values
        String expectedYear = "1923";
        String expectedmonth = "December";
        String expectedDay = "1";
        //getting actual values from browser
        String actualYear = yearDropdown.getFirstSelectedOption().getText();
        String actualMonth = monthDropdown.getFirstSelectedOption().getText();
        String actualDay = dayDropdown.getFirstSelectedOption().getText();
        //create assertions
        Assert.assertTrue(actualDay.equals(expectedDay));
        Assert.assertEquals(actualMonth,expectedmonth);
        Assert.assertEquals(actualYear,expectedYear);



    }

    @AfterTest
    public void teardownMethod(){
        driver.close();
    }


}
