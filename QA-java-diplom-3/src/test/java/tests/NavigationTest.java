package tests;

import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.ConstructorPage;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;
import util.BrowserFactory;
import util.UserFactory;

import static org.junit.Assert.assertTrue;

public class NavigationTest {
    private WebDriver driver;
    private String testEmail = "testuser" + System.currentTimeMillis() + "@example.com";
    private String testPassword = "password123";
    private String testName = "TestUser";
    private UserFactory userFactory = new UserFactory();

    @Before
    @Step("Подготовка тестового окружения: создание пользователя и инициализация драйвера")
    public void setUp() {
        userFactory.createTestUser(testEmail, testPassword, testName);
        driver = BrowserFactory.createDriver();
        driver.get("https://stellarburgers.nomoreparties.site");
    }

    @Test
    public void testNavigateToPersonalAccount() {
        goToPersonalAccountWithoutLogin();
        loginWithTestCredentials();
        verifyLoginFormDisplayed();
    }

    @Test
    public void testNavigateFromProfileToConstructorViaLink() {
        goToLoginPage();
        navigateToConstructorViaLink();
        verifyConstructorPageLoaded();
    }

    @Test
    public void testNavigateFromProfileToConstructorViaLogo() {
        loginToAccount();
        navigateToConstructorViaLogo();
        verifyConstructorPageLoaded();
    }

    @Test
    public void testLogout() {
        loginToAccount();
        performLogout();
        verifyLoginFormDisplayed();
    }

    @After
    @Step("Очистка тестового окружения: закрытие драйвера и удаление тестового пользователя")
    public void tearDown() {
        driver.quit();
        userFactory.deleteTestUser(testEmail, testPassword);
    }

    @Step("Переход в личный кабинет без авторизации")
    private void goToPersonalAccountWithoutLogin() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();
    }

    @Step("Авторизация с тестовыми учетными данными")
    private void loginWithTestCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(testEmail, testPassword);
    }

    @Step("Проверка отображения формы входа")
    private void verifyLoginFormDisplayed() {
        LoginPage loginPage = new LoginPage(driver);
        assertTrue("Не отображается форма входа", loginPage.isLoginFormDisplayed());
    }

    @Step("Переход на страницу входа")
    private void goToLoginPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();
    }

    @Step("Навигация в конструктор через ссылку")
    private void navigateToConstructorViaLink() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickConstructorLink();
    }

    @Step("Проверка загрузки страницы конструктора")
    private void verifyConstructorPageLoaded() {
        ConstructorPage constructorPage = new ConstructorPage(driver);
        assertTrue("Не удалось перейти в конструктор", constructorPage.isLoaded());
    }

    @Step("Авторизация в аккаунт")
    private void loginToAccount() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(testEmail, testPassword);
    }

    @Step("Навигация в конструктор через логотип")
    private void navigateToConstructorViaLogo() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLogo();
    }

    @Step("Выход из аккаунта")
    private void performLogout() {
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickLogoutButton();
    }
}