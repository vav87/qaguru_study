package allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Open main page")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Searching for repository")
    public void searchForRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("Click on link")
    public void clickOnLink(String repository) {
        $(linkText(repository)).click();
    }

    @Step("Open Issues tab")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Checking existence of the issue")
    public void checkIssueExists(int issue) {
        $(withText("#"+issue)).should(Condition.exist);
    }
}
