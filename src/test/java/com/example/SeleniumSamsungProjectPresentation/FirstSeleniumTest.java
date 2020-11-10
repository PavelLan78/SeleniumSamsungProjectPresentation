package com.example.SeleniumSamsungProjectPresentation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstSeleniumTest {
    WebDriver wd;

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        wd.get("https://www.apple.com/ru/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void openSamsungTest(){
        System.out.println("site opened!!");

        wd.findElement(By.cssSelector("#ac-gn-link-search")).click();
        wd.findElement(By.cssSelector("#ac-gn-searchform-input")).click();
        wd.findElement(By.cssSelector("#ac-gn-searchform-input")).sendKeys("iPhone SE" + Keys.ENTER);
        String text = wd.findElement(By.cssSelector("div h2[class = 'as-productname as-util-relatedlink'][data-relatedlink = '1']")).getText();
        Assert.assertEquals(text.toLowerCase(),"iphone se");

    }

    

    @AfterMethod(enabled = false)
    public void tearDown(){
        wd.quit();
    }

}
