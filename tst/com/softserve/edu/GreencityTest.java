package com.softserve.edu;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class GreencityTest {

    private WebDriver driver;

    @BeforeClass
    public static void setUpClass() {
        //
        // https://googlechromelabs.github.io/chrome-for-testing/
        System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
        //
        // use 64 bit version
        // https://github.com/mozilla/geckodriver/releases
        System.setProperty("webdriver.gecko.driver", "./lib/geckodriver.exe");

    }

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1295, 687));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testLogin() throws InterruptedException {
        driver.get("https://www.greencity.cx.ua/");
        Thread.sleep(1000);
        //
        driver.findElement(By.cssSelector("app-header:nth-child(1) .ubs-header-sing-in-img")).click();
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
        driver.findElement(By.id("email")).sendKeys("tyv09754@zslsz.com");
        Thread.sleep(1000);
        //
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("Qwerty_1");
        Thread.sleep(1000);
        //
        driver.findElement(By.cssSelector(".image-show-hide-password")).click();
        Thread.sleep(1000);
        //
        driver.findElement(By.cssSelector(".ubsStyle")).click();
        Thread.sleep(1000);
        //
        Assert.assertEquals("QwertyY", driver.findElement(By.cssSelector("app-header:nth-child(1) .body-2")).getText());
        Thread.sleep(1000);
        //
        driver.findElement(By.cssSelector("app-header:nth-child(1) .body-2")).click();
        Thread.sleep(1000);
        //
        driver.findElement(By.linkText("Sign out")).click();
        Thread.sleep(1000);
        //
        List<WebElement> elements = driver.findElements(By.cssSelector("app-header:nth-child(1) .header_sign-up-link:nth-child(4) span:nth-child(1)"));
        assert (elements.size() > 0);
        Thread.sleep(1000);
        //
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('Hello, Click me')");
        Thread.sleep(4000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        //
    }

}
