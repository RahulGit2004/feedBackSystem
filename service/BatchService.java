package Feedback_System.service;

import Feedback_System.service.impl.UserServiceImpl;

public interface BatchService {
    String assignBatch(String batchName, String studentPhone, String role, String adminPhone, UserServiceImpl studentService);

    String createBatch(String adminPhone, String batchName, UserServiceImpl studentService);
}
