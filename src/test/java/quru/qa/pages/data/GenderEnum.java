package quru.qa.pages.data;

public enum GenderEnum {
    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");

    public final String value;

    GenderEnum(String gender) {
        this.value = gender;
    }
}
