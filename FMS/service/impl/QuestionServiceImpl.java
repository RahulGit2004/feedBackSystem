package Feedback_System.service.impl;

import Feedback_System.model.Batch;
import Feedback_System.model.FeedbackQuestion;
import Feedback_System.model.User;
import Feedback_System.repository.impl.QuestionRepoImpl;
import Feedback_System.service.QuestionService;

import java.util.List;
import java.util.Scanner;

public class QuestionServiceImpl implements QuestionService {
    QuestionRepoImpl questionRepo = new QuestionRepoImpl();


    @Override
    public String createQuestion(String batchName, String adminPhone, UserServiceImpl studentService, BatchServiceImpl batch) {
        Batch checked = batch.findBatchByBatchName(batchName);
        if (checked != null) {
            User admin = studentService.findAdminByPhone(adminPhone);
            if (admin != null) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Question is about to create of batch : "+batchName);
                System.out.println("Enter your Question Id : ");
                String qid = sc.nextLine();
                System.out.println("Enter your Question for batch : " + batchName);
                String question = sc.nextLine();
                FeedbackQuestion feedbackQuestion = new FeedbackQuestion(qid, question, batchName); // review here
                questionRepo.saveQuestions(feedbackQuestion);
                return "Question Saved";
            } else {
                return "You are not able to do this action";
            }

        } else {
            return "Batch not Found";
        }
    }

    @Override
    public List<FeedbackQuestion> list() {
        List<FeedbackQuestion> lists = questionRepo.questionList();
        for (FeedbackQuestion feedbackQuestion : lists) {
            System.out.println(feedbackQuestion.getQuestion());
        }
        return lists;
    }

    @Override
    public void listWithQid() {
        List<FeedbackQuestion> lists = questionRepo.questionList();
        for (FeedbackQuestion feedbackQuestion : lists) {
            System.out.println(feedbackQuestion.getQuestion() + "  question id  : " + feedbackQuestion.getQuestionId());
        }
    }

    @Override
    public List<FeedbackQuestion> listOfQuestion() {
        return questionRepo.questionList();
    }


    @Override
    public String deleteQuestion(String qId, String batchName, String adminPhone, UserServiceImpl userService, BatchServiceImpl batchService, FeedbackServiceImpl feedbackService) {
        User admin = userService.findAdminByPhone(adminPhone);
        if (admin != null) {
            Batch batch = batchService.findBatchByBatchName(batchName);
            if (batch != null) {
                String batch1 = batch.getBatchName();
                FeedbackQuestion question = questionRepo.questionInBatch(qId, batch1);
                if (question != null) {
                    questionRepo.deleteQuestion(qId); // feedback should not be deleted.
                    feedbackService.feedbackRepo.deleteFeedbackByBatch(batch1); // this will have to be changed.
                    return "question deleted from batch : " + batch1;
                } else {
                    return "Question not found";
                }
            } else {
                return "Batch not found";
            }

        } else {
            return "Admin not Found";
        }
    }

    @Override
    public String updateQuestion(String qId, String batch, String adminPhone, UserServiceImpl studentService, BatchServiceImpl batchService) {
        User isAdmin = studentService.userRepo.findAdminByPhone(adminPhone);
        if (isAdmin != null) {
            Batch batch1 = batchService.findBatchByBatchName(batch);
            if (batch1 != null) {
                String batch2 = batch1.getBatchName();
                FeedbackQuestion question = questionRepo.questionInBatch(qId, batch2);
                if (question != null) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter a Question to update");
                    String updatedQuestion = sc.nextLine();
                    questionRepo.updateQuestion(qId, batch, updatedQuestion);
                    return "Question updated for Batch : " + batch;
                } else {
                    return "Question not found!";
                }
            } else {
                return "Batch not found";
            }
        }

        return "admin not Found";
    }
}
