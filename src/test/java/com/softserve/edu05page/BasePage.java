package com.softserve.edu05page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebDriver driver;
    //
    private WebElement emailField;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        //
        emailField = driver.findElement(By.id("email"));
    }

    // Atomic operation

    // emailField


    // Functional


    // Business Logic
}
