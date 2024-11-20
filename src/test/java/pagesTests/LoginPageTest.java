package pagesTests;

import org.junit.jupiter.api.*;
import pages.LoginPage;


public class LoginPageTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeEach
    public void setupPage() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testSuccessfulLogin() {
        loginPage.loginUser("carlitos12", "1234");


    }
}
