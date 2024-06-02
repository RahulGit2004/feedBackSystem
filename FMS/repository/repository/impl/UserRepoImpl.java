package Feedback_System.repository.impl;

import Feedback_System.model.User;
import Feedback_System.repository.UserRepo;

import java.util.ArrayList;
import java.util.List;

public class UserRepoImpl implements UserRepo {
    List<User> userlist = new ArrayList<>();
    @Override
    public User saveUser(User user) {
        userlist.add(user);
        return user;
    }


    @Override
    public User findByUsername(String username) {
        for (User user : userlist) {
            if (user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

    @Override
    public User findStudentByPhone(String studentPhone) {
        for (User user : userlist){
            if (user.getPhone().equals(studentPhone)){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> listOfUser() {
        return userlist;
    }

    @Override
    public User findAdminByPhone(String adminPhone) {
        for (User admin: userlist){
            if (admin.getPhone().equals(adminPhone) && (admin.getRole()).equalsIgnoreCase("A")) {
                return admin;
            }
        }
        return null;
    }

    @Override
    public List<User> studentData(String studentPhonenumber) {
        return userlist;
    }

    @Override
    public User findByPassword(String pass) {
        for (User user : userlist) {
            if (user.getPassword().equals(pass)) {
                return user;
            }
        }
        return null;
    }
}
