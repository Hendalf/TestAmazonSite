package amazon.site.amazon.site.pages;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class BasketPage {
    private By inStockLabel = withText("left in stock.");
    private By deleteLink = By.xpath("//input[@value='Delete']");

    public void checkInStockItem(){
        $(inStockLabel).shouldHave(matchText("Only .* left in stock."));
    }

    public void deleteFromBasket(){
        $(deleteLink).click();
    }
}
