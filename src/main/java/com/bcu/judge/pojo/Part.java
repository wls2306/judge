package com.bcu.judge.pojo;

public class Part {
    /**
    * 自增id
    */
    private Integer id;

    /**
    * 小组编号
    */
    private String partId;

    /**
    * 小组名称
    */
    private String partName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPartId() {
        return partId;
    }

    public void setPartId(String partId) {
        this.partId = partId;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", partId=").append(partId);
        sb.append(", partName=").append(partName);
        sb.append("]");
        return sb.toString();
    }
}