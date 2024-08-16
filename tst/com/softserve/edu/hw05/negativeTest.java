package com.softserve.edu.hw05;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.Map;

public class negativeTest {
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
    public void hw02() {
        driver.get("https://www.greencity.cx.ua/#/ubs");
        driver.manage().window().setSize(new Dimension(1382, 744));
        driver.findElement(By.cssSelector("app-header:nth-child(1) .header_sign-up-link:nth-child(4) span:nth-child(1)")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("lizababyuk1mail.com");
        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).sendKeys("12345");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("Vjqvbh2011");
        driver.findElement(By.id("repeatPassword")).click();
        driver.findElement(By.id("repeatPassword")).sendKeys(" Vjqvbh2011/");
        driver.findElement(By.cssSelector(".form-content-container")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys(Keys.DOWN);
        {
            WebElement element = driver.findElement(By.cssSelector(".wrapper"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).clickAndHold().perform();
        }
    }
}
