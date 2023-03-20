package quru.qa.config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class WebDriverProvider {

    private final WebDriverConfig config;

    public WebDriverProvider() {
        this.config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
        createWebDriver();
    }

    private void createWebDriver() {
        Configuration.holdBrowserOpen = config.getHoldBrowserOpen();
        Configuration.browser = config.getBrowser();
        Configuration.browserSize = config.getBrowserSize();
        Configuration.baseUrl = config.getBaseUrl();
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.remote = config.getRemoteURL();
        Configuration.headless = config.getHeadless();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        Map<String, Object> prefs = new HashMap<String, Object>();
        // browser notification
        // 0 - Default, 1 - Allow, 2 - Block
        prefs.put("profile.default_content_setting_values.notifications", 2);
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;
    }
}
