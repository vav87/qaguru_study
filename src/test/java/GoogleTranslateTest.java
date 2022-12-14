import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GoogleTranslateTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1280x720";
    }

    @BeforeEach
    public void setUp() {
        open("https://translate.google.com/");
    }

    @CsvFileSource(resources = "/words_en.csv", delimiter = ';')
    @ParameterizedTest(name = "Check if the translation of the word {0} to English is correct")
    public void testEnglishTranslate(String word, String expectedResult) {

        if(!$(byXpath("//div[@jsname='HexNre']"))
                .$(byXpath(".//button[@aria-selected='true']"))
                .$(byXpath(".//span[@jsname='V67aGc']"))
                .has(text("русский"))) {
            $(By.xpath("//button[@jsname='RCbdJd']")).click();
            $(byClassName("OoYv6d")).$(byText("русский")).doubleClick();
        }

        if(!$(byXpath("//div[@jsname='ji7Qmb']"))
                .$(byXpath(".//button[@aria-selected='true']"))
                .$(byXpath(".//span[@jsname='V67aGc']"))
                .has(text("английский"))) {
            $(By.xpath("//button[@jsname='zumM6d']")).click();
            $(byClassName("ykTHSe")).$(byText("английский")).doubleClick();
        }

        $(byClassName("er8xn")).setValue(word);
        $(byClassName("usGWQd")).$(byClassName("ryNqvb")).shouldHave(text(expectedResult));
    }

    @CsvFileSource(resources = "/words_de.csv", delimiter = ';')
    @ParameterizedTest(name = "Check if the translation of the word {0} to German is correct")
    public void testGermanTranslate(String word, String expectedResult) {

        if(!$(byXpath("//div[@jsname='HexNre']"))
                .$(byXpath(".//button[@aria-selected='true']"))
                .$(byXpath(".//span[@jsname='V67aGc']"))
                .has(text("русский"))) {
            $(By.xpath("//button[@jsname='RCbdJd']")).click();
            $(byClassName("OoYv6d")).$(byText("русский")).doubleClick();
        }

        if(!$(byXpath("//div[@jsname='ji7Qmb']"))
                .$(byXpath(".//button[@aria-selected='true']"))
                .$(byXpath(".//span[@jsname='V67aGc']"))
                .has(text("немецкий"))) {
            $(By.xpath("//button[@jsname='zumM6d']")).click();
            $(byClassName("ykTHSe")).$(byText("немецкий")).doubleClick();
        }

        $(byClassName("er8xn")).setValue(word);
        $(byClassName("usGWQd")).$(byClassName("ryNqvb")).shouldHave(text(expectedResult));
    }
}
