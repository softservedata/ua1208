package com.softserve.edu05page.pages;

import com.softserve.edu05page.tests.GreencityTestRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage extends TopPart {

    private WebElement ubsUsername;
    private UserMenuComponent userMenuComponent;

    public BasePage(WebDriver driver) {
        super(driver);
        //
        ubsUsername = driver.findElement(By.cssSelector("app-header:nth-child(1) .body-2"));
    }

    // Atomic operation

    // ubsUsername
    public WebElement getUbsUsername() {
        return ubsUsername;
    }

    public String getUbsUsernameText() {
        return getUbsUsername().getText();
    }

    public void clickUbsUsername() {
        getUbsUsername().click();
    }

    // Functional
    private void createUserMenuComponent() {
        clickLanguageButton();
        clickUbsUsername();
        userMenuComponent = new UserMenuComponent(driver);
    }

    private void notificationUserMenuComponent() {
        if (userMenuComponent == null) {
            createUserMenuComponent();
        }
        userMenuComponent.clickNotifications();
        userMenuComponent = null;
    }

    private void signOutUserMenuComponent() {
        if (userMenuComponent == null) {
            createUserMenuComponent();
        }
        userMenuComponent.clickSignOut();
        userMenuComponent = null;
    }

    private void closeUserMenuComponent() {
        if (userMenuComponent != null) {
            clickUbsUsername();
            userMenuComponent = null;
        }
    }

    // Business Logic
    public HomePage signOutApplication() {
        signOutUserMenuComponent();
        GreencityTestRunner.presentationSleep();
        return new HomePage(driver);
    }
}
