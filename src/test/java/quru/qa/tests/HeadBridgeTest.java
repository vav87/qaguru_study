package quru.qa.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class HeadBridgeTest extends BaseTest {

    @Test
    @DisplayName("Проверить ссылку на раздел Блог в меню заголовка")
    @Owner("vav87")
    @Tag("UI_test")
    public void checkLinkToBlogMenuItem() {

        step("Open main page", () -> {
            mainPage.openMainPage();
        });

        step("Click on Blog menu item", () -> {
            mainPage.getBlogLink().click();
        });

        step("Check the result", () -> {
            $(byText("Подпишись на наш блог")).shouldBe(Condition.visible);
            $(byText("Подписаться")).shouldBe(Condition.visible, Condition.tagName("button"));
        });
    }
}
