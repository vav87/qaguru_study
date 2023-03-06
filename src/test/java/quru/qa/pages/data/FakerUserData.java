package quru.qa.pages.data;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class FakerUserData {

    private String firstName;
    private String lastName;
    private String email;
    private BirthDate birthDate;
    private String phoneNumber;
    private String address;
    private InputData inputData;

    public FakerUserData() {
        inputData = new InputData();
        Faker faker = new Faker(new Locale("en"));

        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.email = faker.internet().emailAddress();

        SimpleDateFormat format = new SimpleDateFormat("yyyy:MMMM:dd", Locale.ENGLISH);
        String date = format.format(faker.date().birthday(18, 50));
        String[] dateParts = date.split(":");
        birthDate = new BirthDate(dateParts[0], dateParts[1], dateParts[2]);

        phoneNumber = faker.phoneNumber().subscriberNumber(10);
        address = faker.address().fullAddress();
    }

    public class BirthDate{
        private String year;
        private String month;
        private String day;

        public BirthDate(String year, String month, String day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public String getYear() {
            return year;
        }

        public String getMonth() {
            return month;
        }

        public String getDay() {
            return day;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public BirthDate getBirthDate() {
        return birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public InputData getInputData() {
        return inputData;
    }
}
