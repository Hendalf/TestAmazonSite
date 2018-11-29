package amazon.site.amazon.site.pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

public class BuyingOptionsPage {
    private By addToCartButton = By.name("submit.addToCart");

    public void addToCart(){
        $(addToCartButton).click();
    }
}
