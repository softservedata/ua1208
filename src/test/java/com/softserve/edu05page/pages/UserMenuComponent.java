package com.softserve.edu05page.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserMenuComponent {

    protected WebDriver driver;
    //
    private WebElement notifications;
    private WebElement signOut;
    private WebElement ubsUser;

    public UserMenuComponent(WebDriver driver) {
        this.driver = driver;
        //
        notifications = driver.findElement(By.cssSelector("ul.dropdown-list.drop-down-item li[aria-label='notifications'] > a"));
        signOut = driver.findElement(By.cssSelector("ul.dropdown-list.drop-down-item li[aria-label='sign-out'] > a"));
        ubsUser = driver.findElement(By.cssSelector("ul.dropdown-list.drop-down-item a[href='#/ubs-user/orders']"));
    }

    // Atomic operation

    // notifications
    public WebElement getNotifications() {
        return notifications;
    }

    public void clickNotifications() {
        getNotifications().click();
    }

    // signOut
    public WebElement getSignOut() {
        return signOut;
    }

    public void clickSignOut() {
        getSignOut().click();
    }

    // ubsUser
    public WebElement getUbsUser() {
        return ubsUser;
    }

    public void clickUbsUser() {
        getUbsUser().click();
    }

    // Functional

    // Business Logic

}
