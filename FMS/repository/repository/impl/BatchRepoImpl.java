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
    public Batch findBatch(String batchName) {
        for (Batch batch: batches) {
            if (batch.getBatchName().equals(batchName)) {
                return batch;
            }
        }
        return null;
    }

    @Override
    public List<Batch> findStudentInBatch() {

        return batchWithStudent;
    }

    @Override
    public List<Batch> listOfBatch() {

        return batches;
    }

//  added by prince
//    @Override
//    public String getBatchByUsernameAndPassword(String username, String password) {
//        for (Batch batch : batches) {
//            if (batch.getStudentPhone().equals(username) && batch.getBatchName().equals(password)) {
//                String batchname = batch.getBatchName();
//                return batchname;
//            }
//        }
//        return null;
//    }



// added by prince
//    public void showMyBatchmates(String username, String password) {
//
//        String batchname = getBatchByUsernameAndPassword(username , password);
//        for (Batch batch : batches) {
//            if (batch.getBatchName().equals(batchname)) {
//                System.out.println(batch.getStudentName());
//            }
//        }
//    }
}
