package Feedback_System.service;

import Feedback_System.model.Batch;
import Feedback_System.model.User;
import Feedback_System.service.impl.BatchServiceImpl;

import java.util.List;

public interface UserService {
    boolean signUp(String username, String password, String phone, String role);


    boolean getUser(String username, String pass);
    List<User> userList();
    Batch findStudentByBatch(String studentPhone, String batchName, BatchServiceImpl batchService);
    User findAdminByPhone(String adminPhoneNumber);

    User findStudentByPhone(String studentPhone);
    List<User> getStudentDetailsByPhone(String studentPhone);

    String findPhoneByPassword(String password);

    String findRoleByPhoneNumber(String phoneNumber);
    String findUsernameByPhoneNumber(String phoneNumber);

    int isPhoneExist(String phoneNumber, String username);
}
