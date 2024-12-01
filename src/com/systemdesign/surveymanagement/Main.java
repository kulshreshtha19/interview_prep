package com.systemdesign.surveymanagement;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        SurveyService surveyService = new SurveyService();


        // Test cases
        User admin = new User("Kul", "test@gmail.com", UserRole.ADMIN);
        Survey s1 = surveyService.createSurvey(admin, "s1", "Collecting Feedback");

        Map<String, Integer> options = Map.of("Good", 2, "Very Good", 3, "Poor", 1);
        Question q1 = new Question("q1", "How was the session?", options);
        surveyService.addQuestion(admin, s1, q1);

        User u1 = new User("Av", "av@gmail.com", UserRole.USER);
        surveyService.submitResponse(u1, q1, "Good", s1);

        User u2 = new User("Naveen", "naveen@gmail.com", UserRole.USER);
        surveyService.submitResponse(u2, q1, "Very Good", s1);

        System.out.println(surveyService.calculateOverallRating(admin, s1));
        System.out.println(surveyService.calculateOverallRatingByQuestion(admin, q1));


        surveyService.createSurvey(u1, "s2", "Hello");
        surveyService.addQuestion(u1, s1, q1);

    }
}
