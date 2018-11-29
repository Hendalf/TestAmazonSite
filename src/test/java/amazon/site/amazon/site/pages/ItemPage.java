package amazon.site.amazon.site.pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

public class ItemPage {
    private By seeAllBuyingOptionsButton = By.id("buybox-see-all-buying-choices-announce");

    public void seeAllBuyingOptions(){
        $(seeAllBuyingOptionsButton).click();
    }

}
