package Feedback_System.repository.impl;

import Feedback_System.model.User;
import Feedback_System.repository.UserRepo;

import java.util.ArrayList;
import java.util.List;

public class UserRepoImpl implements UserRepo {
    List<User> studentList = new ArrayList<>();
    @Override
    public User saveStudent(User user) {
        studentList.add(user);
        return user;
    }


    @Override
    public User findUser(String username, String pass) {
        for (User user : studentList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(pass)){
                System.out.println(user.getRole());
                return user;
            }
        }
        return null;
    }

    @Override
    public User existsStudent(String studentPhone) {
        for (User user : studentList){
            if (user.getPhoneNumber().equals(studentPhone)){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> userList() {
        return studentList;
    }

    @Override
    public User checkAdminByPhone(String adminPhone) {
        for (User admin:studentList){
            if (admin.getPhoneNumber().equals(adminPhone) && (admin.getRole()).toUpperCase().equals("ADMIN")) {
                return admin;
            }
        }
        return null;
    }
}
