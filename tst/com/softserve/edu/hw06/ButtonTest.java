package com.softserve.edu.hw06;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class ButtonTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setUpClass() {
        //
        System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "./lib/geckodriver.exe");
        driver = new FirefoxDriver();
        //
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Before
    public void setUp() {
        driver.get("https://www.greencity.cx.ua/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        Thread.sleep(4000); // for presentation
    }

    @Test
    public void ButtonTest03() throws InterruptedException {
        driver.findElement(By.cssSelector("app-header:nth-child(1) .lang-option")).click();
        driver.findElement(By.cssSelector(".ubs-lang-switcher-span")).click();
        driver.findElement(By.cssSelector("app-header:nth-child(1) .nav-left-list:nth-child(4) > .url-name")).click();
        driver.findElement(By.cssSelector(".ubs-header-sing-in-img")).click();
        List<WebElement> frames = driver.findElements(By.cssSelector("iframe"));
        if (frames.size() > 0) {
            driver.switchTo().frame(frames.get(0));
            driver.findElement(By.id("close")).click();
            driver.switchTo().defaultContent();
        }
        //
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("svetlana.babyuk1@gmail.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("Vjqvbh2011//");
        driver.findElement(By.cssSelector(".greenStyle")).click();
        Thread.sleep(1000); // for presentation
        // Click Econews
        driver.findElement(By.cssSelector(".nav-left-list:nth-child(1) > .url-name")).click();
        Thread.sleep(1000); // for presentation
        // "Test Test" Click
        driver.findElement(By.cssSelector(".nav-left-list:nth-child(1) > .url-name")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".gallery-view-li-active:nth-child(1) h3")).click();
        Thread.sleep(2000);
        WebElement commentButton = driver.findElement(By.cssSelector("button.primary-global-button"));
        WebElement inputField =driver.findElement(By.cssSelector(".comment-textarea"));
        Thread.sleep(2000); // for presentation
        //

        boolean isDisabled = commentButton.getAttribute("disabled") != null;
        System.out.println("Button disabled: " + isDisabled);

        //елемент, що впливає на активацію кнопки
        inputField.clear();
        inputField.sendKeys("some value");


        boolean isEnabled = commentButton.getAttribute("disabled") == null;
        System.out.println("Button enabled: " + isEnabled);
        //

        if (isEnabled){
            commentButton.click();}
        else {
            System.out.println("Button is still disabled.");

        }
        driver.quit();

    }
}