package Feedback_System.service;

import Feedback_System.model.Batch;
import Feedback_System.model.User;
import Feedback_System.service.impl.BatchServiceImpl;

import java.util.List;

public interface UserService {
    String signUp(String username, String password, String phone, String role);


    String getUser(String username, String pass);
    List<User> userList();
    Batch findStudentByBatch(String studentPhone, String batchName, BatchServiceImpl batchService);
}
