package Feedback_System.service.impl;

import Feedback_System.model.Batch;
import Feedback_System.model.User;
import Feedback_System.repository.impl.UserRepoImpl;
import Feedback_System.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserRepoImpl userRepo = new UserRepoImpl();

    public boolean signUp(String username, String password, String phone, String role) {
        // waiting from prince end.
        User user = new User(username, password, phone, role.toUpperCase());
        userRepo.saveUser(user);
        return true;

    }


    @Override
    public boolean getUser(String username, String pass) {
        User userName = userRepo.findByUsername(username);
        User password = userRepo.findByPassword(pass);
        if (userName != null) {
            if (password != null) {
                return true;
            } else {
                System.out.println("Invalid Password");
                return false;
            }
        }
        System.out.println("Invalid username");
        return false;
    }

    @Override
    public List<User> userList() {
        List<User> users = userRepo.listOfUser();
        for (User user : users) {
            System.out.println(user.getRole() + " " + user.getPhoneNumber());
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
            if (user.getPhoneNumber().equals(studentPhone)) {
                String studentName = user.getUsername();
                String studentPassword = user.getPassword();
                User student = new User(studentName, studentPhone, studentPassword);
                students.add(student);
                return students;
            }
        }
        return null;
    }

    @Override
    public String findPhoneByPassword(String password) {
       return userRepo.findPhoneNumberByPassword(password);
    }

    @Override
    public String findRoleByPhoneNumber(String phoneNumber) {
        return userRepo.findRoleByPhoneNumber(phoneNumber);
    }

    @Override
    public String findUsernameByPhoneNumber(String phoneNumber) {

        return userRepo.findUsernameByPhoneNumber(phoneNumber);
    }


    public int isPhoneExist(String phoneNumber , String username){
        return userRepo.isPhoneExist(phoneNumber , username);
    }
}
