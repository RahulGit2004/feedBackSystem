package Feedback_System.repository;

import Feedback_System.model.Batch;

import java.util.List;

public interface BatchRepo {
    Batch addNewBatch(Batch batch);
    Batch saveBatchWithStudent(Batch batch);
    Batch findBatch(String batchName);
    //    Batch isStudentByBatch(String batchName, String studentPhone);
    List findStudentInBatch();

    List<Batch> listOfBatch();

//    String  getBatchByUsernameAndPassword(String username, String password);


//    void showMyBatchmates(String username, String password);
}
