package Feedback_System.service;

import Feedback_System.service.impl.BatchServiceImpl;
import Feedback_System.service.impl.QuestionServiceImpl;
import Feedback_System.service.impl.UserServiceImpl;

public interface FeedbackService {

    String submitFeedback(String studentPhone, String batchName, BatchServiceImpl batchService, QuestionServiceImpl questionService);
    void feedbackList();
    String feedbackByBatch(String adminPhone, String batch, BatchServiceImpl batchService, UserServiceImpl user);

    String individualFeedback(String adminPhone, String studentPhone, UserServiceImpl studentService);
}
