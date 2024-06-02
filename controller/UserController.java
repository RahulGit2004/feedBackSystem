package Feedback_System.controller;

import Feedback_System.model.Batch;
import Feedback_System.model.FeedbackQuestion;
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


    public boolean signUp(String username, String password, String phone, String role) {
        return userService.signUp(username, password, phone, role);
    }

    public boolean signIn(String username, String pass) {
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
    public List<String> listOfQuestion(){
        return questionService.questionList();
    }
    public void listOfQuestionByBatch(String batch) {
        questionService.listOfQuestionByBatch(batch,batchService);
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
//    public void feedbackList(){
//        feedbackService.feedbackList(questionService);
//    }
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

    public List<Batch> listOfBatches() {
        return batchService.getListOfBatch();
    }

    public String getPhoneByPassword(String password) {
        return userService.findPhoneByPassword(password);
    }

    public String findRoleByPhoneNumber(String phoneNumber) {
        return userService.findRoleByPhoneNumber(phoneNumber);
    }

    public String getYourBatch(String username, String password) {
        return batchService.findBatchByUsernameAndPassword(username,password);
    }

    public List myBatchMates(String username, String password) {
        return batchService.showBatchMates(username,password);
    }

    public boolean madeBatch(String batchName, String username) {
        return batchService.madeBatch(batchName,username);
    }
    public boolean existsBatch(String batchName){
        return batchService.existsBatch(batchName);
    }

    public void listOfStudentByBatch(String batchName) {
        batchService.listOfStudentByBatchName(batchName);
    }
    public String deleteBatch(String adminPhone, String batchName) {
        return batchService.deleteBatch(adminPhone, batchName,userService,batchService);
    }

    public boolean isBatchExists() {
        return batchService.isBatchExists();
    }


    public int isPhoneExist(String phoneNumber, String username) {
        return userService.isPhoneExist(phoneNumber , username);
    }
}
