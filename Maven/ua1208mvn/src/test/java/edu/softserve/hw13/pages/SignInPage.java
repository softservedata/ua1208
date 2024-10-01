    package edu.softserve.hw13.pages;

    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.FindBy;
    import org.openqa.selenium.support.PageFactory;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;

    import java.time.Duration;


    public class SignInPage {
        private WebDriver driver;
        private WebDriverWait wait;

        @FindBy(css = "div.main-content.app-container img.ubs-header-sing-in-img.ng-star-inserted")
        private WebElement signInButton;

        @FindBy(css = ".container h1")
        private WebElement welcomeText;

        @FindBy(css = "div.container h2")
        private WebElement signInDetailsText;

        @FindBy(css = ".sign-in-form label[for='email']")
        private WebElement emailLabel;

        @FindBy(id = "email")
        private WebElement emailInput;

        @FindBy(id = "password")
        private WebElement passwordInput;

        @FindBy(css = ".ubsStyle")
        private WebElement signInSubmitButton;

        @FindBy(css = ".mat-simple-snackbar > span")
        private WebElement result;

        @FindBy(css = ".alert-general-error")
        private WebElement errorMessage;

        @FindBy(css = "#pass-err-msg.validation-password-error")
        private WebElement errorPassword;

        @FindBy(css = "#email-err-msg.validation-email-error")
        private WebElement errorEmail;

        public SignInPage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            PageFactory.initElements(driver, this);

        }
        public boolean isElementPresent(WebElement element) {
            try {
                wait.until(ExpectedConditions.visibilityOf(element)); // Чекаємо, поки елемент стане видимим
                return true; // Елемент присутній і видимий
            } catch (Exception e) {
                System.out.println("Element is not present or visible: " + e.getMessage());
                return false; // Елемент не знайдений або не видимий
            }
        }

        public void clickSignInButton() {
            try {
                if (isElementPresent(signInButton)) {
                    System.out.println("Sign In button is present and ready for interaction.");
                    wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
                    System.out.println("Successfully clicked on Sign In button.");
                } else {
                    System.out.println("Sign In button is not available.");
                }
            } catch (Exception e) {
                System.out.println("Error while clicking Sign In button: " + e.getMessage());
            }
        }

        public void enterCredentials(String email, String password) {
            emailInput.clear();
            emailInput.sendKeys(email);

            passwordInput.clear();
            passwordInput.sendKeys(password);

        }

        public void submitSignIn() {
            wait.until(ExpectedConditions.elementToBeClickable(signInSubmitButton)).click();
        }

        public String getEmailErrorMessage() {
            wait.until(ExpectedConditions.visibilityOf(errorEmail));
            return errorEmail.getText();

        }

        public String getPasswordErrorMessage() {
            wait.until(ExpectedConditions.visibilityOf(errorPassword));
            return errorPassword.getText();
        }

        public String getGeneralErrorMessage() {
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            return errorMessage.getText();
        }

        public String getWelcomeMessage() {
            return welcomeText.getText();
        }
    }

