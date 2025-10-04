package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

public class LandingPageStepDefinition {
    public WebDriver driver;
    public String landingPageProductName;
    public String offerPageProductName;
    TestContextSetup testContextSetup;
    PageObjectManager pageObjectManager;
    LandingPage landingPage;
    //Single Responsibility Principle
    //loosly coupled used for dependency injection name as pico container where we created constructor
    //Created TestContextSetup and used driver , landingPageStepDefiniton variable with classname

    public LandingPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.landingPage= testContextSetup.pageObjectManager.getLandingPage();
    }

    @Given("User is on GreenCart Landing Page")
    public void user_is_on_green_cart_landing_page() {
        Assert.assertTrue(landingPage.getTileLandingPage().contains("GreenKart"));
        System.out.println("GitDemo change 1");
        System.out.println("GitDemo change 2");
        System.out.println("GitDemo change 3");
        //African guy changes
        System.out.println("GitX change 1");
        System.out.println("GitX change 2");
        System.out.println("GitX change 3");

    }

    @When("^user searched with Shortname (.+) and extracted actual name of product$")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.searchItem(shortName);
        //testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
        Thread.sleep(2000);
        testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
        System.out.println(testContextSetup.landingPageProductName + " is extracted from Home Page");
    }
    @When("Added {string} items of the selected product to cart")
    public void Added_items_product(String quantity)
    {
       landingPage.incrementQunatity(Integer.parseInt(quantity));
       landingPage.addToCart();
    }


}
