package edu.softserve.edu.hw13.pages;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class TestRunner {
    private WebDriver driver;

    public TestRunner() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(100));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(180));
    }

    public void setUp() {
        driver.get("https://www.greencity.cx.ua/#/ubs");
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}