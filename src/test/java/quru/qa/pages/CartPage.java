package quru.qa.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CartPage extends AbstractPage {

    private final SelenideElement cartTitle = $(byText("Корзина"));

    private final ElementsCollection cartItemsList = $$("[data-testid=\"CartItemsList\"]");

    public SelenideElement getCartTitle() {
        return cartTitle;
    }

    public ElementsCollection getCartItemsList() {
        return cartItemsList;
    }
}
