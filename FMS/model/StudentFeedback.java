package Feedback_System.model;

public class StudentFeedback {
    private String feedbackDetails;
    private String batchName;
    private String studentPhone;
    private String feedbackQid;

    public StudentFeedback(String feedbackDetails, String batchName, String studentPhone, String feedbackQid) {
        this.feedbackDetails = feedbackDetails;
        this.batchName = batchName;
        this.studentPhone = studentPhone;
        this.feedbackQid = feedbackQid;
    }


    public String getFeedbackDetails() {
        return feedbackDetails;
    }

    public void setFeedbackDetails(String feedbackDetails) {
        this.feedbackDetails = feedbackDetails;
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
