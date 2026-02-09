package stepdefinitions;

import base.DriverFactory;
import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.ProductPage;
import pages.CartPage;
import utils.ConfigReader;

public class ShopSteps {

    LoginPage login;
    ProductPage product;
    CartPage cart;

    @Given("user is on login page")
    public void openLoginPage() {
        DriverFactory.initDriver();
        login = new LoginPage(DriverFactory.getDriver());
        product = new ProductPage(DriverFactory.getDriver());
        cart = new CartPage(DriverFactory.getDriver());
    }

    @When("user logs in with valid credentials")
    public void user_logs_in() {
        login.login(
            ConfigReader.getProperty("username"),
            ConfigReader.getProperty("password")
        );
    }

    @Then("user adds product to cart")
    public void add_product() {
        product.addProductToCart();
        cart.openCart();
    }
}
