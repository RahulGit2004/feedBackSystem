package Feedback_System.service;

import Feedback_System.model.FeedbackQuestion;
import Feedback_System.service.impl.BatchServiceImpl;
import Feedback_System.service.impl.FeedbackServiceImpl;
import Feedback_System.service.impl.UserServiceImpl;

import java.util.List;

public interface QuestionService {
    String createQuestion(String batchName, String adminPhone, UserServiceImpl studentService, BatchServiceImpl batchService);
    List<FeedbackQuestion> list();

    String deleteQuestion(String qId, String batch, String adminPhone, UserServiceImpl service, BatchServiceImpl batchService, FeedbackServiceImpl feedbackService);

    String updateQuestion(String qId, String batch, String adminPhone, UserServiceImpl studentService, BatchServiceImpl batchService);

    void listWithQid();


}
