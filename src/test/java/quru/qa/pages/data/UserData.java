package quru.qa.pages.data;

import java.io.File;
import java.util.List;

public class UserData {

    private String firstName = "Ivan";
    private String lastName = "Ivanov";
    private String email = "ivanivanov@mail.com";
    private GenderEnum gender = GenderEnum.MALE;
    private BirthDate birthDate = new BirthDate();
    private String phoneNumber = "8777711122";
    private String subject = "English";
    private List<String> hobbies = List.of("Sports");
    private File picture = new File("src/test/resources/image.png");
    private String address = "Street, house";
    private String state = "Rajasthan";
    private String city = "Jaipur";

    public class BirthDate{
        private String year = "1987";
        private String month = "April";
        private String day = "29";

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

    public UserData.BirthDate getBirthDate() {
        return birthDate;
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

    public GenderEnum getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSubject() {
        return subject;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public File getPicture() {
        return picture;
    }

    public String getAddress() {
        return address;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }
}
