package com.softserve.edu05page.tests;

import com.softserve.edu05page.data.User;
import com.softserve.edu05page.data.UserRepository;
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
                //{"tyv09754@zslsz.com", "Qwerty_1", "QwertyY"}
                //{ new User("tyv09754@zslsz.com", "Qwerty_1", "QwertyY") }
                { UserRepository.getValidUser() }
                //{ UserRepository.getExistUser() }
        };
    }

    //@ParameterizedTest(name = "{index} => email={0}, password={1}, name={2}")
    @ParameterizedTest(name = "checkValidLogin number = {index}  parameter =  user={0}")
    @MethodSource("validAccountProvider")
    //public void checkValidLogin(String email, String password, String name) {
    public void checkValidLogin(User validUser) {
        logger.info("Test_Name = checkValidLogin; Parameters: User = " + validUser);
        BasePage basePage = startApplication()
                .switchToEN()
                .gotoLogin()
                .successfullyLogin(validUser);
                //.successfullyLogin(user.getEmail(), user.getPassword());
                //.successfullyLogin(email, password);
        //Assertions.assertEquals(name, basePage.getUbsUsernameText());
        Assertions.assertEquals(validUser.getName(), basePage.getUbsUsernameText());
        //
        HomePage homePage = basePage.signOutApplication();
        // isSuccess = true;
    }


    private static Object[][] invalidAccountProvider() {
        return new Object[][] {
                //{"hahaha@zslsz.com", "Qwerty_Error"}
                //{ new User("hahaha@zslsz.com", "Qwerty_Error", "hahaha") }
                { UserRepository.getNewUser() }
        };
    }

    //@ParameterizedTest(name = "{index} => email={0}, password={1}, name={2}")
    @ParameterizedTest(name = "{index} => user={0}")
    @MethodSource("invalidAccountProvider")
    //public void checkInvalidLogin(String email, String password) {
    public void checkInvalidLogin(User invalidUser) {
        logger.info("Test_Name = checkValidLogin; Parameters: User = " + invalidUser);
        InvaliLoginPage invaliLoginPage = startApplication()
                .switchToEN()
                .gotoLogin()
                .unsuccessfullyLogin(invalidUser);
                //.unsuccessfullyLogin(user.getEmail(), user.getPassword());
        Assertions.assertEquals(InvaliLoginPage.ERROR_MESSAGE_EN, invaliLoginPage.getAlertErrorText().trim());
        //
        HomePage homePage = invaliLoginPage.closeLoginPage();
        // isSuccess = true;
    }
}
