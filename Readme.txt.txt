Feedback Managment System:

 1.Model   
	a.User
		Username   
		Password
		role
		Phone Number
		
		//Constructor(String username, String phoneNumber, String password);
		//Getter & setters



        b.Batch
		batchName
    		createdBy
    		List<User> studentsList

		//Constructor
		//Getter & setters

	c.Feedback Questions

		questionId;
    		question;
		batchName;
		
		//Constructor
		//Getter & setters
	
	d.Student Feedback

		feedbackDetails = feedbackDetails;
        	batchName = batchName;
        	studentPhone = studentPhone;
        	feedbackQid
			
		//Constructor
		//Getter & setters

2.UI client

	1.Sign Up  ----> registers Student/Admin
	2.Sign In  ----> Log in User. If user is Student displays Student Menu And if User  is Admin displays Admin menu.

	Student Menu
		1. Know your assigned batch: 
				Displays the batch assigned to the student.

		2. Know your batch-mates: 
				  Displays the list of batch- mates.

		3. Submit Feedback: 
			Allows the student to submit feedback for their batch.

		4. Sign Out:
			 Signs out the student.
	
	Admin Menu
		1. Create Batches:
				 Allows admin to create new batches.

		2. Assign Batch:
				 Assigns a student to a batch.

		3. Delete Batch: 
				Deletes an existing batch.

		4. Create Questions:
				 Creates new questions for a specific batch.

		5. Update Question:
				 Updates an existing question.

		6. Delete Question:
				 Deletes a specific question.

		7. Student List By Batch:
				 Displays the list of students in a specific batch.

		8. List of Question:
				 Lists all the questions.

		9. Feedback List By Batch:
				 Displays feedback for a specific batch.

		10. Individual Student Feedback:
				 Retrieves feedback for a specific student.

		11. Sign Out: 
				Signs out the admin.



3.Helper class
	
	//Methods
		
		phoneNumberValidator(String phoneNumber): Validates the phone number format.

		passwordValidator(String password): Validates the strength of the password.

		isValidRole(String role): Checks if the provided role is either "student" or "admin".




4.Controller

	a.Controller
		//attributes
           	 object of User Service
           	 object of batch Service
           	 object of Question Service
           	 object of Feedback Service

	//API

	* signUp(String username, String password, String phone, String role) 	---> calls User Service

	*signIn(String username, String pass): 	---> calls User Service

	*userList(): 	---> calls User Service

	*assignBatch(String batchName, String studentPhone, String adminPhone):	---> calls batch Service

	*createQuestion(String batchName, String adminPhone): 	---> calls question Service

	*listOfQuestion(): 	---> calls question Service

	*deleteQuestion(String qId, String batch, String adminPhone): 	---> calls question Service

	*updateQuestion(String qId, String batch, String adminPhone): 	---> calls question Service

	*submitFeedback(String studentPhone, String batchName): 	---> calls Feedback Service 

	*feedbackList(): 	---> calls Feedback Service

	*feedbackByBatch(String adminPhone, String batch): ---> calls feedback Service

	*individualFeedback(String adminPhone, String studentPhone):	---> calls feedback Service

	*createBatch(String adminPhone, String batchName): ---> calls batch Service

	*listOfBatches(): ---> calls batch Service

	*getPhoneByPassword(String password): ---> calls User Service method findPhoneByPassword(password);

	*findRoleByPhoneNumber(String phoneNumber): --->calls userService method findRoleByPhoneNumber(phoneNumber)

	*getYourBatch(String username, String password): 	---> calls batch Service

	*showMyBatchmates(String username, String password): 	---> calls batch Service

	*existsBatch(String batchName): 	---> calls batch Service

	*deleteBatch(String adminPhone, String batchName):	---> calls batch Service
	
	*listOfStudentByBatch(String batchName)		--->calls batch service 

5. Service
	

   a.Batch Service


	 //attributes
           object of Batch Repository.
	   object of User Service.

	//Methods


	*assignBatch(String batchName, String studentPhone, String adminPhone, UserServiceImpl userService)  ---> Checks if the student and batch exist before assignment;
		
	*createBatch(String adminPhone, String batchName, UserServiceImpl studentService)  ---> Checks if the user is an admin before creating the batch. and Returns The name of the 													created batch or an error message.

	*findStudentInBatchByPhone(String batchName, String studentPhone)  ---> Returns The batch if the student is found, otherwise null.

	*findBatchByBatchName(String batchName)  ---> Returns A list of batches.

	*getListOfBatch()  --->  Returns A list of batches.

	*findBatchByUsernameAndPassword(String username, String password)  --->  Returns The name of the batch by username and password.

	*showBatchMates(String username, String password)  --->  Retrieves and returns a list of batchmates for a specific user

	*existsBatch(String batchName)  ---> Returns true if the batch exists, otherwise false. 

	* listOfStudentByBatchName(String batchName)  --->  Prints the names of students in the batch.

	*deleteBatch(String adminPhone, String batchName)  ---> Deletes a batch if it exists.  





    b.User Service


	
	//attributes
	  object of user Repository.

	//Methods

	*signUp(String username, String password, String phone, String role) --->   Creates a new User object and saves it in the repository. Returns true upon successful registration.


	*getUser(String username, String pass)   --->  Checks if the provided username and password match any user in the repository. Returns true if authentication is successful, 								otherwise false

	*findStudentByBatch(String studentPhone, String batchName, BatchServiceImpl batchService)   --->  Utilizes BatchServiceImpl to find the student in the specified batch.
													Returns A Batch object if the student is found

	*findAdminByPhone(String adminPhoneNumber)  --->  Fetches the admin user from the repository.

	*findStudentByPhone(String studentPhone)  --->   Fetches the student user from the repository.

	*getStudentDetailsByPhone(String studentPhone)  --->  Fetches and returns a list of User objects containing the student's details.

	*findPhoneByPassword(String password) ---> Fetches the phone number from the repository.
	
	*findRoleByPhoneNumber(String phoneNumber)   --->   Fetches the user's role from the repository.

	*findUsernameByPhoneNumber(String phoneNumber)  --->  Fetches the username from the repository. And Returns The username as a String.





   c.Question service
	

	//attribute
	  object of question Repository.


	//Methods
	*createQuestion(String batchName, String adminPhone, UserServiceImpl userService, BatchServiceImpl batchService)   --->  Prompts the admin to enter a question ID and the question 																text, then saves it to the repository. And Returns A String 																indicating whether the question was successfully saved or if 																there was an error


	*questionList()  --->   Fetches all questions from the repository and prints them.
	
	*listWithQid()  --->   Fetches all questions from the repository and prints them with their IDs.

	*listOfQuestion()  --->   Fetches and returns all questions from the repository.

	*listOfQuestionByBatch(String batch)  --->  Fetches and prints all questions for the specified batch.

	*deleteQuestion(String qId, String batchName, String adminPhone)  ---> Deletes the question from the repository  if the admin is authorized and the batch exists. 

	*updateQuestion(String qId, String batch, String adminPhone, UserServiceImpl studentService, BatchServiceImpl batchService)  --->   Prompts the admin to enter the updated question 																text and saves the updated question to the repository.






   d.Feedback Service.
	

	//attributes
	  object of feedback repository

	//Methods
	  
	*submitFeedback(String studentPhone, String batchName, BatchServiceImpl batchService, QuestionServiceImpl questionService)  --->  Checks if the student is enrolled in the specified 																batch and then prompts the student to provide feedback for 															  each question in the batch. and feedback is saved to repository.


	*feedbackList()  --->  Fetches all feedback from the repository and prints the question ID and feedback details.

	*feedbackByBatch(String adminPhone, String batchName, BatchServiceImpl batchService, UserServiceImpl user)  --->   Verifies the admin and batch existence, then prints feedback 															details given by students in the specified batch.

	*individualFeedback(String adminPhone, String studentPhone, UserServiceImpl studentService)  --->   Verifies the admin and student existence, then prints feedback details given by 														the specified student.



6.Repository
     a.Batch Repository

	
	//List<Batch> batches: Stores all batches.
	//List<Batch> batchWithStudent: Stores batches along with their associated students.

	
	//methods
	*addNewBatch(Batch batch)  --->  Adds a new batch to the list batches.
	
	*saveBatchWithStudent(Batch batch)  --->   Adds a batch along with its associated students to the  list batchWithStudent.

	*findBatchByBatchName(String batchName)  --->   Searches for a batch in the list of batches by its name. and returns batch or null if not found.

	*listOfBatchWithStudent()  --->   Returns the list batchWithStudent containing batches with students.

	*listOfBatch()  --->   Returns the list of  batches containing all batches.

	*existsBatch(String batchName) ---> Searches for a batch in the list batches by its name.and returns tue if found else false.

	*deleteBatch(String batchName)  --->   Removes the batch with the specified name from both batches and batchWithStudent lists.

	*findBatchByUsernameAndPassword(String username, String password)  --->   Searches for a batch in the list batchWithStudent by a student's username and password.
										  Returns The batch name if found or  null otherwise.

	*showBatchMates(String batchName)  --->  Lists usernames and phone numbers of students in the specified batch.

	*isBatchExists()  --->   Checks if the list batches contains any batches.returns true or false.


    b.feedback Repository

	//List<StudentFeedback> feedbackList: Stores all feedback entries.


	//methods
	
	*saveFeedback(StudentFeedback feedback)  --->   Adds the provided feedback to the  list feedbackList.

	*feedbackList()  ---> Returns the list feedbackList containing all feedback entries.

	*feedbackByPhonenumber(String studentPhone) --->   Prints the feedback details of all feedback entries provided by the student with the specified phone number.

	*deleteFeedbackByBatch(String batch)  --->  Removes the feedback entries associated with the specified batch name from the list feedbackList


	c. question Repository
	
	//List<FeedbackQuestion> questionList: Stores all feedback questions.

	//methods
	*saveQuestions(FeedbackQuestion feedbackQuestion)  ---> Adds the provided feedback question to the internal list questionList.

	*questionList()  --->   Returns the list questionList containing all feedback questions.

	*questionInBatch(String qId, String batchName)  --->   Searches for a question with the specified question ID and batch name.

	*isCorrectQid(String qId)  --->  Searches for a question with the specified question ID. Returns The FeedbackQuestion object if found, null otherwise.

	*deleteQuestion(String qId)  --->   Removes the question with the specified question ID from the list questionList.

	*updateQuestion(String qId, String batch, String updatedQuestion)  --->   Updates the question text for a question with the specified question ID and batch name.

	*questionListAndQid()  --->  Returns the list questionList containing all feedback questions.

	*findQuestionId(String qid)  --->   Searches for a question with the specified question ID. Returns: The FeedbackQuestion object if found, null otherwise.

	
    d. User Repository

	//List<User> userlist: Stores all user objects.

	//Methods
	*saveUser(User user)  --->   Adds the provided user to the internal list userlist.

	*findByUsername(String username)  --->  Searches for a user with the specified username in userlist.Returns: The User object if found, null otherwise.

	*findStudentByPhone(String studentPhone)  --->   Searches for a user with the specified phone number in userlist.Returns: The User object if found, null otherwise.

	*listOfUser()  --->   Returns the list userlist containing all users.

	*findAdminByPhone(String adminPhone) Searches for a user with the specified phone number and role "admin" in userlist.

	*studentData(String studentPhone)  --->   Returns the list userlist containing all users 

	*findByPassword(String pass)  --->   Searches for a user with the specified password in userlist.

	*findPhoneNumberByPassword(String password)  --->   Searches for a user with the specified password in userlist and returns their phone number.


	*findRoleByPhoneNumber(String phoneNumber)  --->   Searches for a user with the specified phone number in userlist.Returns The role as a String if found, null otherwise.

	*findUsernameByPhoneNumber(String phoneNumber)  --->   Searches for a user with the specified phone number in userlist and returns their username.