package allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepTest {

    private static final String REPOSITORY = "spring-projects/spring-boot";
    private static final int ISSUE = 34008;

    @Test
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open main page", () -> {
            open("https://github.com/");
        });

        step("Searching for repository", () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Click on link "+REPOSITORY, () -> {
            $(linkText("spring-projects/spring-boot")).click();
        });

        step("Open Issues tab", () -> {
            $("#issues-tab").click();
        });

        step("Checking existence of issue with number "+ISSUE, () -> {
            $(withText("#"+ISSUE)).should(Condition.visible);
        });
    }

    @Test
    public void testAnnotatedStep() {
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnLink(REPOSITORY);
        steps.openIssuesTab();
        steps.checkIssueExists(ISSUE);
    }
}
