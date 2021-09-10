package com.qa.trello_web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class LoginTests {
    WebDriver wd;

    @BeforeClass
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://trello.com/");
    }

    @Test
    public void testLogin() throws InterruptedException {
        click(By.cssSelector("[href='/login']"));
        type(By.cssSelector("#user"), "ashuliko.qa@gmail.com");
        Thread.sleep(2000);//wait
        click(By.id("login"));
        type(By.name("password"), "L2npF#w8");
        click(By.id("login-submit"));
        Thread.sleep(15000); //wait

        //4to bi ne delat otdelnuyu peremennuyu
        Assert.assertTrue(wd.findElements(By.cssSelector("[data-test-id='header-home-button']")).size() > 0);

    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    private void click(By locator) {
        wd.findElement(locator).click();
      }

    @AfterClass
    public void tearDown() {
        wd.quit();
    }

}
