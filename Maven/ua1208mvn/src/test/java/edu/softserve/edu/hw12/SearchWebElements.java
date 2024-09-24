package edu.softserve.edu.hw12;
import edu.softserve.edu.hw10.Language;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;

import java.time.Duration;
import java.util.List;

public class SearchWebElements {
    private static WebDriver driver;

    @FindBy(css = "div.main-content.app-container img.ubs-header-sing-in-img.ng-star-inserted")
    private WebElement signInButton;

    @FindBy(css = ".container h1")
    private WebElement welcomeText;

    @FindBy(css = "div.container h2")
    private WebElement signInDetailsText;

    @FindBy(css = ".sign-in-form label[for='email']")
    private WebElement emailLabel;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(css = ".ubsStyle")
    private WebElement signInSubmitButton;

    @FindBy(css = ".mat-simple-snackbar > span")
    private WebElement result;

    @FindBy(css = ".alert-general-error")
    private WebElement errorMessage;

    @FindBy(css = "#pass-err-msg.validation-password-error")
    private WebElement errorPassword;

    @FindBy(css = "#email-err-msg.validation-email-error")
    private WebElement errorEmail;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(100));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(180));
    }

    @BeforeEach
    public void initPageElements() {
        driver.get("https://www.greencity.cx.ua/#/ubs");
        PageFactory.initElements(driver, this);
    }

    private WebElement waitForVisibility(WebElement element, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    private void clickWithJS(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    @Test
    public void verifyTitle() {
        Assertions.assertEquals("GreenCity", driver.getTitle());
    }

    @ParameterizedTest
    @CsvSource({"svetlana.babyuk1@gmail.com, Vjqvbh2011//"})
    public void signIn(String email, String password) {
        //  Check the language
        String languageCode = driver.findElement(By.cssSelector("div.main-content.app-container li.lang-option > span")).getText();
        Language currentLanguage = Language.fromCode(languageCode);

        if (currentLanguage == Language.UA) {
            clickWithJS(driver.findElement(By.cssSelector("div.main-content.app-container img[src='assets/img/arrow_down.svg']")));
            clickWithJS(driver.findElement(By.cssSelector("div.main-content.app-container li[aria-label='EN'] > span")));
        }

        List<WebElement> frames = driver.findElements(By.cssSelector("iframe"));
        if (!frames.isEmpty()) {
            driver.switchTo().frame(frames.get(0));
            waitForVisibility(driver.findElement(By.id("close")),Duration.ofSeconds(5)).click();
            driver.switchTo().defaultContent();
            waitForVisibility(welcomeText, Duration.ofSeconds(5)).click();
        }

        clickWithJS(signInButton);
        waitForVisibility(welcomeText, Duration.ofSeconds(5));

        Assertions.assertEquals("Welcome back!", welcomeText.getText());
        Assertions.assertEquals("Please enter your details to sign in.", signInDetailsText.getText());
        Assertions.assertEquals("Email", emailLabel.getText());

        emailInput.clear();
        emailInput.sendKeys(email);
        Assertions.assertEquals(email, emailInput.getAttribute("value"));

        passwordInput.clear();
        passwordInput.sendKeys(password);

        clickWithJS(signInSubmitButton); // Натискання кнопки входу за допомогою JS
    }

    @ParameterizedTest
    @CsvSource({
            "svetlana.babyuk1gmail.com, bh2011//",
            "invalid.email@, wrongPassword//"
    })
    public void signInWithInvalidCredentials(String email, String password) {
        clickWithJS(signInButton);
        waitForVisibility(emailInput, Duration.ofSeconds(5));
        emailInput.clear();
        emailInput.sendKeys(email);
        passwordInput.clear();
        passwordInput.sendKeys(password);

        clickWithJS(signInSubmitButton); // Натискання кнопки входу за допомогою JS

        // Перевірка повідомлень про помилки для електронної пошти та пароля
        try {
            waitForVisibility(errorMessage, Duration.ofSeconds(5)); // Додано тривалість
        } catch (TimeoutException exception) {
            Assertions.fail("Expected error message did not appear within the timeout.");
        }
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}





















