package Feedback_System.service;

import Feedback_System.model.Batch;
import Feedback_System.service.impl.BatchServiceImpl;
import Feedback_System.service.impl.UserServiceImpl;

import java.util.List;

public interface BatchService {
    String assignBatch(String batchName, String studentPhone, String adminPhone, UserServiceImpl studentService);

    String createBatch(String adminPhone, String batchName, UserServiceImpl studentService);

    //    void showMyBatchmates(String username, String password);
    Batch findStudentInBatchByPhone (String batchName, String studentPhone);
    Batch findBatchByBatchName(String batchName);

    List getListOfBatch();

    String findBatchByUsernameAndPassword(String username, String password);

    List showBatchMates(String username, String password);

    boolean madeBatch(String batchName,String username);

    boolean existsBatch(String batchNameForAssign);

    void listOfStudentByBatchName(String batchName);

    String deleteBatch(String adminPhone, String batchName, UserServiceImpl userService, BatchServiceImpl batchService);

    boolean isBatchExists();
}
