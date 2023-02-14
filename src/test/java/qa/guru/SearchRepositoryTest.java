package qa.guru;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class SearchRepositoryTest {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1280x720";
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    public void searchRepositoryTest() {
        // открыть браузер на странице github.com
        open("/");
        // в поле поиска набрать selenide и нажать Enter
        $("[name=q]").setValue("selenide").pressEnter();
        // в списке репозиториев выбрать первый
        $$("ul.repo-list").first().$("a").pressEnter();
        // заголовок репозитория должен содержать "selenide / selenide"
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
        // выбрать вкладку wiki
        $("#wiki-tab").click();
        // раскрыть весь список страниц
        $("div.wiki-rightbar").$("ul li.wiki-more-pages-link button").click();
        // проверка, что в списке страниц есть ссылка на страницу Soft assertions
        $("div.wiki-rightbar").$(byText("SoftAssertions")).shouldHave(Condition.href("/selenide/selenide/wiki/SoftAssertions"));
        // открыть старницу Soft assertions
        $("div.wiki-rightbar").$(byText("SoftAssertions")).click();
        // проверка, что существует пример с JUnit5
        $(".markdown-body").shouldHave(text("Using JUnit5"));
    }

}
