package Feedback_System.service.impl;

import Feedback_System.model.Batch;
import Feedback_System.model.User;
import Feedback_System.repository.impl.BatchRepoImpl;
import Feedback_System.service.BatchService;

import java.util.List;

public class BatchServiceImpl implements BatchService {
    BatchRepoImpl batchRepo = new BatchRepoImpl();

    @Override
    public String assignBatch(String batchName, String studentPhone, String adminPhone, UserServiceImpl userService) {
        User admin = userService.findAdminByPhone(adminPhone);
        if (admin != null) {
            User isStudent = userService.findStudentByPhone(studentPhone);
            if (isStudent != null) {
                Batch batchExists = batchRepo.findBatch(batchName);
                if (batchExists != null) {
                    List<User> studentData = userService.getStudentDetailsByPhone(studentPhone);
                    System.out.println(studentData);
                    Batch batch = new Batch(batchName, studentData);
                    batchRepo.saveBatchWithStudent(batch);
                    return "Student name : " + isStudent.getUsername() + " assigned a batch : " + batchName;
                } else {
                    return "Batch not found";
                }
            } else {
                return "Student Does not enrolled";
            }
        } else {
            return "You are not authorized for this action";
        }
    }

    @Override
    public String createBatch(String adminPhone, String batchName, UserServiceImpl studentService) {
        User isAdmin = studentService.findAdminByPhone(adminPhone);
        if (isAdmin != null) {
            String adminName = isAdmin.getUsername();
            Batch batch = new Batch(batchName, adminName);
            batchRepo.addNewBatch(batch);
            System.out.println(" Batch created Success");
            return "Batch name : " + batchName;
        } else {
            return "You are not authorized for this action";
        }
    }

    @Override
    public Batch findStudentInBatchByPhone(String batchName, String studentPhone) {
        List<Batch> batches = batchRepo.findStudentInBatch();
        for (Batch batch : batches) {
            if (batch.getBatchName().equals(batchName)) {
                List<User> batchList = batch.getStudents();
                for (User batch1 : batchList) {
                    if (batch1.getPhone().equals(studentPhone)) {
                        return batch;
                    }
                }
            }

        }
        return null;
    }


    @Override
    public Batch findBatchByBatchName(String batchName) {
        return batchRepo.findBatch(batchName);
    }

    @Override
    public void getListOfBatch() {
        List<Batch> batchList  =  batchRepo.listOfBatch();
        System.out.println("List of Batches : ");
        for (Batch batch : batchList) {
            System.out.println(batch.getBatchName());
        }
    }


}
