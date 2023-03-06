package quru.qa.pages.data;

import java.io.File;
import java.util.List;

public class InputData {

    private final GenderEnum gender = GenderEnum.MALE;
    private final String subject = "English";
    private final List<String> hobbies = List.of("Sports");
    private final File picture = new File("src/test/resources/image.png");
    private final String state = "Rajasthan";
    private final String city = "Jaipur";

    public GenderEnum getGender() {
        return gender;
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

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }
}
