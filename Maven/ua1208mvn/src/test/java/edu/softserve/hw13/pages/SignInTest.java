package edu.softserve.hw13.pages;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SignInTest extends TestRunner {
    private SignInPage signInPage;
    static final Logger logger = LoggerFactory.getLogger(SignInTest.class);


    @BeforeEach
    public void setUpPage() {
        signInPage = new SignInPage(driver);
    }

    @ParameterizedTest
    @MethodSource("edu.softserve.hw13.pages.SignInDataRepository#provideValidSignInData")
    public void signInValidUser(SignInDataRepository.SignInData data) {
        logger.info("Starting test for valid user sign-in.");

        signInPage.clickSignInButton();
        logger.info("Sign In button clicked.");
        signInPage.enterCredentials(data.getEmail(), data.getPassword());
        logger.info("Credentials entered: email={} password=******", data.getEmail());
        assertEquals("З поверненням!", signInPage.getWelcomeMessage());
        logger.info("Test for valid user sign-in passed.");

    }

    @ParameterizedTest
    @MethodSource("edu.softserve.hw13.pages.SignInDataRepository#provideInvalidSignInData")
    public void signInInvalidUser(SignInDataRepository.SignInData data) {
        logger.info("Starting test for invalid user sign-in with email: {}", data.getEmail());
        signInPage.clickSignInButton();
        logger.info("Sign In button clicked.");
        signInPage.enterCredentials(data.getEmail(), data.getPassword());
        logger.info("Credentials entered: email={} password=******", data.getEmail());
        signInPage.submitSignIn();
        logger.info("Sign In form submitted.");

        assertEquals(data.getEmailErrorMessage(), signInPage.getEmailErrorMessage());
        logger.info("Test for invalid user sign-in passed.");

    }
}