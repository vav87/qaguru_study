package quru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AboutPage extends AbstractPage {

    private final SelenideElement contactsLink = $("[href=\"/about/contacts/\"]");

    private final SelenideElement contactsTitle = $(byText("Контакты"));

    private final SelenideElement aboutTitle = $(byText("О компании"));

    public SelenideElement getContactsTitle() {
        return contactsTitle;
    }

    public SelenideElement getAboutTitle() {
        return aboutTitle;
    }

    public void clickOnContactsLink() {
        contactsLink.click();
    }
}
