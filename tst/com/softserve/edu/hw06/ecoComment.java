package com.softserve.edu.hw06;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class ecoComment {

    private static WebDriver driver;

    @BeforeClass
    public static void setUpClass() {
        //
        // https://googlechromelabs.github.io/chrome-for-testing/
        System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
        //driver = new ChromeDriver();
        //
        // use 64 bit version
        // https://github.com/mozilla/geckodriver/releases
        System.setProperty("webdriver.gecko.driver", "./lib/geckodriver.exe");
        driver = new FirefoxDriver();
        //
        //driver.manage().window().setSize(new Dimension(1295, 687));
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
    public void testLogin() throws Exception {
        // Open Dropdown
        driver.findElement(By.cssSelector("app-header:nth-child(1) .lang-option")).click();
        Thread.sleep(1000); // for presentation
        // Click EN
        driver.findElement(By.cssSelector(".ubs-lang-switcher-span")).click();
        Thread.sleep(1000); // for presentation
        // Greensity Click
        driver.findElement(By.cssSelector("app-header:nth-child(1) .nav-left-list:nth-child(4) > .url-name")).click();
        Thread.sleep(1000); // for presentation
        // sign in
        driver.findElement(By.cssSelector(".ubs-header-sing-in-img")).click();
        // check iframe
        List<WebElement> frames = driver.findElements(By.cssSelector("iframe"));
        if (frames.size() > 0) {
            driver.switchTo().frame(frames.get(0));
            Thread.sleep(1000); // for presentation
            driver.findElement(By.id("close")).click();
            driver.switchTo().defaultContent();
            Thread.sleep(1000); // for presentation
        }
        //
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("svetlana.babyuk1@gmail.com");
        Thread.sleep(1000); // for presentation
        //
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("Vjqvbh2011//");
        Thread.sleep(1000); // for presentation
        // Click Button
        driver.findElement(By.cssSelector(".greenStyle")).click();
        Thread.sleep(1000); // for presentation
        // Click Econews
        driver.findElement(By.cssSelector(".nav-left-list:nth-child(1) > .url-name")).click();
        Thread.sleep(1000); // for presentation
        // "Test Test" Click
        driver.findElement(By.cssSelector(".gallery-view-li-active:nth-child(1) h3")).click();
        Thread.sleep(1000); // for presentation
        // Search Comment Field
        WebElement element = driver.findElement(By.cssSelector(".comment-textarea"));
        Thread.sleep(1000); // for presentation
        // Scrolling
        WebElement scroll = driver.findElement(By.cssSelector("div.wrapper > p"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", scroll);
        Thread.sleep(1000); // for presentation
        // Type Message
        element.clear();
        element.sendKeys("QWERTY");
        Thread.sleep(1000); // for presentation
        // Send message
        driver.findElement(By.cssSelector("button.primary-global-button")).click();
        Thread.sleep(1000); // for presentation
        // Open Dropdown
        driver.findElement(By.cssSelector(".body-2.user-name")).click();
        Thread.sleep(1000);
        // Sign out
        driver.findElement(By.cssSelector("li[aria-label='sign-out'] > a")).click();
        Thread.sleep(1000);
    }


}