package edu.softserve.hw13.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static edu.softserve.hw13.pages.SignInTest.logger;


public class TestRunner {
    protected static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        logger.info("Setting up WebDriver.");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.greencity.cx.ua/#/ubs");
        logger.info("WebDriver setup complete, browser launched.");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            logger.info("Closing WebDriver.");
            driver.quit();
            logger.info("WebDriver closed.");
        }
    }

}