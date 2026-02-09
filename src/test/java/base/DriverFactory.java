package base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ConfigReader;

public class DriverFactory {

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static void initDriver() {
        ConfigReader.initProperties();

        String browser = ConfigReader.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            tlDriver.set(new ChromeDriver());
        }

        getDriver().manage().timeouts()
            .implicitlyWait(Duration.ofSeconds(
                Integer.parseInt(ConfigReader.getProperty("timeout"))));

        getDriver().manage().window().maximize();
        getDriver().get(ConfigReader.getProperty("url"));
    }

    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    public static void quitDriver() {
     //   getDriver().quit();
        tlDriver.remove();
    }
}
