package Feedback_System.service.impl;

import Feedback_System.model.Batch;
import Feedback_System.model.FeedbackQuestion;
import Feedback_System.model.StudentFeedback;
import Feedback_System.model.User;
import Feedback_System.repository.impl.FeedbackRepoImpl;
import Feedback_System.service.FeedbackService;

import java.util.List;
import java.util.Scanner;

public class FeedbackServiceImpl implements FeedbackService {
    FeedbackRepoImpl feedbackRepo = new FeedbackRepoImpl();

    @Override
    public String submitFeedback(String studentPhone, String batchName, BatchServiceImpl batchService, QuestionServiceImpl questionService) {
        Batch studentInBatch = batchService.findStudentInBatchByPhone(batchName, studentPhone);
        if (studentInBatch != null) {
            Scanner sc = new Scanner(System.in);
            List<FeedbackQuestion> questionsList = questionService.listOfQuestion();
            for (FeedbackQuestion question : questionsList) {
                if (question.getBatchName().equals(batchName)) {
                    System.out.println(question.getQuestion());
                    String qId = question.getQuestionId();
                    System.out.println("Enter Your Feedback of Above Question : ");
                    String feedback = sc.nextLine();
                    StudentFeedback feedbackQuestion = new StudentFeedback(feedback, batchName, studentPhone, qId);
                    feedbackRepo.saveFeedback(feedbackQuestion);
                    System.out.println("Thanks for Your Valuable Feedback");
                }
            }
        } else {
            return "Student not found";
        }
        return "";
    }

    @Override
    public void feedbackList() { // need to be change
        List<StudentFeedback> lists = feedbackRepo.feedbackList();
        for (StudentFeedback feedback : lists) {
            System.out.println("Question No : " + feedback.getFeedbackQid() + "  answer is : " + feedback.getFeedbackDetails());
        }
    }

    @Override
    public String feedbackByBatch(String adminPhone, String batchName, BatchServiceImpl batchService, UserServiceImpl user) {
        User admin = user.findAdminByPhone(adminPhone);
        if (admin != null) {
            Batch batch = batchService.findBatchByBatchName(batchName);
            if (batch != null) {
                System.out.println("Feedback Provided By Students in Batch : " + batchName);
                List<StudentFeedback> feedbacksList = feedbackRepo.feedbackList();
                for (StudentFeedback feedback : feedbacksList) {
                    if (feedback.getBatchName().equals(batchName)) {
                        System.out.println(feedback.getStudentPhone() + " is provided feedback is : " + feedback.getFeedbackDetails());
                    }
                }
            } else {
                return "Batch not Found";
            }
        }
        else {
            return "You are not authorized for this action";
        }
        return "";
    }

    @Override
    public String individualFeedback(String adminPhone, String studentPhone, UserServiceImpl studentService) {
        User isAdmin = studentService.userRepo.findAdminByPhone(adminPhone);
        if (isAdmin != null) {
            User isStudent = studentService.userRepo.findStudentByPhone(studentPhone);
            if (isStudent != null) {
                System.out.println("Feedback Provided By : " + isStudent.getUsername());
                feedbackRepo.feedbackByPhonenumber(studentPhone);
                return "";

            } else {
                return "Student Not found";
            }

        } else {
            return "You are not Authorized for this action";
        }

    }

}
