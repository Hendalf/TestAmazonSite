package amazon.site.amazon.site.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;


public class LoginPage {
    private By userLogin = By.id("ap_email");
    private By userPassword = By.id("ap_password");
    private By submitButton = By.id("signInSubmit");

    public void login(String login, String password){
        $(userLogin).setValue(login);
        $(userPassword).setValue(password);
        $(submitButton).click();
    }

}
