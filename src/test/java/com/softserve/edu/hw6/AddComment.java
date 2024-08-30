package com.softserve.edu.hw6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;


public class AddComment {

    private static WebDriver driver;

    @BeforeAll
    public static void setUpClass() {
        //
        // https://googlechromelabs.github.io/chrome-for-testing/
        //System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
        //
        // use 64 bit version
        // https://github.com/mozilla/geckodriver/releases
        //System.setProperty("webdriver.gecko.driver", "./lib/geckodriver.exe");
        //
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
        //
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //driver.manage().window().setSize(new Dimension(1295, 687));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @BeforeEach
    public void setUp() throws InterruptedException {
        driver.get("https://www.greencity.cx.ua/");
        Thread.sleep(1000);
        //
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Test
    public void testLogin() throws InterruptedException {
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
//        driver.findElement(By.cssSelector("app-header:nth-child(1) .ubs-header-sing-in-img")).click();//could not find
        // Click on the sign-in icon
        //driver.findElement(By.cssSelector("img.ubs-header-sing-in-img")).click();//
        // Click on the 'Sign in' link using class names
//        driver.findElement(By.cssSelector("a.header_sign-in-link.tertiary-global-button")).click();
        // Click header arrow
        driver.findElement(By.cssSelector("app-header:nth-child(1) .header_arrow:nth-child(2)")).click();
        Thread.sleep(1000);

        // Click sign in
        driver.findElement(By.cssSelector("app-header:nth-child(1) .ubs-header-sign-in")).click();
        Thread.sleep(1000);

        // Enter login credentials
        driver.findElement(By.id("email")).sendKeys("xenefa2366@apifan.com");
        Thread.sleep(1000);

        driver.findElement(By.id("password")).sendKeys("Qwerty1234567!");
        Thread.sleep(1000);

        // Click sign in button
        driver.findElement(By.cssSelector(".ubsStyle")).click();
        Thread.sleep(2000);

        // Validate elements in navigation
        List<WebElement> elements = driver.findElements(By.cssSelector("li.nav-left-list.ng-star-inserted a.url-name.ng-star-inserted"));
        Assertions.assertTrue(elements.size() > 0);
        Thread.sleep(1000);

        // Navigate to 'Green City'
        driver.findElement(By.cssSelector("li.nav-left-list.ng-star-inserted a.url-name.ng-star-inserted[href=\"#/greenCity\"]")).click();
//        driver.findElement(By.cssSelector("div.main-content.app-container a.url-name.ng-star-inserted[href='#/greenCity']")).click();
        Thread.sleep(1000);

        // Click Eco-news tab in navigation
//        driver.findElement(By.cssSelector(".nav-left-list:nth-child(1) > .url-name")).click();
        driver.findElement(By.cssSelector("li.nav-left-list ng-star-inserted")).click();

        Thread.sleep(1000);

        // Select gallery item
//        driver.findElement(By.cssSelector(".gallery-view-li-active:nth-child(9) h3")).click();
//        driver.findElement(By.cssSelector("li.gallery-view-li-active h3")).click();
//        Thread.sleep(1000);

        // Validate title and comment section
//        Assertions.assertEquals("Winter is coming", driver.findElement(By.cssSelector("div.news-title-container div.news-title")).getText());
//         Click on the image with the alt text 'user added image'
//        List<WebElement> articleTitles = driver.findElements(By.cssSelector("li.gallery-view-li-active .title-list h3"));
//        for (WebElement title : articleTitles) {
//            if (title.getText().equals("Winter is coming")) {
//                title.click(); // Click on the article
////        driver.findElement(By.cssSelector("li.gallery-view-li-active h3")).click();
//
//
//                Assertions.assertEquals("Add a comment", driver.findElement(By.cssSelector("div.comment-textarea span.placeholder")).getText());
//
//                // Add comment (in this case, just clicking the text area)
//                driver.findElement(By.cssSelector(".comment-textarea")).click();
//                Thread.sleep(1000);
//
//                // Submit comment
//                driver.findElement(By.cssSelector("button.primary-global-button")).click();
//                Thread.sleep(1000);
//
//
//                // Validate 'Back to News' button
//                Assertions.assertEquals("Back to News", driver.findElement(By.cssSelector("div.button-text")).getText());
//                Thread.sleep(1000);
//
//                // Click 'Back to News'
//                driver.findElement(By.cssSelector("div.button-arrow img.button-arrow-img")).click();
//                Thread.sleep(1000);
//
//                // Validate user name and sign out
//                Assertions.assertEquals("Qwerty1", driver.findElement(By.cssSelector("li.body-2.user-name")).getText());
//                driver.findElement(By.cssSelector("li.body-2.user-name")).click();
//                Thread.sleep(1000);
//
//                // Open dropdown and validate 'Sign out' option
//                List<WebElement> dropdownElements = driver.findElements(By.cssSelector("ul.dropdown-list.drop-down-item"));
//                Assertions.assertTrue(dropdownElements.size() > 0);
//                Assertions.assertEquals("Sign out", driver.findElement(By.cssSelector("li[role=\"button\"][aria-label=\"sign-out\"] a")).getText());
//
//                // Click 'Sign out'
//                driver.findElement(By.linkText("Sign out")).click();
//                Thread.sleep(1000);
            }
        }


//
//        Thread.sleep(1000);
//        //
//        List<WebElement> frames = driver.findElements(By.cssSelector("iframe"));
//        if (frames.size() > 0) {
//            driver.switchTo().frame(frames.get(0));
//            driver.findElement(By.id("close")).click();
//            driver.switchTo().defaultContent();
//            Thread.sleep(1000);
//        }
//        //
//        driver.findElement(By.id("email")).click();
//        driver.findElement(By.id("email")).sendKeys("tyv09754@zslsz.com");
//        Thread.sleep(1000);
//        //
//        driver.findElement(By.id("password")).click();
//        driver.findElement(By.id("password")).sendKeys("Qwerty_1");
//        Thread.sleep(1000);
//        //
//        driver.findElement(By.cssSelector(".image-show-hide-password")).click();
//        Thread.sleep(1000);
//        //
//        driver.findElement(By.cssSelector(".ubsStyle")).click();
//        Thread.sleep(1000);
//        //
//        Assertions.assertEquals("QwertyY", driver.findElement(By.cssSelector("app-header:nth-child(1) .body-2")).getText());
//        Thread.sleep(1000);
//        //
//        driver.findElement(By.cssSelector("app-header:nth-child(1) .body-2")).click();
//        Thread.sleep(1000);
//        //
//        driver.findElement(By.linkText("Sign out")).click();
//        Thread.sleep(1000);
//        //
//        List<WebElement> elements = driver.findElements(By.cssSelector("app-header:nth-child(1) .header_sign-up-link:nth-child(4) span:nth-child(1)"));
//        assert (elements.size() > 0);
//        Thread.sleep(1000);
//        //
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("alert('Hello, Click me')");
//        Thread.sleep(4000);
//        driver.switchTo().alert().accept();
//        Thread.sleep(1000);
//    }
//
//}
