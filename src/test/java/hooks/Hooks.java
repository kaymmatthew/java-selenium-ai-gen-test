package hooks;

import base.BaseClass;
import utilities.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp() {
        // Ensure the driver is initialized
        BaseClass.getDriver(); // This initializes BaseClass.driver if null
        // Navigate to the base URL
        BaseClass.getDriver().get(ConfigReader.get("base.url"));
        BaseClass.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown() {
        BaseClass.closeDriver(); // Closes the driver after each scenario
    }
}