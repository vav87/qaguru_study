package quru.qa.tests;

import org.junit.jupiter.api.Test;
import quru.qa.pages.data.UserData;

public class DemoqaTestExample extends BaseTest {

    UserData userData = new UserData();

    @Test
    void fillFormTestSuccess() {

        registrationForm.openForm()
                        .setFirstName(userData.getFirstName())
                        .setLastName(userData.getLastName())
                        .setUserEmail(userData.getEmail())
                        .setGender(userData.getGender())
                        .setUserNumber(userData.getPhoneNumber())
                        .setBirthDate(userData.getBirthDate().getYear(),
                                userData.getBirthDate().getMonth(),
                                userData.getBirthDate().getDay()
                        )
                        .setSubject(userData.getSubject())
                        .setHobbies(userData.getHobbies())
                        .setPicture(userData.getPicture())
                        .setCurrentAddress(userData.getAddress())
                        .setState(userData.getState())
                        .setCity(userData.getCity())
                        .submitForm();

        registrationForm.verifyResultsModalExist()
                        .verifyResult("Student Name",
                                String.format("%s %s", userData.getFirstName(), userData.getLastName()))
                        .verifyResult("Student Email", userData.getEmail())
                        .verifyResult("Gender", userData.getGender().value)
                        .verifyResult("Mobile", userData.getPhoneNumber())
                        .verifyResult("Date of Birth",
                                String.format("%s %s,%s",
                                        userData.getBirthDate().getDay(),
                                        userData.getBirthDate().getMonth(),
                                        userData.getBirthDate().getYear()))
                        .verifyResult("Subjects", userData.getSubject())
                        .verifyResult("Hobbies", userData.getHobbies().get(0))
                        .verifyResult("Picture", userData.getPicture().getName())
                        .verifyResult("Address", userData.getAddress())
                        .verifyResult("State and City",
                                String.format("%s %s", userData.getState(), userData.getCity()))
                        .closeModal();
    }
}
