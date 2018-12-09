package amazon.site.amazon.site.pages;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class MailLoginPage {
    private By loginField = By.id("mailbox:login");
    private By selectDomainCombo = By.id("mailbox:domain");
    private By passwordField = By.id("mailbox:password");
    private By submitButton = By.id("mailbox:submit");

    public void signIn(String email, String password){
        $(loginField).setValue(email);
        $(selectDomainCombo).selectOption("@inbox.ru");
        $(passwordField).setValue(password);
        $(submitButton).click();
}
}
