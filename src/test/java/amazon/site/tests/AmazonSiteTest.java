package amazon.site.tests;

import amazon.site.amazon.site.pages.*;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AmazonSiteTest extends TestBase {
    MainPage mainPage;
    LoginPage loginPage;
    SearchResultsPage searchResultsPage;
    ItemPage itemPage;
    BuyingOptionsPage buyingOptionsPage;
    BasketPage basketPage;

    public AmazonSiteTest() {
        super();
    }

    @Test(priority = 1)
    public void loginTest() {

        open(getBaseUrl());
        getWebDriver().manage().window().maximize();

        mainPage = new MainPage();
        //Click on Sign In button
        mainPage.clickOnSignIn();


        loginPage = new LoginPage();
        //enter email, password and click on submit
        loginPage.login(getUserLogin(), getUserPassword());
    }

    @Test(priority = 2)
    public void searchItemTest() {

        //Perform search
        mainPage.performSearch("iphone 7 128gb");

        searchResultsPage = new SearchResultsPage();

        //Sort list of items by Price
        searchResultsPage.sortByPrice();
        searchResultsPage.selectCheapestItem();

        itemPage = new ItemPage();
        //See all buying options
        itemPage.seeAllBuyingOptions();
    }

    @Test(priority = 3)
    public void addToCartTest() {

        buyingOptionsPage = new BuyingOptionsPage();
        //add item to Basket
        buyingOptionsPage.addToCart();


        // go to edit basket
        $(By.id("hlb-view-cart-announce")).click();
    }

    @Test(priority = 4)
    public void deleteFromBasketAndSignOut() {

        basketPage = new BasketPage();
        //Check availability of item and delete from basket
        basketPage.checkInStockItem();
        basketPage.deleteFromBasket();

        //Sign out
        mainPage.signOut();
    }

}
