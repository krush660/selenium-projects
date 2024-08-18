package pack1.mavan_gsit;

import static org.testng.AssertJUnit.assertNotNull;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class class2 {
    WebDriver driver;
    
    @Parameters("browsers")//cross browser 
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

    @Test(priority = 1)
    public void t1() {
        WebElement intigerfield = driver.findElement(By.id("number"));
        String intiger_Watermark = intigerfield.getAttribute("placeholder");
        assertNotNull("Placeholder is not present", intiger_Watermark);
        System.out.println("it contains placeholder");
    }

    @Test(priority = 2)
    public void t2() {
        String pageTitle = driver.getTitle();
        boolean b = pageTitle.contains("Factoriall");
        AssertJUnit.assertEquals(b, true);
        System.out.println("it contain Factoriall");
    }

    @Test(priority = 3)
    public void t3() {
        String currentUrl = driver.getCurrentUrl();
        boolean containsHttps = currentUrl.startsWith("https");
        AssertJUnit.assertEquals(containsHttps, true);
        System.out.println("url contain https and the server is secured");
    }

    @AfterTest
    public void close1() {
        driver.quit();
    }
}
