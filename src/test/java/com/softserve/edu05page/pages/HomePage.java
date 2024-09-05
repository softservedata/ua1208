package com.softserve.edu05page.pages;

import com.softserve.edu05page.tests.GreencityTestRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends TopPart{

    private WebElement loginButton;

    public HomePage(WebDriver driver) {
        super(driver);
        //
        loginButton = driver.findElement(By.cssSelector("div.main-content.app-container img.ubs-header-sing-in-img.ng-star-inserted"));
        GreencityTestRunner.presentationSleep();
    }

    // Atomic operation

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
        GreencityTestRunner.presentationSleep();
        return this;
    }

    public HomePage switchToUA() {
        chooseLanguage("UA");
        GreencityTestRunner.presentationSleep();
        return this;
    }

    public LoginPage gotoLogin() {
        clickLoginButton();
        GreencityTestRunner.presentationSleep();
        return new LoginPage(driver);
    }
}
