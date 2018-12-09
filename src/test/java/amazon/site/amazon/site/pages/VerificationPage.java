package amazon.site.amazon.site.pages;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class VerificationPage {
    private By pageItem = By.id("a-page");
    private By sendCodeButton = By.id("continue");
    private By enterCodeField = By.name("code");
    private By submitCodeField = By.className("a-button-input");

    public boolean verificationNeeded(){
        if($(sendCodeButton).exists()){
            return true;
        }else return false;
    }

    public void sendCode(){
        $(sendCodeButton).click();
    }

    public void submitCode(String code){
        $(enterCodeField).setValue(code);
        $(submitCodeField).click();
    }
}
