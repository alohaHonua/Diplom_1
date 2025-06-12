package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {
    private static final String DEFAULT_BROWSER = "chrome";
    public static WebDriver createDriver() {
        String browser = System.getProperty("browser", DEFAULT_BROWSER);
        return createDriver(browser);
    }
    public static WebDriver createDriver(String browserName) {
        WebDriver driver;

        switch (browserName.toLowerCase()) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-features=PasswordLeakDetection");
                driver = new ChromeDriver(options);
                break;
            case "yandex":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }
}
