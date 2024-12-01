package com.systemdesign.surveymanagement;

import java.util.ArrayList;
import java.util.List;

public class Survey {

    String surveyId;

    String title;

    List<Question> questionList;

    Survey(String surveyId, String title) {
        this.surveyId = surveyId;
        this.title = title;
        this.questionList = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        this.questionList.add(question);
    }
}
