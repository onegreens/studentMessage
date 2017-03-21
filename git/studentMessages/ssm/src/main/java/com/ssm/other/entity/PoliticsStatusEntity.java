package com.ssm.other.entity;

/**
 * 政治面貌
 */
public class PoliticsStatusEntity {
    private Integer psEntityId;

    private String politicsStatus;

    public Integer getPsEntityId() {
        return psEntityId;
    }

    public void setPsEntityId(Integer psEntityId) {
        this.psEntityId = psEntityId;
    }

    public String getPoliticsStatus() {
        return politicsStatus;
    }

    public void setPoliticsStatus(String politicsStatus) {
        this.politicsStatus = politicsStatus;
    }
}
