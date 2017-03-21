package com.ssm.other.entity;

/**
 *教师工作年份
 */
public class WorkTimeEntity {
    /**
     * 工作年份ID
     */
    private Integer workTimeEntityId;

    /**
     * 工作年份
     */
    private Integer workTime;

    public Integer getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Integer workTime) {
        this.workTime = workTime;
    }

    public Integer getWorkTimeEntityId() {
        return workTimeEntityId;
    }

    public void setWorkTimeEntityId(Integer workTimeEntityId) {
        this.workTimeEntityId = workTimeEntityId;
    }
}
