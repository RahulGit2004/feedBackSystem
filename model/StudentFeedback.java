package Feedback_System.model;

public class StudentFeedback {
    private String feedbackDetials;
    private String batchName;
    private String studentPhone;
    private String feedbackQid;

    public StudentFeedback(String feedbackDetials, String batchName, String studentPhone, String feedbackQid) {
        this.feedbackDetials = feedbackDetials;
        this.batchName = batchName;
        this.studentPhone = studentPhone;
        this.feedbackQid = feedbackQid;
    }

    public String getFeedbackDetials() {
        return feedbackDetials;
    }

    public void setFeedbackDetials(String feedbackDetials) {
        this.feedbackDetials = feedbackDetials;
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

    public String getFeedbackQid() {
        return feedbackQid;
    }

    public void setFeedbackQid(String feedbackQid) {
        this.feedbackQid = feedbackQid;
    }
}
