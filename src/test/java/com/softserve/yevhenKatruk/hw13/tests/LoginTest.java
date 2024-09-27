package com.softserve.yevhenKatruk.hw13.tests;

import com.softserve.yevhenKatruk.hw13.data.LoginData;
import com.softserve.yevhenKatruk.hw13.pages.LoginPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends TestRunner {
    private LoginPage loginPage;

    @ParameterizedTest
    @MethodSource("com.softserve.yevhenKatruk.hw13.data.LoginDataRepository#getInvalidLoginData")
    public void signInWithInvalidData(LoginData loginData) {
        // Use the logger inherited from TestRunner
        logger.info("Test_Name = signInWithInvalidData; Parameters: User = {}; Password = {}",
                loginData.getEmail(), loginData.getPassword());

        loginPage = new LoginPage(driver, wait);
        loginPage.openLoginForm();
        loginPage.signIn(loginData.getEmail(), loginData.getPassword());

        assertEquals(loginData.getEmailErrorMessage(), loginPage.getErrorMessage());
        assertEquals(loginData.getPasswordErrorMessage(), loginPage.getPasswordErrorMessage());

        setTestSuccess();
    }

    @ParameterizedTest
    @MethodSource("com.softserve.yevhenKatruk.hw13.data.LoginDataRepository#getValidLoginData")
    public void signInWithValidData(LoginData validUser) {
        // Use the logger inherited from TestRunner
        logger.info("Test_Name = signInWithValidData; Parameters: User = {}; Password = {}",
                validUser.getEmail(), validUser.getPassword());

        loginPage = new LoginPage(driver, wait);
        loginPage.openLoginForm();
        assertEquals("Welcome back!", loginPage.getWelcomeMessage());
        loginPage.signIn(validUser.getEmail(), validUser.getPassword());

        setTestSuccess();
    }
}
