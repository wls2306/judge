package com.bcu.judge.pojo;

public class Answer {
    /**
     * 自增id
     */
    private Integer id;

    /**
     * 答案编号
     */
    private String answerId;

    /**
     * 考试编号
     */
    private String answerExamId;

    /**
     * 答题者用户号
     */
    private String answerUserId;

    /**
     * 试题编号
     */
    private String answerQueId;

    /**
     * 答案内容
     */
    private String answerContent;

    /**
     * 是否正确
     */
    private String answerIsRight;

    /**
     * 正确答案
     */
    private String answerRightAnswer;

    /**
     * 答案得分
     */
    private String answerScore;

    /**
     * 题目总分
     */
    private String answerQueScore;

    /**
     * 阅卷人姓名
     */
    private String answerJudgeUsername;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    public String getAnswerExamId() {
        return answerExamId;
    }

    public void setAnswerExamId(String answerExamId) {
        this.answerExamId = answerExamId;
    }

    public String getAnswerUserId() {
        return answerUserId;
    }

    public void setAnswerUserId(String answerUserId) {
        this.answerUserId = answerUserId;
    }

    public String getAnswerQueId() {
        return answerQueId;
    }

    public void setAnswerQueId(String answerQueId) {
        this.answerQueId = answerQueId;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public String getAnswerIsRight() {
        return answerIsRight;
    }

    public void setAnswerIsRight(String answerIsRight) {
        this.answerIsRight = answerIsRight;
    }

    public String getAnswerRightAnswer() {
        return answerRightAnswer;
    }

    public void setAnswerRightAnswer(String answerRightAnswer) {
        this.answerRightAnswer = answerRightAnswer;
    }

    public String getAnswerScore() {
        return answerScore;
    }

    public void setAnswerScore(String answerScore) {
        this.answerScore = answerScore;
    }

    public String getAnswerQueScore() {
        return answerQueScore;
    }

    public void setAnswerQueScore(String answerQueScore) {
        this.answerQueScore = answerQueScore;
    }

    public String getAnswerJudgeUsername() {
        return answerJudgeUsername;
    }

    public void setAnswerJudgeUsername(String answerJudgeUsername) {
        this.answerJudgeUsername = answerJudgeUsername;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", answerId=").append(answerId);
        sb.append(", answerExamId=").append(answerExamId);
        sb.append(", answerUserId=").append(answerUserId);
        sb.append(", answerQueId=").append(answerQueId);
        sb.append(", answerContent=").append(answerContent);
        sb.append(", answerIsRight=").append(answerIsRight);
        sb.append(", answerRightAnswer=").append(answerRightAnswer);
        sb.append(", answerScore=").append(answerScore);
        sb.append(", answerQueScore=").append(answerQueScore);
        sb.append(", answerJudgeUsername=").append(answerJudgeUsername);
        sb.append("]");
        return sb.toString();
    }
}