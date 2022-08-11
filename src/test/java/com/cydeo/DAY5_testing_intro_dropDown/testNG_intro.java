package com.cydeo.DAY5_testing_intro_dropDown;

import org.testng.Assert;
import org.testng.annotations.*;

public class testNG_intro {


    @BeforeClass

    public void setupMethod(){
        System.out.println("--->beforeClass is running!");
    }
    @AfterClass
    public void tearDownClass(){
        System.out.println("--->afterClass is running!");
    }


    @BeforeMethod
    public void setUpMethod(){
        System.out.println("--->BeforeMethod is running!");
    }
    @AfterMethod
    public void tearDownMethod(){
        System.out.println("--->AfterMethod is running!");
    }

    @Test
    public void test1(){
        System.out.println("Test 1 is running...");

        //ASSERT EQUALS: SHOWS IF 2 CLASS HAVE SAME THING
        String actual = "apple";
        String expected = "apple";

        Assert.assertEquals("actual","actual");

    }


    @Test
    public void test2(){
        System.out.println("Test 2 is running...");
        //AssertTrue
        String actual = "apple";
        String expected = "apple";
        Assert.assertTrue(actual.equals(expected));
    }

}
