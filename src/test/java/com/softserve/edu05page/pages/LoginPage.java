package com.softserve.edu05page.pages;

import com.softserve.edu05page.data.User;
import com.softserve.edu05page.tests.GreencityTestRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    protected WebDriver driver;
    //
    private WebElement emailField;
    private WebElement passwordField;
    private WebElement signinButton;
    private WebElement closeModalWindow;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        //
        emailField = driver.findElement(By.id("email"));
        passwordField = driver.findElement(By.id("password"));
        signinButton = driver.findElement(By.cssSelector(".ubsStyle"));
        closeModalWindow = driver.findElement(By.cssSelector("a.close-modal-window"));
        GreencityTestRunner.presentationSleep();
    }

    // Atomic operation

    // emailField
    public WebElement getEmailField() {
        return emailField; // Classic Page Object
        //return driver.findElement(By.id("email")); // Lazy initialization
    }

    public void clickEmailField() {
        getEmailField().click();
    }

    public void clearEmailField() {
        getEmailField().clear();
    }

    public void typeEmailField(String email) {
        getEmailField().sendKeys(email);
    }

    // passwordField
    public WebElement getPasswordField() {
        return passwordField;
    }

    public void clickPasswordField() {
        getPasswordField().click();
    }

    public void clearPasswordField() {
        getPasswordField().clear();
    }

    public void typePasswordField(String password) {
        getPasswordField().sendKeys(password);
    }

    // signinButton
    public WebElement getSigninButton() {
        return signinButton;
    }

    public void clickSigninButton() {
        getSigninButton().click();
    }

    // closeModalWindow
    public WebElement getCloseModalWindow() {
        return closeModalWindow;
    }

    public void clickCloseModalWindow() {
        getCloseModalWindow().click();
    }

    // Functional

    // emailField
    private void sendEmailField(String email) {
        clickEmailField();
        clearEmailField();
        typeEmailField(email);
    }

    // passwordField
    private void sendPasswordField(String password) {
        clickPasswordField();
        clearPasswordField();
        typePasswordField(password);
    }

    // Business Logic

    //public BasePage successfullyLogin(String validEmail, String validPassword) {
    public BasePage successfullyLogin(User validUser) {
        //sendEmailField(validEmail);
        sendEmailField(validUser.getEmail());
        //sendPasswordField(validPassword);
        sendPasswordField(validUser.getPassword());
        clickSigninButton();
        GreencityTestRunner.presentationSleep();
        return new BasePage(driver);
    }

    //public InvaliLoginPage unsuccessfullyLogin(String invalidEmail, String invalidPassword) {
    public InvaliLoginPage unsuccessfullyLogin(User invalidUser) {
        //sendEmailField(invalidEmail);
        sendEmailField(invalidUser.getEmail());
        //sendPasswordField(invalidPassword);
        sendPasswordField(invalidUser.getPassword());
        clickSigninButton();
        GreencityTestRunner.presentationSleep();
        return new InvaliLoginPage(driver);
    }

    public HomePage closeLoginPage() {
        clickCloseModalWindow();
        return new HomePage(driver);
    }
}
