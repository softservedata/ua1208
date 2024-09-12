package edu.softserve.edu.hw11;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


public class TestSamples3 {
    private static WebDriver driver;

    @FindBy(css = "div.main-content.app-container img.ubs-header-sing-in-img.ng-star-inserted")//OK
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
    @FindBy(xpath = "div#pass-err-msg.validation-password-error")
    private WebElement errorPassword;
    @FindBy(xpath = "div.ng-star-inserted")
    private WebElement errorEmail;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @BeforeEach
    public void initPageElements() {
        driver.get("https://www.greencity.cx.ua/#/ubs");
        PageFactory.initElements(driver, this);
    }

    @Test
    public void verifyTitle() {
        Assertions.assertEquals("GreenCity", driver.getTitle());

    }

    @ParameterizedTest
    @CsvSource({"svetlana.babyuk1@gmail.com, Vjqvbh2011//"})

    public void signIn(String email, String password) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Перевірка мови, якщо потрібно
        String language = driver.findElement(By.cssSelector("div.main-content.app-container li.lang-option > span")).getText();
        if (language.toLowerCase().equals("ua")) {
            driver.findElement(By.cssSelector("div.main-content.app-container img[src='assets/img/arrow_down.svg']")).click();
            driver.findElement(By.cssSelector("div.main-content.app-container li[aria-label='EN'] > span")).click();
        }
        // Переключення на iframe, якщо є
        List<WebElement> frames = driver.findElements(By.cssSelector("iframe"));
        if (!frames.isEmpty()) {
            driver.switchTo().frame(frames.get(0));
            driver.findElement(By.id("close")).click();
            driver.switchTo().defaultContent();

        }
        signInButton.click();
        wait.until(ExpectedConditions.visibilityOf(welcomeText));
        Assertions.assertEquals("Welcome back!", welcomeText.getText());
        Assertions.assertEquals("Please enter your details to sign in.", signInDetailsText.getText());
        Assertions.assertEquals("Email", emailLabel.getText());

        emailInput.clear();
        emailInput.sendKeys(email); // Використовуйте параметризоване значення електронної пошти
        Assertions.assertEquals(email, emailInput.getAttribute("value"));
        passwordInput.sendKeys(password); // Використовуйте параметризоване значення пароля
        Assertions.assertEquals(password, passwordInput.getAttribute("value"));
        signInSubmitButton.click();
    }
    //Параметризований тест для негативного сценарію логування


    @ParameterizedTest
    @CsvSource({"svetlana.babyuk1gmail.com, bh2011//"})
    public void signInNegative(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        signInButton.click();
        wait.until(ExpectedConditions.visibilityOf(emailInput));

        emailInput.clear();
        emailInput.sendKeys(email);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        signInSubmitButton.click();
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        Assertions.assertTrue(errorMessage.isDisplayed(), "Expected error message is not displayed.");

    }

        @AfterAll
        public static void tearDown () {
            if (driver != null) {
                driver.quit();
            }
        }
    }
