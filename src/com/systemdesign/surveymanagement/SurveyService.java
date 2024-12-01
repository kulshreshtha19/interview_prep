package com.systemdesign.surveymanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SurveyService {

    Map<String, List<Response>> surveyResponseMap;
    Map<String, List<Response>> questionResponseMap;

    AuthorizationService authorizationService;

    SurveyService() {
        this.surveyResponseMap = new ConcurrentHashMap<>();
        this.authorizationService = new AuthorizationService();
        this.questionResponseMap = new ConcurrentHashMap<>();
    }

    public Survey createSurvey(User user, String surveyId, String title) {
        if (!authorizationService.validateAdminRole(user)) {
            System.out.println("User is not allowed to perform this action");
            return null;
        }

        return new Survey(surveyId, title);
    }


    public void addQuestion(User user, Survey survey, Question question) {
        if (!authorizationService.validateAdminRole(user)) {
            System.out.println("User is not allowed to perform this action");
            return;
        }
        survey.addQuestion(question);
    }

    public float calculateOverallRating(User user, Survey survey) {
        if (!authorizationService.validateAdminRole(user)) {
            System.out.println("User is not allowed to perform this action");
            return -1;
        }

        List<Response> responseList = this.surveyResponseMap.get(survey.surveyId);
        Integer totalRating = 0;

        for (Response response : responseList) {
            totalRating += response.question.options.get(response.answer);
        }

        return (float)totalRating/ (float)responseList.size();
    }

    public float calculateOverallRatingByQuestion(User user, Question question) {
        if (!authorizationService.validateAdminRole(user)) {
            System.out.println("User is not allowed to perform this action");
            return -1;
        }

        List<Response> responseList = this.questionResponseMap.get(question.questionId);
        Integer totalRating = 0;
        for (Response response : responseList) {
            totalRating += response.question.options.get(response.answer);
        }

        return (float)totalRating/ (float)responseList.size();
    }

    public void submitResponse(User user, Question question, String answer, Survey survey) {
        if (!authorizationService.validateUserRole(user)) {
            System.out.println("User is not allowed to perform this action");
            return;
        }

        if (!question.options.containsKey(answer)) {
            System.out.println("Invalid answer");
            return;
        }

        Response response = new Response(user, question, answer);

        // Adding into survey map
        if (surveyResponseMap.containsKey(survey.surveyId)) {
            surveyResponseMap.get(survey.surveyId).add(response);
        } else  {
            List<Response> responses = new ArrayList<>();
            responses.add(response);
            surveyResponseMap.put(survey.surveyId, responses);
        }

        // Adding into question map
        if (questionResponseMap.containsKey(question.questionId)) {
            questionResponseMap.get(question.questionId).add(response);
        } else  {
            List<Response> responses = new ArrayList<>();
            responses.add(response);
            questionResponseMap.put(question.questionId, responses);
        }
    }
}
