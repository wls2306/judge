package com.bcu.judge.pojo;

import java.util.Date;

public class ExamUser {
    /**
    * 自增id
    */
    private Integer id;

    /**
    * 考试编号
    */
    private String examId;

    /**
    * 考生编号
    */
    private String userId;

    /**
    * 是否进入考试
    */
    private String hasEnter;

    /**
    * 进入考试时间
    */
    private Date enterTime;

    /**
    * 是否提交
    */
    private String hasSubmit;

    /**
    * 提交试卷时间
    */
    private Date submitTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHasEnter() {
        return hasEnter;
    }

    public void setHasEnter(String hasEnter) {
        this.hasEnter = hasEnter;
    }

    public Date getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }

    public String getHasSubmit() {
        return hasSubmit;
    }

    public void setHasSubmit(String hasSubmit) {
        this.hasSubmit = hasSubmit;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", examId=").append(examId);
        sb.append(", userId=").append(userId);
        sb.append(", hasEnter=").append(hasEnter);
        sb.append(", enterTime=").append(enterTime);
        sb.append(", hasSubmit=").append(hasSubmit);
        sb.append(", submitTime=").append(submitTime);
        sb.append("]");
        return sb.toString();
    }
}