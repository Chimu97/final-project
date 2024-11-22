package pagesTests;

import org.junit.jupiter.api.*;
import pages.RegistrationPage;
import utils.Utils;

public class RegistrationPageTest extends BaseTest {
    private RegistrationPage registrationPage;
    private static String uniqueUsername;

    @BeforeAll
    public static void generateUniqueUsername() {
        uniqueUsername = Utils.generateUniqueUsername("user", 8);
    }

    @BeforeEach
    public void registrationLink(){
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
        registrationPage = new RegistrationPage(driver);
        // nombre de usuario unico
    }

    @Test
    public void testSuccessfulRegistration(){
        registrationPage.registerUser("Carlos", "Tevez", "Calle Falsa", "Springfield",
                "Memphis","1123","992992992","666455455",uniqueUsername,
                "1234","1234");

        // Validar mensaje cuando se crea un usuario
        String actualMessage = registrationPage.getConfirmationMessage();
        String expectedMessage = "Your account was created successfully. You are now logged in.";
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testSuccesfulLogin(){
        registrationPage.loginUser(uniqueUsername, "1234");
        System.out.println(uniqueUsername);
    }

    @Test
    public void testRegistrationWithoutFirstName(){
        registrationPage.registerUser("", "Tevez", "Calle Falsa", "Springfield",
                "Memphis","1123","992992992","666455455","carlitos1",
                "1234","1234");


        // Validar mensaje cuando falta el first name
        String actualMessage = registrationPage.getFirstNameErrorMessage();
        String expectedMessage = "First name is required.";
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testRegistrationWithoutLastName(){
        registrationPage.registerUser("Carlos", "", "Calle Falsa", "Springfield",
                "Memphis","1123","992992992","666455455","carlitos1",
                "1234","1234");


        // Validar mensaje cuando falta el last name
        String actualMessage = registrationPage.getLastNameErrorMessage();
        String expectedMessage = "Last name is required.";
        Assertions.assertEquals(expectedMessage, actualMessage);
    }
}