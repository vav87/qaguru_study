package qa.guru;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelectorsTest {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = false;
        Configuration.browserSize = "1280x720";
        Configuration.baseUrl = "https://selenide.org";
    }

    @Test
    public void checkSelectorsTest() {
        open("/quick-start.html");
        // поиск элемента section внутри которого есть p
        $("section p").shouldHave(Condition.text("How to write UI test in 10 minutes"));
        // поиск элемента h3 внутри элемента section
        $("section").$("h3").shouldHave(Condition.text("QUICK START"));

    }
}
