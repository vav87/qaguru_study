package quru.qa.tests;

import org.junit.jupiter.api.Test;
import quru.qa.pages.data.FakerUserData;

public class DemoqaTestExample extends BaseTest {

    FakerUserData fakerUserData = new FakerUserData();

    @Test
    void fillFormTestSuccess() {

        registrationForm.openForm()
                        .setFirstName(fakerUserData.getFirstName())
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
    }
}
