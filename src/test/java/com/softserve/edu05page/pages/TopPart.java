package com.softserve.edu05page.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class TopPart {

    protected WebDriver driver;
    //
    private WebElement languageButton;

    public TopPart(WebDriver driver) {
        this.driver = driver;
        //
        languageButton = driver.findElement(By.cssSelector("div.main-content.app-container li.lang-option > span"));
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

    // Functional

    // Business Logic
}
