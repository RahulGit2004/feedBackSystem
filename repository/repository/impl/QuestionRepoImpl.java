package Feedback_System.repository.impl;

import Feedback_System.model.FeedbackQuestion;
import Feedback_System.repository.QuestionRepo;

import java.util.ArrayList;
import java.util.List;

public class QuestionRepoImpl implements QuestionRepo {
    List<FeedbackQuestion> questionList = new ArrayList<>();

    @Override
    public FeedbackQuestion saveQuestions(FeedbackQuestion feedbackQuestion) {
        questionList.add(feedbackQuestion);
        return feedbackQuestion;
    }

    @Override
    public List<FeedbackQuestion> questionList() {
        return questionList;
    }

    @Override
    public FeedbackQuestion isAvailable(String qId, String batchName) {
        for (FeedbackQuestion question : questionList) {
            if (question.getQuestionId().equals(qId) && question.getBatchName().equals(batchName)) {
                return question;
            }
        }
        return null;
    }

    @Override
    public FeedbackQuestion isCorrectQid(String qId) {
        for (FeedbackQuestion question : questionList) {
            if (question.getQuestionId().equals(qId)) {
                return question;
            }
        }
        return null;
    }

    @Override
    public void deleteQuestion(String qId) {
        questionList.removeIf(question -> question.getQuestionId().equals(qId));
    }

    @Override
    public void updateQuestion(String qId, String batch, String updatedQuestion) {
        for (FeedbackQuestion question : questionList) {
            if (question.getBatchName().equals(batch) && question.getQuestionId().equals(qId)) {
                question.setQuestion(updatedQuestion);
            }
        }
    }

    @Override
    public List<FeedbackQuestion> questionListAndQid() {
        return questionList;
    }


}

