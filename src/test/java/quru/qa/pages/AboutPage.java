package quru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AboutPage {

    private final SelenideElement contactsLink = $("[href=\"/about/contacts/\"]");

    private final SelenideElement contactsTitle = $("h1").$(byText("Контакты"));

    private final SelenideElement aboutTitle = $("h1").$(byText("О компании"));

    public SelenideElement getContactsLink() {
        return contactsLink;
    }

    public SelenideElement getContactsTitle() {
        return contactsTitle;
    }

    public SelenideElement getAboutTitle() {
        return aboutTitle;
    }
}
