package Feedback_System.repository;

import Feedback_System.model.FeedbackQuestion;

import java.util.List;

public interface QuestionRepo {
    FeedbackQuestion saveQuestions(FeedbackQuestion feedbackQuestion);

    List<FeedbackQuestion> questionList();

    FeedbackQuestion isAvailable(String qId, String batchName);

    FeedbackQuestion isCorrectQid(String qId);

    void deleteQuestion(String qId);

    void updateQuestion(String qId, String batch, String updatedQuestion);

    List<FeedbackQuestion> questionListAndQid();
}
