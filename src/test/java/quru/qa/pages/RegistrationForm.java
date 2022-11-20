package quru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import quru.qa.pages.components.CalendarComponent;
import quru.qa.pages.components.RegistrationModal;
import quru.qa.pages.data.GenderEnum;

import java.io.File;
import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationForm {

    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationModal registrationModal = new RegistrationModal();

    private final SelenideElement firstName = $("#firstName");
    private final SelenideElement lastName = $("#lastName");
    private final SelenideElement userEmail = $("#userEmail");
    private final SelenideElement maleGender = $(By.xpath("//div[@id='genterWrapper']/div/div/input[@id='gender-radio-1']"));
    private final SelenideElement femaleGender = $(By.xpath("//div[@id='genterWrapper']/div/div/input[@id='gender-radio-2']"));
    private final SelenideElement otherGender = $(By.xpath("//div[@id='genterWrapper']/div/div/input[@id='gender-radio-3']"));
    private final SelenideElement userNumber = $("#userNumber");
    private final SelenideElement birthDateComponent = $("#dateOfBirthInput");
    private final SelenideElement subjectsContainer = $("#subjectsContainer");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbiesWrapper = $("#hobbiesWrapper");
    private final SelenideElement uploadPicture = $(By.id("uploadPicture"));
    private final SelenideElement currentAddress = $("#currentAddress");
    private final SelenideElement stateElement = $("#state");
    private final SelenideElement cityElement = $("#city");
    private final SelenideElement stateCityWrapper = $("#stateCity-wrapper");
    private final SelenideElement submitButton = $("#submit");

    public RegistrationForm openForm() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationForm setFirstName(String firstName) {
        this.firstName.setValue(firstName);
        return this;
    }

    public RegistrationForm setLastName(String lastName) {
        this.lastName.setValue(lastName);
        return this;
    }

    public RegistrationForm setUserEmail(String userEmail) {
        this.userEmail.setValue(userEmail);
        return this;
    }

    public RegistrationForm setGender(GenderEnum gender) {
        switch (gender) {
            case MALE: this.maleGender.doubleClick();
                break;
            case FEMALE: this.femaleGender.doubleClick();
                break;
            default: this.otherGender.doubleClick();
        }
        return this;
    }

    public RegistrationForm setUserNumber(String userNumber) {
        this.userNumber.setValue(userNumber);
        return this;
    }

    public RegistrationForm setBirthDate(String year, String month, String day) {
        birthDateComponent.click();
        calendarComponent.setDate(year, month, day);
        return this;
    }

    public RegistrationForm setSubject(String subject) {
        subjectsContainer.click();
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationForm setHobbies(List<String> hobbies) {
        for(String hobby: hobbies) {
            hobbiesWrapper.$(byText(hobby)).click();
        }
        return this;
    }

    public RegistrationForm setPicture(File pictureFile) {
        uploadPicture.uploadFile(pictureFile);
        return this;
    }

    public RegistrationForm setCurrentAddress(String address) {
        currentAddress.setValue(address);
        return this;
    }
    public RegistrationForm setState(String state) {
        stateElement.click();
        stateCityWrapper.$(byText(state)).click();
        return this;
    }
    public RegistrationForm setCity(String city) {
        cityElement.click();
        stateCityWrapper.$(byText(city)).click();
        return this;
    }

    public void submitForm() {
        submitButton.click();
    }

    public RegistrationForm verifyResultsModalExist() {
        registrationModal.verifyModalAppears();
        return this;
    }

    public RegistrationForm verifyResult(String key, String value) {
        registrationModal.verifyResult(key, value);
        return this;
    }

    public void closeModal() {
        registrationModal.closeModal();
    }
}
