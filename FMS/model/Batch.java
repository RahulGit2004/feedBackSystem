package Feedback_System.model;

import java.util.ArrayList;
import java.util.List;

public class Batch {
    //23 :- Batch Model Contain :- batchName, createdBy, active(t/f) and List<Student>
    private String batchName;
    private String createdBy;
    private List<User> students = new ArrayList<>();


    public List<User> getStudents() {
        return students;
    }

    public void setStudents(List<User> students) {
        this.students = students;
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


    public Batch(String batchName, List<User> students) {
        this.batchName = batchName;
        this.students = students;

    }

    public Batch(String batchName,String adminName) {
        this.batchName = batchName;
        this.createdBy = adminName;
    }
}
