package com.systemdesign.surveymanagement;

import java.util.List;
import java.util.Map;

public class Question {

    String questionId;

    String description;

    Map<String, Integer> options;

    Question(String questionId, String description, Map<String, Integer> options) {
        this.questionId = questionId;
        this.description = description;
        this.options = options;
    }
}
