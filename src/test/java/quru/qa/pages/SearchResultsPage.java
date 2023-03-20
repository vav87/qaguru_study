package quru.qa.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage extends AbstractPage {

    private ElementsCollection products = $$("#products-wrapper");

    private ElementsCollection productList = $$("li");

    private SelenideElement product = $("li");

    public SelenideElement getFirstProduct() {
        return $$("#products-wrapper").first().$$("ul").first().$("li");
    }
}
