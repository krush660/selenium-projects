package pack1.mavan_gsit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class class1 {
    WebDriver driver;

    @Parameters("browsers")
    @BeforeTest
    public void launch(@Optional("chrome") String nameofthebrowser) throws InterruptedException {
        if (nameofthebrowser.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (nameofthebrowser.equals("edge")) {
            driver = new EdgeDriver();
        }
        driver.get("https://qainterview.pythonanywhere.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }

    @Test
    public void t1() throws Exception {
        // Create a WebDriverWait instance
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Check if the Calculate button is displayed and enabled
        WebElement calculateButton = driver.findElement(By.id("getFactorial"));
        boolean isCalculateButtonDisplayed = calculateButton.isDisplayed();
        boolean isCalculateButtonEnabled = calculateButton.isEnabled();

        // Check if the Terms and Conditions link is displayed and enabled
        WebElement termsLink = driver.findElement(By.linkText("Terms and Conditions"));
        boolean isTermsLinkDisplayed = termsLink.isDisplayed();
        boolean isTermsLinkEnabled = termsLink.isEnabled();

        // Check if the Privacy link is displayed, enabled, and clickable
        WebElement privacyLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Privacy")));
        boolean isPrivacyLinkDisplayed = privacyLink.isDisplayed();
        boolean isPrivacyLinkEnabled = privacyLink.isEnabled();

        // Output the results
        System.out.println("Calculate button is displayed: " + isCalculateButtonDisplayed);
        System.out.println("Calculate button is enabled: " + isCalculateButtonEnabled);
        System.out.println("Terms and Conditions link is displayed: " + isTermsLinkDisplayed);
        System.out.println("Terms and Conditions link is enabled: " + isTermsLinkEnabled);
        System.out.println("Privacy link is displayed: " + isPrivacyLinkDisplayed);
        System.out.println("Privacy link is enabled: " + isPrivacyLinkEnabled);
    }

    @AfterTest
    public void close() {
        driver.quit();
    }
}
