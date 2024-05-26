package Feedback_System.repository.impl;

import Feedback_System.model.Batch;
import Feedback_System.model.StudentFeedback;
import Feedback_System.repository.FeedbackRepo;

import java.util.ArrayList;
import java.util.List;

public class FeedbackRepoImpl implements FeedbackRepo {
    List<StudentFeedback> feedbackList = new ArrayList<>();
    List<StudentFeedback> feedbackList2 = new ArrayList<>();

    @Override
    public StudentFeedback saveFeedback(StudentFeedback feedback) {
        feedbackList.add(feedback);
        return feedback;
    }

    @Override
    public StudentFeedback saveFeedback2(StudentFeedback feedback) {
        feedbackList2.add(feedback);
        return feedback;
    }

    @Override
    public List<StudentFeedback> feedbackList() {
        return feedbackList;
    }

    @Override
    public boolean isAlreadyFeedback(String phone, String qId) {
        for (StudentFeedback feedback: feedbackList) {
            if (feedback.getStudentPhone().equals(phone) && feedback.getFeedbackQid().equals(qId)){
                return false;
            }
        }
        return true;
    }

    @Override
    public void feedbackListByBatch(String batch) {
        for (StudentFeedback feedback: feedbackList) {
            if (feedback.getBatchName().equals(batch)) {
                System.out.println(feedback.getFeedbackDetials());
            }
        }

    }

    @Override
    public void feedbackByPhone(String studentPhone) {
        for (StudentFeedback feedback: feedbackList) {
            if (feedback.getStudentPhone().equals(studentPhone)) {
                System.out.println(feedback.getFeedbackDetials());
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
