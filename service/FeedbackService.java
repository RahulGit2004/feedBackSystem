package Feedback_System.service;

import Feedback_System.service.impl.BatchServiceImpl;
import Feedback_System.service.impl.QuestionServiceImpl;
import Feedback_System.service.impl.UserServiceImpl;

public interface FeedbackService {

    String submitFeedback(String studentPhone, String batchName, UserServiceImpl studentService, BatchServiceImpl batchService, QuestionServiceImpl questionService);
    void feedbackList();

    String listOfFeedbackByBatch( String batch, BatchServiceImpl batchService);

    String feedbackByBatchToAdmin(String adminPhone, String batch, BatchServiceImpl batchService, UserServiceImpl student);

    String individualFeedback(String adminPhone, String studentPhone, UserServiceImpl studentService);
}
