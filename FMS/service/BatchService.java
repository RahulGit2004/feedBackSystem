package Feedback_System.service;

import Feedback_System.model.Batch;
import Feedback_System.service.impl.UserServiceImpl;

public interface BatchService {
    String assignBatch(String batchName, String studentPhone, String adminPhone, UserServiceImpl studentService);

    String createBatch(String adminPhone, String batchName, UserServiceImpl studentService);

    //    void showMyBatchmates(String username, String password);
    Batch findStudentInBatchByPhone (String batchName, String studentPhone);
    Batch findBatchByBatchName(String batchName);

    void getListOfBatch();
}
