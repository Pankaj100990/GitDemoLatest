
package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

public class CheckoutPageStepDefinition {
    public WebDriver driver;
    public String landingPageProductName;
    public String offerPageProductName;
    TestContextSetup testContextSetup;
    PageObjectManager pageObjectManager;
    CheckoutPage checkoutPage;

    //Single Responsibility Principle
    //loosly coupled used for dependency injection name as pico container where we created constructor
    //Created TestContextSetup and used driver , landingPageStepDefiniton variable with classname

    public CheckoutPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
    }


    @Then("verify user has ability to enter promo code and place the order")
    public void verify_user_has_ability_enter_promo() {
        Assert.assertTrue(checkoutPage.VerifyPromoBtn());
        Assert.assertTrue(checkoutPage.VerifyPlaceOrder());

    }

    @Then("^user proceeds to Checkout and validate the (.+) items in checkout page$")
    public void user_proceeds_to_checkout(String name) {
        checkoutPage.CheckoutItems();
        //Assertion to extract name from screen and compare with name
    }

}
