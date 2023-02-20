package qa.guru;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubTest {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1280x720";
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    public void openEnterprisePage() {
        open("/");
        $("header").$(withText("Solutions")).hover();
        $("[href=\"/enterprise\"]").click();
        $("h4").shouldHave(text("GitHub for enterprises"));
    }
}
