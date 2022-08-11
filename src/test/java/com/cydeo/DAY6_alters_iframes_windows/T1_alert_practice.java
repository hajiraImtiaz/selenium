package com.cydeo.DAY6_alters_iframes_windows;

import com.tests.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_alert_practice {
    public WebDriver driver;
@BeforeMethod
    public void setupMethod(){
    // 1. Open browser
    driver= WebDriverFactory.getDriver("chrome");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
// 2. Go to website: http://practice.cydeo.com/javascript_alerts
    driver.get("http://practice.cydeo.com/javascript_alerts");
}

@Test
    public void alerts_test1() throws InterruptedException {
    // TC #1: Information alert practice

    //        3. Click to “Click for JS Alert” button
    WebElement informationAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));

    informationAlertButton.click();

    Thread.sleep(2000);


    // to be able to click to Alert ok button we need to switch deiver's focus to Alert itself
    Alert alert = driver.switchTo().alert();
    // 4. Click to OK button from the alert
    alert.accept();
    Thread.sleep(2000);

// 5. Verify “You successfully clicked an alert” text is displayed.
WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

    Assert.assertTrue(resultText.isDisplayed(),"result text is not displayed.");

    String expectedText = "you successfully clicked an alert";
    String actualText = resultText.getText();

   // Assert.assertEquals(actualText,expectedText,"actalText is not as expected!!!");

    driver.close();
}

}
