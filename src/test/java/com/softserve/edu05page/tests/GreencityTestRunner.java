package com.softserve.edu05page.tests;

import com.softserve.edu05page.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@ExtendWith(RunnerExtension.class)
public abstract class GreencityTestRunner {

    private static final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss-S";
    private static final Long ONE_SECOND_DELAY = 1000L;
    private static final Long IMPLICIT_WAIT = 5L;
    private static WebDriver driver;
    private static JavascriptExecutor js;
    protected static boolean isSuccess = false;;

    @BeforeAll
    public static void setUpClass() {
        //WebDriverManager.firefoxdriver().setup();
        //driver = new FirefoxDriver();
        //
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        //
        //driver.manage().window().setSize(new Dimension(1295, 687));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT)); // 0 by default
    }

    @BeforeEach
    public void setUp() throws InterruptedException {
        presentationSleep();
        isSuccess = false;
    }

    @AfterEach
    public void tearDownClass(TestInfo testInfo) throws InterruptedException {
        presentationSleep();
        if (!isSuccess) {
            System.out.println("\t\t\tTest_Name = " + testInfo.getDisplayName() + " fail");
            System.out.println("\t\t\tTest_Method = " + testInfo.getTestMethod() + " fail");
            //
            takeScreenShot();
            takePageSource();
            //
            driver.manage().deleteAllCookies();
            removeItemFromLocalStorage("accessToken");
            removeItemFromLocalStorage("refreshToken");
            driver.navigate().refresh();
        }
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

    public void removeItemFromLocalStorage(String item) {
        js.executeScript(String.format("window.localStorage.removeItem('%s');", item));
    }

    private void takeScreenShot() {
        //logger.debug("Start takeScreenShot()");
        //
        //String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(TIME_TEMPLATE);
        String currentTime = localDate.format(formatter);
        //
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("./" + currentTime + "_screenshot.png"));
        } catch (IOException e) {
            // Log.error
            throw new RuntimeException(e);
        }
    }

    private void takePageSource() {
        //logger.debug("Start takePageSource()");
        //
        String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
        String pageSource = driver.getPageSource();
        byte[] strToBytes = pageSource.getBytes();
        Path path = Paths.get("./" + currentTime + "_" + "_source.html.txt");
        try {
            Files.write(path, strToBytes, StandardOpenOption.CREATE);
        } catch (IOException e) {
            // Log.error
            throw new RuntimeException(e);
        }
    }

    public HomePage startApplication() {
        driver.get("https://www.greencity.cx.ua/#/ubs");
        presentationSleep();
        return new HomePage(driver);
    }
}
