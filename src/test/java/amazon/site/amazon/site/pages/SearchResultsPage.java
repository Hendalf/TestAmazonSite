package amazon.site.amazon.site.pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

public class SearchResultsPage {
    private By sortComboBox = By.id("sort");
    private By resultList = By.id("s-results-list-atf");
    private By resultListItems = By.xpath("//a[@class='a-link-normal s-access-detail-page  s-color-twister-title-link a-text-normal']");

    public void sortByPrice(){
        $(sortComboBox).selectOption("Price: Low to High");
    }

    public void selectCheapestItem(){
        $(resultList).$$(resultListItems).first().click();
    }
}
