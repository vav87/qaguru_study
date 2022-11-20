package quru.qa.pages.components;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String year, String month, String day) {
        $(".react-datepicker__year-select").selectOptionByValue(year);
        $(".react-datepicker__month-select").selectOptionContainingText(month);
        $(By.xpath(String.format("//div[contains(@aria-label,'%s %sth')]", month, day))).click();
    }
}
