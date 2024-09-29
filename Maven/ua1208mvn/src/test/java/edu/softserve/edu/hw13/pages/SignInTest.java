package edu.softserve.edu.hw13.pages;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static edu.softserve.edu.hw09.pt.GreencityTest.driver;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class SignInTest extends TestRunner {
    @BeforeEach
    public void init() {
        // Navigate to the login page before each test
        driver.get("https://www.greencity.cx.ua/#/ubs");
    }
    @Test
    public void verifyTitle() {
        assertEquals("GreenCity", driver.getTitle());
    }

    @ParameterizedTest
    @MethodSource("edu.softserve.edu.hw13.pages.SignInDataRepository#provideValidSignInData")
    public void signInValidUser(SignInData data) {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.clickSignInButton();
        signInPage.enterCredentials(data.getEmail(), data.getPassword());
        signInPage.submitSignIn();
        assertEquals("Welcome back!", signInPage.getWelcomeText());
    }

    @ParameterizedTest
    @MethodSource("edu.softserve.edu.hw13.pages.SignInDataRepository#provideInvalidSignInData")
    public void signInInvalidUser(SignInData data) {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.clickSignInButton();
        signInPage.enterCredentials(data.getEmail(), data.getPassword());
        signInPage.submitSignIn();
        assertEquals("Invalid email or password.", signInPage.getErrorMessage());
    }
}

