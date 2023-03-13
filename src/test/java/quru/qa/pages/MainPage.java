package quru.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private final SelenideElement blogLink = $("[href=\"/blog\"]");

    public MainPage openMainPage() {
        open("/");
        $(withText("Онлайн-курсы")).shouldBe(Condition.visible);
        return this;
    }

    public SelenideElement getBlogLink() {
        return blogLink;
    }
}
