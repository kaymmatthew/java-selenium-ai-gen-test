package stepdefinitions;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import org.openqa.selenium.WebDriver;

public class DemoSteps {
    private final WebDriver driver;
    private final HomePage homePage;

    public DemoSteps() {
        //this.driver = Hooks.driver;
        this.driver = BaseClass.getDriver();
        this.homePage = new HomePage(driver);
        System.out.println("Driver initialized: " + (driver != null));
    }

    @Given("I am on the DemoQA homepage")
    public void i_am_on_the_demo_qa_homepage() {
        // Already handled in Hooks
    }

    @When("I click on the Elements card")
    public void i_click_on_the_elements_card() {
        homePage.clickElementsCard();
    }

    @Then("I should be redirected to the Elements page")
    public void i_should_be_redirected_to_the_elements_page() {
        String currentUrl = driver.getCurrentUrl();
        assert currentUrl.contains("elements");
    }
}