package quru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import quru.qa.helpers.Attach;
import quru.qa.pages.AboutPage;
import quru.qa.pages.MainPage;
import quru.qa.pages.ShopsPage;

public class BaseTest {

    protected MainPage mainPage = new MainPage();
    protected AboutPage aboutPage = new AboutPage();
    protected ShopsPage shopsPage = new ShopsPage();

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = false;
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = System.getProperty("browserSize", "1280x720");
        Configuration.browserVersion = System.getProperty("browserVersion", "100.0");
        Configuration.baseUrl = "https://www.petshop.ru";
        Configuration.headless = false;
        Configuration.timeout = 10000;
        Configuration.remote = System.getProperty("remote", "https://user1:1234@selenoid.autotests.cloud/wd/hub");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
