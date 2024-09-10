package com.softserve.edu05page.tests;

import com.softserve.edu05page.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class GreencityTestRunner {

    private static final Long ONE_SECOND_DELAY = 1000L;
    private static final Long IMPLICIT_WAIT = 5L;
    private static WebDriver driver;
    private static JavascriptExecutor js;
    protected static boolean isSuccess;

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
            System.out.println("\t\t\tTest_Name = " + testInfo.getTestMethod() + " fail");
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

    public HomePage startApplication() {
        driver.get("https://www.greencity.cx.ua/#/ubs");
        presentationSleep();
        return new HomePage(driver);
    }
}
