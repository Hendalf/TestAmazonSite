package amazon.site.tests;

import amazon.site.amazon.site.pages.*;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AmazonSiteTest extends TestBase {
    MainPage mainPage;
    LoginPage loginPage;
    SearchResultsPage searchResultsPage;
    ItemPage itemPage;
    BuyingOptionsPage buyingOptionsPage;
    BasketPage basketPage;
    VerificationPage verificationPage;
    String verificationCode;

    public AmazonSiteTest() {
        super();
    }

    @Test(priority = 1)
    public void loginTest() throws AWTException {

        open(getBaseUrl());
        WebDriver driver = getWebDriver();
        driver.manage().window().maximize();

        mainPage = new MainPage();
        //Click on Sign In button
        mainPage.clickOnSignIn();


        loginPage = new LoginPage();
        //enter email, password and click on submit
        loginPage.login(getUserEmail(), getUserPassword());

        if($("title").getText().equals("Please confirm your identity")){
            verificationPage = new VerificationPage();
            verificationPage.sendCode();

            //To open a new tab
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_CONTROL);
            r.keyPress(KeyEvent.VK_T);
            r.keyRelease(KeyEvent.VK_CONTROL);
            r.keyRelease(KeyEvent.VK_T);
//To switch to the new tab
            WebDriver wd = WebDriverRunner.getWebDriver();
            ArrayList<String> tabs = new ArrayList<String>(wd.getWindowHandles());
            wd.switchTo().window(tabs.get(1));

            verificationCode = checkVerification();

            //Switch to old tab
            wd.switchTo().window(tabs.get(0));
            verificationPage.submitCode(verificationCode);
        }else return;
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

    private String checkVerification() {
        open("https://mail.ru");
        MailLoginPage mailLoginPage = new MailLoginPage();
        mailLoginPage.signIn(getUserLogin(), getUserPassword());

        MailItemsPage mailItemsPage = new MailItemsPage();
        mailItemsPage.goToEmail();
        return mailItemsPage.getVerificationCode();
    }

}
