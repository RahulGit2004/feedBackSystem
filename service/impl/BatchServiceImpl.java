package Feedback_System.service.impl;

import Feedback_System.model.Batch;
import Feedback_System.model.User;
import Feedback_System.repository.impl.BatchRepoImpl;
import Feedback_System.service.BatchService;

public class BatchServiceImpl implements BatchService {
    BatchRepoImpl batchRepo = new BatchRepoImpl();

    @Override
    public String assignBatch(String batchName, String studentPhone, String role, String adminPhone, UserServiceImpl studentService) {
        User admin = studentService.studentRepo.checkAdminByPhone(adminPhone);
        if (admin != null) {
            User isStudent = studentService.studentRepo.existsStudent(studentPhone);
            if (isStudent != null) {
                Batch batchExists = batchRepo.checkBatch(batchName);
                if (batchExists != null) {
                    Batch batch = new Batch(batchName, studentPhone);
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
        User isAdmin = studentService.studentRepo.checkAdminByPhone(adminPhone);
        // need student phone and batch in pair then save.
        if (isAdmin != null) {
            Batch batch = new Batch(batchName);
            batchRepo.addNewBatch(batch);

            return batchName+"   Batch created Success";
        } else {
            return "You are not authorized for this action";
        }
    }
}
