package quru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import quru.qa.pages.RegistrationForm;

public class BaseTest {

    protected RegistrationForm registrationForm = new RegistrationForm();

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1280x720";
        Configuration.baseUrl = "https://demoqa.com";
    }
}
