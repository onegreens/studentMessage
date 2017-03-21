package com.ssm.other.entity;

/**
 * Created by chensui on 2017/3/16.
 */
public class MajorEntity {

    private Integer majorEntityId;

    private String major;

    private AcademyEntity academyEntity;

    public Integer getMajorEntityId() {
        return majorEntityId;
    }

    public void setMajorEntityId(Integer majorEntityId) {
        this.majorEntityId = majorEntityId;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public AcademyEntity getAcademyEntity() {
        return academyEntity;
    }

    public void setAcademyEntity(AcademyEntity academyEntity) {
        this.academyEntity = academyEntity;
    }
}
