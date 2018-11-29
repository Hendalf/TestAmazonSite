package amazon.site.amazon.site.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private By signInButton = By.id("nav-link-yourAccount");
    private By searchField = By.id("twotabsearchtextbox");
    private By searchSubmitButton = By.xpath("//input[@value='Go']");
    private By accountMenu = By.id("nav-link-yourAccount");
    private By signOutLink = By.linkText("Sign Out");

    public void clickOnSignIn(){
        $(signInButton).click();
    }

    public void performSearch(String value){
        $(searchField).setValue(value);
        $(searchSubmitButton).click();
    }

    public void signOut(){
        $(accountMenu).hover();
        $(signOutLink).click();
    }

}
