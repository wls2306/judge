package com.bcu.judge.pojo;

import java.util.Date;

public class Exam {
    /**
     * 自增id
     */
    private Integer id;

    /**
     * 考试编号
     */
    private String examId;

    /**
     * 考试所用试卷编号
     */
    private String examPaperId;

    /**
     * 考试名称
     */
    private String examName;

    /**
     * 考试描述
     */
    private String examDesc;

    /**
     * 考试状态
     */
    private String examStatus;

    /**
     * 考试时间
     */
    private Date examTime;

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

    public String getExamPaperId() {
        return examPaperId;
    }

    public void setExamPaperId(String examPaperId) {
        this.examPaperId = examPaperId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamDesc() {
        return examDesc;
    }

    public void setExamDesc(String examDesc) {
        this.examDesc = examDesc;
    }

    public String getExamStatus() {
        return examStatus;
    }

    public void setExamStatus(String examStatus) {
        this.examStatus = examStatus;
    }

    public Date getExamTime() {
        return examTime;
    }

    public void setExamTime(Date examTime) {
        this.examTime = examTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", examId=").append(examId);
        sb.append(", examPaperId=").append(examPaperId);
        sb.append(", examName=").append(examName);
        sb.append(", examDesc=").append(examDesc);
        sb.append(", examStatus=").append(examStatus);
        sb.append(", examTime=").append(examTime);
        sb.append("]");
        return sb.toString();
    }
}