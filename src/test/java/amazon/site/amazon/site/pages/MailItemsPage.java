package amazon.site.amazon.site.pages;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class MailItemsPage {
    private By emailItem = By.partialLinkText("Your Amazon verification code");
    private By verificationCode = By.className("otp_mailru_css_attribute_postfix");

    public void goToEmail(){
        $(emailItem).click();
    }

    public String getVerificationCode(){
        return $(verificationCode).getText();
    }
}
