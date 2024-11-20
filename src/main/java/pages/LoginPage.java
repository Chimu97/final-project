package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // Locators para el login
    private By usernameField = By.cssSelector("#loginPanel input[name='username']");
    private By passwordField = By.cssSelector("#loginPanel input[name='password']");
    private By loginButton = By.cssSelector("#loginPanel input.button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void loginUser(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}
