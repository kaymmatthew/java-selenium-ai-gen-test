package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import utilities.ConfigReader;


public class BaseClass {
    protected static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = ConfigReader.get("browser").toLowerCase();

            switch (browser) {
                case "chrome" -> driver = new ChromeDriver();
                case "firefox" -> driver = new FirefoxDriver();
                case "edge" -> driver = new EdgeDriver();
                default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}