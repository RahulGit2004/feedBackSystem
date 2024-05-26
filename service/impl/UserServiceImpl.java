package Feedback_System.service.impl;

import Feedback_System.model.Batch;
import Feedback_System.model.User;
import Feedback_System.repository.impl.UserRepoImpl;
import Feedback_System.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserRepoImpl studentRepo = new UserRepoImpl();

    public String signUp(String username, String password, String phone, String role) {

        User user = new User(username, password, phone, role);
          studentRepo.saveStudent(user);

        return "Register Success";

    }


    @Override
    public String getUser(String username, String pass) {
        User user = studentRepo.findUser(username, pass);
        if (user != null) {
            return "Login Success";
        }
        return "Invalid User";
    }

    @Override
    public List<User> userList() {
        List<User> users = studentRepo.userList();
        for (User user : users) {
            System.out.println(user.getRole() + " " + user.getPhoneNumber());
        }
        return users;
    }

    @Override
    public Batch findStudentByBatch(String studentPhone, String batchName, BatchServiceImpl batchService) {
        // issue is a student able to give feedback of any bach.
//        User isStudent = studentRepo.existsStudent(studentPhone);  //  this is able to solve my feedback
//        Batch studentInBatch = batchService.batchRepo.checkBatch(batchName);  // but above problem arrived.
        Batch student = batchService.batchRepo.isStudentByBatch(batchName,studentPhone);
        if (student != null) {
            return student;
        }
        return null;
    }
}
