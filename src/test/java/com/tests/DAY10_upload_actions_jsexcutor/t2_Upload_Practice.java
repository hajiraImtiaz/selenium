package com.tests.DAY10_upload_actions_jsexcutor;

import com.tests.utilities.BrowserUtils;
import com.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class t2_Upload_Practice {
    @Test
    public void upload_test(){
        //TC #2 Upload Test
        //1. Go to https://practice.cydeo.com/upload
        Driver.getDriver().get("https://practice.cydeo.com/upload");
        //2. Find some small file from your computer, and get the path of it.
        String path = "C:\\Users\\Aqmad\\OneDrive\\Desktop\\IMG-20211013-WA0014 (1).jpg";
        //3. Upload the file.
        WebElement fileUpload = Driver.getDriver().findElement(By.id("file-upload"));

        BrowserUtils.sleep(2);
        fileUpload.sendKeys(path);
        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));
        uploadButton.click();
        //4. Assert:
        //-File uploaded text is displayed on the page

        Assert

    }

}
