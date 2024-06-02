package Feedback_System.model;

public class StudentFeedback {
    private String feedbackDetails;
    private String batchName;
    private String studentPhone;
    private String qId;
    private boolean flag = true;

    public StudentFeedback(String feedbackDetails, String batchName, String studentPhone, String qId) {
        this.feedbackDetails = feedbackDetails;
        this.batchName = batchName;
        this.studentPhone = studentPhone;
        this.qId = qId;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
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

    public String getqId() {
        return qId;
    }

    public void setqId(String qId) {
        this.qId = qId;
    }
}
