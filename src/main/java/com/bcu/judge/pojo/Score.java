package com.bcu.judge.pojo;

public class Score {
    /**
     * 自增id
     */
    private Integer id;

    /**
     * 得分编号
     */
    private String scoreId;

    /**
     * 考试编号
     */
    private String scoreExamId;

    /**
     * 用户编号
     */
    private String scoreUserId;

    /**
     * 组织编号
     */
    private String scoreUserPart;

    /**
     * 得分分数
     */
    private String scoreResult;

    /**
     * 试卷总分
     */
    private String scoreTotal;

    /**
     * 答题时间
     */
    private String scoreTime;

    /**
     * 分数状态
     */
    private String scoreStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getScoreId() {
        return scoreId;
    }

    public void setScoreId(String scoreId) {
        this.scoreId = scoreId;
    }

    public String getScoreExamId() {
        return scoreExamId;
    }

    public void setScoreExamId(String scoreExamId) {
        this.scoreExamId = scoreExamId;
    }

    public String getScoreUserId() {
        return scoreUserId;
    }

    public void setScoreUserId(String scoreUserId) {
        this.scoreUserId = scoreUserId;
    }

    public String getScoreUserPart() {
        return scoreUserPart;
    }

    public void setScoreUserPart(String scoreUserPart) {
        this.scoreUserPart = scoreUserPart;
    }

    public String getScoreResult() {
        return scoreResult;
    }

    public void setScoreResult(String scoreResult) {
        this.scoreResult = scoreResult;
    }

    public String getScoreTotal() {
        return scoreTotal;
    }

    public void setScoreTotal(String scoreTotal) {
        this.scoreTotal = scoreTotal;
    }

    public String getScoreTime() {
        return scoreTime;
    }

    public void setScoreTime(String scoreTime) {
        this.scoreTime = scoreTime;
    }

    public String getScoreStatus() {
        return scoreStatus;
    }

    public void setScoreStatus(String scoreStatus) {
        this.scoreStatus = scoreStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", scoreId=").append(scoreId);
        sb.append(", scoreExamId=").append(scoreExamId);
        sb.append(", scoreUserId=").append(scoreUserId);
        sb.append(", scoreUserPart=").append(scoreUserPart);
        sb.append(", scoreResult=").append(scoreResult);
        sb.append(", scoreTotal=").append(scoreTotal);
        sb.append(", scoreTime=").append(scoreTime);
        sb.append(", scoreStatus=").append(scoreStatus);
        sb.append("]");
        return sb.toString();
    }
}