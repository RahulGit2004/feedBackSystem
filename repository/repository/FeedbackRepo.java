package Feedback_System.repository;

import Feedback_System.model.StudentFeedback;

import java.util.List;

public interface FeedbackRepo {
    StudentFeedback saveFeedback(StudentFeedback feedback);
    StudentFeedback saveFeedback2(StudentFeedback feedback);
    List<StudentFeedback>  feedbackList();
    boolean isAlreadyFeedback(String phone,String qId);
    void feedbackListByBatch(String batch);
    void feedbackByPhone(String studentPhone);
    StudentFeedback deleteFeedbackByBatch(String studentPhone);

}
