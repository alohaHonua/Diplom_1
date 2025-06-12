package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    private final By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By personalAccountButton = By.xpath("//p[text()='Личный Кабинет']");

    private final By bunSectionButton = By.xpath("//span[contains(text(),'Булки')]");
    private final By sauceSectionButton = By.xpath("//span[contains(text(),'Соусы')]");
    private final By fillingSectionButton = By.xpath("//span[contains(text(),'Начинки')]");
    private final By logo = By.className("AppHeader_header__logo__2D0X2");
    private final By constructorLink = By.xpath("//p[text()='Конструктор']");

    private final By activeTab = By.xpath("//div[contains(@class, 'tab_tab_type_current')]/span");

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
        driver.findElement(bunSectionButton).click();
    }

    public void clickSauceSection() {
        driver.findElement(sauceSectionButton).click();
    }

    public String getActiveTabText() {
        return driver.findElement(activeTab).getText();
    }

    public By getActiveTabLocator() {
        return activeTab;
    }

    public void clickFillingSection() {
        driver.findElement(fillingSectionButton).click();
    }

    public void clickLogo() {
        driver.findElement(logo).click();
    }

    public void clickConstructorLink() {
        driver.findElement(constructorLink).click();
    }

}
