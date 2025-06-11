package tests;

import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.RegistrationPage;
import util.BrowserFactory;

import static org.junit.Assert.assertTrue;

public class RegistrationTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = BrowserFactory.createDriver();
        openMainPage();
    }

    @Step("Открыть главную страницу")
    public void openMainPage() {
        driver.get("https://stellarburgers.nomoreparties.site");
    }

    @Test
    public void testSuccessfulRegistration() {
        goToRegistrationPageThroughLogin();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        fillRegistrationForm(registrationPage, "TestUser", "testuser@example.com", "password123");
        submitRegistrationForm(registrationPage);

        verifyLoginFormDisplayedAfterRegistration();
    }

    @Test
    public void testRegistrationWithShortPassword() {
        goToRegistrationPageThroughLogin();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        fillRegistrationFormWithShortPassword(registrationPage, "TestUser", "testuser@example.com", "12345");

        verifyPasswordErrorDisplayed(registrationPage);
    }

    @Step("Перейти на страницу регистрации через страницу входа")
    private void goToRegistrationPageThroughLogin() {
        MainPage mainPage = new MainPage(driver);
        clickLoginButton(mainPage);

        LoginPage loginPage = new LoginPage(driver);
        clickRegisterLink(loginPage);
    }

    @Step("Нажать кнопку 'Войти' на главной странице")
    private void clickLoginButton(MainPage mainPage) {
        mainPage.clickLoginButton();
    }

    @Step("Нажать ссылку 'Зарегистрироваться' на странице входа")
    private void clickRegisterLink(LoginPage loginPage) {
        loginPage.clickRegisterLink();
    }

    @Step("Заполнить форму регистрации: имя = {name}, email = {email}, пароль = {password}")
    private void fillRegistrationForm(RegistrationPage registrationPage, String name, String email, String password) {
        registrationPage.register(name, email, password);
    }

    @Step("Заполнить форму регистрации с коротким паролем")
    private void fillRegistrationFormWithShortPassword(RegistrationPage registrationPage, String name, String email, String password) {
        registrationPage.setName(name);
        registrationPage.setEmail(email);
        registrationPage.setPassword(password);
    }

    @Step("Отправить форму регистрации")
    private void submitRegistrationForm(RegistrationPage registrationPage) {
        registrationPage.clickRegisterButton();
    }

    @Step("Проверить, что после регистрации отображается форма входа")
    private void verifyLoginFormDisplayedAfterRegistration() {
        LoginPage loginPage = new LoginPage(driver);
        assertTrue("После регистрации должна отображаться форма входа",
                loginPage.isLoginFormDisplayed());
    }

    @Step("Проверить отображение ошибки о некорректном пароле")
    private void verifyPasswordErrorDisplayed(RegistrationPage registrationPage) {
        registrationPage.clickRegisterButton();
        assertTrue("Не отображается ошибка о некорректном пароле",
                registrationPage.isPasswordErrorDisplayed());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
