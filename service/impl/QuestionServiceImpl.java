package Feedback_System.service.impl;

import Feedback_System.model.Batch;
import Feedback_System.model.FeedbackQuestion;
import Feedback_System.model.User;
import Feedback_System.repository.repository.impl.QuestionRepoImpl;
import Feedback_System.service.QuestionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestionServiceImpl implements QuestionService {
    QuestionRepoImpl questionRepo = new QuestionRepoImpl();


    @Override
    public String createQuestion(String batchName, String adminPhone, UserServiceImpl userService, BatchServiceImpl batchService) {
        Batch batch = batchService.findBatchByBatchName(batchName);
        if (batch != null) {
            User admin = userService.findAdminByPhone(adminPhone);
            if (admin != null) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Question is about to create of batch : " + batchName);
                System.out.println("Enter your Question Id : ");
                String qid = sc.nextLine();
                // problem :- if different batch have same qId then it can not to create me question.(solved)
                FeedbackQuestion question = questionRepo.findQuestionIdByBatch(qid, batchName);
                if (question == null) {
                    System.out.println("Enter your Question for batch : " + batchName);
                    String questionName = sc.nextLine();
                    FeedbackQuestion feedbackQuestion = new FeedbackQuestion(qid, questionName, batchName); // review here
                    questionRepo.saveQuestions(feedbackQuestion);
                    return "Question Saved";
                } else {
                    return "Question Id Already Present In Question List.";
                }
            } else {
                return "You are not able to do this action";
            }

        } else {
            return "Batch not Found";
        }
    }

    @Override
    public List<String> questionList() {
        List<FeedbackQuestion> questions = questionRepo.questionList();
        List<String>  questionList = new ArrayList<>();
        for (FeedbackQuestion question : questions) {
            if (question.getFlag()) {
                questionList.add(question.getQuestion());
            }
        }
        return questionList;
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
        List<FeedbackQuestion> questions = questionRepo.questionList();
        if (questions != null) {
            return questions;
        } else {
            return null;
        }
    }

    @Override
    public void listOfQuestionByBatch(String batch, BatchServiceImpl batchService) {
        boolean batch1 = batchService.existsBatch(batch);
        if (batch1) {
            List<FeedbackQuestion> questionList = questionRepo.questionList();
            if (questionList.isEmpty()) {
                System.out.println("There is no question available!!");
            } else {
                System.out.println("Question List From Batch :- " + batch);
                for (FeedbackQuestion question : questionList) {
                    boolean active = question.getFlag();
                    if (active) {     // done active
                        if (question.getBatchName().equals(batch)) {
                            System.out.println(question.getQuestion());
                        }
                    }
                }
            }
        } else {
            System.out.println("Batch Not Found!!");
        }
    }

    @Override
    public String deleteQuestion(String qId, String batchName, String adminPhone, UserServiceImpl userService, BatchServiceImpl batchService, FeedbackServiceImpl feedbackService) {
        User admin = userService.findAdminByPhone(adminPhone);
        if (admin != null) {
            Batch batch = batchService.findBatchByBatchName(batchName);
            if (batch != null) {
                FeedbackQuestion question = questionRepo.questionInBatch(qId, batchName);
                boolean active = question.getFlag();
                if (active) {
                    questionRepo.deleteQuestion(qId,batchName); // feedback should not be deleted(work is on repo check there)
                    feedbackService.deleteFeedbackByBatch(batchName,qId); // this will have to be changed.
                    return "question deleted from batch : " + batchName;
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
        User isAdmin = studentService.findAdminByPhone(adminPhone);
        if (isAdmin != null) {
            Batch batch1 = batchService.findBatchByBatchName(batch);
            if (batch1 != null) {
                String batch2 = batch1.getBatchName();
                FeedbackQuestion question = questionRepo.questionInBatch(qId, batch2);
                boolean flag = question.getFlag();
                if (flag) {  // I do it on update question (have to do same for everything related to question)
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
