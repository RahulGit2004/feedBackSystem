package Feedback_System.model;

public class FeedbackQuestion {
    private String questionId;
    private String question;

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    private String batchName;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public FeedbackQuestion(String questionId, String question, String batchName) {
        this.questionId = questionId;
        this.question = question;
        this.batchName = batchName;
    }
}
