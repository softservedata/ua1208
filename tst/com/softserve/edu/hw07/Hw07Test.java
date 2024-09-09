package com.softserve.edu.hw07;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class Hw07Test {
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
    public void hw07() {
        driver.get("https://www.greencity.cx.ua/#/greenCity");
        driver.manage().window().setSize(new Dimension(1382, 744));
        driver.findElement(By.cssSelector(".nav-left-list:nth-child(1) > .url-name")).click();
        js.executeScript("window.scrollTo(0,0)");
        driver.findElement(By.cssSelector(".gallery-view-li-active:nth-child(2) .list-image-content")).click();
        js.executeScript("window.scrollTo(0,0)");
        driver.findElement(By.cssSelector(".comment-textarea")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".comment-textarea"));
            js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = ')(*&amp;^cvbNM&lt;'}", element);
        }
        driver.findElement(By.cssSelector(".primary-global-button")).click();
    }
}

