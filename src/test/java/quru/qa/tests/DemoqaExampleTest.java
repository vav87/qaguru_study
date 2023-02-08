package quru.qa.tests;

import org.junit.jupiter.api.Test;
import quru.qa.pages.data.FakerUserData;

import static io.qameta.allure.Allure.step;

public class DemoqaExampleTest extends BaseTest {

    FakerUserData fakerUserData = new FakerUserData();

    @Test
    void fillFormSuccessTest() {

        step("Open registration form", () -> {
            registrationForm.openForm();
        });

        step("Fill registration form", () -> {
            registrationForm.setFirstName(fakerUserData.getFirstName())
                    .setLastName(fakerUserData.getLastName())
                    .setUserEmail(fakerUserData.getEmail())
                    .setGender(fakerUserData.getInputData().getGender())
                    .setUserNumber(fakerUserData.getPhoneNumber())
                    .setBirthDate(fakerUserData.getBirthDate().getYear(),
                            fakerUserData.getBirthDate().getMonth(),
                            fakerUserData.getBirthDate().getDay()
                    )
                    .setSubject(fakerUserData.getInputData().getSubject())
                    .setHobbies(fakerUserData.getInputData().getHobbies())
                    .setPicture(fakerUserData.getInputData().getPicture())
                    .setCurrentAddress(fakerUserData.getAddress())
                    .setState(fakerUserData.getInputData().getState())
                    .setCity(fakerUserData.getInputData().getCity())
                    .submitForm();
        });

        step("Check the results", () -> {
            registrationForm.verifyResultsModalExist()
                    .verifyResult("Student Name",
                            String.format("%s %s", fakerUserData.getFirstName(),
                                    fakerUserData.getLastName()))
                    .verifyResult("Student Email", fakerUserData.getEmail())
                    .verifyResult("Gender", fakerUserData.getInputData().getGender().value)
                    .verifyResult("Mobile", fakerUserData.getPhoneNumber())
                    .verifyResult("Date of Birth",
                            String.format("%s %s,%s",
                                    fakerUserData.getBirthDate().getDay(),
                                    fakerUserData.getBirthDate().getMonth(),
                                    fakerUserData.getBirthDate().getYear()))
                    .verifyResult("Subjects", fakerUserData.getInputData().getSubject())
                    .verifyResult("Hobbies", fakerUserData.getInputData().getHobbies().get(0))
                    .verifyResult("Picture", fakerUserData.getInputData().getPicture().getName())
                    .verifyResult("Address", fakerUserData.getAddress())
                    .verifyResult("State and City",
                            String.format("%s %s", fakerUserData.getInputData().getState(),
                                    fakerUserData.getInputData().getCity()))
                    .closeModal();
        });
    }
}
