package Feedback_System.repository;

import Feedback_System.model.Batch;

public interface BatchRepo {
    Batch addNewBatch(Batch batch);
    Batch saveBatchWithStudent(Batch batch);
    Batch duplicateStudent(String studentPhone, String batchName);
    Batch checkBatch(String batchName);
    Batch isStudentByBatch(String batchName, String studentPhone);
}
