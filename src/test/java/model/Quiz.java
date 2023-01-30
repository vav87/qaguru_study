package model;

public class Quiz {

    public Question[] questions;

    public static class Question {
        public String question;
        public String[] options;
        public String answer;
    }
}
