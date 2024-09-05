package com.softserve.edu05page.tests;

import com.softserve.edu05page.pages.BasePage;
import com.softserve.edu05page.pages.HomePage;
import com.softserve.edu05page.pages.InvaliLoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class GreencityLoginTest extends GreencityTestRunner {

    private static Object[][] validAccountProvider() {
        return new Object[][] {
                {"tyv09754@zslsz.com", "Qwerty_1", "QwertyY"}
        };
    }

    @ParameterizedTest(name = "{index} => email={0}, password={1}, name={2}")
    @MethodSource("validAccountProvider")
    public void checkValidLogin(String email, String password, String name) {
        BasePage basePage = startApplication()
                .switchToEN()
                .gotoLogin()
                .successfullyLogin(email, password);
        Assertions.assertEquals(name, basePage.getUbsUsernameText());
        //
        HomePage homePage = basePage.signOutApplication();
    }


    private static Object[][] invalidAccountProvider() {
        return new Object[][] {
                {"hahaha@zslsz.com", "Qwerty_Error"}
        };
    }

    @ParameterizedTest(name = "{index} => email={0}, password={1}, name={2}")
    @MethodSource("invalidAccountProvider")
    public void checkValidLogin(String email, String password) {
        InvaliLoginPage invaliLoginPage = startApplication()
                .switchToEN()
                .gotoLogin()
                .unsuccessfullyLogin(email, password);
        Assertions.assertEquals(InvaliLoginPage.ERROR_MESSAGE_EN, invaliLoginPage.getAlertErrorText().trim());
        //
        HomePage homePage = invaliLoginPage.closeLoginPage();
    }
}
