package quru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public abstract class AbstractPage {

    protected final SelenideElement aboutLink = $("[href=\"/about/\"]");

    protected final SelenideElement shopsLink = $("[href=\"/about/outpost/\"]");

    protected final SelenideElement salesLink = $("[href=\"/catalog/sale/\"]");

    protected final SelenideElement inputField = $("[type=\"search\"]");

    protected final SelenideElement cartButton = $("[href=\"/personal/cart/\"]");

    public void openAboutPage() {
        aboutLink.click();
    }

    public void openShopsPage() {
        shopsLink.click();
    }

    public void openSalesLink() {
        salesLink.click();
    }

    public SelenideElement getInputField() {
        return inputField;
    }

    public SelenideElement getCartButton() {
        return cartButton;
    }

    public void removeCookiePopUp() {
        if($(".CookieInformer_tablet__UIOKa").isDisplayed()) {
            executeJavaScript("$('.CookieInformer_tablet__UIOKa').remove()");
        }
    }

    public void removePermissionPopUps() {
        if($(".flocktory-widget-overlay").isDisplayed()) {
            $$(".flocktory-widget-overlay").removeIf(SelenideElement::isDisplayed);
        }
    }

    // close PopUp "Теперь все ссылки в одном месте..."
    public void closeAllLinksPopUp() {
        if($(".TutoringEcoTooltip_button__zhTqX").isDisplayed()) {
            $(".TutoringEcoTooltip_button__zhTqX").click();
        }
    }

    // close PopUp "Выберите город"
    public void closeCityPopUp() {
        if($(byText("Да, спасибо")).isDisplayed()) {
            $(byText("Да, спасибо")).click();
        }
    }
}
