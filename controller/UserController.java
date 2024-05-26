package Feedback_System.controller;

import Feedback_System.model.User;
import Feedback_System.service.impl.BatchServiceImpl;
import Feedback_System.service.impl.FeedbackServiceImpl;
import Feedback_System.service.impl.QuestionServiceImpl;
import Feedback_System.service.impl.UserServiceImpl;

import java.util.List;

public class UserController {
    UserServiceImpl studentService = new UserServiceImpl();
    BatchServiceImpl batchService = new BatchServiceImpl();
    QuestionServiceImpl questionService = new QuestionServiceImpl();
    FeedbackServiceImpl feedbackService = new FeedbackServiceImpl();


    public String signUp(String username, String password, String phone, String role) {
        return studentService.signUp(username, password, phone, role);
    }

    public String signIn(String username, String pass) {
        return studentService.getUser(username, pass);
    }

    public List<User> userList() {
        return studentService.userList();
    }
    public String assignBatch(String batchName, String studentPhone, String role, String adminPhone){
        return batchService.assignBatch(batchName, studentPhone,role,adminPhone,studentService);
    }
    public String createQuestion(String batchName,  String adminPhone) {
        return questionService.createQuestion(batchName, adminPhone, studentService, batchService);
    }
    public void questionList(){
        questionService.list();
    }

    public String deleteQuestion(String qId,String batch, String adminPhone) {
        return questionService.deleteQuestion(qId,batch, adminPhone, studentService, batchService, feedbackService);
    }
    public String updateQuestion(String qId,String batch, String adminPhone) {
        return questionService.updateQuestion(qId,batch, adminPhone, studentService, batchService);
    }
    public String submitFeedback(String studentPhone, String batchName) {
        return feedbackService.submitFeedback(studentPhone, batchName, studentService,batchService,questionService);
    }
    public void feedbackList(){
         feedbackService.feedbackList();
    }
    public String feedbackByBatch(String batch){
        return feedbackService.listOfFeedbackByBatch(batch,batchService);
    }
    public String feedbackByBatchToAdmin(String adminPhone, String batch){
        return feedbackService.feedbackByBatchToAdmin(adminPhone,batch,batchService,studentService);
    }
    public String individualFeedback(String adminPhone, String studentPhone){
        return feedbackService.individualFeedback(adminPhone,studentPhone,studentService);
    }
    public void listWithQid(){
        questionService.listWithQid();
    }
    public String createBatch(String adminPhone, String batchName) {
        return batchService.createBatch(adminPhone,batchName,studentService);
    }

}
