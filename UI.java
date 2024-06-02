package Feedback_System;

import Feedback_System.controller.UserController;

import java.util.Scanner;

public class UI {
    public static void main(String[] args) {
        UserController userController = new UserController();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("------> Feedback System Menu <------");
            System.out.println("1. Sign Up");
            System.out.println("2. Sign In");
            System.out.println("3. Create Batch");
            System.out.println("4. Assign Batch");
            System.out.println("5. Create Question");
            System.out.println("6. Update Question");
            System.out.println("7. Delete Question");
            System.out.println("8. Submit Feedback");
            System.out.println("9. List Questions");
            System.out.println("10. List Feedback");
            System.out.println("11. Feedback by Batch");
            System.out.println("12. Feedback by Batch for Admin");
            System.out.println("13. Individual Feedback for Admin");
            System.out.println("14. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter role (student/admin): ");
                    String role = scanner.nextLine();
                    System.out.println(userController.signUp(username, password, phoneNumber, role));
                    break;
                case 2:
                    System.out.print("Enter your name : ");
                    String name = scanner.nextLine();
                    System.out.print("Enter your password: ");
                    String pass = scanner.nextLine();
                    System.out.println(userController.signIn(name, pass));
                    break;

                case 3:
                    System.out.print("Enter admin phone number: ");
                    String adminPhoneForBatch = scanner.nextLine();
                    System.out.print("Enter batch name: ");
                    String batchName = scanner.nextLine();
                    System.out.println(userController.createBatch(adminPhoneForBatch, batchName));
                    break;

                case 4:
                    System.out.print("Enter batch name: ");
                    String batchNameForAssign = scanner.nextLine();
                    System.out.print("Enter student phone number: ");
                    String studentPhone = scanner.nextLine();
                    System.out.print("Enter admin role: ");
                    String adminRole = scanner.nextLine();
                    System.out.print("Enter admin phone number: ");
                    String adminPhoneForAssign = scanner.nextLine();
                    System.out.println(userController.assignBatch(batchNameForAssign, studentPhone,adminRole,adminPhoneForAssign));
                    break;

                case 5:
                    System.out.print("Enter batch name: ");
                    String batchNameForQuestion = scanner.nextLine();
                    System.out.print("Enter admin phone number: ");
                    String adminPhoneForQuestion = scanner.nextLine();
                    System.out.println(userController.createQuestion(batchNameForQuestion, adminPhoneForQuestion));
                    break;
                case 6:
                    System.out.print("Enter question ID : ");
                    String qid = scanner.nextLine();
                    System.out.print("Enter batch name: ");
                    String batch = scanner.nextLine();
                    System.out.print("Enter admin phone number: ");
                    String admin = scanner.nextLine();
                    System.out.println(userController.updateQuestion(qid,batch,admin));
                    break;
                case 7:
                    System.out.print("Enter question ID : ");
                    String qID = scanner.nextLine();
                    System.out.print("Enter batch name: ");
                    String batchN = scanner.nextLine();
                    System.out.print("Enter admin phone number: ");
                    String adPhone = scanner.nextLine();
                    System.out.println(userController.deleteQuestion(qID,batchN,adPhone));
                    break;


                case 8:
                    System.out.print("Enter student phone number: ");
                    String studentPhoneForFeedback = scanner.nextLine();
                    System.out.print("Enter batch name: ");
                    String batchNameForFeedback = scanner.nextLine();
                    System.out.println(userController.submitFeedback(studentPhoneForFeedback, batchNameForFeedback));
                    break;

                case 9:
                    userController.questionList();
                    break;

                case 10:
                    userController.feedbackList();
                    break;

                case 11:
                    System.out.print("Enter batch name: ");
                    String batchNameForFeedbackByBatch = scanner.nextLine();
                    System.out.println(userController.feedbackByBatch(batchNameForFeedbackByBatch));
                    break;

                case 12:
                    System.out.print("Enter admin phone number: ");
                    String adminPhoneForFeedbackByBatch = scanner.nextLine();
                    System.out.print("Enter batch name: ");
                    String batchNameForFeedbackByBatchToAdmin = scanner.nextLine();
                    System.out.println(userController.feedbackByBatchToAdmin(adminPhoneForFeedbackByBatch, batchNameForFeedbackByBatchToAdmin));
                    break;

                case 13:
                    System.out.print("Enter admin phone number: ");
                    String adminPhoneForIndividualFeedback = scanner.nextLine();
                    System.out.print("Enter student phone number: ");
                    String studentPhoneForIndividualFeedback = scanner.nextLine();
                    System.out.println(userController.individualFeedback(adminPhoneForIndividualFeedback, studentPhoneForIndividualFeedback));
                    break;

                case 14:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
