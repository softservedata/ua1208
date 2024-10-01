package edu.softserve.hw13.pages;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SignInTest extends TestRunner {
    private SignInPage signInPage;

    @BeforeEach
    public void setUpPage() {
        signInPage = new SignInPage(driver);
    }

    @ParameterizedTest
    @MethodSource("edu.softserve.hw13.pages.SignInDataRepository#provideValidSignInData")
    public void signInValidUser(SignInDataRepository.SignInData data) {

        signInPage.clickSignInButton();
        signInPage.enterCredentials(data.getEmail(), data.getPassword());
        assertEquals("З поверненням!", signInPage.getWelcomeMessage());
    }

    @ParameterizedTest
    @MethodSource("edu.softserve.hw13.pages.SignInDataRepository#provideInvalidSignInData")
    public void signInInvalidUser(SignInDataRepository.SignInData data) {
        signInPage.clickSignInButton();
        signInPage.enterCredentials(data.getEmail(), data.getPassword());
        signInPage.submitSignIn();

        assertEquals(data.getEmailErrorMessage(), signInPage.getEmailErrorMessage());

    }
}