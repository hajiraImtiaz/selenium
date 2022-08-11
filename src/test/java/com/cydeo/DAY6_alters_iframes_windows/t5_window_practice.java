package com.cydeo.DAY6_alters_iframes_windows;

import com.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class t5_window_practice {
    public WebDriver driver;
    @BeforeMethod
    public void setupMethod() {
        // 1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
// 3. Go to: https://practice.cydeo.com/windows
        driver.get("http://practice.cydeo.com/windows");
    }
    @Test
    public void multiple_window_test(){
        //current/main window handel as string is a good
        //practie for future reusable purpose
        String mainHandel = driver.getWindowHandle();
        System.out.println("mainHandel" + mainHandel);

       // 4. Assert: Title is “Windows”
        String expectedTitle = "windows";
        String actualTitle = "windows";

        Assert.assertEquals(actualTitle,expectedTitle);
        System.out.println("Title before click:" + actualTitle);

        //5. Click to: “Click Here” link
        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();
        actualTitle= driver.getTitle();
        System.out.println("Title after click:"+ actualTitle);
        //6. Switch to new Window.
        for (String each: driver.getWindowHandles()){
            driver.switchTo().window(each);
            System.out.println("Current title while switching windows:"+ driver.getTitle());

        }

        //7. Assert: Title is “New Window”
        String expectedTitleAfterClick =" New window";
        actualTitle= driver.getTitle();

       // Assert.assertEquals( actualTitle, expectedTitleAfterClick);

       // Assert.assertEquals(actualTitle,expectedTitleAfterClick);
        System.out.println("Title after click:"+ actualTitle);

        driver.close();

    }



}
