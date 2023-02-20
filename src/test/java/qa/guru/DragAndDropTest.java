package qa.guru;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTest {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1280x720";
        Configuration.baseUrl = "https://the-internet.herokuapp.com/";
    }

    @Test
    public void dragAndDropTest() {
        open("/drag_and_drop");
        WebElement columnA = $("#column-a");
        WebElement columnB = $("#column-b");
        actions().dragAndDrop(columnA, columnB);
        $$("#columns").first().shouldHave(text("B"));
        $$("#columns").last().shouldHave(text("A"));

    }
}
