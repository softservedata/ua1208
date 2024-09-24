package com.softserve.edu02events;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.List;

public class DemoOpenCartTest {
    private static WebDriver driver;

    @BeforeAll
    public static void setUpClass() {
        WebDriverManager.firefoxdriver().setup();
        //System.setProperty("webdriver.gecko.driver", "./lib/geckodriver.exe");
        //driver = new FirefoxDriver();
        //
        FirefoxOptions options = new FirefoxOptions()
                .setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
                //.addArguments("-headless")
                //.addArguments("-console");
        driver = new FirefoxDriver(options);
        //
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        //
        //driver.manage().window().setSize(new Dimension(1295, 687));
        //driver.manage().window().setSize(new Dimension(500, 200)); // 500 min
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @BeforeEach
    public void setUp() throws InterruptedException {
        driver.get("https://demo.opencart.com/");
        Thread.sleep(1000);
        //
    }

    @AfterEach
    public void tearDownClass() throws InterruptedException {
        Thread.sleep(2000);
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void checkSize() throws InterruptedException {
        // My Account
        driver.findElement(By.cssSelector("li.list-inline-item > div.dropdown a.dropdown-toggle")).click();
        Thread.sleep(2000);
        driver.manage().window().setSize(new Dimension(600, 500));
        Thread.sleep(2000);
        driver.manage().window().setSize(new Dimension(500, 200));
        Thread.sleep(2000);
        //
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.resizeTo(600, 500);"); // Not Working
        Thread.sleep(2000);
    }

    @Test
    public void checkLogin() throws InterruptedException {
        // My Account
        driver.findElement(By.cssSelector("li.list-inline-item > div.dropdown a.dropdown-toggle")).click();
        Thread.sleep(1000);
        // Login
        driver.findElement(By.cssSelector("a[href*='route=account/login']")).click();
        Thread.sleep(1000);
        //
        // Login Page
        // email
        /*
        driver.findElement(By.id("input-email")).click();
        Thread.sleep(1000);
        //
        driver.findElement(By.id("input-email")).clear();
        Thread.sleep(1000);
        //
        driver.findElement(By.id("input-email")).sendKeys("my1@gmail.com");
        Thread.sleep(1000);
        */
        // ----------
        WebElement email = driver.findElement(By.id("input-email"));
        email.click();
        email.clear();
        email.sendKeys("my1@gmail.com");
        Thread.sleep(2000);
        //
        driver.navigate().refresh();
        Thread.sleep(2000);
        //
        //email.sendKeys("second@gmail.com"); // Error
        driver.findElement(By.id("input-email")).sendKeys("my1@gmail.com"); // OK
        Thread.sleep(2000);
        //
        // password
        driver.findElement(By.id("input-password")).click();
        Thread.sleep(1000);
        //
        driver.findElement(By.id("input-password")).clear();
        Thread.sleep(1000);
        //
        driver.findElement(By.id("input-password")).sendKeys("qwerty");
        Thread.sleep(1000);
        //
    }

}
