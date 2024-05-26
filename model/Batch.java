package Feedback_System.model;

public class Batch {
    private String batchName;
    private String studentPhone;
    public String studentName;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public Batch(String batchName, String studentPhone) {
        this.batchName = batchName;
        this.studentPhone = studentPhone;
    }

    public Batch(String batchName) {
        this.batchName = batchName;
    }
}
