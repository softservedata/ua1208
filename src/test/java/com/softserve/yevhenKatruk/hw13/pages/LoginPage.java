package com.softserve.yevhenKatruk.hw13.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "app-header:nth-child(1) .ubs-header-sing-in-img")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@id='mat-mdc-dialog-0']/div/div/app-auth-modal/div/div/div[2]/div/app-sign-in/div/div[1]/h1")
    private WebElement welcomeText;

    @FindBy(css = "h2:nth-child(2)")
    private WebElement signInDetailsText;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(css = ".ubsStyle")
    private WebElement signInSubmitButton;

    @FindBy(css = ".alert-general-error")
    private WebElement errorPassword;

    @FindBy(xpath = "//*[@id=\"email-err-msg\"]/app-error/div")
    private WebElement errorEmail;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void openLoginForm() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }

    public void signIn(String email, String password) {
        emailInput.clear();
        emailInput.sendKeys(email);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(signInSubmitButton)).click();
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorEmail));
        return errorEmail.getText();
    }

    public String getPasswordErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorPassword));
        return errorPassword.getText();
    }

    public String getWelcomeMessage() {
        wait.until(ExpectedConditions.visibilityOf(welcomeText));
        return welcomeText.getText();
    }
}
