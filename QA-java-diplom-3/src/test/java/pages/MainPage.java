package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    private final By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By personalAccountButton = By.xpath("//p[text()='Личный Кабинет']");
    private final By bunSection = By.xpath("//h2[contains(text(),'Булки')]");
    private final By sauceSection = By.xpath("//h2[contains(text(),'Соусы')]");
    private final By fillingSection = By.xpath("//h2[contains(text(),'Начинки')]");
    private final By logo = By.className("AppHeader_header__logo__2D0X2");
    private final By constructorLink = By.xpath("//p[text()='Конструктор']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    public void clickBunSection() {
        driver.findElement(bunSection).click();
    }

    public void clickSauceSection() {
        driver.findElement(sauceSection).click();
    }

    public void clickFillingSection() {
        driver.findElement(fillingSection).click();
    }

    public void clickLogo() {
        driver.findElement(logo).click();
    }

    public void clickConstructorLink() {
        driver.findElement(constructorLink).click();
    }

    public boolean isBunSectionActive() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(bunSection));
        return driver.findElement(bunSection).isDisplayed();
    }

    public boolean isSauceSectionActive() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(sauceSection));
        return driver.findElement(sauceSection).isDisplayed();
    }

    public boolean isFillingSectionActive() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(fillingSection));
        return driver.findElement(fillingSection).isDisplayed();
    }
}
