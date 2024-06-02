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
            // questionList null check is in process.
            List<FeedbackQuestion> questionsList = questionService.listOfQuestion();
            if (!questionsList.isEmpty()) {
                for (FeedbackQuestion question : questionsList) {
                    boolean active = question.getFlag();
                    if (active) {
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
                }
            } else {
                return "There is no Question Available!!";
            }
        } else {
            return "Student not found in batch";
        }
        return "";
    }

    @Override
    public String feedbackByBatch(String adminPhone, String batchName, BatchServiceImpl batchService, UserServiceImpl userService) {
        User admin = userService.findAdminByPhone(adminPhone);
        if (admin != null) {
            Batch batch = batchService.findBatchByBatchName(batchName);
            if (batch != null) {
                List<StudentFeedback> feedbacksList = feedbackRepo.feedbackList();
                if (!feedbacksList.isEmpty()) {
                    System.out.println("Feedback Provided By Students in Batch : " + batchName);
                    for (StudentFeedback feedback : feedbacksList) {
                        boolean active = feedback.getFlag();
                        if (active) {
                            // api need
                            if (feedback.getBatchName().equals(batchName)) {
                                String getUsername = userService.findUsernameByPhoneNumber(feedback.getStudentPhone());
                                System.out.println("Feedback Provided By : " + getUsername + " feedback Details --->  " + feedback.getFeedbackDetails());
                            }
                        }
                    }
                } else {
                    return "There is no Feedback Available!!";
                }
            } else {
                return "Batch not Found";
            }
        } else {
            return "You are not authorized for this action";
        }
        return "";
    }

    @Override
    public String individualFeedback(String adminPhone, String studentPhone, UserServiceImpl userService) {
        User admin = userService.findAdminByPhone(adminPhone);
        if (admin != null) {
            User student = userService.findStudentByPhone(studentPhone);
            if (student != null) {
                List<String> feedbacks = feedbackRepo.feedbackByPhoneNumber(studentPhone);
                if (!feedbacks.isEmpty()) {
                    System.out.println("Feedback Provided By : " + student.getUsername());
                    for (String list : feedbacks) {
                        System.out.println(list);
                    }
                    return "";
                } else {
                    return "There is no Feedbacks Available from Student  :-  " + student.getUsername();
                }

            } else {
                return "Student Not found";
            }

        } else {
            return "You are not Authorized for this action";
        }

    }

    @Override
    public boolean deleteFeedbackByBatch(String batchName, String qId) {
        StudentFeedback feedback = feedbackRepo.deleteFeedbackByBatch(batchName,qId);
        if (feedback != null) {
            return true;
        }
        return false;
    }

}
