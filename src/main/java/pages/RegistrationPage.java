package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RegistrationPage {
        private WebDriver driver;
//        private String uniqueUserName;

        public RegistrationPage(WebDriver driver){
            this.driver = driver;
        }

//    public String getUniqueUserName() {
//        return uniqueUserName;
//    }

        // locators
        private By firstNameField = By.id("customer.firstName");
        private By lastNameField = By.id("customer.lastName");
        private By addressField = By.id("customer.address.street");
        private By cityField = By.id("customer.address.city");
        private By stateField = By.id("customer.address.state");
        private By zipCodeField = By.id("customer.address.zipCode");
        private By phoneNumberField = By.id("customer.phoneNumber");
        private By ssnField = By.id("customer.ssn");
        private By userNameField = By.id("customer.username");
        private By userPasswordField = By.id("customer.password");
        private By userConfirmPasswordField = By.id("repeatedPassword");

        private By registerButton = By.cssSelector("input.button[value='Register']");

        private By confirmationMessage = By.cssSelector("#rightPanel p");


        // locators para los campos vacios
        private By firstNameFieldError = By.id("customer.firstName.errors");
        private By lastNameFieldError = By.id("customer.lastName.errors");
        private By addressFieldError = By.id("customer.address.street.errors");
        private By cityFieldError = By.id("customer.address.city.errors");
        private By stateFieldError = By.id("customer.address.state.errors");
        private By zipCodeFieldError = By.id("customer.address.zipCode.errors");
        private By ssnFieldError = By.id("customer.ssn.errors");
        private By userNameFieldError = By.id("customer.username.errors");
        private By userPasswordFieldError = By.id("customer.password.errors");
        private By userConfirmPasswordFieldError = By.id("repeatedPassword.errors");


        // Metodos para interactuar con el formulario
        public void setFirstName(String firstName) {
            driver.findElement(firstNameField).sendKeys(firstName);
        }

        public void setLastName(String lastName) {
            driver.findElement(lastNameField).sendKeys(lastName);
        }

        public void setAddress(String address) {
            driver.findElement(addressField).sendKeys(address);
        }

        public void setCity(String city) {
            driver.findElement(cityField).sendKeys(city);
        }

        public void setState(String state) {
            driver.findElement(stateField).sendKeys(state);
        }

        public void setZipCode(String zipCode) {
            driver.findElement(zipCodeField).sendKeys(zipCode);
        }

        public void setPhoneNumber(String phoneNumber) {
            driver.findElement(phoneNumberField).sendKeys(phoneNumber);
        }

        public void setSSN(String ssn) {
            driver.findElement(ssnField).sendKeys(ssn);
        }

        public void setUsername(String username) {
            driver.findElement(userNameField).sendKeys(username);
        }

        public void setPassword(String password) {
            driver.findElement(userPasswordField).sendKeys(password);
        }

        public void setConfirmPassword(String confirmPassword) {
            driver.findElement(userConfirmPasswordField).sendKeys(confirmPassword);
        }

        public void clickRegisterButton() {
            driver.findElement(registerButton).click();
        }


        //Metodo para traer el texto de usuario creado exitoso
        public String getConfirmationMessage(){
            return driver.findElement(confirmationMessage).getText();
        }


        // Metodos para traer el texto con error
        public String getFirstNameErrorMessage() {
            return getErrorMessage(firstNameFieldError);
        }

        public String getLastNameErrorMessage() {
            return getErrorMessage(lastNameFieldError);
        }

        public String getAddressErrorMessage() {
            return getErrorMessage(addressFieldError);
        }

        public String getCityErrorMessage() {
            return getErrorMessage(cityFieldError);
        }

        public String getStateErrorMessage() {
            return getErrorMessage(stateFieldError);
        }

        public String getZipCodeErrorMessage() {
            return getErrorMessage(zipCodeFieldError);
        }

        public String getSSNErrorMessage() {
            return getErrorMessage(ssnFieldError);
        }

        public String getUsernameErrorMessage() {
            return getErrorMessage(userNameFieldError);
        }

        public String getPasswordErrorMessage() {
            return getErrorMessage(userPasswordFieldError);
        }

        public String getConfirmPasswordErrorMessage() {
            return getErrorMessage(userConfirmPasswordFieldError);
        }


        // Metodo para traer el texto de error
        public String getErrorMessage(By locator) {
            return driver.findElement(locator).getText();
        }


    // Metodo para registrar un usuario. El metodo (registerUser) actua singularmente para llenar todos los campos
    // del registro en una sola accion.
    public void registerUser(String firstName, String lastName, String address, String city, String state,
                             String zipCode, String phoneNumber, String ssn, String userName, String password, String confirmPassword) {
        // Generar nombre único y almacenarlo en la variable uniqueUserName
//        uniqueUserName = "user" + System.currentTimeMillis();

        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setCity(city);
        setState(state);
        setZipCode(zipCode);
        setPhoneNumber(phoneNumber);
        setSSN(ssn);
        setUsername(userName);
        setPassword(password);
        setConfirmPassword(confirmPassword);
        clickRegisterButton();
    }
}
