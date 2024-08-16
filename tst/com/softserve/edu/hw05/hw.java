package com.softserve.edu.hw05;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class hw {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void hw() throws InterruptedException {
        driver.get("https://www.greencity.cx.ua/#/ubs");
        Thread.sleep(1000);
        driver.manage().window().setSize(new Dimension(1382, 744));
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("app-header:nth-child(1) .header_sign-up-link:nth-child(4) span:nth-child(1)")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("email")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("email")).sendKeys("lizetababyuk1@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.id("firstName")).click();
        Thread.sleep(1000);driver.findElement(By.id("firstName")).sendKeys("Maria");
        driver.findElement(By.id("password")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys(" Vjqvbh2011/");
        Thread.sleep(1000);
        driver.findElement(By.id("repeatPassword")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("repeatPassword")).sendKeys(" Vjqvbh2011/");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".ubsStyle")).click();
    }
}

