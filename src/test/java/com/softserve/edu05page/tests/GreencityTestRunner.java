package com.softserve.edu05page.tests;

import com.softserve.edu05page.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class GreencityTestRunner {

    private static final Long ONE_SECOND_DELAY = 1000L;
    private static WebDriver driver;

    @BeforeAll
    public static void setUpClass() {
        //WebDriverManager.firefoxdriver().setup();
        //driver = new FirefoxDriver();
        //
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //
        //driver.manage().window().setSize(new Dimension(1295, 687));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // 0 by default
    }

    @BeforeEach
    public void setUp() throws InterruptedException {
        presentationSleep();
    }

    @AfterEach
    public void tearDownClass() throws InterruptedException {
        presentationSleep();
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        presentationSleep();
    }

    public static void presentationSleep() {
        presentationSleep(1);
    }

    // Overload
    public static void presentationSleep(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public HomePage startApplication() {
        driver.get("https://www.greencity.cx.ua/#/ubs");
        presentationSleep();
        return new HomePage(driver);
    }
}
