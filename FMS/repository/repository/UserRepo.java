package Feedback_System.repository;

import Feedback_System.model.User;

import java.util.List;

public interface UserRepo {
    User saveUser(User user);

    User findByUsername(String username);
    User findStudentByPhone(String studentPhone);
    List<User> listOfUser();

    User findAdminByPhone(String adminPhone);
    List<User> studentData(String studentPhonenumber);

    User findByPassword(String pass);
}
