package com.softserve.edu02events;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class PageFactoryTest {

    private static final String BASE_URL = "https://demo.opencart.com/index.php";
    private static final long IMPLICITLY_WAIT_SECONDS = 10L;
    private static WebDriver driver;

    @FindBy(css = "div.nav.float-end a[data-bs-toggle='dropdown']")
    private WebElement myAccount;
    @FindBy(css = "#top a[href*='route=account/login']")
    private WebElement login;
    @FindBy(id = "input-email")
    private WebElement email;


    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        //
        // https://peter.sh/experiments/chromium-command-line-switches/
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");
        //driver = new ChromeDriver(options);
        //
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        //
        //driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS)); // 0 by default
        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(1295, 687));
        System.out.println("@BeforeAll executed");
    }

    @AfterAll
    public static void tear() {
        if (driver != null) {
            driver.quit(); // close()
        }
        System.out.println("@AfterAll executed");
    }

    @BeforeEach
    public void setupThis() {
        driver.get(BASE_URL);
        System.out.println("\t@BeforeEach executed");
        //
        PageFactory.initElements(driver, this);
    }

    @AfterEach
    public void tearThis() throws InterruptedException {
        Thread.sleep(8000); // For Presentation
        System.out.println("\t@AfterEach executed");
        // TODO
        // Close Session
    }

    @Test
    public void checkLogin() throws InterruptedException {
        myAccount.click();
        Thread.sleep(1000); // For Presentation ONLY
        //
        login.click();
        Thread.sleep(1000); // For Presentation ONLY
        //
        email.click();
        Thread.sleep(1000); // For Presentation ONLY
        //
        email.clear();
        Thread.sleep(1000); // For Presentation ONLY
        //
        email.sendKeys("ha-ha-ha");
        //driver.findElement(By.id("input-email")).sendKeys("ha-ha-ha");
        Thread.sleep(1000); // For Presentation ONLY
    }
}
