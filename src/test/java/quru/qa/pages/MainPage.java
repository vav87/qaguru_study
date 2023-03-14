package quru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private final SelenideElement aboutLink = $("[href=\"/about/\"]");

    private final SelenideElement shopsLink = $("[href=\"/about/outpost/\"]");

    public MainPage openMainPage() {
        open("/");
        return this;
    }

    public SelenideElement getAboutLink() {
        return aboutLink;
    }

    public SelenideElement getShopsLink() {
        return shopsLink;
    }
}
