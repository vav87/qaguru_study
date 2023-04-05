package quru.qa.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import quru.qa.config.WebDriverProvider;
import quru.qa.pages.AboutPage;
import quru.qa.pages.CartPage;
import quru.qa.pages.ItemPage;
import quru.qa.pages.MainPage;
import quru.qa.pages.SalesPage;
import quru.qa.pages.SearchResultsPage;
import quru.qa.pages.ShopsPage;

public class BaseTest {

    protected MainPage mainPage = new MainPage();
    protected AboutPage aboutPage = new AboutPage();
    protected ShopsPage shopsPage = new ShopsPage();
    protected SalesPage salesPage = new SalesPage();
    protected SearchResultsPage searchResultsPage = new SearchResultsPage();
    protected ItemPage itemPage = new ItemPage();
    protected CartPage cartPage = new CartPage();

    @BeforeAll
    static void setUp() {
        WebDriverProvider provider = new WebDriverProvider();
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
}
