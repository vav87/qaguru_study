package quru.qa.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SalesPage extends AbstractPage {

    private final SelenideElement title = $(byText("Распродажа товаров для животных"));

    public ElementsCollection getItems() {
        return $$(".CatalogProducts_content__sAzhV");
    }

    public SelenideElement getTitle() {
        return title;
    }
}
