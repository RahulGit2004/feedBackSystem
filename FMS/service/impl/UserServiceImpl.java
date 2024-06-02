package Feedback_System.service.impl;

import Feedback_System.model.Batch;
import Feedback_System.model.User;
import Feedback_System.repository.impl.UserRepoImpl;
import Feedback_System.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserRepoImpl userRepo = new UserRepoImpl();

    public String signUp(String username, String password, String phone, String role) {
        // waiting from prince end.
        User user = new User(username, password, phone, role);
        userRepo.saveUser(user);
        return "Register Success";

    }


    @Override
    public String getUser(String username, String pass) {
        User userName = userRepo.findByUsername(username);
        User password = userRepo.findByPassword(pass);
        if (userName != null) {
            if (password != null) {
                return "Login Success";
            } else {
                return "Invalid Password";
            }
        }
        return "Invalid username";
    }

    @Override
    public List<User> userList() {
        List<User> users = userRepo.listOfUser();
        for (User user : users) {
            System.out.println(user.getRole() + " " + user.getPhone());
        }
        return users;
    }

    @Override
    public Batch findStudentByBatch(String studentPhone, String batchName, BatchServiceImpl batchService) {
        return batchService.findStudentInBatchByPhone(batchName, studentPhone);
    }

    @Override
    public User findAdminByPhone(String adminPhoneNumber) {
        return userRepo.findAdminByPhone(adminPhoneNumber);
    }

    @Override
    public User findStudentByPhone(String studentPhone) {

        return userRepo.findStudentByPhone(studentPhone);
    }

    @Override
    public List<User> getStudentDetailsByPhone(String studentPhone) {
        List<User> users = userRepo.studentData(studentPhone);
        // for saving important data which is need for batch
        List<User> students = new ArrayList<>();
        for (User user : users) {
            if (user.getPhone().equals(studentPhone)) {
                String studentName = user.getUsername();
                String studentPassword = user.getPassword();
                User student = new User(studentName, studentPhone, studentPassword);
                students.add(student);
                return students;
            }
        }
        return null;
    }


}
