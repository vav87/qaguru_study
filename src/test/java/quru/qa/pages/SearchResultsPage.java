package quru.qa.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage extends AbstractPage {

    private final ElementsCollection products = $$("#products-wrapper");

    private final ElementsCollection productList = $$("li");

    private final SelenideElement product = $("li");

    public SelenideElement getFirstProduct() {
        return $$("#products-wrapper").first().$$("ul").first().$("li");
    }
}
