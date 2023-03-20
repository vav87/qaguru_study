package quru.qa.pages;

import static com.codeborne.selenide.Selenide.open;

public class MainPage extends AbstractPage {

    public void openMainPage() {
        open("/");
    }
}
