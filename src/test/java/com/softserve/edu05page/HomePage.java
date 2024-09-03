package com.softserve.edu05page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    protected WebDriver driver;
    //
    private WebElement languageButton;
    private WebElement loginButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        //
        languageButton = driver.findElement(By.cssSelector("div.main-content.app-container li.lang-option > span"));
        loginButton = driver.findElement(By.cssSelector("div.main-content.app-container img.ubs-header-sing-in-img.ng-star-inserted"));
    }

    // Atomic operation

    // language
    public WebElement getLanguageButton() {
        return languageButton;
    }

    public String getLanguageButtonText() {
        return getLanguageButton().getText();
    }

    public void clickLanguageButton() {
        getLanguageButton().click();
    }

    // loginButton
    public WebElement getLoginButton() {
        return loginButton;
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }

    // Functional

    private void chooseLanguage(String language) {
        clickLanguageButton();
        driver.findElement(By.cssSelector("div.main-content.app-container li[aria-label='"
                + language + "'] > span")).click();
    }

    // Business Logic

    public HomePage switchToEN() {
        chooseLanguage("EN");
        return this;
    }

    public HomePage switchToUA() {
        chooseLanguage("UA");
        return this;
    }

    public LoginPage gotoLogin() {
        clickLoginButton();
        return new LoginPage(driver);
    }
}
