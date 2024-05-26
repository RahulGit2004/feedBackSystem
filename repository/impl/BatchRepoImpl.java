package Feedback_System.repository.impl;

import Feedback_System.model.Batch;
import Feedback_System.repository.BatchRepo;

import java.util.ArrayList;
import java.util.List;

public class BatchRepoImpl implements BatchRepo {

    List<Batch> batches = new ArrayList<>();
    List<Batch> batchWithStudent = new ArrayList<>();
    @Override
    public Batch addNewBatch(Batch batch) {
        batches.add(batch);
        return batch;
    }

    @Override
    public Batch saveBatchWithStudent(Batch batch) {
        batchWithStudent.add(batch);
        return batch;
    }

    @Override
    public Batch duplicateStudent(String studentPhone, String batchName) {
        for (Batch batch: batches){
            if (batch.getStudentPhone().equals(studentPhone) && batch.getBatchName().equals(batchName)){
                return batch;
            }
        }
        return null;
    }

    @Override
    public Batch checkBatch(String batchName) {
        for (Batch batch: batches) {
            if (batch.getBatchName().equals(batchName)) {
                return batch;
            }
        }
        return null;
    }

    @Override
    public Batch isStudentByBatch(String batchName, String studentPhone) {
        for (Batch isStudent : batchWithStudent) {
//            System.out.println(isStudent.getStudentPhone());
        if (isStudent.getBatchName().equals(batchName) && isStudent.getStudentPhone().equals(studentPhone)) {
                return isStudent;
            }

        }
        return null;
    }

}
