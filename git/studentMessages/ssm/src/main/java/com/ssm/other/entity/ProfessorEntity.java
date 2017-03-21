package com.ssm.other.entity;

/**
 * 教师职称
 */
public class ProfessorEntity {
    /**
     * 职称id
     */
    private Integer professorEntityId;

    /**
     * 职称名称
     */
    private String professorName;

    public Integer getProfessorEntityId() {
        return professorEntityId;
    }

    public void setProfessorEntityId(Integer professorEntityId) {
        this.professorEntityId = professorEntityId;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }
}
