package Feedback_System.model;

import java.util.ArrayList;
import java.util.List;

public class Batch {
    //23 :- Batch Model Contain :- batchName, createdBy, active(t/f) and List<Student>
    private String batchName;
    private String createdBy;
    private List<User> studentsList = new ArrayList<>();
    private List<FeedbackQuestion> questionList = new ArrayList<>();// in process

    public List<FeedbackQuestion> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<FeedbackQuestion> questionList) {
        this.questionList = questionList;
    }

    public List<User> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<User> studentsList) {
        this.studentsList = studentsList;
    }



    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }




    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }


    public Batch(String batchName, List<User> studentsList) {
        this.batchName = batchName;
        this.studentsList = studentsList;

    }
    public Batch(){}
    public Batch(String batchName,String adminName) {
        this.batchName = batchName;
        this.createdBy = adminName;
    }
}
