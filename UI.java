package Feedback_System;

import Feedback_System.controller.UserController;
import Feedback_System.model.Batch;

import java.util.List;
import java.util.Scanner;

class UI {

    public static void main(String[] args) {
        UserController userController = new UserController();
        HelperClass helper = new HelperClass();
        Scanner scanner = new Scanner(System.in);

        int choice = 0;

        while (true) {

            System.out.println("Welcome to Feedback System");
            System.out.println("1. Sign Up");
            System.out.println("2. Sign In");
            System.out.println("16. Exit");

            System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();


            if (choice == 1) {

                System.out.print("Enter name: ");
                String username = scanner.nextLine();

                String password;
                while (true) {
                    System.out.println("Enter a strong password: ");
                    System.out.println("Example :Abc1234@");
                    password = scanner.nextLine();
                    boolean isValidPassword = helper.passwordValidator(password);
                    if (isValidPassword) {
                        break;
                    }

                    else {
                        System.out.println("Password is invalid.");
                        System.out.println("Create strong password as per credentials");
                    }
                }


                String phoneNumber;
                int typeOfExistance = 0;
                while (true) {
                    System.out.print("Enter phone number: ");
                    phoneNumber = scanner.nextLine();
                    boolean isValidPhone = helper.phoneNumberValidator(phoneNumber);
                    if (isValidPhone) {
                        typeOfExistance = userController.isPhoneExist(phoneNumber , username);
                        if(typeOfExistance == 0){
                            break;
                        } else if (typeOfExistance == 1) {
                            System.out.println("Phone number already registered please enter other one.");
                        } else if (typeOfExistance == 2) {
                            System.out.println("User already exists.");
                            System.out.println("Proceed to Sign In.");
                            break;
                        }
                    }
                    else {
                        System.out.println("Phone number is invalid.");
                    }
                }
                if (typeOfExistance == 2) {
                    continue;
                }


                String role;
                while (true) {
                    System.out.print("Enter role (student/admin): ");
                    role = scanner.nextLine();
                    boolean isValidRole = helper.isValidRole(role);
                    if (isValidRole) {
                        System.out.println("Congratulations! You are successfully Registered!");
                        break;
                    } else {
                        System.out.println("Invalid role");
                    }
                }

                userController.signUp(username, password, phoneNumber, role);
            }


             else if (choice == 2) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                boolean isSignIn = userController.signIn(username, password);
                if (isSignIn) {
                    System.out.println("Login Successful");

                    while (true) {
                        //need a phone number of signed user.
                        String phoneNumber = userController.getPhoneByPassword(password);
                        String checkRole = userController.findRoleByPhoneNumber(phoneNumber);
                        String getBatch = userController.getYourBatch(username, password);

                        if (checkRole.equals("STUDENT")) {
                            System.out.println("1. Know your assigned batch");
                            System.out.println("2. Know your batch-mates");
                            System.out.println("3. Submit Feedback");
                            System.out.println("4. Sign Out");
                            System.out.println("5. Exit");

                            System.out.print("Enter choice : ");
                                choice = scanner.nextInt();

                            if (choice == 1) { // not sure
                                if(getBatch != null){
                                    System.out.println("You are assigned in batch " + getBatch);
                                }
                                else {
                                    System.out.println("You are not assigned in any batch");
                                }
                            }

                            else if (choice == 2) {
                                if (getBatch != null){
                                    // show with phone
                                    System.out.println("Your batch-mates are : ");
                                    List batchmatesList = userController.myBatchMates(username, password);
                                    for (int i = 0; i < batchmatesList.size(); i++) {
                                        System.out.print(batchmatesList.get(i));
                                        System.out.print("           ");
                                        System.out.println(batchmatesList.get(++i));
                                    }
                                }

                                else {
                                    System.out.println("You are not assigned in any batch");
                                }
                            }

                            else if (choice == 3) {
                                System.out.println(userController.submitFeedback(phoneNumber, getBatch));
                            }

                            else if (choice == 4) {
                                System.out.println("Signed out successfully.");
                                break;
                            }

                            else if (choice == 5) {
                                System.out.println("Tadda!!!");
                                return;
                            }
                        }


                        if (checkRole.equals("ADMIN")) {

                            while (true) {

                                if(!userController.isBatchExists()){
                                    System.out.println("1. Create Batch");
                                    System.out.println("2. Sign Out");
                                    System.out.println("3. Exit");

                                    System.out.print("Enter choice : ");
                                    choice = scanner.nextInt();
                                    scanner.nextLine();

                                    if (choice == 1) {
                                        System.out.println("Enter batch name: ");
                                        String batch = scanner.nextLine();
                                        System.out.println(userController.createBatch(phoneNumber, batch));
                                    }

                                    else if (choice == 2) {
                                        System.out.println("Signed out successfully.");
                                        break;
                                    }

                                    else if (choice == 3) {
                                        System.out.println("Tadda!!!");
                                        return;
                                    }
                                }


                                else{
                                    System.out.println("1. Create Batches");
                                    System.out.println("2. Assign Batch");
                                    System.out.println("3. Delete Batch");
                                    System.out.println("4. Create Questions");
                                    System.out.println("5. Update Question"); // done
                                    System.out.println("6. Delete Question"); // done
                                    System.out.println("7. Student List By Batch");
                                    System.out.println("8. List of Question");  // done
                                    System.out.println("9. List of Question By Batch");  // done
                                    System.out.println("10. List of Batches");
                                    // 11 :- issue is deleted question is different and giving feedback of another
                                    // 11 :- issue is might be after deleting it always remove 0th position feedback (same for 12)
                                    System.out.println("11. Feedback List By Batch");  // updated
                                    System.out.println("12. Individual student Feedback");// updated
                                    System.out.println("13. Sign Out");
                                    System.out.println("14. Exit");

                                    System.out.print("Enter choice : ");
                                    choice = scanner.nextInt();
                                    scanner.nextLine();

                                    if (choice == 1) {
                                        System.out.println("Enter batch name: ");
                                        String batch = scanner.nextLine();
                                        System.out.println(userController.createBatch(phoneNumber, batch));
                                    } else if (choice == 2) {
                                        List<Batch> listOfBatches = userController.listOfBatches();
                                        System.out.println("List of Batches :-");
                                        for (Batch batch : listOfBatches) {
                                            System.out.println(batch.getBatchName()+ "  is created By : "+batch.getCreatedBy());
                                        }
                                        System.out.print("Enter batch name: ");
                                        String batchName = scanner.nextLine();
                                        boolean isBatchExists = userController.existsBatch(batchName);
                                        if (isBatchExists) {
                                            System.out.print("Enter student phone number: ");
                                            String studentPhone = scanner.nextLine();
                                            System.out.println(userController.assignBatch(batchName, studentPhone, phoneNumber));
                                        }
                                        else {
                                            System.out.println("Batch not found");
                                        }
                                    }
                                    else if (choice == 3) {
                                        if (userController.isBatchExists()){
                                            System.out.print("Enter batch name : ");
                                            String batchName = scanner.nextLine();
                                            System.out.println(userController.deleteBatch(phoneNumber,batchName));
                                        }

                                        else {
                                            System.out.println("There is no any batch to delete");
                                        }

                                    } else if (choice == 4) {
                                        userController.listOfBatches();
                                        System.out.print("Enter batch name: ");
                                        String batchNameForQuestion = scanner.nextLine();
                                        System.out.println(userController.createQuestion(batchNameForQuestion, phoneNumber));

                                    }
                                    else if (choice == 5) {
                                        System.out.print("Enter question ID : ");
                                        String qid = scanner.nextLine();
                                        userController.listOfBatches();
                                        System.out.print("Enter batch name: ");
                                        String batch = scanner.nextLine();
                                        System.out.println(userController.updateQuestion(qid, batch, phoneNumber));

                                    } else if (choice == 6) {
                                        System.out.print("Enter question ID : ");
                                        String qID = scanner.nextLine();
                                        userController.listOfBatches();
                                        System.out.print("Enter batch name: ");
                                        String batchN = scanner.nextLine();
                                        System.out.println(userController.deleteQuestion(qID, batchN, phoneNumber));

                                    }
                                    else if (choice == 7) {
                                        System.out.print("Enter Batch Name : ");
                                        String batch = scanner.nextLine();
                                        userController.listOfStudentByBatch(batch);

                                    } else if (choice == 8) {
                                        System.out.println("List Of Question");
                                        List<String > questions = userController.listOfQuestion();
                                        for (String question : questions) {
                                            System.out.println(question); // updating here

                                        }

                                    } else if (choice == 9) {
                                        System.out.println("Enter Batch Name : ");
                                        String batch = scanner.nextLine();
                                        userController.listOfQuestionByBatch(batch);

                                    } else if (choice == 10) {
                                        List<Batch> listOfBatches = userController.listOfBatches();
                                        System.out.println("List of Batches :-");
                                        for (Batch batch : listOfBatches) {
                                            System.out.println(batch.getBatchName()+ "  is created By : "+batch.getCreatedBy());
                                        }

                                    } else if (choice == 11) {
                                        System.out.print("Enter Batch Name : ");
                                        String batch = scanner.nextLine();
                                        System.out.println(userController.feedbackByBatch(phoneNumber,batch));

                                    } else if (choice == 12) {
                                        System.out.print("Enter Student Phone Number : ");
                                        String studentPhone = scanner.nextLine();
                                        System.out.println(userController.individualFeedback(phoneNumber,studentPhone));
                                    }else if (choice == 13) {
                                        System.out.println("Signed out successfully.");
                                        break;
                                    } else if (choice == 14) {
                                        System.out.println("Tadda!!!");
                                        return;
                                    }
                                }
                            }
                            break;
                        }
                    }

                }
            }
             else if (choice == 16) {
                System.out.println("Tadda!!!");
                return;
            }
             else {
                System.out.println("Invalid choice");
            }
        }
    }
}
