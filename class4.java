package pack1.mavan_gsit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class class4 {
    
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to the chromedriver executable
    	System.setProperty("webdriver.chrome.driver" ,"C:\\Users\\Krushnal\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qainterview.pythonanywhere.com/");
    }

    @Test
    public void testFactorial() {
        for (int i = 1; i <176; i++) {
            WebElement inputField = driver.findElement(By.id("number"));
            WebElement calculateButton = driver.findElement(By.id("getFactorial"));
            WebElement resultField = driver.findElement(By.id("resultDiv"));

            inputField.clear();
            inputField.sendKeys(String.valueOf(i));
            calculateButton.click();

            String resultText = resultField.getText();
            System.out.println(+ i + " is " + resultText);


            // Check if the result contains "infinity"
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
