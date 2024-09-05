package com.softserve.edu05page.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InvaliLoginPage extends LoginPage {
    public static final String ERROR_MESSAGE_EN = "Bad email or password";
    public static final String ERROR_MESSAGE_UA = "Введено невірний email або пароль";

    private WebElement alertError;

    public InvaliLoginPage(WebDriver driver) {
        super(driver);
        //
        alertError = driver.findElement(By.cssSelector("div.alert-general-error.ng-star-inserted"));
    }

    // Atomic operation

    // alertError
    public WebElement getAlertError() {
        return alertError;
    }

    public String getAlertErrorText() {
        return getAlertError().getText();
    }

    // Functional

    // Business Logic
}
