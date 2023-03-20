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
            mainPage.closeCityPopUp();
            mainPage.removeCookiePopUp();
        });
        step("Check the About link", () -> {
            mainPage.openAboutPage();
            aboutPage.removePermissionPopUps();
            aboutPage.removeCookiePopUp();
            aboutPage.getAboutTitle().shouldBe(Condition.visible);
        });
        step("Check the Contacts link", () -> {
            aboutPage.clickOnContactsLink();
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
            mainPage.closeCityPopUp();
            mainPage.closeAllLinksPopUp();
        });
        step("Click on the Shops link", () -> {
            mainPage.openShopsPage();
            shopsPage.removePermissionPopUps();
        });
        step("Check the result", () -> {
            shopsPage.getSearchShopTitle().shouldBe(Condition.visible);
            shopsPage.getInputBox().shouldHave(Condition.attribute("placeholder", "По адресу или станции метро"));
        });
    }

    @Test
    @DisplayName("Проверить раздел \"Акции\"")
    @Owner("vav87")
    @Tag("UI_test")
    public void checkSalesPage() {
        step("Open main page", () -> {
            mainPage.openMainPage();
            mainPage.closeAllLinksPopUp();
            mainPage.closeCityPopUp();
        });
        step("Click on the Sales link", () -> {
            mainPage.openSalesLink();
            salesPage.removePermissionPopUps();
        });
        step("Check the result", () -> {
            salesPage.getTitle().shouldBe(Condition.visible);
            salesPage.getItems().first().$("div").shouldHave(Condition.attribute("data-testid", "CatalogItem"));
        });
    }

    @Test
    @DisplayName("Проверить фунуционал поиска")
    @Owner("vav87")
    @Tag("UI_test")
    public void checkSearchFunctionality() {
        step("Open main page", () -> {
            mainPage.openMainPage();
            mainPage.closeCityPopUp();
            mainPage.closeAllLinksPopUp();
        });
        step("Search for toys", () -> {
            mainPage.getInputField().setValue("игрушки").pressEnter();
        });
        step("Check the result", () -> {
            searchResultsPage.removePermissionPopUps();
            searchResultsPage.getFirstProduct().shouldHave(Condition.attribute("data-testid", "product__item"));
        });
    }

    @Test
    @DisplayName("Проверить фунуционал корзины")
    @Owner("vav87")
    @Tag("UI_test")
    public void checkCartFunctionality() {
        step("Open main page", () -> {
            mainPage.openMainPage();
            mainPage.closeCityPopUp();
            mainPage.closeAllLinksPopUp();
        });
        step("Search for toys", () -> {
            mainPage.getInputField().setValue("корм").pressEnter();
        });
        step("Choose the first item", () -> {
            searchResultsPage.removePermissionPopUps();
            searchResultsPage.getFirstProduct().$("a").click();
        });
        step("Add item to cart", () -> {
            itemPage.removePermissionPopUps();
            itemPage.removeCookiePopUp();
            itemPage.getButtonAddToCart().click();
        });
        step("Go to the cart", () -> {
            mainPage.getCartButton().click();
            cartPage.removePermissionPopUps();
        });
        step("Check the result", () -> {
            cartPage.removeCookiePopUp();
            cartPage.getCartTitle().shouldBe(Condition.exist);
            cartPage.getCartItemsList().first().$("div").shouldBe(Condition.visible);
        });
    }
}
