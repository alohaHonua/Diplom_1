package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import util.BrowserFactory;

import java.util.function.BooleanSupplier;

import static org.junit.Assert.assertTrue;

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
        switchToSectionAndVerify(
                () -> mainPage.clickBunSection(),
                mainPage::isBunSectionActive,
                "Булки"
        );
    }

    @Test
    @DisplayName("Проверка перехода в раздел 'Соусы'")
    public void shouldSwitchToSauceSectionSuccessfully() {
        switchToSectionAndVerify(
                () -> mainPage.clickSauceSection(),
                mainPage::isSauceSectionActive,
                "Соусы"
        );
    }

    @Test
    @DisplayName("Проверка перехода в раздел 'Начинки'")
    public void shouldSwitchToFillingSectionSuccessfully() {
        switchToSectionAndVerify(
                () -> mainPage.clickFillingSection(),
                mainPage::isFillingSectionActive,
                "Начинки"
        );
    }

    @Step("Переключение на раздел '{sectionName}' и проверка активности")
    private void switchToSectionAndVerify(Runnable switchAction,
                                          BooleanSupplier isActiveChecker,
                                          String sectionName) {
        switchAction.run();
        assertTrue(String.format("Раздел '%s' должен быть активным", sectionName),
                isActiveChecker.getAsBoolean());
    }

    @After
    @Step("Завершение теста и закрытие браузера")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}