package Feedback_System.repository;

import Feedback_System.model.StudentFeedback;

import java.util.List;

public interface FeedbackRepo {
    StudentFeedback saveFeedback(StudentFeedback feedback);

    List<StudentFeedback>  feedbackList();
    //    boolean alreadyFeedbackProvidedByStudent(String phone, String qId);
//    List feedbackListByBatch(String batch);
    void feedbackByPhonenumber(String studentPhone);
    StudentFeedback deleteFeedbackByBatch(String studentPhone);

}
