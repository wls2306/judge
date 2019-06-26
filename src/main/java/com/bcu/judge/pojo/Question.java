package com.bcu.judge.pojo;

public class Question {
    /**
    * 自增id
    */
    private Integer id;

    /**
    * 题目编号
    */
    private String queId;

    /**
    * 试卷编号
    */
    private String quePaperId;

    /**
    * 所属部分
    */
    private String quePart;

    /**
    * 题目内容
    */
    private String queContent;

    /**
    * 题目答案
    */
    private String queAnswer;

    /**
    * 题目分值
    */
    private String queScore;

    /**
    * 题目类型
    */
    private String queType;

    /**
    * 是否使用机读（自动）阅卷
    */
    private String queAutoJudge;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQueId() {
        return queId;
    }

    public void setQueId(String queId) {
        this.queId = queId;
    }

    public String getQuePaperId() {
        return quePaperId;
    }

    public void setQuePaperId(String quePaperId) {
        this.quePaperId = quePaperId;
    }

    public String getQuePart() {
        return quePart;
    }

    public void setQuePart(String quePart) {
        this.quePart = quePart;
    }

    public String getQueContent() {
        return queContent;
    }

    public void setQueContent(String queContent) {
        this.queContent = queContent;
    }

    public String getQueAnswer() {
        return queAnswer;
    }

    public void setQueAnswer(String queAnswer) {
        this.queAnswer = queAnswer;
    }

    public String getQueScore() {
        return queScore;
    }

    public void setQueScore(String queScore) {
        this.queScore = queScore;
    }

    public String getQueType() {
        return queType;
    }

    public void setQueType(String queType) {
        this.queType = queType;
    }

    public String getQueAutoJudge() {
        return queAutoJudge;
    }

    public void setQueAutoJudge(String queAutoJudge) {
        this.queAutoJudge = queAutoJudge;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", queId=").append(queId);
        sb.append(", quePaperId=").append(quePaperId);
        sb.append(", quePart=").append(quePart);
        sb.append(", queContent=").append(queContent);
        sb.append(", queAnswer=").append(queAnswer);
        sb.append(", queScore=").append(queScore);
        sb.append(", queType=").append(queType);
        sb.append(", queAutoJudge=").append(queAutoJudge);
        sb.append("]");
        return sb.toString();
    }
}