package quru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ShopsPage {

    private final SelenideElement searchShopTitle = $("h2").$(byText("Поиск магазина"));

    private final SelenideElement inputBox = $("#vm").$("input");

    public SelenideElement getSearchShopTitle() {
        return searchShopTitle;
    }

    public SelenideElement getInputBox() {
        return inputBox;
    }
}
