package Feedback_System.repository.impl;

import Feedback_System.model.StudentFeedback;
import Feedback_System.repository.FeedbackRepo;

import java.util.ArrayList;
import java.util.List;

public class FeedbackRepoImpl implements FeedbackRepo {
    List<StudentFeedback> feedbackList = new ArrayList<>();
    @Override
    public StudentFeedback saveFeedback(StudentFeedback feedback) {
        feedbackList.add(feedback);
        return feedback;
    }

    @Override
    public List<StudentFeedback> feedbackList() {
        return feedbackList;
    }

//    @Override
//    public boolean alreadyFeedbackProvidedByStudent(String phone, String qId) {
//        for (StudentFeedback feedback: feedbackList) {
//            if (feedback.getStudentPhone().equals(phone) && feedback.getFeedbackQid().equals(qId)){
//                return false;
//            }
//        }
//        return true;
//    }


    @Override
    public void feedbackByPhonenumber(String studentPhone) {
        for (StudentFeedback feedback: feedbackList) {
            if (feedback.getStudentPhone().equals(studentPhone)) {
                System.out.println(feedback.getFeedbackDetails());
            }
        }
    }

    @Override
    public StudentFeedback deleteFeedbackByBatch(String batch) {
        for (StudentFeedback feedback: feedbackList) {
            if (feedback.getBatchName().equals(batch)) {
                feedbackList.remove(feedback);
                return feedback;
            }
        }
        return null;
    }


}
