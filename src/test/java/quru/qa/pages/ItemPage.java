package quru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ItemPage extends AbstractPage {

    public SelenideElement getButtonAddToCart() {
        return $(byText("Добавить в корзину"));
    }
}
