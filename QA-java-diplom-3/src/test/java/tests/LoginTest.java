package tests;

import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.*;
import util.BrowserFactory;
import util.UserFactory;

import static org.junit.Assert.assertTrue;

public class LoginTest {
    private WebDriver driver;
    private String testEmail = "testuser" + System.currentTimeMillis() + "@example.com";
    private String testPassword = "password123";
    private String testName = "TestUser";
    private UserFactory userFactory = new UserFactory();

    @Before
    @Step("Настройка тестового окружения: создание пользователя и инициализация драйвера")
    public void setUp() {
        userFactory.createTestUser(testEmail, testPassword, testName);
        driver = BrowserFactory.createDriver();
        driver.get("https://stellarburgers.nomoreparties.site");
    }

    @Test
    public void testLoginViaMainPageButton() {
        openMainPageAndClickLoginButton();
        loginWithCredentials(testEmail, testPassword);
        verifySuccessfulLogin();
    }

    @Test
    public void testLoginViaPersonalAccountButton() {
        openMainPageAndClickPersonalAccountButton();
        loginWithCredentials(testEmail, testPassword);
        verifySuccessfulLogin();
    }

    @Test
    public void testLoginViaRegistrationForm() {
        openMainPageAndClickLoginButton();
        navigateToRegistrationFromLogin();
        navigateBackToLoginFromRegistration();
        loginWithCredentials(testEmail, testPassword);
        verifySuccessfulLogin();
    }

    @Test
    public void testLoginViaPasswordRecoveryForm() {
        openMainPageAndClickLoginButton();
        navigateToPasswordRecoveryFromLogin();
        navigateBackToLoginFromPasswordRecovery();
        loginWithCredentials(testEmail, testPassword);
        verifySuccessfulLogin();
    }

    @After
    @Step("Очистка тестового окружения: закрытие драйвера и удаление тестового пользователя")
    public void tearDown() {
        driver.quit();
        userFactory.deleteTestUser(testEmail, testPassword);
    }

    @Step("Открытие главной страницы и нажатие кнопки 'Войти'")
    private void openMainPageAndClickLoginButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();
    }

    @Step("Открытие главной страницы и нажатие кнопки 'Личный кабинет'")
    private void openMainPageAndClickPersonalAccountButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();
    }

    @Step("Вход с учетными данными: email = {email}, password = {password}")
    private void loginWithCredentials(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);
    }

    @Step("Проверка успешного входа в аккаунт")
    private void verifySuccessfulLogin() {
        ProfilePage profilePage = new ProfilePage(driver);
        assertTrue("Не удалось войти в аккаунт", profilePage.isProfileLinkDisplayed());
    }

    @Step("Переход на страницу регистрации из формы входа")
    private void navigateToRegistrationFromLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterLink();
    }

    @Step("Возврат на страницу входа из формы регистрации")
    private void navigateBackToLoginFromRegistration() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickLoginLink();
    }

    @Step("Переход на страницу восстановления пароля из формы входа")
    private void navigateToPasswordRecoveryFromLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRecoverPasswordLink();
    }

    @Step("Возврат на страницу входа из формы восстановления пароля")
    private void navigateBackToLoginFromPasswordRecovery() {
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(driver);
        passwordRecoveryPage.clickLoginLink();
    }
}