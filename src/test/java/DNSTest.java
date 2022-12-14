import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.partialText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class DNSTest {

    @BeforeEach
    public void setUp() {
        open("https://www.dns-shop.ru/");
        if($(byClassName("v-confirm-city")).isDisplayed()) {
            $(byClassName("v-confirm-city")).$(byText("Всё верно")).click();
        }
    }

    static Stream<Arguments> searchItemTest() {
        return Stream.of(
                Arguments.of("SSD Samsung", "Samsung"),
                Arguments.of("Ноутбук Lenovo", "Lenovo")
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Checking if the item {1} is present in the shop")
    public void searchItemTest(String searchValue, String controlValue) {
        $(By.xpath("//div[@class='header-menu-wrapper']//input")).click();
        $(By.xpath("//div[@class='header-menu-wrapper']//input")).setValue(searchValue).pressEnter();
        $(byClassName("products-list")).shouldBe(visible);
        SelenideElement firstItem = $$(byClassName("catalog-product")).get(0);
        firstItem.$(By.xpath(".//a[@class='catalog-product__name ui-link ui-link_black']/span")).shouldHave(partialText(controlValue));
    }
}
