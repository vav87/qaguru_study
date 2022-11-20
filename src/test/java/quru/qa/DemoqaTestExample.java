package quru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaTestExample {

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1280x720";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {

        open("/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ivanivanov@mail.com");
        $(By.xpath("//div[@id='genterWrapper']/div/div/input[@id='gender-radio-1']")).doubleClick();
        $("#userNumber").setValue("8777711122");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1987");
        $(".react-datepicker__month-select").selectOptionContainingText("April");
        $(By.xpath("//div[contains(@aria-label,'April 29th')]")).click();
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("En");
        $(By.xpath("//div[text()='English']")).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $(By.id("uploadPicture")).uploadFile(new File("src/test/resources/image.png"));
        $("#currentAddress").setValue("Street, house");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Rajasthan")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Jaipur")).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Ivan Ivanov"),
                text("ivanivanov@mail.com"),
                text("Male"),
                text("8777711122"),
                text("29 April,1987"),
                text("English"),
                text("Sports"),
                text("image.png"),
                text("Street, house"),
                text("Rajasthan Jaipur"));

        $("#closeLargeModal").click();


    }
}
