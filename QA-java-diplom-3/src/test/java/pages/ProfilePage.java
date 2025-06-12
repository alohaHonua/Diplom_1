package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    private final WebDriver driver;

    private final By logoutButton = By.xpath("//button[text()='Выход']");
    private final By profileLink = By.xpath("//a[text()='Профиль']");
    private final By personalAccountButton = By.xpath("//p[text()='Личный Кабинет']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogoutButton() {
        clickPersonalAccountButton();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(profileLink));
        driver.findElement(logoutButton).click();
    }
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }
    public boolean isProfileLinkDisplayed() {
        clickPersonalAccountButton();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(profileLink));
        return driver.findElement(profileLink).isDisplayed();
    }
}
