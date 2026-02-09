package hooks;

import io.cucumber.java.After;
import base.DriverFactory;

public class Hooks {

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
