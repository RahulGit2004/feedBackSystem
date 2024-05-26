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

//    @Override
//    public String submitFeedback(String studentPhone, String batchName, StudentServiceImpl studentService, BatchServiceImpl batchService, QuestionServiceImpl questionService) {
//        UserStudent student = studentService.studentRepo.existsStudent(studentPhone);
//        if (student != null) {
//            questionService.listWithQid();
//            List<FeedbackQuestion> questionList = questionService.questionRepo.questionListByBatch(batchName);
//            for (FeedbackQuestion fb : questionList) {
//                Scanner sc = new Scanner(System.in);
//                System.out.println("Enter Question Id : ");
//                String qId = sc.nextLine();
//
//                FeedbackQuestion checkQuid = questionService.questionRepo.isCorrectQid(qId);
//                if (checkQuid != null) {
//                    System.out.println("Enter feedback for question no : " + qId);
//                    String feedbackDetails = sc.nextLine();
////                    String isFeedback = feedbackRepo.isAlreadyFeedback(studentPhone,qId);
////                    if (isFeedback.equals("Continue")) {
//                    StudentFeedback feedback = new StudentFeedback(feedbackDetails, batchName, studentPhone, qId);
//                    feedbackRepo.saveFeedback(feedback);
//                    System.out.println("Thanks for giving feedback for question id : " + qId);
////                    }
//                } else {
//                    return "Invalid Question Id";
//                }
//            }
//            return "All question Answered";
//        }
//        return "Student does not exists";
//    }

    @Override
    public String submitFeedback(String studentPhone, String batchName, UserServiceImpl studentService, BatchServiceImpl batchService, QuestionServiceImpl questionService) {
        //
        Batch isStudent = studentService.findStudentByBatch(studentPhone, batchName, batchService); // giving null
        if (isStudent != null) {
            // loop use karna hai // generating issue is loop is not updating because questionByBatch is giving one qId only
            Scanner sc = new Scanner(System.in);
            List<FeedbackQuestion> questionsList = questionService.questionRepo.questionList();
            for (FeedbackQuestion question : questionsList) {
                if (question.getBatchName().equals(batchName)) {
                    System.out.println(question.getQuestion());
                    String qId = question.getQuestionId();
                    boolean isFeedback = feedbackRepo.isAlreadyFeedback(studentPhone,qId);
                    if (isFeedback) {
                        System.out.println("Enter Your Feedback of Above Question : ");
                        String feedback = sc.nextLine();
                        StudentFeedback feedbackQuestion = new StudentFeedback(feedback, batchName, studentPhone, qId);
                        feedbackRepo.saveFeedback(feedbackQuestion);
                        System.out.println("Thanks for Your Valuable Feedback");
                    }
                    else {
                        System.out.println("Feedback already Provided going To the Next one");
                }
                }
            }
        }
        else {
            return "Student not found";
        }
        return "";

    }

    @Override
    public void feedbackList() {
        List<StudentFeedback> lists = feedbackRepo.feedbackList();
        for (StudentFeedback feedback : lists) {
            System.out.println("Question No : "+feedback.getFeedbackQid()+"  answer is : "+feedback.getFeedbackDetials());
        }

    }

    @Override
    public String listOfFeedbackByBatch( String batch, BatchServiceImpl batchService) {
        Batch batch1 = batchService.batchRepo.checkBatch(batch);
        // null pointer exception
        if (batch1 != null) {
            System.out.println("Feedback Provided By Students in Batch : " + batch);
            feedbackRepo.feedbackListByBatch(batch);
            return "";
        }
        else {
            return "Batch not found";
        }
    }

    @Override
    public String feedbackByBatchToAdmin(String adminPhone, String batch, BatchServiceImpl batchService, UserServiceImpl student) {
        User isAdmin = student.studentRepo.checkAdminByPhone(adminPhone);
        if (isAdmin != null) {
            Batch batch1 = batchService.batchRepo.checkBatch(batch);
            if (batch1 != null) {
                System.out.println("Feedback Provided By Students in Batch : " + batch);
                feedbackRepo.feedbackListByBatch(batch);
                return "";

            } else {
                return "Batch not Found";
            }
        }
        return "You are not authorized for this action";

    }

    @Override
    public String individualFeedback(String adminPhone, String studentPhone, UserServiceImpl studentService) {
        User isAdmin = studentService.studentRepo.checkAdminByPhone(adminPhone);
        if (isAdmin != null) {
            User isStudent = studentService.studentRepo.existsStudent(studentPhone);
            if (isStudent != null) {
                System.out.println("Feedback Provided By : " + isStudent.getUsername());
                feedbackRepo.feedbackByPhone(studentPhone);
                return "";

            } else {
                return "Student Not found";
            }

        } else {
            return "You are not Authorized for this action";
        }

    }

}
