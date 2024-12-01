package com.systemdesign.surveymanagement;



public class Response {

    User user;
    Question question;
    String answer;

    Response(User user, Question question, String answer) {
        this.question = question;
        this.answer = answer;
        this.user = user;
    }

}
