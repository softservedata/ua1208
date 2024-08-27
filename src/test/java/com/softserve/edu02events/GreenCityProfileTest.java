package com.softserve.edu02events;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class GreenCityProfileTest {

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @BeforeEach
    public void setUp() throws InterruptedException {
        driver.get("https://www.greencity.cx.ua/#/ubs");
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

    private void login(String email, String password) throws InterruptedException {
        //
        String language = driver.findElement(By.cssSelector("div.main-content.app-container li.lang-option > span")).getText();
        Thread.sleep(2000);
        if (language.toLowerCase().equals("ua")) {
            driver.findElement(By.cssSelector("div.main-content.app-container img[src='assets/img/filled_arrow_down.svg']")).click();
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("div.main-content.app-container li[aria-label='EN'] > span")).click();
            Thread.sleep(1000);
        }
        //
        //driver.findElement(By.cssSelector("app-header:nth-child(1) .ubs-header-sing-in-img")).click();
        driver.findElement(By.cssSelector("div.main-content.app-container img.ubs-header-sing-in-img.ng-star-inserted")).click();
        Thread.sleep(1000);
        //
        List<WebElement> frames = driver.findElements(By.cssSelector("iframe"));
        if (frames.size() > 0) {
            driver.switchTo().frame(frames.get(0));
            driver.findElement(By.id("close")).click();
            driver.switchTo().defaultContent();
            Thread.sleep(1000);
        }
        //
        driver.findElement(By.id("email")).click();
        //driver.findElement(By.id("email")).sendKeys("tyv09754@zslsz.com");
        driver.findElement(By.id("email")).sendKeys(email);
        Thread.sleep(1000);
        //
        driver.findElement(By.id("password")).click();
        //driver.findElement(By.id("password")).sendKeys("Qwerty_1");
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(1000);
        //
        driver.findElement(By.cssSelector(".image-show-hide-password")).click();
        Thread.sleep(1000);
        //
        driver.findElement(By.cssSelector(".ubsStyle")).click();
        Thread.sleep(1000);
    }

    private void logout() throws InterruptedException {
        //
        driver.findElement(By.cssSelector("app-header:nth-child(1) .body-2")).click();
        Thread.sleep(1000);
        //
        driver.findElement(By.linkText("Sign out")).click();
        Thread.sleep(1000);
        //
    }

    @Test
    public void checkProfile() throws InterruptedException {
        login("tyv09754@zslsz.com","Qwerty_1");
        //
        //driver.findElement(By.cssSelector("app-header:nth-child(1) .nav-left-list:nth-child(4) > .url-name")).click();
        driver.findElement(By.cssSelector("div.main-content.app-container a.url-name.ng-star-inserted[href='#/greenCity']")).click();
        Thread.sleep(1000);
        //
        driver.findElement(By.cssSelector(".nav-left-list:nth-child(5) > .url-name")).click();
        Thread.sleep(1000);
        //
        driver.findElement(By.cssSelector("#mat-tab-label-0-2 .mdc-tab__text-label")).click();
        Thread.sleep(1000);
        //
        WebElement label = driver.findElement(By.cssSelector("#mat-mdc-checkbox-1 .mdc-label"));
        Thread.sleep(1000);
        //
        Assertions.assertEquals("homepage.events.my-space.event-type-online", label.getText().trim());
        Thread.sleep(1000);
        //
        driver.findElement(By.cssSelector("a.url-name.ng-star-inserted[href='#/']")).click();
        Thread.sleep(1000);
        //
        logout();
    }

}
