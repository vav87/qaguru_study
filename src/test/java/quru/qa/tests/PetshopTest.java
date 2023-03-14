package quru.qa.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class PetshopTest extends BaseTest {

    @Test
    @DisplayName("Проверить раздел \"О нас\"")
    @Owner("vav87")
    @Tag("UI_test")
    public void checkLinkToAboutPage() {

        step("Open main page", () -> {
            mainPage.openMainPage();
        });

        step("Check the About link", () -> {
            mainPage.getAboutLink().click();
            aboutPage.getAboutTitle().shouldBe(Condition.visible);
        });

        step("Check the Contacts link", () -> {
            aboutPage.getContactsLink().click();
            aboutPage.getContactsTitle().shouldBe(Condition.visible);
        });
    }

    @Test
    @DisplayName("Проверить раздел \"Магазины\" в меню заголовка")
    @Owner("vav87")
    @Tag("UI_test")
    public void checkLinkToContactsPage() {

        step("Open main page", () -> {
            mainPage.openMainPage();
        });

        step("Click on the Shops link", () -> {
            mainPage.getShopsLink().click();
        });

        step("Check the result", () -> {
            shopsPage.getSearchShopTitle().shouldBe(Condition.visible);
            shopsPage.getInputBox().shouldHave(Condition.attribute("placeholder", "По адресу или станции метро"));
        });
    }
}
