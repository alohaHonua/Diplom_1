package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import util.BrowserFactory;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

@Epic("Stellar Burgers - Конструктор")
@Feature("Навигация по разделам конструктора")
public class ConstructorTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    @Step("Открытие главной страницы и инициализация теста")
    public void setUp() {
        driver = BrowserFactory.createDriver();
        mainPage = new MainPage(driver);
        driver.get("https://stellarburgers.nomoreparties.site");
    }

    @Test
    @DisplayName("Проверка перехода в раздел 'Булки'")
    public void shouldSwitchToBunSectionSuccessfully() {
        mainPage.clickFillingSection();
        switchToSectionAndVerify(
                () -> mainPage.clickBunSection(),
                "Булки"
        );
    }

    @Test
    @DisplayName("Проверка перехода в раздел 'Соусы'")
    public void shouldSwitchToSauceSectionSuccessfully() {
        mainPage.clickFillingSection();
        switchToSectionAndVerify(
                () -> mainPage.clickSauceSection(),
                "Соусы"
        );
    }

    @Test
    @DisplayName("Проверка перехода в раздел 'Начинки'")
    public void shouldSwitchToFillingSectionSuccessfully() {
        switchToSectionAndVerify(
                () -> mainPage.clickFillingSection(),
                "Начинки"
        );
    }

    @Step("Переключение на раздел '{expectedText}' и проверка активности")
    private void switchToSectionAndVerify(Runnable switchAction, String expectedText) {
        switchAction.run();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(mainPage.getActiveTabLocator(), expectedText));
        String actualText = mainPage.getActiveTabText();
        assertEquals(String.format("Текст активной вкладки должен быть '%s'", expectedText),
                expectedText, actualText);
    }

    @After
    @Step("Завершение теста и закрытие браузера")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}