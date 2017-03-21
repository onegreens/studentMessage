package com.ssm.student.entity;

import com.ssm.other.entity.*;

/**
 * 学生信息表
 */
public class StudentEntity {
    //ID
    private Integer studentId;
    //姓名
    private String studentName;
    //住址
    private String address;
    //出生日期
    private String birth;
    //身份证号
    private String identityCard;
    //邮箱
    private String email;
    //性别
    private SexEntity sexEntity;
    //民族
    private NationEntity nationEntity;
    //政治面貌
    private PoliticsStatusEntity politicsStatusEntity;
    //籍贯
    private NativePlaceEntity nativePlaceEntity;
    //年级
    private GradeEntity gradeEntity;
    //专业
    private MajorEntity majorEntity;

    private Integer gradeMajorId;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGradeMajorId() {
        return gradeMajorId;
    }

    public void setGradeMajorId(Integer gradeMajorId) {
        this.gradeMajorId = gradeMajorId;
    }

    public GradeEntity getGradeEntity() {
        return gradeEntity;
    }

    public void setGradeEntity(GradeEntity gradeEntity) {
        this.gradeEntity = gradeEntity;
    }

    public MajorEntity getMajorEntity() {
        return majorEntity;
    }

    public void setMajorEntity(MajorEntity majorEntity) {
        this.majorEntity = majorEntity;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public SexEntity getSexEntity() {
        return sexEntity;
    }

    public void setSexEntity(SexEntity sexEntity) {
        this.sexEntity = sexEntity;
    }

    public NationEntity getNationEntity() {
        return nationEntity;
    }

    public void setNationEntity(NationEntity nationEntity) {
        this.nationEntity = nationEntity;
    }

    public PoliticsStatusEntity getPoliticsStatusEntity() {
        return politicsStatusEntity;
    }

    public void setPoliticsStatusEntity(PoliticsStatusEntity politicsStatusEntity) {
        this.politicsStatusEntity = politicsStatusEntity;
    }

    public NativePlaceEntity getNativePlaceEntity() {
        return nativePlaceEntity;
    }

    public void setNativePlaceEntity(NativePlaceEntity nativePlaceEntity) {
        this.nativePlaceEntity = nativePlaceEntity;
    }
}
