package com.softserve.yevhenKatruk.hw13.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ExtendWith(RunnerExtension.class)
public abstract class TestRunner {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static JavascriptExecutor js;
    protected static boolean isSuccess = false;
    private static final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss-S";

    // Logger
    static final Logger logger = LoggerFactory.getLogger(TestRunner.class);

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        logger.info("WebDriver initialized");
    }

    @BeforeEach
    public void initTest(TestInfo testInfo) {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1264, 798));
        driver.get("https://www.greencity.cx.ua/#/ubs");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        isSuccess = false;
        logger.info("Test started: Opening URL https://www.greencity.cx.ua/#/ubs");
        logger.info("Test_Name = {} started", testInfo.getDisplayName());
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        if (!isSuccess) {
            logger.error("Test_Name = {} failed", testInfo.getDisplayName());
            handleTestFailure();
        } else {
            logger.info("Test_Name = {} completed successfully", testInfo.getDisplayName());
        }
        tearDownAll();
    }

    @AfterAll
    public static void tearDownAll() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed");
        }
    }

    private void handleTestFailure() {
        logger.warn("Handling test failure: Taking screenshot and cleaning up session");
        takeScreenshot();
        driver.manage().deleteAllCookies();
        removeItemFromLocalStorage("accessToken");
        removeItemFromLocalStorage("refreshToken");
        driver.navigate().refresh();
        logger.info("Session cleaned up after failure");
    }

    private void takeScreenshot() {
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(TIME_TEMPLATE);
        String currentTime = localDate.format(formatter);
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            File screenshot = new File("./" + currentTime + "_screenshot.png");
            FileUtils.copyFile(scrFile, screenshot);
            logger.info("Screenshot saved: {}", screenshot.getAbsolutePath());
        } catch (IOException e) {
            logger.error("Failed to save screenshot: {}", e.getMessage());
        }
    }

    public void removeItemFromLocalStorage(String item) {
        js.executeScript(String.format("window.localStorage.removeItem('%s');", item));
        logger.debug("Removed item from localStorage: {}", item);
    }

    protected void setTestSuccess() {
        isSuccess = true;
        logger.info("Test status set to success");
    }
}
