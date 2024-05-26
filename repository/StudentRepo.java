package Feedback_System.repository;

import Feedback_System.model.User;

import java.util.List;

public interface StudentRepo {
    User saveStudent(User user);


    User findUser(String username, String pass);
    User existsStudent(String studentPhone);
    List<User> userList();

    User checkAdminByPhone(String adminPhone);
}
