package Feedback_System.service.impl;

import Feedback_System.model.Batch;
import Feedback_System.model.User;
import Feedback_System.repository.repository.impl.BatchRepoImpl;
import Feedback_System.service.BatchService;

import java.util.List;

public class BatchServiceImpl implements BatchService {
    BatchRepoImpl batchRepo = new BatchRepoImpl();

    @Override
    public String assignBatch(String batchName, String studentPhone, String adminPhone, UserServiceImpl userService) {
            User student = userService.findStudentByPhone(studentPhone);
            if (student != null) {
                Batch batchExists = batchRepo.findBatchByBatchName(batchName);
                if (batchExists != null) {
                    List<User> studentData = userService.getStudentDetailsByPhone(studentPhone);
                    Batch batch = new Batch(batchName, studentData);
                    batchRepo.saveBatchWithStudent(batch);
                    return "Student name : " + student.getUsername() + " is assigned in batch : " + batchName;
                } else {
                    return "Batch not found";
                }
            } else {
                return "Student Does not enrolled";
            }
    }

    @Override
    public String createBatch(String adminPhone, String batchName, UserServiceImpl studentService) {
        User admin = studentService.findAdminByPhone(adminPhone);
        if (admin != null) {
            String adminName = admin.getUsername();
            Batch batch = new Batch(batchName, adminName);
            boolean alreadyBatch = batchRepo.existsBatch(batchName);
            if (alreadyBatch) {
                return "Batch Already Exists!!";
            } else {
                batchRepo.addNewBatch(batch);
                System.out.println(" Batch created");
                return "Batch name : " + batchName;
            }
        } else {
            return "You are not authorized for this action";
        }
    }

    @Override
    public Batch findStudentInBatchByPhone(String batchName, String studentPhone) {
        List<Batch> batches = batchRepo.listOfBatchWithStudent();
        for (Batch batch : batches) {
            if (batch.getBatchName().equals(batchName)) {
                List<User> batchList = batch.getStudentsList();
                for (User batch1 : batchList) {
                    if (batch1.getPhoneNumber().equals(studentPhone)) {
                        return batch;
                    }
                }
            }
        }
        return null;
    }


    @Override
    public Batch findBatchByBatchName(String batchName) {
        return batchRepo.findBatchByBatchName(batchName);
    }

    @Override
    public List<Batch> getListOfBatch() {
        return batchRepo.listOfBatch();
    }

    @Override
    public String findBatchByUsernameAndPassword(String username, String password) {

//       List<Batch> batches = batchRepo.listOfBatchWithStudent();

//       for (Batch batch :batches) {
//           List<User> students = batch.getStudents();
//           for (User user : students) {
//               if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
//                   return batch.getBatchName();
//               }
//           }
//       }
 //
        return batchRepo.findBatchByUsernameAndPassword(username, password);
    }

    @Override
    public List showBatchMates(String username, String password) {  // not working Properly.(done)
//            List<Batch> batches = batchRepo.listOfBatchWithStudent();
//            for (Batch batch : batches) {
//                List<User> students =  batch.getStudents();
//                for (User user : students) {
//                    if (user.getPassword().equals(password) && user.getUsername().equals(username)) {
//                        System.out.println(user.getUsername());
//                    }
//                }
//            }
       String batchName = findBatchByUsernameAndPassword(username, password);
       return batchRepo.showBatchMates(batchName);
    }

    @Override
    public boolean madeBatch(String batchName, String username) {
        Batch batch = new Batch(batchName,username);
        batchRepo.addNewBatch(batch);
        return true;
    }

    @Override
    public boolean existsBatch(String batchName) {
//        Batch batch = batchRepo.existsBatch();
        return batchRepo.existsBatch(batchName);
    }

    @Override
    public void listOfStudentByBatchName(String batchName) {
        Batch batch = batchRepo.findBatchByBatchName(batchName);
        if (batch != null) {
            List<Batch> batches = batchRepo.listOfBatchWithStudent();
            System.out.println("Students in batch :- "+batchName);
            for (Batch batch1 : batches) {
                if (batch1.getBatchName().equals(batchName)) {
                    List<User> student = batch1.getStudentsList();
                    for (User user : student) {
                        System.out.println(user.getUsername());
                    }
                }
            }
        } else {
            System.out.println("Batch not Found");
        }

    }

    @Override
    public String deleteBatch(String adminPhone, String batchName, UserServiceImpl userService, BatchServiceImpl batchService) {
        boolean batch = batchService.existsBatch(batchName);
        if (batch) {
            batchRepo.deleteBatch(batchName);
            return "Batch Deleted Successfully!";
        } else {
            return "Batch Does not Exists.";
        }
    }


    public boolean isBatchExists(){
        return batchRepo.isBatchExists();
    }


}
