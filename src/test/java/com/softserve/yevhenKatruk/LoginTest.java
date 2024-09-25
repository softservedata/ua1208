package com.softserve.yevhenKatruk;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class LoginTest {

    @FindBy(css = "app-header:nth-child(1) .ubs-header-sing-in-img")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@id='mat-mdc-dialog-0']/div/div/app-auth-modal/div/div/div[2]/div/app-sign-in/div/div[1]/h1")
    private WebElement welcomeText;

    @FindBy(css = "h2:nth-child(2)")
    private WebElement signInDetailsText;

    @FindBy(css = "label[for=\"email\"]")
    private WebElement emailLabel;

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

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void classSetUp() {
        driver = new ChromeDriver();
        driver.get("https://www.greencity.cx.ua/#/ubs");
        driver.manage().window().setSize(new Dimension(1264, 798));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
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
    @CsvSource({
            "tyv09754@zslsz.com, Qwerty_1",
    })
    public void signIn(String email, String password) throws InterruptedException {
        String language = driver.findElement(By.cssSelector("div.main-content.app-container li.lang-option > span")).getText();
        if (language.toLowerCase().equals("ua")) {
            driver.findElement(By.cssSelector("div.main-content.app-container img[src='assets/img/filled_arrow_down.svg']")).click();
            driver.findElement(By.cssSelector("div.main-content.app-container li[aria-label='EN'] > span")).click();
        }

        wait.until(elementToBeClickable(signInButton)).click();

        List<WebElement> frames = driver.findElements(By.cssSelector("iframe"));
        if (frames.size() > 0) {
            driver.switchTo().frame(frames.get(0));
            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("close")));
            closeButton.click();
            driver.switchTo().defaultContent(); // Повернення до основного контенту
        }

        wait.until(ExpectedConditions.visibilityOf(welcomeText));
        assertThat(welcomeText.getText(), is("Welcome back!"));
        assertThat(signInDetailsText.getText(), is("Please enter your details to sign in."));
        assertThat(emailLabel.getText(), is("Email"));

        emailInput.clear();
        emailInput.sendKeys(email);
        wait.until(ExpectedConditions.attributeToBe(emailInput, "value", email));

        passwordInput.clear();
        passwordInput.sendKeys(password);
        wait.until(ExpectedConditions.attributeToBe(passwordInput, "value", password));

        wait.until(elementToBeClickable(signInSubmitButton)).click();
    }

    /*@ParameterizedTest
    @CsvSource({
            "Please check if the email is written correctly, Bad email or password"
    })
    public void signInNotValid(String emailMessage, String passwordMessage) {
        wait.until(elementToBeClickable(signInButton)).click();

        emailInput.sendKeys("invalidemailgreencity.com");
        wait.until(ExpectedConditions.attributeToBe(emailInput, "value", "invalidemailgreencity.com"));

        passwordInput.sendKeys("invalidpass");
        wait.until(ExpectedConditions.attributeToBe(passwordInput, "value", "invalidpass"));

        wait.until(elementToBeClickable(signInSubmitButton)).click();

        wait.until(ExpectedConditions.visibilityOf(errorEmail));
        assertThat(errorEmail.getText(), is(emailMessage));

        wait.until(ExpectedConditions.visibilityOf(errorPassword));
        assertThat(errorPassword.getText(), is(passwordMessage));
    }*/

    private static Stream<Arguments> negativeLoginProvider() {
        return Stream.of(
                Arguments.of("invalidemailgreencity.com", "Please check if the email is written correctly"),
                Arguments.of("somewrongemailexample.com", "Please check if the email is written correctly")
        );
    }

    @ParameterizedTest
    @MethodSource("negativeLoginProvider")
    public void signInNotValid(String email, String emailMessage) {
        wait.until(elementToBeClickable(signInButton)).click();

        emailInput.sendKeys(email);
        wait.until(ExpectedConditions.attributeToBe(emailInput, "value", email));

        passwordInput.sendKeys("invalidpass");
        wait.until(ExpectedConditions.attributeToBe(passwordInput, "value", "invalidpass"));

        wait.until(elementToBeClickable(signInSubmitButton)).click();

        wait.until(ExpectedConditions.visibilityOf(errorEmail));
        assertThat(errorEmail.getText(), is(emailMessage));

        wait.until(ExpectedConditions.visibilityOf(errorPassword));
        assertThat(errorPassword.getText(), is("Bad email or password"));
    }

}
