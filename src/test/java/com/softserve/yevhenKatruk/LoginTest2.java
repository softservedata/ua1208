package com.softserve.yevhenKatruk;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Objects;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginTest2 {

    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void classSetUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.greencity.cx.ua/#/ubs");
        driver.manage().window().setSize(new Dimension(1264, 798));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void verifyTitle() {
        Assertions.assertEquals("GreenCity", driver.getTitle());
    }

    @ParameterizedTest
    @MethodSource("negativeLoginProvider")
    public void signInNotValid(String email, String emailMessage) {
        WebElement signInButton = driver.findElement(By.cssSelector("app-header:nth-child(1) .ubs-header-sing-in-img"));
        clickElement(signInButton);

        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement signInSubmitButton = driver.findElement(By.cssSelector(".ubsStyle"));

        emailInput.sendKeys(email);
        passwordInput.sendKeys("invalidpass");
        clickElement(signInSubmitButton);

        WebElement errorEmail = driver.findElement(By.xpath("//*[@id=\"email-err-msg\"]/app-error/div"));
        WebElement errorPassword = driver.findElement(By.cssSelector(".alert-general-error"));

        assertThat(getElementText(errorEmail), is(emailMessage));
        assertThat(getElementText(errorPassword), is("Bad email or password"));
    }

    private static Stream<Arguments> negativeLoginProvider() {
        return Stream.of(
                Arguments.of("invalidemailgreencity.com", "Please check if the email is written correctly")
        );
    }

    @Test
    public void signInValidTest() {
        String email = "tyv09754@zslsz.com";
        String password = "Qwerty_1";

        WebElement signInButton = driver.findElement(By.cssSelector("app-header:nth-child(1) .ubs-header-sing-in-img"));
        clickElement(signInButton);

        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement signInSubmitButton = driver.findElement(By.cssSelector(".ubsStyle"));

        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        clickElement(signInSubmitButton);

        WebElement welcomeText = driver.findElement(By.xpath("//*[@id='mat-mdc-dialog-0']/div/div/app-auth-modal/div/div/div[2]/div/app-sign-in/div/div[1]/h1"));
        String expectedWelcomeMessage = "Welcome back!";
        assertThat(getElementText(welcomeText), is(expectedWelcomeMessage));
    }

    @Test
    public void testAlertInjectionAndDismiss() {
        ((JavascriptExecutor) driver).executeScript("alert('This is a test alert!');");
        Alert alert = driver.switchTo().alert();
        assertThat(alert.getText(), is("This is a test alert!"));
        alert.accept();
    }

    private void clickElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    private String getElementText(WebElement element) {
        return Objects.requireNonNull(((JavascriptExecutor) driver)
                        .executeScript("return arguments[0].textContent;", element))
                .toString()
                .trim();
    }
}
