package Feedback_System.controller;

import Feedback_System.model.Batch;
import Feedback_System.model.User;
import Feedback_System.service.impl.BatchServiceImpl;
import Feedback_System.service.impl.FeedbackServiceImpl;
import Feedback_System.service.impl.QuestionServiceImpl;
import Feedback_System.service.impl.UserServiceImpl;

import java.util.List;

public class UserController {
    UserServiceImpl userService = new UserServiceImpl();
    BatchServiceImpl batchService = new BatchServiceImpl();
    QuestionServiceImpl questionService = new QuestionServiceImpl();
    FeedbackServiceImpl feedbackService = new FeedbackServiceImpl();


    public String signUp(String username, String password, String phone, String role) {
        return userService.signUp(username, password, phone, role);
    }

    public String signIn(String username, String pass) {
        return userService.getUser(username, pass);
    }

    public List<User> userList() {
        return userService.userList();
    }
    public String assignBatch(String batchName, String studentPhone, String adminPhone){
        return batchService.assignBatch(batchName, studentPhone,adminPhone, userService);
    }
    public String createQuestion(String batchName,  String adminPhone) {
        return questionService.createQuestion(batchName, adminPhone, userService, batchService);
    }
    public void questionList(){
        questionService.list();
    }

    public String deleteQuestion(String qId,String batch, String adminPhone) {
        return questionService.deleteQuestion(qId,batch, adminPhone, userService, batchService, feedbackService);
    }
    public String updateQuestion(String qId,String batch, String adminPhone) {
        return questionService.updateQuestion(qId,batch, adminPhone, userService, batchService);
    }
    public String submitFeedback(String studentPhone, String batchName) {
        return feedbackService.submitFeedback(studentPhone, batchName,batchService,questionService);
    }
    public void feedbackList(){
        feedbackService.feedbackList();
    }
    public String feedbackByBatch(String adminPhone, String batch){
        return feedbackService.feedbackByBatch(adminPhone,batch,batchService, userService);
    }
    public String individualFeedback(String adminPhone, String studentPhone){
        return feedbackService.individualFeedback(adminPhone,studentPhone, userService);
    }
    public void listWithQid(){
        questionService.listWithQid();
    }
    public String createBatch(String adminPhone, String batchName) {
        return batchService.createBatch(adminPhone,batchName, userService);
    }

    public void listOfBatches() {
        batchService.getListOfBatch();
    }

}
