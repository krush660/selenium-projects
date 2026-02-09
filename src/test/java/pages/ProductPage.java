package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    WebDriver driver;

    By addToCart = By.id("add-to-cart-sauce-labs-backpack");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart() {
        driver.findElement(addToCart).click();
    }
}
