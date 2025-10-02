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
import pageObjects.OffersPage;

import java.util.Iterator;
import java.util.Set;

public class OfferPageStepDefinition {
    public WebDriver driver;
    public String landingPageProductName;
    public String offerPageProductName;
    TestContextSetup testContextSetup;

    public OfferPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
//        offersPage=testContextSetup.pageObjectManager.getOffersPage();
    }

    @Then("^user searched for (.+) shortname in offers page$")
    public void user_searched_for_same_shortname_in_offers_page(String shortName) throws InterruptedException {
        //offer page->enter->grab
        switchToOffersPage();
        OffersPage offersPage =testContextSetup.pageObjectManager.OffersPage();
        offersPage.searchItem(shortName);
        //driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
        Thread.sleep(2000);
        offerPageProductName = offersPage.getProductName();

    }

    public void switchToOffersPage() {
        //if switched to offer page where switch to child window not required->then skip below part
        //  if(testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
  //      PageObjectManager = new PageObjectManager(testContextSetup.driver);
        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.selectTopDealsPage();
       testContextSetup.genericUtils.SwitchWindowToChild();
    }

    @Then("validate product name in offers page matches with Landing Page")
    public void validate_product_name_in_offers_page() {
        Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
    }
}
