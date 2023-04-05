package quru.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${env}.properties"})
public interface WebDriverConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://www.petshop.ru")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String getBrowserVersion();

    @Key("remoteUrl")
    String getRemoteURL();

    @Key("browserSize")
    @DefaultValue("1280x720")
    String getBrowserSize();

    @Key("holdBrowserOpen")
    @DefaultValue("false")
    boolean getHoldBrowserOpen();

    @Key("pageLoadTimeout")
    @DefaultValue("30000")
    long getPageLoadTimeout();
}
